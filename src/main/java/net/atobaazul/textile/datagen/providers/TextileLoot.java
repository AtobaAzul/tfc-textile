package net.atobaazul.textile.datagen.providers;

import net.atobaazul.textile.common.loot.TextileCropYieldProvider;
import net.dries007.tfc.util.loot.MinMaxProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.providers.number.LootNumberProviderType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.atobaazul.textile.Textile.MOD_ID;

public class TextileLoot {
    public static final DeferredRegister<LootNumberProviderType> NUMBER_PROVIDERS = DeferredRegister.create(Registries.LOOT_NUMBER_PROVIDER_TYPE, MOD_ID);


    public static final DeferredHolder<LootNumberProviderType, LootNumberProviderType> TEXTILE_CROP_YIELD = NUMBER_PROVIDERS.register("crop_yield_uniform", () -> new LootNumberProviderType(MinMaxProvider.codec(TextileCropYieldProvider::new)));
}
