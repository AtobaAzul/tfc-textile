/*
 * Licensed under the EUPL, Version 1.2.
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 */

package net.atobaazul.textile.util;


import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.dries007.tfc.util.loot.MinMaxProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.level.storage.loot.providers.number.LootNumberProviderType;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.atobaazul.textile.Textile.MOD_ID;


public class TextileLoot {
    public static final DeferredRegister<LootItemConditionType> CONDITIONS = DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, MOD_ID);
    public static final DeferredRegister<LootNumberProviderType> NUMBER_PROVIDERS = DeferredRegister.create(Registries.LOOT_NUMBER_PROVIDER_TYPE, MOD_ID);
    public static final DeferredRegister<LootItemFunctionType> LOOT_FUNCTIONS = DeferredRegister.create(Registries.LOOT_FUNCTION_TYPE, MOD_ID);

    public static final RegistryObject<LootNumberProviderType> CROP_YIELD = numberProvider("crop_yield_uniform", new MinMaxProvider.Serializer(TextileCropYieldProvider::new));

    private static RegistryObject<LootItemFunctionType> lootFunction(String id, Serializer<? extends LootItemFunction> serializer) {
        return LOOT_FUNCTIONS.register(id, () -> new LootItemFunctionType(serializer));
    }

    private static RegistryObject<LootItemConditionType> lootCondition(String id, Serializer<? extends LootItemCondition> serializer) {
        return CONDITIONS.register(id, () -> new LootItemConditionType(serializer));
    }

    private static RegistryObject<LootNumberProviderType> numberProvider(String id, Serializer<? extends NumberProvider> serializer) {
        return NUMBER_PROVIDERS.register(id, () -> new LootNumberProviderType(serializer));
    }

    public record InstanceSerializer<T extends LootItemCondition>(T instance) implements Serializer<T> {
        @Override
        public void serialize(JsonObject json, T value, JsonSerializationContext context) {
        }

        @Override
        public T deserialize(JsonObject json, JsonDeserializationContext context) {
            return instance;
        }
    }
}