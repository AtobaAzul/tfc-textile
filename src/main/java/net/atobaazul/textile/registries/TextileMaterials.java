package net.atobaazul.textile.registries;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

import static net.atobaazul.textile.Textile.MOD_ID;
import static net.atobaazul.textile.Textile.textileResource;

public class TextileMaterials {
    public static final DeferredRegister<ArmorMaterial> MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, MOD_ID);


    public final static Holder<ArmorMaterial> BLACK_BEAR_MATERIAL = createFurArmorMaterial("black_bear");
    public final static Holder<ArmorMaterial> CARIBOU_MATERIAL = createFurArmorMaterial("caribou");
    public final static Holder<ArmorMaterial> COUGAR_MATERIAL = createFurArmorMaterial("cougar");
    public final static Holder<ArmorMaterial> CROCODILE_MATERIAL = createFurArmorMaterial("crocodile");
    public final static Holder<ArmorMaterial> DIREWOLF_MATERIAL = createFurArmorMaterial("direwolf");
    public final static Holder<ArmorMaterial> GRIZZLY_BEAR_MATERIAL = createFurArmorMaterial("grizzly_bear");
    public final static Holder<ArmorMaterial> LION_MATERIAL = createFurArmorMaterial("lion");
    public final static Holder<ArmorMaterial> PANTHER_MATERIAL = createFurArmorMaterial("panther");
    public final static Holder<ArmorMaterial> POLAR_BEAR_MATERIAL = createFurArmorMaterial("polar_bear");
    public final static Holder<ArmorMaterial> RAW_HIDE_MATERIAL = createFurArmorMaterial("raw_hide");
    public final static Holder<ArmorMaterial> SABERTOOTH_MATERIAL = createFurArmorMaterial("sabertooth");
    public final static Holder<ArmorMaterial> TIGER_MATERIAL = createFurArmorMaterial("tiger");
    public final static Holder<ArmorMaterial> BISON_MATERIAL = createFurArmorMaterial("bison");
    public final static Holder<ArmorMaterial> YAK_MATERIAL = createFurArmorMaterial("yak");


    //for non-dyeable clothing.
    public static Holder<ArmorMaterial> createFurArmorMaterial(String name) {
        ArmorMaterial material = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 1);
            map.put(ArmorItem.Type.LEGGINGS, 2);
            map.put(ArmorItem.Type.CHESTPLATE, 2);
            map.put(ArmorItem.Type.HELMET, 1);
            map.put(ArmorItem.Type.BODY, 4);
        }), 0, Holder.direct(SoundEvents.WOOL_PLACE), () -> Ingredient.EMPTY, List.of(new ArmorMaterial.Layer(textileResource(name), "", true), new ArmorMaterial.Layer(textileResource(name), "", false)), 1, 0);

        return MATERIALS.register(name, () -> material);
    }


}
