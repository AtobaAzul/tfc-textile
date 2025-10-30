package net.atobaazul.textile.common.loot;

import net.atobaazul.textile.common.block.crop.TextileCropBlockEntity;
import net.atobaazul.textile.datagen.providers.TextileLoot;
import net.dries007.tfc.util.loot.MinMaxProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.providers.number.LootNumberProviderType;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;

//I really don't know why the TFC one doesn't work...
public class TextileCropYieldProvider extends MinMaxProvider {
    public TextileCropYieldProvider(NumberProvider min, NumberProvider max) {
        super(min, max);
    }

    @Override
    public float getFloat(LootContext context) {
        final BlockEntity entity = context.getParamOrNull(LootContextParams.BLOCK_ENTITY);
        if (entity instanceof TextileCropBlockEntity crop) {
            return Mth.lerp(crop.getYield(), min.getFloat(context), max.getFloat(context));
        }
        return min.getFloat(context);
    }

    @Override
    public LootNumberProviderType getType() {
        return TextileLoot.TEXTILE_CROP_YIELD.get();
    }

}
