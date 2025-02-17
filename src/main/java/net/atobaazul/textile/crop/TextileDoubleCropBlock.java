/*
 * Licensed under the EUPL, Version 1.2.
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 */

package net.atobaazul.textile.crop;

import net.atobaazul.textile.TextileHelpers;
import net.atobaazul.textile.block.TextileBlocks;
import net.atobaazul.textile.registries.TextileItems;
import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.common.blockentities.FarmlandBlockEntity;
import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.util.climate.ClimateRange;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

public abstract class TextileDoubleCropBlock extends TextileCropBlock {
    public static final EnumProperty<Part> PART = TextileBlockStateProperties.DOUBLE_CROP_PART;
    protected final int maxSingleAge;
    protected final float maxSingleGrowth;

    protected TextileDoubleCropBlock(ExtendedProperties properties, int maxSingleAge, int maxAge, Supplier<? extends Block> dead, Supplier<? extends Item> seeds, FarmlandBlockEntity.NutrientType primaryNutrient, Supplier<ClimateRange> climateRange) {
        super(properties, maxAge, dead, seeds, primaryNutrient, climateRange);

        this.maxSingleAge = maxSingleAge;
        this.maxSingleGrowth = (float) maxSingleAge / maxAge;
        registerDefaultState(defaultBlockState().setValue(PART, Part.BOTTOM));
    }

    public static TextileDoubleCropBlock create(ExtendedProperties properties, int singleStages, int doubleStages, TextileCrop crop) {
        final IntegerProperty property = TextileBlockStateProperties.getAgeProperty(singleStages + doubleStages - 1);
        return new TextileDoubleCropBlock(properties, singleStages - 1, singleStages + doubleStages - 1, TextileBlocks.DEAD_CROPS.get(crop), TextileItems.CROP_SEEDS.get(crop), crop.getPrimaryNutrient(), TextileClimateRanges.CROPS.get(crop)) {
            @Override
            public IntegerProperty getAgeProperty() {
                return property;
            }
        };
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        final Part part = state.getValue(PART);
        final BlockState belowState = level.getBlockState(pos.below());
        if (part == Part.BOTTOM) {
            return TextileHelpers.isBlock(belowState.getBlock(), TFCTags.Blocks.FARMLAND);
        } else {
            return TextileHelpers.isBlock(belowState, this) && belowState.getValue(PART) == Part.BOTTOM;
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        TextileDoubleCropBlock.Part part = state.getValue(PART);
        if (facing.getAxis() != Direction.Axis.Y || part == TextileDoubleCropBlock.Part.BOTTOM != (facing == Direction.UP) || facingState.getBlock() == this && facingState.getValue(PART) != part) {
            return part == TextileDoubleCropBlock.Part.BOTTOM && facing == Direction.DOWN && !state.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        TextileWildDoubleCropBlock.onPlayerWillDestroy(level, pos, state, player);
        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity tile, ItemStack stack) {
        super.playerDestroy(level, player, pos, Blocks.AIR.defaultBlockState(), tile, stack);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(PART));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (state.getValue(PART) == Part.TOP) return HALF_SHAPE;
        float growth = (float) state.getValue(getAgeProperty()) / maxSingleAge;
        if (growth <= 0.25F) return QUARTER_SHAPE;
        else if (growth <= 0.5F) return HALF_SHAPE;
        return FULL_SHAPE;
    }

    @Override
    public void growthTick(Level level, BlockPos pos, BlockState state, TextileCropBlockEntity crop) {
        // Only perform growth ticks on the lower part
        if (state.getValue(TextileDoubleCropBlock.PART) == Part.BOTTOM) {
            super.growthTick(level, pos, state, crop);
        }
    }

    @Override
    protected void postGrowthTick(Level level, BlockPos pos, BlockState state, TextileCropBlockEntity crop) {
        final BlockPos posAbove = pos.above();
        final BlockState stateAbove = level.getBlockState(posAbove);
        final int age = Mth.clamp((int) (crop.getGrowth() * getMaxAge()), 0, getMaxAge());

        level.setBlock(pos, state.setValue(getAgeProperty(), age), Block.UPDATE_CLIENTS);
        if (age > maxSingleAge && (stateAbove.isAir() || stateAbove.getBlock() == this)) {
            level.setBlock(posAbove, state.setValue(getAgeProperty(), age).setValue(PART, Part.TOP), Block.UPDATE_ALL);
        }
    }

    @Override
    public float getGrowthLimit(Level level, BlockPos pos, BlockState state) {
        return isSameOrAir(level.getBlockState(pos.above())) ? super.getGrowthLimit(level, pos, state) : maxSingleGrowth;
    }

    @Override
    public void die(Level level, BlockPos pos, BlockState state, boolean fullyGrown) {
        final BlockPos posAbove = pos.above();
        final BlockState stateAbove = level.getBlockState(posAbove);
        final BlockState deadState = dead.get().defaultBlockState().setValue(TextileDeadCropBlock.MATURE, fullyGrown);
        if (fullyGrown && isSameOrAir(stateAbove)) {
            level.setBlock(posAbove, deadState.setValue(TextileDeadDoubleCropBlock.PART, Part.TOP), Block.UPDATE_CLIENTS);
        } else if (stateAbove.getBlock() == this) {
            level.destroyBlock(posAbove, false);
        }
        level.setBlockAndUpdate(pos, deadState.setValue(TextileDeadDoubleCropBlock.PART, Part.BOTTOM));
    }

    protected boolean isSameOrAir(BlockState state) {
        return state.isAir() || state.getBlock() == this;
    }

    @Override
    public void addHoeOverlayInfo(Level level, BlockPos pos, BlockState state, List<Component> text, boolean isDebug) {
        super.addHoeOverlayInfo(level, state.getValue(PART) == Part.TOP ? pos.below() : pos, state, text, isDebug);
    }

    public enum Part implements StringRepresentable {
        BOTTOM, TOP;

        private final String serializedName;

        Part() {
            this.serializedName = name().toLowerCase(Locale.ROOT);
        }

        @Override
        public String getSerializedName() {
            return serializedName;
        }
    }
}