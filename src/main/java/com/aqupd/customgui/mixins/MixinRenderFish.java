package com.aqupd.customgui.mixins;

import static com.aqupd.customgui.util.Configuration.*;

import net.minecraft.client.renderer.entity.RenderFish;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(RenderFish.class)
public class MixinRenderFish {

	@ModifyConstant(
		method = "doRender(Lnet/minecraft/entity/projectile/EntityFishHook;DDDFF)V",
		constant = @Constant(ordinal = 0, doubleValue = -0.36D)
	)
	private double xValue(double xPos) {
		return 0.36D * (isLeftHand ? 1 : -1);
	}

	@ModifyConstant(
		method = "doRender(Lnet/minecraft/entity/projectile/EntityFishHook;DDDFF)V",
		constant = @Constant(ordinal = 5, floatValue = 0.5F)
	)
	private float x1(float x11) {
		return 0.5F * (isLeftHand ? -1 : 1);
	}

	@ModifyConstant(
		method = "doRender(Lnet/minecraft/entity/projectile/EntityFishHook;DDDFF)V",
		constant = @Constant(ordinal = 0, floatValue = 0.7F)
	)
	private float x2(float x22) {
		return 0.7F * (isLeftHand ? -1 : 1);
	}
}
