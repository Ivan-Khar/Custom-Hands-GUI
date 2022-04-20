package com.aqupd.customgui.mixins;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.util.EnumHandSide;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.aqupd.customgui.CustomHandGUI.isLeftHand;
import static com.aqupd.customgui.util.Configuration.*;

@Mixin(ItemRenderer.class)
public class MixinItemRenderer {
	@Inject(
			method = "transformSideFirstPerson(Lnet/minecraft/util/EnumHandSide;F)V",
			at = @At(
					value = "HEAD"
			))
	private void transformSideFirstPerson(EnumHandSide hand, float progress, CallbackInfo ci) {
		if(hand == EnumHandSide.LEFT) {
			GlStateManager.translate(x2Gui, y2Gui, z2Gui);
			GlStateManager.rotate(x2Rot, 1, 0, 0);
			GlStateManager.rotate(y2Rot, 0, 1, 0);
			GlStateManager.rotate(z2Rot, 0, 0, 1);
		} else if(hand == EnumHandSide.RIGHT) {
			GlStateManager.translate(x1Gui, y1Gui, z1Gui);
			GlStateManager.rotate(x1Rot, 1, 0, 0);
			GlStateManager.rotate(y1Rot, 0, 1, 0);
			GlStateManager.rotate(z1Rot, 0, 0, 1);
		}
	}

	@Inject(
			method = "renderArmFirstPerson(FFLnet/minecraft/util/EnumHandSide;)V",
			at = @At(
					value = "HEAD"
			))
	private void renderArmFirstPerson(float progress, float p_187456_2_, EnumHandSide hand, CallbackInfo ci){
		if(hand == EnumHandSide.LEFT) {
			isLeftHand = true;
			GlStateManager.translate(x2Gui, y2Gui, z2Gui);
			GlStateManager.rotate(x2Rot, 1, 0, 0);
			GlStateManager.rotate(y2Rot, 0, 1, 0);
			GlStateManager.rotate(z2Rot, 0, 0, 1);
		} else if(hand == EnumHandSide.RIGHT) {
			isLeftHand = false;
			GlStateManager.translate(x1Gui, y1Gui, z1Gui);
			GlStateManager.rotate(x1Rot, 1, 0, 0);
			GlStateManager.rotate(y1Rot, 0, 1, 0);
			GlStateManager.rotate(z1Rot, 0, 0, 1);
		}
	}
}
