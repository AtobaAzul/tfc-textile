package net.atobaazul.textile.mixin;

import com.momosoftworks.coldsweat.api.temperature.modifier.TempModifier;
import com.momosoftworks.coldsweat.api.temperature.modifier.WaterTempModifier;
import com.momosoftworks.coldsweat.api.util.Temperature;
import com.momosoftworks.coldsweat.config.ConfigSettings;
import com.momosoftworks.coldsweat.util.math.CSMath;
import com.momosoftworks.coldsweat.util.world.WorldHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Function;

import static net.atobaazul.textile.common.item.TextileItemTags.UMBRELLA;

@Mixin(WaterTempModifier.class)
public abstract class WaterTempModifierMixin extends TempModifier {
    @Shadow public abstract double getTemperature();
    @Shadow public abstract double getTargetTemperature(LivingEntity entity);
    @Shadow public abstract void setTemperature(double temperature);

    @Unique
    private boolean tfc_textile$isHoldingUmbrella(LivingEntity entity) {
        for (ItemStack item : entity.getHandSlots()) {
            if (item.is(UMBRELLA)) {
                return true;
            }
        }
        return false;
    }

    @Inject(method = "calculate", remap = false, at = @At("HEAD"), cancellable = true)
    public void calculate(LivingEntity entity, Temperature.Trait trait, CallbackInfoReturnable<Function<Double, Double>> cir) {
        double worldTemp = Temperature.get(entity, Temperature.Trait.WORLD);
        double minWorldTemp = ConfigSettings.MIN_TEMP.get();
        double maxWorldTemp = ConfigSettings.MAX_TEMP.get();
        double configDrySpeed = ConfigSettings.DRYOFF_SPEED.get();

        double temperature = getTemperature();
        double target = getTargetTemperature(entity);
        double addAmount;

        if (WorldHelper.isInWater(entity)) {
            if (temperature < target) {
                addAmount = Math.min(ConfigSettings.WATER_SOAK_SPEED.get(), target - temperature);
            } else {
                addAmount = Math.max(-ConfigSettings.WATER_SOAK_SPEED.get(), target - temperature);
            }
        }
        //all this for only changing this. I really need to figure out how to edit just this line.
        else if (WorldHelper.isRainingAt(entity.level(), entity.blockPosition()) && !tfc_textile$isHoldingUmbrella(entity)) {
            addAmount = Math.max(-ConfigSettings.RAIN_SOAK_SPEED.get(), -ConfigSettings.MAX_RAIN_SOAK.get() - temperature);
        } else {
            addAmount = 0;
        }
        double dryAmount = WorldHelper.isInWater(entity) ? 0 : CSMath.blendExp(configDrySpeed / 1.5, configDrySpeed * 5, worldTemp, minWorldTemp, maxWorldTemp, 20);

        double tickRate = this.getTickRate() / 5.0;
        double newTemperature = CSMath.shrink(temperature + addAmount * tickRate, dryAmount * tickRate);
        if (newTemperature == 0) {
            this.expires(0);
        }
        setTemperature(newTemperature);

        cir.setReturnValue(temp -> temp + newTemperature);
    }
}
