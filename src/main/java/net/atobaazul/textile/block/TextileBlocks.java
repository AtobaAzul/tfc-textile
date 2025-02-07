package net.atobaazul.textile.block;

import net.atobaazul.textile.TextileHelpers;
import net.atobaazul.textile.crop.TextileCrop;
import net.atobaazul.textile.registries.TextileItems;
import net.dries007.tfc.util.registry.RegistrationHelpers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static net.atobaazul.textile.Textile.MOD_ID;

@SuppressWarnings("unused")
public class TextileBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, MOD_ID);

    public static final Map<TextileCrop, RegistryObject<Block>> CROPS = TextileHelpers.mapOfKeys(TextileCrop.class, crop ->
            registerNoItem("crop/" + crop.name(), crop::create)
    );

    public static final Map<TextileCrop, RegistryObject<Block>> DEAD_CROPS = TextileHelpers.mapOfKeys(TextileCrop.class, crop ->
            registerNoItem("dead_crop/" + crop.name(), crop::createDead)
    );

    public static final Map<TextileCrop, RegistryObject<Block>> WILD_CROPS = TextileHelpers.mapOfKeys(TextileCrop.class, crop ->
            register("wild_crop/" + crop.name(), crop::createWild)
    );


    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> blockSupplier) {
        return register(name, blockSupplier, (Function<T, ? extends BlockItem>) null);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier) {
        return register(name, blockSupplier, block -> new BlockItem(block, new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier, Item.Properties blockItemProperties) {
        return register(name, blockSupplier, block -> new BlockItem(block, blockItemProperties));
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier, @Nullable Function<T, ? extends BlockItem> blockItemFactory) {
        return RegistrationHelpers.registerBlock(TextileBlocks.BLOCKS, TextileItems.ITEMS, name, blockSupplier, blockItemFactory);
    }

}
