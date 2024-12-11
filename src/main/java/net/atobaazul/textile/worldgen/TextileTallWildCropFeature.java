/*
 * Licensed under the EUPL, Version 1.2.
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 */

package net.atobaazul.textile.worldgen;

import com.mojang.serialization.Codec;
import net.atobaazul.textile.crop.TextileWildDoubleCropBlock;
import net.dries007.tfc.world.feature.BlockConfig;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class TextileTallWildCropFeature extends Feature<BlockConfig<TextileWildDoubleCropBlock>> {
    public static final Codec<BlockConfig<TextileWildDoubleCropBlock>> CODEC = BlockConfig.codec(b -> b instanceof TextileWildDoubleCropBlock t ? t : null, "Must be a " + TextileWildDoubleCropBlock.class.getSimpleName());

    public TextileTallWildCropFeature(Codec<BlockConfig<TextileWildDoubleCropBlock>> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<BlockConfig<TextileWildDoubleCropBlock>> context) {
        context.config().block().placeTwoHalves(context.level(), context.origin(), 2);
        return true;
    }
}