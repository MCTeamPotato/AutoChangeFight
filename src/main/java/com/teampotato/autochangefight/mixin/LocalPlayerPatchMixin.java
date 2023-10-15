package com.teampotato.autochangefight.mixin;

import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import yesman.epicfight.client.world.capabilites.entitypatch.player.AbstractClientPlayerPatch;
import yesman.epicfight.client.world.capabilites.entitypatch.player.LocalPlayerPatch;

import java.util.List;

@Mixin(LocalPlayerPatch.class)
public abstract class LocalPlayerPatchMixin extends AbstractClientPlayerPatch<LocalPlayer> {
    @Redirect(method = "updateHeldItem", remap = false, at = @At(value = "INVOKE", remap = false, target = "Ljava/util/List;contains(Ljava/lang/Object;)Z", ordinal = 1))
    private boolean onCheckMiningItem(List<?> instance, Object o) {
        return this.playerMode != PlayerMode.MINING;
    }
}
