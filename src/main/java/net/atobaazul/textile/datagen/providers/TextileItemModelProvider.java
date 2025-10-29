package net.atobaazul.textile.datagen.providers;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

import static net.atobaazul.textile.Textile.MOD_ID;
import static net.atobaazul.textile.registries.TextileItems.*;

public class TextileItemModelProvider extends ItemModelProvider {
    public TextileItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MOD_ID, existingFileHelper);
    }



    @Override
    protected void registerModels() {
        BLACK_BEAR_CLOTHES.forEach(this::simpleItem);
        CARIBOU_CLOTHES.forEach(this::simpleItem);
        COUGAR_CLOTHES.forEach(this::simpleItem);
        CROCODILE_CLOTHES.forEach(this::simpleItem);
        DIREWOLF_CLOTHES.forEach(this::simpleItem);
        GRIZZLY_BEAR_CLOTHES.forEach(this::simpleItem);
        LION_CLOTHES.forEach(this::simpleItem);
        PANTHER_CLOTHES.forEach(this::simpleItem);
        POLAR_BEAR_CLOTHES.forEach(this::simpleItem);
        RAW_HIDE_CLOTHES.forEach(this::simpleItem);
        SABERTOOTH_CLOTHES.forEach(this::simpleItem);
        TIGER_CLOTHES.forEach(this::simpleItem);
        BISON_CLOTHES.forEach(this::simpleItem);
        YAK_CLOTHES.forEach(this::simpleItem);

        FURS.forEach(this::simpleItem);
        simpleItem(PRIMITIVE_INSULATION);
    }

    private ItemModelBuilder simpleItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(), ResourceLocation.fromNamespaceAndPath("minecraft", "item/generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/"+item.getId().getPath()));
    }
}
