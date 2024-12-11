/*
 * Licensed under the EUPL, Version 1.2.
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 */

package net.atobaazul.textile.crop;

import net.atobaazul.textile.TextileHelpers;
import net.dries007.tfc.util.RegisteredDataManager;
import net.dries007.tfc.util.climate.ClimateRange;

import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

public class TextileClimateRanges {

    public static final Map<TextileCrop, Supplier<ClimateRange>> CROPS = TextileHelpers.mapOfKeys(TextileCrop.class, crop -> register("crop/" + crop.getSerializedName()));

    private static RegisteredDataManager.Entry<ClimateRange> register(String name) {
        return ClimateRange.MANAGER.register(TextileHelpers.identifier(name.toLowerCase(Locale.ROOT)));
    }
}