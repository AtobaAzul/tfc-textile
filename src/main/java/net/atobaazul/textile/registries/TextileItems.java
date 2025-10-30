package net.atobaazul.textile.registries;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.atobaazul.textile.Textile.MOD_ID;
import static net.atobaazul.textile.registries.TextileMaterials.*;


public class TextileItems {
    private static final List<ArmorItem.Type> equipSlots = ImmutableList.of(ArmorItem.Type.HELMET, ArmorItem.Type.CHESTPLATE, ArmorItem.Type.LEGGINGS, ArmorItem.Type.BOOTS);
    private static final Map<ArmorItem.Type, Float> durabilityMap = Map.of(
            ArmorItem.Type.HELMET, 55/80f,
            ArmorItem.Type.CHESTPLATE, 1f,
            ArmorItem.Type.LEGGINGS, 75/80f,
            ArmorItem.Type.BOOTS, 65/80f
    );

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

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

    //basic items
    public static final DeferredItem<Item> PRIMITIVE_INSULATION = basicItem("primitive_insulation");
    public static final DeferredItem<Item> COTTON_BALL = basicItem("cotton_ball");
    public static final DeferredItem<Item> COTTON_STRING = basicItem("cotton_string");
    public static final DeferredItem<Item> COTTON_CLOTH = basicItem("cotton_cloth");
    public static final DeferredItem<Item> FLAX = basicItem("flax");
    public static final DeferredItem<Item> FLAX_FIBER = basicItem("flax_fiber");
    public static final DeferredItem<Item> LINEN_CLOTH = basicItem("linen_cloth");

    //fur clothes
    public static final List<DeferredItem<Item>> BLACK_BEAR_CLOTHES = armorSet("black_bear", BLACK_BEAR_MATERIAL, 90);
    public static final List<DeferredItem<Item>> CARIBOU_CLOTHES = armorSet("caribou", CARIBOU_MATERIAL, 90);
    public final static List<DeferredItem<Item>> COUGAR_CLOTHES = armorSet("cougar", COUGAR_MATERIAL, 90);
    public final static List<DeferredItem<Item>> CROCODILE_CLOTHES = armorSet("crocodile", CROCODILE_MATERIAL, 90);
    public final static List<DeferredItem<Item>> DIREWOLF_CLOTHES = armorSet("direwolf", DIREWOLF_MATERIAL, 90);
    public final static List<DeferredItem<Item>> GRIZZLY_BEAR_CLOTHES = armorSet("grizzly_bear", GRIZZLY_BEAR_MATERIAL, 90);
    public final static List<DeferredItem<Item>> LION_CLOTHES = armorSet("lion", LION_MATERIAL, 90);
    public final static List<DeferredItem<Item>> PANTHER_CLOTHES = armorSet("panther", PANTHER_MATERIAL, 90);
    public final static List<DeferredItem<Item>> POLAR_BEAR_CLOTHES = armorSet("polar_bear", POLAR_BEAR_MATERIAL, 90);
    public final static List<DeferredItem<Item>> RAW_HIDE_CLOTHES = armorSetWithoutBoots("raw", RAW_HIDE_MATERIAL, 90);
    public final static List<DeferredItem<Item>> SABERTOOTH_CLOTHES = armorSet("sabertooth", SABERTOOTH_MATERIAL, 90);
    public final static List<DeferredItem<Item>> TIGER_CLOTHES = armorSet("tiger", TIGER_MATERIAL, 90);
    public final static List<DeferredItem<Item>> BISON_CLOTHES = armorSet("bison", BISON_MATERIAL, 90);
    public final static List<DeferredItem<Item>> YAK_CLOTHES = armorSet("yak", YAK_MATERIAL, 90);

    //cloth clothes
    public final static List<DeferredItem<Item>> LINEN_CLOTHES = armorSetWithoutBoots("linen", LINEN_MATERIAL, 50);
    public final static List<DeferredItem<Item>> COTTON_CLOTHES = armorSetWithoutBoots("cotton", COTTON_MATERIAL, 50);

    public static final DeferredItem<ItemNameBlockItem> FLAX_SEEDS = ITEMS.register("seeds/flax", ()-> new ItemNameBlockItem(TextileBlocks.FLAX_CROP.get(), new Item.Properties()));
    public static final DeferredItem<ItemNameBlockItem> COTTON_SEEDS = ITEMS.register("seeds/cotton", ()-> new ItemNameBlockItem(TextileBlocks.COTTON_CROP.get(), new Item.Properties()));


    //accessories
    public static final DeferredItem<Item> LEATHER_APRON = ITEMS.register("leather_apron", () -> new ArmorItem(ArmorMaterials.LEATHER,ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(60)));
    public static final DeferredItem<Item> UMBRELLA = basicItem("umbrella");

    //gloves
    public static final DeferredItem<Item> LEATHER_GLOVES = basicItem("leather_gloves");
    public static final DeferredItem<Item> WOOL_GLOVES = basicItem("wool_gloves");
    public static final DeferredItem<Item> SILK_GLOVES = basicItem("silk_gloves");
    public static final DeferredItem<Item> COTTON_GLOVES = basicItem("cotton_gloves");


    //scarfs
    public static final DeferredItem<Item> WOOL_SCARF = basicItem("wool_scarf");
    public static final DeferredItem<Item> SILK_SCARF = basicItem("silk_scarf");
    public static final DeferredItem<Item> COTTON_SCARF = basicItem("cotton_scarf");



    //creates a helmet, chestplate, leggings and boots for an armor set of a given material
    private static List<DeferredItem<Item>> armorSet(String name, Holder<ArmorMaterial> material, int baseDurability) {
        List<DeferredItem<Item>> armors = new ArrayList<>();

        equipSlots.forEach((slot) -> {
            armors.add(ITEMS.register(name + "_" + slot.toString().toLowerCase(), () -> new ArmorItem(material, slot, new Item.Properties().stacksTo(1).durability((int) Math.floor((baseDurability*durabilityMap.get(slot)))))));
        });

        return armors;
    }

    private static List<DeferredItem<Item>> armorSetWithoutBoots(String name, Holder<ArmorMaterial> material, int baseDurability) {
        List<DeferredItem<Item>> armors = new ArrayList<>();

        equipSlots.forEach((slot) -> {
            if (!slot.toString().equalsIgnoreCase("boots")) {
                armors.add(ITEMS.register(name + "_" + slot.toString().toLowerCase(), () -> new ArmorItem(material, slot, new Item.Properties().stacksTo(1).durability((int) Math.floor((baseDurability*durabilityMap.get(slot)))))));
            }
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
