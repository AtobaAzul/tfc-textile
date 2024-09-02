/*package net.atobaazul.tfc_textile.mixin;

import com.eerussianguy.firmalife.common.blocks.greenhouse.PumpingStationBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PumpingStationBlock.class)
public class PumpingStationBlockMixin {
    @Inject(method = "hasConnection", at= @At("HEAD"), cancellable = true, remap = false)
    private static void hasConnection(LevelAccessor level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        System.out.println("mixing!");

        cir.setReturnValue(true);
    }
}*/
