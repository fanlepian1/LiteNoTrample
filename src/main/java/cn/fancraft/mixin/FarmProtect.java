package cn.fancraft.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static cn.fancraft.LiteNoTrample.Farm_Protect;

@Mixin(FarmlandBlock.class)
public abstract class FarmProtect {
    @Shadow
    public static void setToDirt(@Nullable Entity entity, BlockState state, World world, BlockPos pos) {
    }

    @Redirect(
            method = "onLandedUpon",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/FarmlandBlock;setToDirt(Lnet/minecraft/entity/Entity;Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V"
            )
    )
    public void redirectSetToDirt(Entity entity, BlockState state, World world, BlockPos pos) {
        if (!world.getGameRules().getBoolean(Farm_Protect)){
            setToDirt(entity, state, world, pos);
        }
    }
}
