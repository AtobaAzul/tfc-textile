package net.atobaazul.tfc_textile_coldsweat.item;

import net.atobaazul.tfc_textile_coldsweat.TFCtextile;
import net.atobaazul.tfc_textile_coldsweat.item.tfctMaterial.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class TFCTextileItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TFCtextile.MODID);


    //ingredients

    public static final RegistryObject<Item> COTTON_CLOTH = ITEMS.register(
            "cotton_cloth",
            () -> new Item(new Item.Properties().stacksTo(32))

    );

    public static final RegistryObject<Item> COTTON_STRING = ITEMS.register(
            "cotton_string",
            () -> new Item(new Item.Properties().stacksTo(32))

    );

    public static final RegistryObject<Item> CROCODILE_LEATHER = ITEMS.register(
            "crocodile_leather",
            () -> new Item(new Item.Properties().stacksTo(32))

    );

    public static final RegistryObject<Item> PRIMITIVE_INSULATION = ITEMS.register(
            "primitive_insulation",
            () -> new Item(new Item.Properties().stacksTo(32))

    );


    public static final RegistryObject<Item> LINEN_CLOTH = ITEMS.register(
            "linen_cloth",
            () -> new Item(new Item.Properties().stacksTo(32))

    );
    public static final RegistryObject<Item> CARIBOU_FUR = ITEMS.register(
            "caribou_fur",
            () -> new Item(new Item.Properties().stacksTo(32))

    );
    public static final RegistryObject<Item> POLAR_BEAR_FUR = ITEMS.register(
            "polar_bear_fur",
            () -> new Item(new Item.Properties().stacksTo(32))

    );
    public static final RegistryObject<Item> BLACK_BEAR_FUR = ITEMS.register(
            "black_bear_fur",
            () -> new Item(new Item.Properties().stacksTo(32))

    );
    public static final RegistryObject<Item> GRIZZLY_BEAR_FUR = ITEMS.register(
            "grizzly_bear_fur",
            () -> new Item(new Item.Properties().stacksTo(32))

    );
    public static final RegistryObject<Item> PANTHER_FUR = ITEMS.register(
            "panther_fur",
            () -> new Item(new Item.Properties().stacksTo(32))

    );
    public static final RegistryObject<Item> SABERTOOTH_FUR = ITEMS.register(
            "sabertooth_fur",
            () -> new Item(new Item.Properties().stacksTo(32))

    );
    public static final RegistryObject<Item> TIGER_FUR = ITEMS.register(
            "tiger_fur",
            () -> new Item(new Item.Properties().stacksTo(32))

    );
    public static final RegistryObject<Item> COUGAR_FUR = ITEMS.register(
            "cougar_fur",
            () -> new Item(new Item.Properties().stacksTo(32))

    );
    public static final RegistryObject<Item> DIREWOLF_FUR = ITEMS.register(
            "direwolf_fur",
            () -> new Item(new Item.Properties().stacksTo(32))

    );
    public static final RegistryObject<Item> LION_FUR = ITEMS.register(
            "lion_fur",
            () -> new Item(new Item.Properties().stacksTo(32))

    );





    public static final RegistryObject<Item> COTTON_HAT = ITEMS.register(
            "cotton_hat",
            () -> new ArmorItem(CottonClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> COTTON_SHIRT = ITEMS.register(
            "cotton_shirt",
            () -> new ArmorItem(CottonClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> COTTON_PANTS = ITEMS.register(
            "cotton_pants",
            () -> new ArmorItem(CottonClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> COTTON_SOCKS = ITEMS.register(
            "cotton_socks",
            () -> new ArmorItem(CottonClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );



    //crocodile clothes

    public static final RegistryObject<Item> CROCODILE_HAT = ITEMS.register(
            "crocodile_hat",
            () -> new ArmorItem(CrocodileLeatherClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> CROCODILE_SHIRT = ITEMS.register(
            "crocodile_shirt",
            () -> new ArmorItem(CrocodileLeatherClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> CROCODILE_PANTS = ITEMS.register(
            "crocodile_pants",
            () -> new ArmorItem(CrocodileLeatherClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> CROCODILE_BOOTS = ITEMS.register(
            "crocodile_boots",
            () -> new ArmorItem(CrocodileLeatherClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );



    //linen clothes


    public static final RegistryObject<Item> LINEN_HAT = ITEMS.register(
            "linen_hat",
            () -> new ArmorItem(LinenClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> LINEN_SHIRT = ITEMS.register(
            "linen_shirt",
            () -> new ArmorItem(LinenClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> LINEN_PANTS = ITEMS.register(
            "linen_pants",
            () -> new ArmorItem(LinenClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> LINEN_SOCKS = ITEMS.register(
            "linen_socks",
            () -> new ArmorItem(LinenClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );


    //caveman clothes

    public static final RegistryObject<Item> RAW_HAT = ITEMS.register(
            "raw_hat",
            () -> new ArmorItem(RawHideClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> RAW_SHIRT = ITEMS.register(
            "raw_shirt",
            () -> new ArmorItem(RawHideClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> RAW_PANTS = ITEMS.register(
            "raw_pants",
            () -> new ArmorItem(RawHideClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> RAW_SOCKS = ITEMS.register(
            "raw_socks",
            () -> new ArmorItem(RawHideClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );


    //Artic-caribou

    public static final RegistryObject<Item> CARIBOU_HAT = ITEMS.register(
            "caribou_hat",
            () -> new ArmorItem(CaribouClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> CARIBOU_SHIRT = ITEMS.register(
            "caribou_shirt",
            () -> new ArmorItem(CaribouClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> CARIBOU_PANTS = ITEMS.register(
            "caribou_pants",
            () -> new ArmorItem(CaribouClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> CARIBOU_SOCKS = ITEMS.register(
            "caribou_boots",
            () -> new ArmorItem(CaribouClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );

    //Artic-polar bear


    public static final RegistryObject<Item> POLAR_HAT = ITEMS.register(
            "polar_bear_hat",
            () -> new ArmorItem(PolarBearClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> POLAR_SHIRT = ITEMS.register(
            "polar_bear_shirt",
            () -> new ArmorItem(PolarBearClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> POLAR_PANTS = ITEMS.register(
            "polar_bear_pants",
            () -> new ArmorItem(PolarBearClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> POLAR_SOCKS = ITEMS.register(
            "polar_bear_boots",
            () -> new ArmorItem(PolarBearClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );

    //Tiger

    public static final RegistryObject<Item> TIGER_HAT = ITEMS.register(
            "tiger_hat",
            () -> new ArmorItem(TigerClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> TIGER_SHIRT = ITEMS.register(
            "tiger_shirt",
            () -> new ArmorItem(TigerClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> TIGER_PANTS = ITEMS.register(
            "tiger_pants",
            () -> new ArmorItem(TigerClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> TIGER_SOCKS = ITEMS.register(
            "tiger_boots",
            () -> new ArmorItem(TigerClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );

    //Cougar


    public static final RegistryObject<Item> COUGAR_HAT = ITEMS.register(
            "cougar_hat",
            () -> new ArmorItem(CougarClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> COUGAR_SHIRT = ITEMS.register(
            "cougar_shirt",
            () -> new ArmorItem(CougarClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> COUGAR_PANTS = ITEMS.register(
            "cougar_pants",
            () -> new ArmorItem(CougarClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> COUGAR_SOCKS = ITEMS.register(
            "cougar_boots",
            () -> new ArmorItem(CougarClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );

    //Panther


    public static final RegistryObject<Item> PANTHER_HAT = ITEMS.register(
            "panther_hat",
            () -> new ArmorItem(PantherClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> PANTHER_SHIRT = ITEMS.register(
            "panther_shirt",
            () -> new ArmorItem(PantherClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> PANTHER_PANTS = ITEMS.register(
            "panther_pants",
            () -> new ArmorItem(PantherClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> PANTHER_SOCKS = ITEMS.register(
            "panther_boots",
            () -> new ArmorItem(PantherClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );

    // Sabertooth


    public static final RegistryObject<Item> SABERTOOTH_HAT = ITEMS.register(
            "sabertooth_hat",
            () -> new ArmorItem(SabertoothClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> SABERTOOTH_SHIRT = ITEMS.register(
            "sabertooth_shirt",
            () -> new ArmorItem(SabertoothClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> SABERTOOTH_PANTS = ITEMS.register(
            "sabertooth_pants",
            () -> new ArmorItem(SabertoothClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> SABERTOOTH_SOCKS = ITEMS.register(
            "sabertooth_boots",
            () -> new ArmorItem(SabertoothClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );

    // Black Bear


    public static final RegistryObject<Item> BLACK_BEAR_HAT = ITEMS.register(
            "black_bear_hat",
            () -> new ArmorItem(BlackBearClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> BLACK_BEAR_SHIRT = ITEMS.register(
            "black_bear_shirt",
            () -> new ArmorItem(BlackBearClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> BLACK_BEAR_PANTS = ITEMS.register(
            "black_bear_pants",
            () -> new ArmorItem(BlackBearClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> BLACK_BEAR_SOCKS = ITEMS.register(
            "black_bear_boots",
            () -> new ArmorItem(BlackBearClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );

    // Grizzly Bear


    public static final RegistryObject<Item> GRIZZLY_BEAR_HAT = ITEMS.register(
            "grizzly_bear_hat",
            () -> new ArmorItem(GrizzlyBearClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> GRIZZLY_BEAR_SHIRT = ITEMS.register(
            "grizzly_bear_shirt",
            () -> new ArmorItem(GrizzlyBearClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> GRIZZLY_BEAR_PANTS = ITEMS.register(
            "grizzly_bear_pants",
            () -> new ArmorItem(GrizzlyBearClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> GRIZZLY_BEAR_SOCKS = ITEMS.register(
            "grizzly_bear_boots",
            () -> new ArmorItem(GrizzlyBearClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );

    // Dire Wolf


    public static final RegistryObject<Item> DIREWOLF_HAT = ITEMS.register(
            "direwolf_hat",
            () -> new ArmorItem(DireWolfClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> DIREWOLF_SHIRT = ITEMS.register(
            "direwolf_shirt",
            () -> new ArmorItem(DireWolfClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> DIREWOLF_PANTS = ITEMS.register(
            "direwolf_pants",
            () -> new ArmorItem(DireWolfClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> DIREWOLF_SOCKS = ITEMS.register(
            "direwolf_boots",
            () -> new ArmorItem(DireWolfClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );

    // Lion


    public static final RegistryObject<Item> LION_HAT = ITEMS.register(
            "lion_hat",
            () -> new ArmorItem(LionClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> LION_SHIRT = ITEMS.register(
            "lion_shirt",
            () -> new ArmorItem(LionClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> LION_PANTS = ITEMS.register(
            "lion_pants",
            () -> new ArmorItem(LionClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> LION_SOCKS = ITEMS.register(
            "lion_boots",
            () -> new ArmorItem(LionClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );

    //Wool
    public static final RegistryObject<Item> WOOL_HAT = ITEMS.register(
            "wool_hat",
            () -> new ArmorItem(WoolClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> WOOL_SHIRT = ITEMS.register(
            "wool_shirt",
            () -> new ArmorItem(WoolClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> WOOL_PANTS = ITEMS.register(
            "wool_pants",
            () -> new ArmorItem(WoolClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );


    //Burlap
    public static final RegistryObject<Item> BURLAP_HAT = ITEMS.register(
            "burlap_hat",
            () -> new ArmorItem(BurlapClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> BURLAP_SHIRT = ITEMS.register(
            "burlap_shirt",
            () -> new ArmorItem(BurlapClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> BURLAP_PANTS = ITEMS.register(
            "burlap_pants",
            () -> new ArmorItem(BurlapClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );


    //Silk

    public static final RegistryObject<Item> SILK_HAT = ITEMS.register(
            "silk_hat",
            () -> new ArmorItem(SilkClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> SILK_SHIRT = ITEMS.register(
            "silk_shirt",
            () -> new ArmorItem(SilkClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> SILK_PANTS = ITEMS.register(
            "silk_pants",
            () -> new ArmorItem(SilkClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );

    /*public static final RegistryObject<Item> SILK_COWL = ITEMS.register(
            "silk_cowl",
            () -> new ArmorItem(SilkClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );
    public static final RegistryObject<Item> SILK_SHIRT = ITEMS.register(
            "silk_shirt",
            () -> new ArmorItem(SilkClothesMaterial.MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(80))
    );
    public static final RegistryObject<Item> SILK_PANTS = ITEMS.register(
            "silk_pants",
            () -> new ArmorItem(SilkClothesMaterial.MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(75))
    );
    public static final RegistryObject<Item> SILK_SHOES = ITEMS.register(
            "silk_shoes",
            () -> new ArmorItem(SilkClothesMaterial.MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(65))
    );

    public static final RegistryObject<Item> BURLAP_COWL = ITEMS.register(
            "burlap_cowl",
            () -> new ArmorItem(BurlapClothesMaterial.MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(60))
    );*/

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}