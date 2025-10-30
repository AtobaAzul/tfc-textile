package net.atobaazul.textile.mixin;


import com.momosoftworks.coldsweat.api.temperature.modifier.TempModifier;
import com.momosoftworks.coldsweat.api.temperature.modifier.WaterTempModifier;
import com.momosoftworks.coldsweat.api.util.Temperature;
import com.momosoftworks.coldsweat.config.ConfigSettings;
import com.momosoftworks.coldsweat.util.math.CSMath;
import com.momosoftworks.coldsweat.util.world.WorldHelper;
import net.dries007.tfc.common.fluids.TFCFluids;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Function;

import static net.atobaazul.textile.common.item.TextileItemTags.UMBRELLA;

@Mixin(WaterTempModifier.class)
public abstract class WaterTempModifierMixin extends TempModifier {
    @Unique
    private static final double WATER_SOAK_SPEED = 0.1;
    @Unique
    private static final double RAIN_SOAK_SPEED = 0.0125;
    @Unique
    private static final double DRY_SPEED = 0.0015;

    @Unique
    private boolean textile$isHoldingUmbrella(LivingEntity entity) {
        for (ItemStack item : entity.getHandSlots()) {
            if (item.is(UMBRELLA)) {
                return true;
            }
        }
        return false;
    }

    @Unique
    public double textile$getTemperature()
    {   return this.getNBT().getDouble("Temperature");
    }

    @Unique
    public double textile$getMaxTemperature(LivingEntity entity)
    {
        double worldTemp = Temperature.get(entity, Temperature.Trait.WORLD);
        double maxTemp = ConfigSettings.MAX_TEMP.get();
        double minTemp = ConfigSettings.MIN_TEMP.get();
        return CSMath.clamp(Math.abs(CSMath.average(maxTemp, minTemp) - worldTemp) / 2, 0.23d, 0.5d);
    }


    @Inject(method = "calculate", remap = false, cancellable = true, at = @At("HEAD"))
    private void textile$calculate(LivingEntity entity, Temperature.Trait trait, CallbackInfoReturnable<Function<Double, Double>> cir) {
        boolean isWarm = entity.isInFluidType(TFCFluids.SPRING_WATER.getType());
        double worldTemp = Temperature.get(entity, Temperature.Trait.WORLD);
        double minWorldTemp = ConfigSettings.MIN_TEMP.get();
        double maxWorldTemp = ConfigSettings.MAX_TEMP.get();
        double configDrySpeed = ConfigSettings.DRYOFF_SPEED.get() * DRY_SPEED;

        double temperature = textile$getTemperature();
        double addAmount = WorldHelper.isInWater(entity) ? WATER_SOAK_SPEED * (isWarm ? 1 : -1) // In water
                : (WorldHelper.isRainingAt(entity.level(), entity.blockPosition()) && !textile$isHoldingUmbrella(entity)) ? RAIN_SOAK_SPEED // In rain
                : 0;
        double dryAmount = CSMath.blendExp(configDrySpeed, configDrySpeed * 10, worldTemp, minWorldTemp, maxWorldTemp, 100);
        double maxTemp = textile$getMaxTemperature(entity);

        double newTemperature = CSMath.clamp(CSMath.shrink(temperature + addAmount, dryAmount), -maxTemp, maxTemp);
        if (newTemperature == 0)
        {   this.expires(0);
        }

        this.getNBT().putDouble("Temperature", newTemperature);
        if (temperature != newTemperature)
        {   this.markDirty();
        }

        cir.setReturnValue(temp -> temp - newTemperature);
    }
}
