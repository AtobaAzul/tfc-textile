package net.atobaazul.textile.item.armor;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.ItemStack;

public class DyeableLinenClothingItem extends DyeableArmorItem {
    public DyeableLinenClothingItem(ArmorMaterial p_266710_, Type p_267178_, Properties p_267093_) {
        super(p_266710_, p_267178_, p_267093_);
    }

    @Override
    public int getColor(ItemStack pStack) {
        CompoundTag compoundtag = pStack.getTagElement("display");
        return compoundtag != null && compoundtag.contains("color", 99) ? compoundtag.getInt("color") : 16709312;
    }
}
