package net.atobaazul.tfc_textile.mixin;

import com.eerussianguy.firmalife.common.blockentities.PumpingStationBlockEntity;
import net.dries007.tfc.common.blockentities.TFCBlockEntity;
import net.dries007.tfc.common.blockentities.rotation.RotationSinkBlockEntity;
import net.dries007.tfc.common.blocks.RiverWaterBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;


@Mixin(PumpingStationBlockEntity.class)
public abstract class PumpingStationBlockEntityMixin extends TFCBlockEntity implements RotationSinkBlockEntity
{
    protected PumpingStationBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Inject(method = "isPumping()Z", at = @At("HEAD"), cancellable = true, remap = false)
    public void isPumping(CallbackInfoReturnable<Boolean> cir) {
        assert level != null;

        final BlockState state = level.getBlockState(worldPosition.below());
        cir.setReturnValue(state.getFluidState().getType() == Fluids.WATER || state.getBlock() instanceof RiverWaterBlock);
    }
}