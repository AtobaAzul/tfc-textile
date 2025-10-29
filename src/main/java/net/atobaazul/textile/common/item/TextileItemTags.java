package net.atobaazul.textile.common.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static net.atobaazul.textile.Textile.textileResource;


public class TextileItemTags {
    public static final TagKey<Item> PRIMITIVE_INSULATION_KNAPPING = itemTag("primitive_insulation_knapping");
    public static final TagKey<Item> FURS_TAG = itemTag("furs");
    public static final TagKey<Item> REPLACEABLE_HIDE = itemTag("replaceable_hide");
    public static final TagKey<Item> FUR_CLOTHES_TAG = itemTag("fur_clothes");

    public static final TagKey<Item> LINEN_CLOTHES_TAG = itemTag("linen_clothes");
    public static final TagKey<Item> COTTON_CLOTHES_TAG = itemTag("cotton_clothes");

    public static final TagKey<Item> GLOVES = curiosTag("gloves");
    public static final TagKey<Item> SCARF = curiosTag("scarf");

    private static TagKey<Item> itemTag(String name) {
        return TagKey.create(Registries.ITEM, textileResource(name));
    }

    private static TagKey<Item> curiosTag(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("curios", name));
    }

}
