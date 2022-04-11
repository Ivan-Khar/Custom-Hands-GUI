package com.aqupd.customgui.mixins;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.aqupd.customgui.util.Configuration.*;
import static org.lwjgl.opengl.GL11.GL_BACK;
import static org.lwjgl.opengl.GL11.GL_FRONT;

@Mixin(ItemRenderer.class)
public class MixinItemRenderer {

	@Shadow
	private ItemStack itemToRender;

	@Inject(method = "renderItemInFirstPerson(F)V", at = @At(value = "HEAD"))
	public void renderItemInFirstPerson(float partialTicks, CallbackInfo ci) {
		int k = isLeftHand ? -1 : 1;
		GlStateManager.translate(xGui * k, yGui, zGui);
		GlStateManager.rotate(xRot, 1, 0, 0);
		GlStateManager.rotate(yRot * k, 0, 1, 0);
		GlStateManager.rotate(zRot * k, 0, 0, 1);
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
