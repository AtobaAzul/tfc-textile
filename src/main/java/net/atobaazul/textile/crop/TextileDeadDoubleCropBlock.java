/*
 * Licensed under the EUPL, Version 1.2.
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 */

package net.atobaazul.textile.crop;


import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.util.climate.ClimateRange;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class TextileDeadDoubleCropBlock extends TextileDeadCropBlock {
    public static final EnumProperty<TextileDoubleCropBlock.Part> PART = TextileBlockStateProperties.DOUBLE_CROP_PART;

    public TextileDeadDoubleCropBlock(ExtendedProperties properties, TextileCrop crop) {
        this(properties, crop.getClimateRange());
    }

    public TextileDeadDoubleCropBlock(ExtendedProperties properties, Supplier<ClimateRange> range) {
        super(properties, range);
        registerDefaultState(getStateDefinition().any().setValue(PART, TextileDoubleCropBlock.Part.BOTTOM).setValue(MATURE, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(PART));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(PART) == TextileDoubleCropBlock.Part.BOTTOM ? TextileCropBlock.FULL_SHAPE : TextileCropBlock.HALF_SHAPE;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        return pos.getY() < context.getLevel().getMaxBuildHeight() - 1 && context.getLevel().getBlockState(pos.above()).canBeReplaced(context) ? super.getStateForPlacement(context) : null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (placer instanceof Player) {
            level.setBlockAndUpdate(pos.above(), defaultBlockState().setValue(PART, TextileDoubleCropBlock.Part.TOP));
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
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return TextileWildDoubleCropBlock.doubleBlockSurvives(state, level, pos);
    }

    @Override
    public void addHoeOverlayInfo(Level level, BlockPos pos, BlockState state, List<Component> text, boolean isDebug) {
        if (state.getValue(PART) == TextileDoubleCropBlock.Part.TOP) {
            final BlockState belowState = level.getBlockState(pos.below());
            if (belowState.getBlock() instanceof TextileDeadDoubleCropBlock) {
                super.addHoeOverlayInfo(level, pos.below(), belowState, text, isDebug);
            }
        } else {
            super.addHoeOverlayInfo(level, pos, state, text, isDebug);
        }
    }
}