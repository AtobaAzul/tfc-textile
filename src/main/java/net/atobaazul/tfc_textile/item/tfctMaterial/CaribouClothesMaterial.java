package net.atobaazul.tfc_textile.item.tfctMaterial;

import com.lumintorious.tfcambiental.item.material.TemperatureAlteringMaterial;
import com.lumintorious.tfcambiental.modifier.TempModifier;
import net.atobaazul.tfc_textile.item.TFCTextileItems;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;


public class CaribouClothesMaterial implements ArmorMaterial, TemperatureAlteringMaterial {

    public static final CaribouClothesMaterial MATERIAL = new CaribouClothesMaterial();

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return 4000;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return 0;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return SoundEvents.WOOL_PLACE;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(TFCTextileItems.CARIBOU_FUR.get(), 1));
    }

    @Override
    public @NotNull String getName() {
        return "tfc_textile:caribou_fur";
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }

    @Override
    public TempModifier getTempModifier(ItemStack stack) {
        return new TempModifier(ForgeRegistries.ITEMS.getKey(stack.getItem()).toString(), 6f, -0.15f,-0.15f);
    }
}
