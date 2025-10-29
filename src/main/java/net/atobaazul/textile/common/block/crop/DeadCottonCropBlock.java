package net.atobaazul.textile.common.block.crop;

import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.crop.DeadDoubleCropBlock;
import net.dries007.tfc.util.climate.ClimateRange;

import java.util.function.Supplier;

public class DeadCottonCropBlock extends DeadDoubleCropBlock {
    public DeadCottonCropBlock(ExtendedProperties properties, Supplier<ClimateRange> range) {
        super(properties, range);
    }
}
