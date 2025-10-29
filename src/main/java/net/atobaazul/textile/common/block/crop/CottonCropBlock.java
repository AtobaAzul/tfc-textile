package net.atobaazul.textile.common.block.crop;

import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.TFCBlockStateProperties;
import net.dries007.tfc.common.blocks.crop.DoubleCropBlock;
import net.dries007.tfc.util.climate.ClimateRange;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.function.Supplier;

public class CottonCropBlock extends DoubleCropBlock {
    public CottonCropBlock(ExtendedProperties properties, int maxSingleAge, int maxAge, Supplier<? extends Block> dead, Supplier<? extends Item> seeds, float nitrogen, float phosporous, float potassium, Supplier<ClimateRange> climateRange) {
        super(properties, maxSingleAge, maxAge, dead, seeds, nitrogen, phosporous, potassium, climateRange);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return TFCBlockStateProperties.getAgeProperty(3 + 3 - 1);
    }
}
