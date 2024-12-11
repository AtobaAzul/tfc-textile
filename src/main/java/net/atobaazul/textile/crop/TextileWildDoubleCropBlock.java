/*
 * Licensed under the EUPL, Version 1.2.
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 */

package net.atobaazul.textile.crop;

import net.atobaazul.textile.TextileHelpers;
import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class TextileWildDoubleCropBlock extends TextileWildCropBlock {
    public static final EnumProperty<TextileDoubleCropBlock.Part> PART = TextileBlockStateProperties.DOUBLE_CROP_PART;

    public TextileWildDoubleCropBlock(ExtendedProperties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any().setValue(PART, TextileDoubleCropBlock.Part.BOTTOM).setValue(MATURE, false));
    }

    public static void onPlayerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            if (player.isCreative()) {
                if (state.getValue(PART) == TextileDoubleCropBlock.Part.TOP) {
                    BlockPos blockpos = pos.below();
                    BlockState blockstate = level.getBlockState(blockpos);
                    if (blockstate.getBlock() == state.getBlock() && blockstate.getValue(PART) == TextileDoubleCropBlock.Part.BOTTOM) {
                        level.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                        level.levelEvent(player, LevelEvent.PARTICLES_DESTROY_BLOCK, blockpos, Block.getId(blockstate));
                    }
                }
            } else {
                dropResources(state, level, pos, level.getBlockEntity(pos), player, player.getMainHandItem());
            }
        }
    }

    public static boolean doubleBlockSurvives(BlockState state, LevelReader level, BlockPos pos) {
        final TextileDoubleCropBlock.Part part = state.getValue(PART);
        final BlockState belowState = level.getBlockState(pos.below());
        if (part == TextileDoubleCropBlock.Part.BOTTOM) {
            return TextileHelpers.isBlock(belowState.getBlock(), TFCTags.Blocks.WILD_CROP_GROWS_ON);
        } else {
            return TextileHelpers.isBlock(belowState, state.getBlock()) && belowState.getValue(PART) == TextileDoubleCropBlock.Part.BOTTOM;
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        if (state.getValue(PART) == TextileDoubleCropBlock.Part.TOP) {
            final BlockState below = level.getBlockState(pos.below());
            if (below.getBlock() == this && below.getValue(MATURE) != isMature(level)) {
                level.setBlockAndUpdate(pos.below(), below.cycle(MATURE));
            }
        } else {
            final BlockState above = level.getBlockState(pos.above());
            if (above.getBlock() == this && above.getValue(MATURE) != isMature(level)) {
                level.setBlockAndUpdate(pos.above(), above.cycle(MATURE));
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(PART) == TextileDoubleCropBlock.Part.BOTTOM ? TextileCropBlock.FULL_SHAPE : TextileCropBlock.HALF_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(PART));
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return doubleBlockSurvives(state, level, pos);
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
        onPlayerWillDestroy(level, pos, state, player);
        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity tile, ItemStack stack) {
        super.playerDestroy(level, player, pos, Blocks.AIR.defaultBlockState(), tile, stack);
    }

    public void placeTwoHalves(LevelAccessor level, BlockPos pos, int flags) {
        final boolean mature = isMature(level);
        level.setBlock(pos, defaultBlockState().setValue(PART, TextileDoubleCropBlock.Part.BOTTOM).setValue(MATURE, mature), flags);
        level.setBlock(pos.above(), defaultBlockState().setValue(PART, TextileDoubleCropBlock.Part.TOP).setValue(MATURE, mature), flags);
    }
}