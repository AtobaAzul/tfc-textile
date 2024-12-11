/*
 * Licensed under the EUPL, Version 1.2.
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 */

package net.atobaazul.textile.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

import static net.atobaazul.textile.Textile.MOD_ID;


@SuppressWarnings("unused")
public class TextileFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, MOD_ID);

    public static final RegistryObject<TextileTallWildCropFeature> TALL_WILD_CROP = register("tall_wild_crop", TextileTallWildCropFeature::new, TextileTallWildCropFeature.CODEC);

    private static <C extends FeatureConfiguration, F extends Feature<C>> RegistryObject<F> register(String name, Function<Codec<C>, F> factory, Codec<C> codec) {
        return FEATURES.register(name, () -> factory.apply(codec));
    }
}