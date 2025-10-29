package net.atobaazul.textile.common.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.ArrayList;

import static net.atobaazul.textile.common.item.TextileItemTags.REPLACEABLE_HIDE;

public class ReplaceHideModifier extends LootModifier {
    public static final MapCodec<ReplaceHideModifier> CODEC = RecordCodecBuilder.mapCodec(inst -> LootModifier.codecStart(inst).and(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(e -> e.item)).apply(inst, ReplaceHideModifier::new));

    private final Item item;

    public ReplaceHideModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }


    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext lootContext) {
        ArrayList<ItemStack> itemsToRemove = new ArrayList<>();


        for (LootItemCondition condition : this.conditions) {
            if (!condition.test(lootContext)) {
                return generatedLoot;
            }
        }

        generatedLoot.forEach((loot) -> {
            if (loot.is(REPLACEABLE_HIDE)) {
                itemsToRemove.add(loot);
            }
        });

        if (!itemsToRemove.isEmpty()) {
            itemsToRemove.forEach(generatedLoot::remove);
            generatedLoot.add(new ItemStack(this.item));
        }


        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
