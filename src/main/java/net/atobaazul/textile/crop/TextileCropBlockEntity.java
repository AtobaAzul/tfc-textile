package net.atobaazul.textile.crop;

import net.atobaazul.textile.block_entities.TextileBlockEntities;
import net.dries007.tfc.common.blockentities.TFCBlockEntity;
import net.dries007.tfc.util.calendar.Calendars;
import net.dries007.tfc.util.calendar.ICalendarTickable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TextileCropBlockEntity extends TFCBlockEntity implements ICalendarTickable {
    private float growth;
    private float yield;
    private float expiry;
    private long lastUpdateTick;
    private long lastGrowthTick;

    public TextileCropBlockEntity(BlockPos pos, BlockState state) {
        this(TextileBlockEntities.CROP.get(), pos, state);
    }

    public TextileCropBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.lastUpdateTick = -2147483648L;
        this.lastGrowthTick = Calendars.SERVER.getTicks();
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, TextileCropBlockEntity crop) {
        crop.checkForCalendarUpdate();
    }

    public static void serverTickBottomPartOnly(Level level, BlockPos pos, BlockState state, TextileCropBlockEntity crop) {
        if (state.getValue(TextileDoubleCropBlock.PART) == TextileDoubleCropBlock.Part.BOTTOM) {
            crop.checkForCalendarUpdate();
        }

    }

    public void onCalendarUpdate(long ticks) {
        assert this.level != null;

        BlockState state = this.level.getBlockState(this.worldPosition);
        Block var5 = state.getBlock();
        if (var5 instanceof ITextileCropBlock crop) {
            crop.growthTick(this.level, this.worldPosition, state, this);
        }

    }

    public float getGrowth() {
        return this.growth;
    }

    public void setGrowth(float growth) {
        this.growth = growth;
        this.markForSync();
    }

    public float getYield() {
        return this.yield;
    }

    public void setYield(float yield) {
        this.yield = yield;
        this.markForSync();
    }

    public float getExpiry() {
        return this.expiry;
    }

    public void setExpiry(float expiry) {
        this.expiry = expiry;
        this.markForSync();
    }

    public long getLastGrowthTick() {
        return this.lastGrowthTick;
    }

    public void setLastGrowthTick(long lastGrowthTick) {
        this.lastGrowthTick = lastGrowthTick;
        this.markForSync();
    }

    /**
     * @deprecated
     */
    @Deprecated
    public long getLastCalendarUpdateTick() {
        return this.lastUpdateTick;
    }

    /**
     * @deprecated
     */
    @Deprecated
    public void setLastCalendarUpdateTick(long tick) {
        this.lastUpdateTick = tick;
    }

    public void loadAdditional(CompoundTag nbt) {
        this.growth = nbt.getFloat("growth");
        this.yield = nbt.getFloat("yield");
        this.expiry = nbt.getFloat("expiry");
        this.lastUpdateTick = nbt.getLong("tick");
        this.lastGrowthTick = nbt.getLong("lastGrowthTick");
        super.loadAdditional(nbt);
    }

    public void saveAdditional(CompoundTag nbt) {
        nbt.putFloat("growth", this.growth);
        nbt.putFloat("yield", this.yield);
        nbt.putFloat("expiry", this.expiry);
        nbt.putLong("tick", this.lastUpdateTick);
        nbt.putLong("lastGrowthTick", this.lastGrowthTick);
        super.saveAdditional(nbt);
    }
}
