package net.atobaazul.textile.crop;

import net.atobaazul.textile.block.TextileBlocks;
import net.atobaazul.textile.item.TextileItems;
import net.dries007.tfc.common.blockentities.CropBlockEntity;
import net.dries007.tfc.common.blockentities.FarmlandBlockEntity;
import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.crop.CropBlock;
import net.dries007.tfc.util.climate.ClimateRange;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.function.Supplier;


public abstract class TextileDefaultCropBlock extends CropBlock {
    protected TextileDefaultCropBlock(ExtendedProperties properties, int maxAge, Supplier<? extends Block> dead, Supplier<? extends Item> seeds, FarmlandBlockEntity.NutrientType primaryNutrient, Supplier<ClimateRange> climateRange) {
        super(properties, maxAge, dead, seeds, primaryNutrient, climateRange);
    }

    public static TextileDefaultCropBlock create(ExtendedProperties properties, int stages, TextileCrop crop) {
        final IntegerProperty property = TextileBlockStateProperties.getAgeProperty(stages - 1);
        return new TextileDefaultCropBlock(properties, stages - 1, TextileBlocks.DEAD_CROPS.get(crop), TextileItems.CROP_SEEDS.get(crop), crop.getPrimaryNutrient(), TextileClimateRanges.CROPS.get(crop)) {
            public IntegerProperty getAgeProperty() {
                return property;
            }
        };
    }

    public void die(Level level, BlockPos pos, BlockState state, boolean fullyGrown) {
        BlockState deadState = this.dead.get().defaultBlockState().setValue(TextileDeadCropBlock.MATURE, fullyGrown);
        level.setBlockAndUpdate(pos, deadState);
    }

    protected void postGrowthTick(Level level, BlockPos pos, BlockState state, CropBlockEntity crop) {
        int age = crop.getGrowth() == 1.0F ? this.getMaxAge() : (int) (crop.getGrowth() * (float) this.getMaxAge());
        level.setBlockAndUpdate(pos, state.setValue(this.getAgeProperty(), age));
    }
}
