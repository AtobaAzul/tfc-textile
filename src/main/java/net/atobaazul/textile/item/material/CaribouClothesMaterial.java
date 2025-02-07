package net.atobaazul.textile.item.material;


import net.atobaazul.textile.item.TextileItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;


public class CaribouClothesMaterial implements ArmorMaterial {

    public static final CaribouClothesMaterial MATERIAL = new CaribouClothesMaterial();

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
        return Ingredient.of(new ItemStack(TextileItems.CARIBOU_FUR.get(), 1));
    }

    @Override
    public @NotNull String getName() {
        return "textile:caribou_fur";
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
