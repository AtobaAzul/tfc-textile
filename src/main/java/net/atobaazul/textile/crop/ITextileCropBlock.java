package net.atobaazul.textile.crop;/*
 * Licensed under the EUPL, Version 1.2.
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 */


import net.dries007.tfc.common.blockentities.FarmlandBlockEntity;
import net.dries007.tfc.util.climate.ClimateRange;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Interface for blocks that use {@link TextileCropBlockEntity}
 */
public interface ITextileCropBlock {
    void growthTick(Level level, BlockPos pos, BlockState state, TextileCropBlockEntity crop);

    /**
     * Get any artificial growth limit imposed by the current environment.
     * This applies to, i.e. two tall crops that have a non-air block occupying their second position.
     *
     * @return A value between [0, 1].
     */
    default float getGrowthLimit(Level level, BlockPos pos, BlockState state) {
        return TextileCropHelpers.lightValid(level, pos) ? TextileCropHelpers.GROWTH_LIMIT : 0f;
    }

    void die(Level level, BlockPos pos, BlockState state, boolean fullyGrown);

    ClimateRange getClimateRange();

    FarmlandBlockEntity.NutrientType getPrimaryNutrient();

}