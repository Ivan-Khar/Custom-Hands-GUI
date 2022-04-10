package com.aqupd.lhm.mixins;

import static com.aqupd.lhm.LeftHandedMod.*;
import static org.lwjgl.opengl.GL11.GL_BACK;
import static org.lwjgl.opengl.GL11.GL_FRONT;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public class MixinItemRenderer {

	@Shadow
	private ItemStack itemToRender;

	@Inject(method = "renderItemInFirstPerson(F)V", at = @At(value = "HEAD"))
	public void renderItemInFirstPerson(float partialTicks, CallbackInfo ci) {
		int k = isLeftHand ? -1 : 1;
		GlStateManager.translate(xGui * k, yGui, zGui);
		GlStateManager.rotate(xRot * k, 1, 0, 0);
		GlStateManager.rotate(yRot, 0, 1, 0);
		GlStateManager.rotate(zRot, 0, 0, 1);
		if (isLeftHand) {
			GlStateManager.scale(-1, 1, 1);
			if (this.itemToRender != null) {
				GlStateManager.cullFace(GL_FRONT);
			} else {
				GlStateManager.cullFace(GL_BACK);
			}
		} else {
			GlStateManager.scale(1, 1, 1);
		}
	}
}
