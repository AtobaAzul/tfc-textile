package net.atobaazul.textile.registries;

import net.atobaazul.textile.common.block.crop.*;

import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static net.atobaazul.textile.Textile.*;
import static net.atobaazul.textile.Textile.MOD_ID;
import static net.atobaazul.textile.registries.TextileItems.*;

public class TextileBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);

    public static final DeferredBlock<Block> DEAD_FLAX_CROP = BLOCKS.register("dead_crop/flax", () -> new DeadFlaxCropBlock(dead(), FLAX_CLIMATE_RANGE));
    public static final DeferredBlock<Block> FLAX_CROP = BLOCKS.register("crop/flax", () -> new FlaxCropBlock(doubleCrop(), 2, 4, DEAD_FLAX_CROP, FLAX_SEEDS, 0.6f, 0.4f, -0.4f, FLAX_CLIMATE_RANGE));
    public static final DeferredBlock<Block> WILD_FLAX_CROP = BLOCKS.register("wild_crop/flax", ()-> new WildFlaxCropBlock(doubleCrop()));

    public static final DeferredBlock<Block> DEAD_COTTON_CROP = BLOCKS.register("dead_crop/cotton", () -> new DeadCottonCropBlock(dead(), COTTON_CLIMATE_RANGE));
    public static final DeferredBlock<Block> COTTON_CROP = BLOCKS.register("crop/cotton", () -> new CottonCropBlock(doubleCrop(), 1, 5, DEAD_COTTON_CROP, COTTON_SEEDS, 0.6f, 0.4f, -0.4f, COTTON_CLIMATE_RANGE));
    public static final DeferredBlock<Block> WILD_COTTON_CROP = BLOCKS.register("wild_crop/cotton", ()-> new WildCottonCropBlock(doubleCrop()));

    private static ExtendedProperties doubleCrop()
    {
        return dead().blockEntity(CROP).serverTicks(TextileCropBlockEntity::serverTickBottomPartOnly);
    }

    private static ExtendedProperties crop()
    {
        return dead().blockEntity(CROP).serverTicks(TextileCropBlockEntity::serverTick);
    }

    private static ExtendedProperties dead()
    {
        return ExtendedProperties.of(MapColor.PLANT).noCollission().randomTicks().strength(0.4F).sound(SoundType.CROP).flammable(60, 30).pushReaction(PushReaction.DESTROY);
    }

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MOD_ID);


    public static List<Supplier<Block>> cropBlocks = List.of(
            FLAX_CROP,
            WILD_FLAX_CROP,
            COTTON_CROP,
            WILD_COTTON_CROP
    );


    public static final Supplier<BlockEntityType<TextileCropBlockEntity>> CROP = register(BLOCK_ENTITIES, "flax", TextileCropBlockEntity::new, cropBlocks.stream());

    public static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(DeferredRegister<BlockEntityType<?>> blockEntities, String name, BlockEntityType.BlockEntitySupplier<T> factory, Stream<? extends Supplier<? extends Block>> blocks)
    {
        return blockEntities.register(name, () -> BlockEntityType.Builder.of(factory, blocks.map(Supplier::get).toArray(Block[]::new)).build(null));
    }


}
