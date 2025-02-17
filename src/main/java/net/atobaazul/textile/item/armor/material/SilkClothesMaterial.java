package net.atobaazul.textile.item.armor.material;

import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class SilkClothesMaterial implements ArmorMaterial {

    public static final SilkClothesMaterial MATERIAL = new SilkClothesMaterial();

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return 3000;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return 1;
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
        return Ingredient.of(new ItemStack(TFCItems.SILK_CLOTH.get(), 1));
    }

    @Override
    public @NotNull String getName() {
        return "textile:silk";
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
