package net.atobaazul.textile.datagen.providers;


import net.atobaazul.textile.common.item.TextileItemTags;
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
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static net.atobaazul.textile.Textile.MOD_ID;

import static net.atobaazul.textile.common.item.TextileItemTags.*;
import static net.atobaazul.textile.registries.TextileItems.*;
import static net.atobaazul.textile.registries.TextileItems.FURS;

public class TextileItemTagsProvider extends ItemTagsProvider {
    public TextileItemTagsProvider(@NotNull PackOutput output, @NotNull CompletableFuture<HolderLookup.Provider> lookupProvider, @NotNull CompletableFuture<TagLookup<Block>> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        IntrinsicTagAppender<Item> armorTag = tag(Tags.Items.ARMORS).replace(false);

        BLACK_BEAR_CLOTHES.forEach((item) -> armorTag.add(item.get()));
        CARIBOU_CLOTHES.forEach((item) -> armorTag.add(item.get()));
        COUGAR_CLOTHES.forEach((item) -> armorTag.add(item.get()));
        CROCODILE_CLOTHES.forEach((item) -> armorTag.add(item.get()));
        DIREWOLF_CLOTHES.forEach((item) -> armorTag.add(item.get()));
        GRIZZLY_BEAR_CLOTHES.forEach((item) -> armorTag.add(item.get()));
        LION_CLOTHES.forEach((item) -> armorTag.add(item.get()));
        PANTHER_CLOTHES.forEach((item) -> armorTag.add(item.get()));
        POLAR_BEAR_CLOTHES.forEach((item) -> armorTag.add(item.get()));
        RAW_HIDE_CLOTHES.forEach((item) -> armorTag.add(item.get()));
        SABERTOOTH_CLOTHES.forEach((item) -> armorTag.add(item.get()));
        TIGER_CLOTHES.forEach((item) -> armorTag.add(item.get()));
        BISON_CLOTHES.forEach((item) -> armorTag.add(item.get()));
        YAK_CLOTHES.forEach((item) -> armorTag.add(item.get()));

        tag(PRIMITIVE_INSULATION_KNAPPING).replace(false).add(PRIMITIVE_INSULATION.get());

        tag(REPLACEABLE_HIDE).replace(false)
                .add(TFCItems.HIDES.get(HideItemType.RAW).get(HideItemType.Size.MEDIUM).get())
                .add(TFCItems.HIDES.get(HideItemType.RAW).get(HideItemType.Size.LARGE).get());

        IntrinsicTagAppender<Item> furTag = tag(TextileItemTags.FURS).replace(false);
        FURS.forEach((item) -> furTag.add(item.get()));
    }
}


