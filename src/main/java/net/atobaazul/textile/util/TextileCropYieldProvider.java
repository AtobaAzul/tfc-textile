/*
 * Licensed under the EUPL, Version 1.2.
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 */

package net.atobaazul.textile.util;

import net.atobaazul.textile.crop.TextileCropBlockEntity;
import net.dries007.tfc.util.loot.CropYieldProvider;
import net.dries007.tfc.util.loot.MinMaxProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.providers.number.LootNumberProviderType;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;

public class TextileCropYieldProvider extends MinMaxProvider
{
    public TextileCropYieldProvider(NumberProvider min, NumberProvider max)
    {
        super(min, max);
    }

    @Override
    public float getFloat(LootContext context)
    {
        final BlockEntity entity = context.getParamOrNull(LootContextParams.BLOCK_ENTITY);
        if (entity instanceof TextileCropBlockEntity crop)
        {
            return Mth.lerp(crop.getYield(), min.getFloat(context), max.getFloat(context));
        }
        return min.getFloat(context);
    }

    @Override
    public LootNumberProviderType getType()
    {
        return TextileLoot.CROP_YIELD.get();
    }
}