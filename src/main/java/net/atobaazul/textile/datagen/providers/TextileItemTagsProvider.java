package net.atobaazul.textile.datagen.providers;


import net.atobaazul.textile.common.item.TextileItemTags;
import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.common.items.HideItemType;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static net.atobaazul.textile.Textile.MOD_ID;
import static net.atobaazul.textile.common.item.TextileItemTags.*;
import static net.atobaazul.textile.registries.TextileItems.*;

public class TextileItemTagsProvider extends ItemTagsProvider {
    public TextileItemTagsProvider(@NotNull PackOutput output, @NotNull CompletableFuture<HolderLookup.Provider> lookupProvider, @NotNull CompletableFuture<TagLookup<Block>> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        IntrinsicTagAppender<Item> armorTag = tag(Tags.Items.ARMORS).replace(false);
        IntrinsicTagAppender<Item> dyeableTag = tag(ItemTags.DYEABLE).replace(false);
        IntrinsicTagAppender<Item> freezeImmuneTag = tag(ItemTags.FREEZE_IMMUNE_WEARABLES).replace(false);
        IntrinsicTagAppender<Item> furClothesTag = tag(FUR_CLOTHES_TAG).replace(false);
        IntrinsicTagAppender<Item> linenClothesTag = tag(LINEN_CLOTHES_TAG).replace(false);
        IntrinsicTagAppender<Item> cottonClothesTag = tag(COTTON_CLOTHES_TAG).replace(false);


        //armor tags
        BLACK_BEAR_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            furClothesTag.add(item.get());
        });
        CARIBOU_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            furClothesTag.add(item.get());
            freezeImmuneTag.add(item.get());
        });
        COUGAR_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            furClothesTag.add(item.get());

        });
        CROCODILE_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            furClothesTag.add(item.get());
        });
        DIREWOLF_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            furClothesTag.add(item.get());
            freezeImmuneTag.add(item.get());
        });
        GRIZZLY_BEAR_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            furClothesTag.add(item.get());
        });
        LION_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            furClothesTag.add(item.get());
        });
        PANTHER_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            furClothesTag.add(item.get());
        });
        POLAR_BEAR_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            furClothesTag.add(item.get());
            freezeImmuneTag.add(item.get());
        });
        RAW_HIDE_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
        });
        SABERTOOTH_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            furClothesTag.add(item.get());
        });
        TIGER_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            furClothesTag.add(item.get());
        });
        BISON_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            furClothesTag.add(item.get());
        });
        YAK_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            furClothesTag.add(item.get());
        });
        LINEN_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            dyeableTag.add(item.get());
            linenClothesTag.add(item.get());

        });
        COTTON_CLOTHES.forEach((item) -> {
            armorTag.add(item.get());
            dyeableTag.add(item.get());
            cottonClothesTag.add(item.get());
        });

        //other tags
        tag(Tags.Items.STRINGS).replace(false).add(COTTON_STRING.get());

        tag(PRIMITIVE_INSULATION_KNAPPING).replace(false).add(PRIMITIVE_INSULATION.get());

        tag(REPLACEABLE_HIDE).replace(false).add(TFCItems.HIDES.get(HideItemType.RAW).get(HideItemType.Size.MEDIUM).get()).add(TFCItems.HIDES.get(HideItemType.RAW).get(HideItemType.Size.LARGE).get());

        tag(TFCTags.Items.SEWING_DARK_CLOTH).replace(false).add(LINEN_CLOTH.get());
        tag(TFCTags.Items.SEWING_LIGHT_CLOTH).replace(false).add(COTTON_CLOTH.get());
        tag(TFCTags.Items.HIGH_QUALITY_CLOTH).replace(false).add(COTTON_CLOTH.get());

        IntrinsicTagAppender<Item> furTag = tag(TextileItemTags.FURS_TAG).replace(false);
        FURS.forEach((item) -> furTag.add(item.get()));

        //curios
        tag(GLOVES).replace(false)
                .add(LEATHER_GLOVES.get())
                .add(WOOL_GLOVES.get())
                .add(SILK_GLOVES.get())
                .add(COTTON_GLOVES.get());

        tag(SCARF).replace(false)
                .add(WOOL_SCARF.get())
                .add(SILK_SCARF.get())
                .add(COTTON_SCARF.get());

        dyeableTag
                .add(LEATHER_APRON.get());
                /*.add(LEATHER_GLOVES.get())
                .add(WOOL_GLOVES.get())
                .add(SILK_GLOVES.get())
                .add(COTTON_GLOVES.get())
                .add(WOOL_SCARF.get())
                .add(SILK_SCARF.get())
                .add(COTTON_SCARF.get());*/


    }
}


