package net.atobaazul.textile.datagen;

import net.atobaazul.textile.Textile;
import net.atobaazul.textile.registries.TextileItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import static net.atobaazul.textile.Textile.MOD_ID;

public class TextileItemModelProvider extends ItemModelProvider {
    public TextileItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Furs
        simpleItem(TextileItems.BLACK_BEAR_FUR);
        simpleItem(TextileItems.CARIBOU_FUR);
        simpleItem(TextileItems.COUGAR_FUR);
        simpleItem(TextileItems.DIREWOLF_FUR);
        simpleItem(TextileItems.PANTHER_FUR);
        simpleItem(TextileItems.LION_FUR);
        simpleItem(TextileItems.GRIZZLY_BEAR_FUR);
        simpleItem(TextileItems.POLAR_BEAR_FUR);
        simpleItem(TextileItems.SABERTOOTH_FUR);
        simpleItem(TextileItems.TIGER_FUR);
        simpleItem(TextileItems.CROCODILE_LEATHER);
        
        //ingredients
        simpleItem(TextileItems.COTTON_CLOTH);
        simpleItem(TextileItems.COTTON_STRING);
        simpleItem(TextileItems.COTTON_BALL);
        simpleItem(TextileItems.PRIMITIVE_INSULATION);
        simpleItem(TextileItems.LINEN_CLOTH);
        simpleItem(TextileItems.FLAX_FIBER);
        simpleItem(TextileItems.FLAX );
        
        //clothes
        simpleItem(TextileItems.RAW_HAT);
        simpleItem(TextileItems.RAW_SHIRT);
        simpleItem(TextileItems.RAW_PANTS);

        simpleItem(TextileItems.BLACK_BEAR_HAT);
        simpleItem(TextileItems.BLACK_BEAR_SHIRT);
        simpleItem(TextileItems.BLACK_BEAR_PANTS);
        simpleItem(TextileItems.BLACK_BEAR_BOOTS);

        simpleItem(TextileItems.GRIZZLY_BEAR_HAT);
        simpleItem(TextileItems.GRIZZLY_BEAR_SHIRT);
        simpleItem(TextileItems.GRIZZLY_BEAR_PANTS);
        simpleItem(TextileItems.GRIZZLY_BEAR_BOOTS);

        simpleItem(TextileItems.CARIBOU_HAT);
        simpleItem(TextileItems.CARIBOU_SHIRT);
        simpleItem(TextileItems.CARIBOU_PANTS);
        simpleItem(TextileItems.CARIBOU_BOOTS);

        simpleItem(TextileItems.POLAR_BEAR_HAT);
        simpleItem(TextileItems.POLAR_BEAR_SHIRT);
        simpleItem(TextileItems.POLAR_BEAR_PANTS);
        simpleItem(TextileItems.POLAR_BEAR_BOOTS);

        simpleItem(TextileItems.DIREWOLF_HAT);
        simpleItem(TextileItems.DIREWOLF_SHIRT);
        simpleItem(TextileItems.DIREWOLF_PANTS);
        simpleItem(TextileItems.DIREWOLF_BOOTS);

        simpleItem(TextileItems.COUGAR_HAT);
        simpleItem(TextileItems.COUGAR_SHIRT);
        simpleItem(TextileItems.COUGAR_PANTS);
        simpleItem(TextileItems.COUGAR_BOOTS);

        simpleItem(TextileItems.LION_HAT);
        simpleItem(TextileItems.LION_SHIRT);
        simpleItem(TextileItems.LION_PANTS);
        simpleItem(TextileItems.LION_BOOTS);

        simpleItem(TextileItems.TIGER_HAT);
        simpleItem(TextileItems.TIGER_SHIRT);
        simpleItem(TextileItems.TIGER_PANTS);
        simpleItem(TextileItems.TIGER_BOOTS);

        simpleItem(TextileItems.PANTHER_HAT);
        simpleItem(TextileItems.PANTHER_SHIRT);
        simpleItem(TextileItems.PANTHER_PANTS);
        simpleItem(TextileItems.PANTHER_BOOTS);

        simpleItem(TextileItems.CROCODILE_HAT);
        simpleItem(TextileItems.CROCODILE_SHIRT);
        simpleItem(TextileItems.CROCODILE_PANTS);
        simpleItem(TextileItems.CROCODILE_BOOTS);

        simpleItem(TextileItems.SABERTOOTH_HAT);
        simpleItem(TextileItems.SABERTOOTH_SHIRT);
        simpleItem(TextileItems.SABERTOOTH_PANTS);
        simpleItem(TextileItems.SABERTOOTH_BOOTS);

        //dyeable armors
        dyeableItem(TextileItems.COTTON_HAT);
        dyeableItem(TextileItems.COTTON_SHIRT);
        dyeableItem(TextileItems.COTTON_PANTS);

        dyeableItem(TextileItems.WOOL_HAT);
        dyeableItem(TextileItems.WOOL_SHIRT);
        dyeableItem(TextileItems.WOOL_PANTS);

        dyeableItem(TextileItems.SILK_HAT);
        dyeableItem(TextileItems.SILK_SHIRT);
        dyeableItem(TextileItems.SILK_PANTS);

        dyeableItem(TextileItems.LINEN_HAT);
        dyeableItem(TextileItems.LINEN_SHIRT);
        dyeableItem(TextileItems.LINEN_PANTS);

        dyeableItem(TextileItems.BURLAP_HAT);
        dyeableItem(TextileItems.BURLAP_SHIRT);
        dyeableItem(TextileItems.BURLAP_PANTS);
        
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder dyeableItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(MOD_ID, "item/" + item.getId().getPath()))
                .texture("layer1", new ResourceLocation(MOD_ID, "item/"+ item.getId().getPath() + "_overlay"));
    }
}
