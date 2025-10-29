package net.atobaazul.textile.common.block.crop;

import net.atobaazul.textile.registries.TextileBlocks;
import net.dries007.tfc.common.blockentities.CropBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TextileCropBlockEntity extends CropBlockEntity {


    public TextileCropBlockEntity(BlockPos pos, BlockState state) {
        super(TextileBlocks.CROP.get(), pos, state);
    }
}
