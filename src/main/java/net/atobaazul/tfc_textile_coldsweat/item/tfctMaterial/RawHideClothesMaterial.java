package net.atobaazul.tfc_textile_coldsweat.item.tfctMaterial;

import net.atobaazul.tfc_textile_coldsweat.item.TFCTextileItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class RawHideClothesMaterial implements ArmorMaterial {

    public static final RawHideClothesMaterial MATERIAL = new RawHideClothesMaterial();

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return 1500;
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
        return Ingredient.of(new ItemStack(TFCTextileItems.PRIMITIVE_INSULATION.get(), 1));    }

    @Override
    public @NotNull String getName() {
        return "tfc_textile_coldsweat:raw_hide";
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
