package net.atobaazul.textile.registries;

import com.mojang.serialization.MapCodec;
import net.atobaazul.textile.common.loot.ReplaceHideModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

import static net.atobaazul.textile.Textile.MOD_ID;

public class TextileLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MOD_ID);


    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> REPLACE_HIDE =
            LOOT_MODIFIER_SERIALIZERS.register("replace_hide", () -> ReplaceHideModifier.CODEC);
}
