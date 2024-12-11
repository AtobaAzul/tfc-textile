/*
 * Licensed under the EUPL, Version 1.2.
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 */

package net.atobaazul.textile.crop;

import net.dries007.tfc.common.blocks.plant.ITallPlant;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

/**
 * @see BlockStateProperties
 */
public class TextileBlockStateProperties {

    public static final EnumProperty<TextileDoubleCropBlock.Part> DOUBLE_CROP_PART = EnumProperty.create("part", TextileDoubleCropBlock.Part.class);
    public static final EnumProperty<ITallPlant.Part> TALL_PLANT_PART = EnumProperty.create("part", ITallPlant.Part.class);

    public static final IntegerProperty STAGE_1 = BlockStateProperties.STAGE;
    public static final IntegerProperty STAGE_2 = IntegerProperty.create("stage", 0, 2);
    public static final IntegerProperty STAGE_3 = IntegerProperty.create("stage", 0, 3);
    public static final IntegerProperty STAGE_4 = IntegerProperty.create("stage", 0, 4);
    public static final IntegerProperty STAGE_5 = IntegerProperty.create("stage", 0, 5);
    public static final IntegerProperty STAGE_6 = IntegerProperty.create("stage", 0, 6);
    public static final IntegerProperty STAGE_7 = IntegerProperty.create("stage", 0, 7);
    public static final IntegerProperty STAGE_8 = IntegerProperty.create("stage", 0, 8);
    public static final IntegerProperty STAGE_9 = IntegerProperty.create("stage", 0, 9);
    public static final IntegerProperty STAGE_10 = IntegerProperty.create("stage", 0, 10);
    public static final IntegerProperty STAGE_11 = IntegerProperty.create("stage", 0, 11);
    public static final IntegerProperty STAGE_12 = IntegerProperty.create("stage", 0, 12);

    public static final IntegerProperty AGE_1 = BlockStateProperties.AGE_1;
    public static final IntegerProperty AGE_2 = BlockStateProperties.AGE_2;
    public static final IntegerProperty AGE_3 = BlockStateProperties.AGE_3;
    public static final IntegerProperty AGE_4 = IntegerProperty.create("age", 0, 4);
    public static final IntegerProperty AGE_5 = BlockStateProperties.AGE_5;
    public static final IntegerProperty AGE_6 = IntegerProperty.create("age", 0, 6);
    public static final IntegerProperty AGE_7 = BlockStateProperties.AGE_7;
    public static final IntegerProperty AGE_8 = IntegerProperty.create("age", 0, 8);
    public static final BooleanProperty MATURE = BooleanProperty.create("mature");
    private static final IntegerProperty[] STAGES = {STAGE_1, STAGE_2, STAGE_3, STAGE_4, STAGE_5, STAGE_6, STAGE_7, STAGE_8, STAGE_9, STAGE_10, STAGE_11, STAGE_12};
    private static final IntegerProperty[] AGES = {AGE_1, AGE_2, AGE_3, AGE_4, AGE_5, AGE_6, AGE_7, AGE_8};

    public static IntegerProperty getStageProperty(int maxStage) {
        if (maxStage > 0 && maxStage <= STAGES.length) {
            return STAGES[maxStage - 1];
        }
        throw new IllegalArgumentException("No stage property for stages [0, " + maxStage + "]");
    }

    public static IntegerProperty getAgeProperty(int maxAge) {
        if (maxAge > 0 && maxAge <= AGES.length) {
            return AGES[maxAge - 1];
        }
        throw new IllegalArgumentException("No age property for ages [0, " + maxAge + "]");
    }
}