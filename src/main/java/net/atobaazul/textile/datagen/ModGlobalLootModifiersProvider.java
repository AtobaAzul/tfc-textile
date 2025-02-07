package net.atobaazul.textile.datagen;

import net.atobaazul.textile.Textile;
import net.atobaazul.textile.loot.AddItemModifier;
import net.atobaazul.textile.loot.RemoveItemModifier;
import net.atobaazul.textile.registries.TextileItems;
import net.dries007.tfc.common.items.HideItemType;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.HashMap;
import java.util.Map;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    private static final Map<String, Item> FUR_DEFS = new HashMap<>();

    static {
        FUR_DEFS.put("black_bear", TextileItems.BLACK_BEAR_FUR.get());
        FUR_DEFS.put("caribou", TextileItems.CARIBOU_FUR.get());
        FUR_DEFS.put("crocodile", TextileItems.CROCODILE_LEATHER.get());
        FUR_DEFS.put("direwolf", TextileItems.DIREWOLF_FUR.get());
        FUR_DEFS.put("grizzly_bear", TextileItems.GRIZZLY_BEAR_FUR.get());
        FUR_DEFS.put("lion", TextileItems.LION_FUR.get());
        FUR_DEFS.put("panther", TextileItems.PANTHER_FUR.get());
        FUR_DEFS.put("polar_bear", TextileItems.POLAR_BEAR_FUR.get());
        FUR_DEFS.put("sabertooth", TextileItems.SABERTOOTH_FUR.get());
        FUR_DEFS.put("tiger", TextileItems.TIGER_FUR.get());
        FUR_DEFS.put("cougar", TextileItems.COUGAR_FUR.get());
    }

    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Textile.MOD_ID);
    }

    @Override
    protected void start() {
        FUR_DEFS.forEach((k, v) -> {
            add(k + "_fur_add", new AddItemModifier(new LootItemCondition[]{
                    new LootTableIdCondition.Builder(new ResourceLocation("tfc:entities/" + k)).build()}, v));
            add(k + "_remove_medium_hide", new RemoveItemModifier(new LootItemCondition[]{
                    new LootTableIdCondition.Builder(new ResourceLocation("tfc:entities/" + k)).build()}, TFCItems.HIDES.get(HideItemType.RAW).get(HideItemType.Size.LARGE).get()));
            add(k + "_remove_large_hide", new RemoveItemModifier(new LootItemCondition[]{
                    new LootTableIdCondition.Builder(new ResourceLocation("tfc:entities/" + k)).build()}, TFCItems.HIDES.get(HideItemType.RAW).get(HideItemType.Size.MEDIUM).get()));

        });

    }
}
