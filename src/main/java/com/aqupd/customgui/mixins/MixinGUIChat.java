package com.aqupd.customgui.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static com.aqupd.customgui.CustomHandGUI.isLeftHand;
import static com.aqupd.customgui.util.Configuration.swapChat;

@Mixin(GuiNewChat.class)
public abstract class MixinGUIChat {

	@Shadow
	public abstract int getChatWidth();

	@Shadow
	public abstract boolean getChatOpen();

	@ModifyArg(
		method = "drawChat(I)V",
		at = @At(
				value = "INVOKE",
				target = "Lnet/minecraft/client/renderer/GlStateManager;translate(FFF)V",
				ordinal = 0
		),
		index = 0
	)
	private float changeArg(float num) {
		ScaledResolution scaledresolution = new ScaledResolution(Minecraft.getMinecraft());
		isLeftHand = !Minecraft.getMinecraft().gameSettings.getKeyBinding(GameSettings.Options.MAIN_HAND).equalsIgnoreCase(I18n.format("options.mainHand") + ": " + I18n.format("options.mainHand.right"));
		if (isLeftHand && swapChat && !this.getChatOpen()) return (float) (
			scaledresolution.getScaledWidth() - getChatWidth() - 6
		); else return 2.0F;
	}
}
//ScaledResolution scaledresolution = new ScaledResolution(Minecraft.getMinecraft());
//if (swapChat && isLeftHand) return (float) (scaledresolution.getScaledWidth() - getChatWidth() - 6);
//else return 2.0F;
