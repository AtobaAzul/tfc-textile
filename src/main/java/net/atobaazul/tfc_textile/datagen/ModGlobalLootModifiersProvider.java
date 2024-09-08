package net.atobaazul.tfc_textile.datagen;

import net.atobaazul.tfc_textile.TFCtextile;
import net.atobaazul.tfc_textile.item.TFCTextileItems;
import net.atobaazul.tfc_textile.loot.AddItemModifier;
import net.atobaazul.tfc_textile.loot.RemoveItemModifier;
import net.dries007.tfc.common.items.HideItemType;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, TFCtextile.MODID);
    }

    @Override
    protected void start() {
        add("blackbear_fur_add", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("tfc:entities/black_bear")).build() }, TFCTextileItems.BLACKBEAR_FUR.get()));

        add("remove_hide", new RemoveItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("tfc:entities/black_bear")).build() }, TFCItems.HIDES.get(HideItemType.RAW).get(HideItemType.Size.LARGE).get()));

    }
}
