package net.atobaazul.tfc_textile_coldsweat.item.tfctMaterial;

import net.atobaazul.tfc_textile_coldsweat.item.TFCTextileItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class PolarBearClothesMaterial implements ArmorMaterial {

    public static final PolarBearClothesMaterial MATERIAL = new PolarBearClothesMaterial();

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return 4000;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return 2;
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
        return Ingredient.of(new ItemStack(TFCTextileItems.POLAR_BEAR_FUR.get(), 1));
    }

    @Override
    public @NotNull String getName() {
        return "tfc_textile_coldsweat:polarbear_fur";
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }

}
