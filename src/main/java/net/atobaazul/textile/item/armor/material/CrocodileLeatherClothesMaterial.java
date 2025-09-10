package net.atobaazul.textile.item.armor.material;


import net.atobaazul.textile.registries.TextileItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class CrocodileLeatherClothesMaterial implements ArmorMaterial {

    public static final CrocodileLeatherClothesMaterial MATERIAL = new CrocodileLeatherClothesMaterial();

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return 400;
    }

    private int getDefenseForSlot(int slotNum) {
        return switch (slotNum) {
            case 0 -> // helmet
                    1;
            case 1 -> //chestplate
                    3;
            case 2 -> //leggings
                    2;
            case 3 -> //boots
                    1;
            default -> 0;
        };
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return getDefenseForSlot(pType.ordinal());
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
        return Ingredient.of(new ItemStack(TextileItems.CROCODILE_LEATHER.get(), 1));
    }

    @Override
    public @NotNull String getName() {
        return "textile:crocodile_leather";
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

