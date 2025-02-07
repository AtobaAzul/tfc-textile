package net.atobaazul.textile.item.armor.material;

import net.atobaazul.textile.registries.TextileItems;
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
        return Ingredient.of(new ItemStack(TextileItems.PRIMITIVE_INSULATION.get(), 1));
    }

    @Override
    public @NotNull String getName() {
        return "textile:raw_hide";
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
