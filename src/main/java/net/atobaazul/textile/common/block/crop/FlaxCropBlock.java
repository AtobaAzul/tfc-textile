package net.atobaazul.textile.common.block.crop;

import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.TFCBlockStateProperties;
import net.dries007.tfc.common.blocks.crop.ClimbingCropBlock;
import net.dries007.tfc.common.blocks.crop.DoubleCropBlock;
import net.dries007.tfc.util.climate.ClimateRange;
import net.dries007.tfc.util.climate.ClimateRanges;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.function.Supplier;

public class FlaxCropBlock extends DoubleCropBlock {
    public FlaxCropBlock(ExtendedProperties properties, int maxSingleAge, int maxAge, Supplier<? extends Block> dead, Supplier<? extends Item> seeds, float nitrogen, float phosporous, float potassium, Supplier<ClimateRange> climateRange) {
        super(properties, maxSingleAge, maxAge, dead, seeds, nitrogen, phosporous, potassium, climateRange);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return TFCBlockStateProperties.getAgeProperty(3 + 3 - 1);
    }
}
