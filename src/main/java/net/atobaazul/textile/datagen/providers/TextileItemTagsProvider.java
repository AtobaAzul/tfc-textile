package net.atobaazul.textile.datagen.providers;


import com.lumintorious.tfcambiental.TFCAmbiental;
import net.atobaazul.tfc_textile.common.item.TextileItemTags;
import net.dries007.tfc.common.items.HideItemType;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static net.atobaazul.tfc_textile.TFCTextileLegacy.MOD_ID;
import static net.atobaazul.tfc_textile.common.item.TextileItemTags.PRIMITIVE_INSULATION_KNAPPING;
import static net.atobaazul.tfc_textile.common.item.TextileItemTags.REPLACEABLE_HIDE;
import static net.atobaazul.tfc_textile.registries.TextileItems.*;

public class TextileItemTagsProvider extends ItemTagsProvider {
    private static final TagKey<Item> CLOTHES_HAT = ambientalTag("clothes_hat");
    private static final TagKey<Item> CLOTHES_PANTS = ambientalTag("clothes_pants");
    private static final TagKey<Item> CLOTHES_SOCKS = ambientalTag("clothes_socks");
    private static final TagKey<Item> CLOTHES_TORSO = ambientalTag("clothes_torso");

    private static final TagKey<Item> CURIOS_HAT = curiosTag("clothes_hat");
    private static final TagKey<Item> CURIOS_PANTS = curiosTag("clothes_pants");
    private static final TagKey<Item> CURIOS_SOCKS = curiosTag("clothes_socks");
    private static final TagKey<Item> CURIOS_TORSO = curiosTag("clothes_torso");

    public TextileItemTagsProvider(@NotNull PackOutput output, @NotNull CompletableFuture<HolderLookup.Provider> lookupProvider, @NotNull CompletableFuture<TagLookup<Block>> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MOD_ID, existingFileHelper);
    }

    private static TagKey<Item> ambientalTag(String tag) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TFCAmbiental.MODID, tag));
    }

    private static TagKey<Item> curiosTag(String tag) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("curios", tag));
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        IntrinsicTagAppender<Item> clothesHat = tag(CLOTHES_HAT).replace(false);
        IntrinsicTagAppender<Item> clothesPants = tag(CLOTHES_PANTS).replace(false);
        IntrinsicTagAppender<Item> clothesSocks = tag(CLOTHES_SOCKS).replace(false);
        IntrinsicTagAppender<Item> clothesTorso = tag(CLOTHES_TORSO).replace(false);


        ArrayList<IntrinsicTagAppender<Item>> clothingTags = new ArrayList<>();
        clothingTags.add( clothesHat);
        clothingTags.add(clothesTorso);
        clothingTags.add(clothesPants);
        clothingTags.add(clothesSocks);

        IntrinsicTagAppender<Item> curiosHat = tag(CURIOS_HAT).replace(false);
        IntrinsicTagAppender<Item> curiosPants = tag(CURIOS_PANTS).replace(false);
        IntrinsicTagAppender<Item> curiosSocks = tag(CURIOS_SOCKS).replace(false);
        IntrinsicTagAppender<Item> curiosTorso = tag(CURIOS_TORSO).replace(false);

        ArrayList<IntrinsicTagAppender<Item>> curios_tags = new ArrayList<>();

        curios_tags.add(curiosHat);
        curios_tags.add(curiosTorso);
        curios_tags.add(curiosPants);
        curios_tags.add(curiosSocks);


        BLACK_BEAR_CLOTHES.forEach((item) -> addClothingTags(item, clothingTags));
        CARIBOU_CLOTHES.forEach((item) -> addClothingTags(item, clothingTags));
        COUGAR_CLOTHES.forEach((item) -> addClothingTags(item, clothingTags));
        CROCODILE_CLOTHES.forEach((item) -> addClothingTags(item, clothingTags));
        DIREWOLF_CLOTHES.forEach((item) -> addClothingTags(item, clothingTags));
        GRIZZLY_BEAR_CLOTHES.forEach((item) -> addClothingTags(item, clothingTags));
        LION_CLOTHES.forEach((item) -> addClothingTags(item, clothingTags));
        PANTHER_CLOTHES.forEach((item) -> addClothingTags(item, clothingTags));
        POLAR_BEAR_CLOTHES.forEach((item) -> addClothingTags(item, clothingTags));
        RAW_HIDE_CLOTHES.forEach((item) -> addClothingTags(item, clothingTags));
        SABERTOOTH_CLOTHES.forEach((item) -> addClothingTags(item, clothingTags));
        TIGER_CLOTHES.forEach((item) -> addClothingTags(item, clothingTags));

        BLACK_BEAR_CLOTHES.forEach((item) -> addClothingTags(item, curios_tags));
        CARIBOU_CLOTHES.forEach((item) -> addClothingTags(item, curios_tags));
        COUGAR_CLOTHES.forEach((item) -> addClothingTags(item, curios_tags));
        CROCODILE_CLOTHES.forEach((item) -> addClothingTags(item, curios_tags));
        DIREWOLF_CLOTHES.forEach((item) -> addClothingTags(item, curios_tags));
        GRIZZLY_BEAR_CLOTHES.forEach((item) -> addClothingTags(item, curios_tags));
        LION_CLOTHES.forEach((item) -> addClothingTags(item, curios_tags));
        PANTHER_CLOTHES.forEach((item) -> addClothingTags(item, curios_tags));
        POLAR_BEAR_CLOTHES.forEach((item) -> addClothingTags(item, curios_tags));
        RAW_HIDE_CLOTHES.forEach((item) -> addClothingTags(item, curios_tags));
        SABERTOOTH_CLOTHES.forEach((item) -> addClothingTags(item, curios_tags));
        TIGER_CLOTHES.forEach((item) -> addClothingTags(item, curios_tags));


        tag(PRIMITIVE_INSULATION_KNAPPING).replace(false).add(PRIMITIVE_INSULATION.get());

        tag(REPLACEABLE_HIDE).replace(false)
                .add(TFCItems.HIDES.get(HideItemType.RAW).get(HideItemType.Size.MEDIUM).get())
                .add(TFCItems.HIDES.get(HideItemType.RAW).get(HideItemType.Size.LARGE).get());

        IntrinsicTagAppender<Item> furTag = tag(TextileItemTags.FURS).replace(false);
        FURS.forEach((item) -> furTag.add(item.get()));
    }

    private void addClothingTags(DeferredItem<Item> item, ArrayList<IntrinsicTagAppender<Item>> tags) {
        if (item.getId().toString().contains("helmet")) {
            tags.get(0).add(item.get());
        } else if (item.getId().toString().contains("chestplate")) {
            tags.get(1).add(item.get());
        } else if (item.getId().toString().contains("leggings")) {
            tags.get(2).add(item.get());
        } else {
            tags.get(3).add(item.get());
        }
    }

    private ResourceLocation tfcItem(String name) {
        return ResourceLocation.fromNamespaceAndPath("tfc", name);
    }
}


