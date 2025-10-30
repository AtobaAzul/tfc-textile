package net.atobaazul.textile.client;

import net.atobaazul.textile.common.item.TextileItemTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import static net.atobaazul.textile.registries.TextileItems.*;

public class TextileIClientExtensions implements IClientItemExtensions {
    @Override
    public int getDefaultDyeColor(ItemStack stack) {
        int color = DyedItemColor.LEATHER_COLOR;
        if (stack.is(ItemTags.DYEABLE)) {
            if (stack.is(TextileItemTags.LINEN_CLOTHES_TAG)) {
                color = 0xe9dcbd;
            } else if (stack.is(TextileItemTags.COTTON_CLOTHES_TAG) || stack.is(COTTON_GLOVES) || stack.is(COTTON_SCARF) || stack.is(WOOL_GLOVES) || stack.is(WOOL_SCARF) || stack.is(SILK_GLOVES) ||stack.is(SILK_SCARF)) {
                color = 0xFFFFFFFF;
            }
        }

        return stack.is(ItemTags.DYEABLE) ? FastColor.ARGB32.opaque(DyedItemColor.getOrDefault(stack, color)) : 0xFFFFFFFF;
    }
}
