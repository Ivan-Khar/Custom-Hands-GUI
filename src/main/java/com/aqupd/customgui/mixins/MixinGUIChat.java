package com.aqupd.customgui.mixins;

import static com.aqupd.customgui.util.Configuration.isLeftHand;
import static com.aqupd.customgui.util.Configuration.swapChat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.ScaledResolution;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(GuiNewChat.class)
public abstract class MixinGUIChat {

	@Shadow
	public abstract int getChatWidth();

	@Shadow
	public abstract boolean getChatOpen();

	@ModifyArg(
		method = "drawChat(I)V",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;translate(FFF)V", ordinal = 0),
		index = 0
	)
	private float changeArg(float num) {
		ScaledResolution scaledresolution = new ScaledResolution(Minecraft.getMinecraft());
		if (swapChat && isLeftHand && !this.getChatOpen()) return (float) (
			scaledresolution.getScaledWidth() - getChatWidth() - 6
		); else return 2.0F;
	}
}
//ScaledResolution scaledresolution = new ScaledResolution(Minecraft.getMinecraft());
//if (swapChat && isLeftHand) return (float) (scaledresolution.getScaledWidth() - getChatWidth() - 6);
//else return 2.0F;
