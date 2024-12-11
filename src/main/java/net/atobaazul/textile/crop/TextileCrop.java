package net.atobaazul.textile.crop;

import net.atobaazul.textile.block_entities.TextileBlockEntities;
import net.dries007.tfc.common.blockentities.FarmlandBlockEntity.NutrientType;
import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.util.climate.ClimateRange;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;

public enum TextileCrop implements StringRepresentable {
    COTTON(NutrientType.NITROGEN, 2, 4),
    FLAX(NutrientType.NITROGEN, 2, 3);
    // Grains
    //  BARLEY(NutrientType.NITROGEN, 8), // Default, 8
    //  OAT(NutrientType.PHOSPHOROUS, 8), // Default, 8
    //  RYE(NutrientType.PHOSPHOROUS, 8), // Default, 8
    //   MAIZE(NutrientType.PHOSPHOROUS, 3, 3, false), // Double, 3 -> 3
    //  WHEAT(NutrientType.PHOSPHOROUS, 8), // Default, 8
    //  RICE(NutrientType.PHOSPHOROUS, 8, true), // Default, Waterlogged, 8
    // Vegetables
    //  BEET(NutrientType.POTASSIUM, 6), // Default, 6
    //  CABBAGE(NutrientType.NITROGEN, 6), // Default, 6
    //  CARROT(NutrientType.POTASSIUM, 5), // Default, 5
    //  GARLIC(NutrientType.NITROGEN, 5), // Default, 5
    //  GREEN_BEAN(NutrientType.NITROGEN, 4, 4, true), // Double, Stick, 4 -> 4
    //  POTATO(NutrientType.POTASSIUM, 7), // Default, 7
    //  ONION(NutrientType.NITROGEN, 7), // Default, 7
    //   SOYBEAN(NutrientType.NITROGEN, 7), // Default, 7
    //   SQUASH(NutrientType.POTASSIUM, 8), // Default , 8
    //   SUGARCANE(NutrientType.POTASSIUM, 4, 4, false), // Double, 4 -> 4
    //   TOMATO(NutrientType.POTASSIUM, 4, 4, true, null, () -> TFCItems.FOOD.get(Food.TOMATO)), // Double, Stick, 4 -> 4
    //  JUTE(NutrientType.POTASSIUM, 3, 3, false), // Double, 3 -> 3
    //   PAPYRUS(NutrientType.POTASSIUM, 3, 3, false),
//    PUMPKIN(NutrientType.PHOSPHOROUS, 8, () -> TFCBlocks.PUMPKIN), // Spreading, 8
    //   MELON(NutrientType.PHOSPHOROUS, 8, () -> TFCBlocks.MELON), // Spreading, 8
    //    RED_BELL_PEPPER(NutrientType.POTASSIUM, 7, () -> TFCItems.FOOD.get(Food.GREEN_BELL_PEPPER), () -> TFCItems.FOOD.get(Food.RED_BELL_PEPPER)), // Pickable, 7
    //   YELLOW_BELL_PEPPER(NutrientType.POTASSIUM, 7, () -> TFCItems.FOOD.get(Food.GREEN_BELL_PEPPER), () -> TFCItems.FOOD.get(Food.YELLOW_BELL_PEPPER)); // Pickable, 7

    private final String serializedName;
    private final NutrientType primaryNutrient;
    private final Supplier<Block> factory;
    private final Supplier<Block> deadFactory;
    private final Supplier<Block> wildFactory;

    TextileCrop(NutrientType primaryNutrient, int singleBlockStages) {
        this(primaryNutrient, self -> TextileDefaultCropBlock.create(crop(), singleBlockStages, self), self -> new TextileDeadCropBlock(dead(), self.getClimateRange()), self -> new TextileWildCropBlock(dead().randomTicks()));
    }

    TextileCrop(NutrientType primaryNutrient, int doubleBlockBottomStages, int doubleBlockTopStages) {
        this(primaryNutrient,
                self -> TextileDoubleCropBlock.create(doubleCrop(), doubleBlockBottomStages, doubleBlockTopStages, self),
                self -> new TextileDeadDoubleCropBlock(dead(), self.getClimateRange()), self -> new TextileWildDoubleCropBlock(dead().randomTicks())
        );
    }

    TextileCrop(NutrientType primaryNutrient, Function<TextileCrop, Block> factory, Function<TextileCrop, Block> deadFactory, Function<TextileCrop, Block> wildFactory) {
        this.serializedName = name().toLowerCase(Locale.ROOT);
        this.primaryNutrient = primaryNutrient;
        this.factory = () -> factory.apply(this);
        this.deadFactory = () -> deadFactory.apply(this);
        this.wildFactory = () -> wildFactory.apply(this);
    }

    private static ExtendedProperties doubleCrop() {
        return dead().blockEntity(TextileBlockEntities.CROP).serverTicks(TextileCropBlockEntity::serverTickBottomPartOnly);
    }

    private static ExtendedProperties crop() {
        return dead().blockEntity(TextileBlockEntities.CROP).serverTicks(TextileCropBlockEntity::serverTick);
    }

    private static ExtendedProperties dead() {
        return ExtendedProperties.of(MapColor.PLANT).noCollission().randomTicks().strength(0.4F).sound(SoundType.CROP).flammable(60, 30);
    }

    @Override
    public String getSerializedName() {
        return serializedName;
    }

    public Block create() {
        return factory.get();
    }

    public Block createDead() {
        return deadFactory.get();
    }

    public Block createWild() {
        return wildFactory.get();
    }

    public NutrientType getPrimaryNutrient() {
        return primaryNutrient;
    }

    public Supplier<ClimateRange> getClimateRange() {
        return TextileClimateRanges.CROPS.get(this);
    }
}

