package net.atobaazul.tfc_textile.item.tfctMaterial;



import com.lumintorious.tfcambiental.modifier.TempModifier;

import com.lumintorious.tfcambiental.item.material.TemperatureAlteringMaterial;

import net.atobaazul.tfc_textile.item.TFCTextileItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;


public class LinenClothesMaterial implements ArmorMaterial, TemperatureAlteringMaterial
{
    public static final LinenClothesMaterial MATERIAL = new LinenClothesMaterial();

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return 3000;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return 0;
    }

    @Override
    public int getEnchantmentValue() {
        return 1;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return SoundEvents.WOOL_PLACE;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemStack(TFCTextileItems.LINEN_CLOTH.get(), 1));
    }

    @Override
    public @NotNull String getName() {
        return "tfc_textile:linen_cloth";
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
        return new TempModifier(ForgeRegistries.ITEMS.getKey(stack.getItem()).toString(), -0.5f, -0.25f);
    }
}