package net.atobaazul.textile.registries;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

import static net.atobaazul.textile.Textile.MOD_ID;
import static net.atobaazul.textile.registries.TextileMaterials.*;


public class TextileItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    private static final List<ArmorItem.Type> equipSlots = ImmutableList.of(ArmorItem.Type.HELMET, ArmorItem.Type.CHESTPLATE, ArmorItem.Type.LEGGINGS, ArmorItem.Type.BOOTS);

    public static final List<DeferredItem<Item>> BLACK_BEAR_CLOTHES = armorSet("black_bear", BLACK_BEAR_MATERIAL);
    public static final List<DeferredItem<Item>> CARIBOU_CLOTHES = armorSet("caribou", CARIBOU_MATERIAL);
    public final static List<DeferredItem<Item>> COUGAR_CLOTHES = armorSet("cougar", COUGAR_MATERIAL);
    public final static List<DeferredItem<Item>> CROCODILE_CLOTHES = armorSet("crocodile", CROCODILE_MATERIAL);
    public final static List<DeferredItem<Item>> DIREWOLF_CLOTHES = armorSet("direwolf", DIREWOLF_MATERIAL);
    public final static List<DeferredItem<Item>> GRIZZLY_BEAR_CLOTHES = armorSet("grizzly_bear", GRIZZLY_BEAR_MATERIAL);
    public final static List<DeferredItem<Item>> LION_CLOTHES = armorSet("lion", LION_MATERIAL);
    public final static List<DeferredItem<Item>> PANTHER_CLOTHES = armorSet("panther", PANTHER_MATERIAL);
    public final static List<DeferredItem<Item>> POLAR_BEAR_CLOTHES = armorSet("polar_bear", POLAR_BEAR_MATERIAL);
    public final static List<DeferredItem<Item>> RAW_HIDE_CLOTHES = armorSet("raw", RAW_HIDE_MATERIAL);
    public final static List<DeferredItem<Item>> SABERTOOTH_CLOTHES = armorSet("sabertooth", SABERTOOTH_MATERIAL);
    public final static List<DeferredItem<Item>> TIGER_CLOTHES = armorSet("tiger", TIGER_MATERIAL);
    public final static List<DeferredItem<Item>> BISON_CLOTHES = armorSet("bison", BISON_MATERIAL);
    public final static List<DeferredItem<Item>> YAK_CLOTHES = armorSet("yak", YAK_MATERIAL);


    public static final List<DeferredItem<Item>> FURS = ImmutableList.of(
            furItem("black_bear"),
            furItem("caribou"),
            furItem("cougar"),
            basicItem("crocodile_leather"),
            furItem("direwolf"),
            furItem("grizzly_bear"),
            furItem("lion"),
            furItem("panther"),
            furItem("polar_bear"),
            furItem("sabertooth"),
            furItem("tiger"),
            furItem("bison"),
            furItem("yak")
    );
    public static final DeferredItem<Item> PRIMITIVE_INSULATION = basicItem("primitive_insulation");



    private static List<DeferredItem<Item>> armorSet(String name, Holder<ArmorMaterial> material) {
        List<DeferredItem<Item>> armors = new ArrayList<>();

        equipSlots.forEach((slot) -> {
            armors.add(ITEMS.register(name + "_" + slot.toString().toLowerCase(), () -> new ArmorItem(material, slot, new Item.Properties().stacksTo(1).durability(1))));
        });

        return armors;
    }

    private static DeferredItem<Item> basicItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().stacksTo(32)));
    }

    private static DeferredItem<Item> furItem(String name) {
        return ITEMS.register(name + "_fur", () -> new Item(new Item.Properties().stacksTo(32)));
    }
}
