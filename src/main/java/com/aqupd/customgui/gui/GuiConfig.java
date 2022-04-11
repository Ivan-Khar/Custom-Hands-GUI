package com.aqupd.customgui.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

import static com.aqupd.customgui.CustomHandGUI.MOD_ID;
import static com.aqupd.customgui.util.Configuration.*;

public class GuiConfig extends GuiScreen {

	GuiButton buttons;
	GuiSlider sliders;

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GL11.glColor4f(1, 1, 1, 1);
		mc.renderEngine.bindTexture(new ResourceLocation(MOD_ID, "textures/gui/ConfigGUI.png"));
		if (isLeftHand) drawTexturedModalRect(width / 2 + 10, height / 2 - 172, 0, 0, 128, 128);
		else drawTexturedModalRect(width/2+10, height - 44 - 84 - 128, 128, 0, 128, 128);
		drawCenteredString(Minecraft.getMinecraft().fontRendererObj, "Hand GUI Editor",width/2, 10, 16777215);

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	public void initGui() {
		buttonList.clear();
		buttonList.add(buttons = new GuiButton(0, width / 2 - 96/2, height - 44, 96, 20, "Swap Hands"));
		buttonList.add(buttons = new GuiButton(8, width / 2 - 96/2 - 96 - 2, height - 44, 96, 20, "Swap Chat: " + swapChat));
		buttonList.add(buttons = new GuiButton(9, width / 2 + 96/2 + 2, height - 44, 96, 20, "AutoUpdate: " + update));
		buttonList.add(buttons = new GuiButton(1, width / 2 - 64, height - 44 - 22, 128, 20, "Reset Position"));

		buttonList.add(
			sliders =
				new GuiSlider(
					new GuiSliderResponder(),
					2,
					width / 2 + 2,
					height - 44 - 44,
					"zPos",
					-1F,
					1F,
					(float) zGui,
					(id, name, value) -> name + " " + String.format("%.2f", value)
				)
		);
		buttonList.add(
			sliders =
				new GuiSlider(
					new GuiSliderResponder(),
					3,
					width / 2 + 2,
					height - 44 - 64,
					"yPos",
					-1F,
					1F,
					(float) yGui,
					(id, name, value) -> name + " " + String.format("%.2f", value)
				)
		);
		buttonList.add(
			sliders =
				new GuiSlider(
					new GuiSliderResponder(),
					4,
					width / 2 + 2,
					height - 44 - 84,
					"xPos",
					-1F,
					1F,
					(float) xGui,
					(id, name, value) -> name + " " + String.format("%.2f", value)
				)
		);

		buttonList.add(
			sliders =
				new GuiSlider(
					new GuiSliderResponder(),
					5,
					width / 2 - 152,
					height - 44 - 44,
					"zRot",
					-179F,
					180F,
					zRot,
					(id, name, value) -> name + " " + (int) value
				)
		);
		buttonList.add(
			sliders =
				new GuiSlider(
					new GuiSliderResponder(),
					6,
					width / 2 - 152,
					height - 44 - 64,
					"yRot",
					-179F,
					180F,
					yRot,
					(id, name, value) -> name + " " + (int) value
				)
		);
		buttonList.add(
			sliders =
				new GuiSlider(
					new GuiSliderResponder(),
					7,
					width / 2 - 152,
					height - 44 - 84,
					"xRot",
					-179F,
					180F,
					xRot,
					(id, name, value) -> name + " " + (int) value
				)
		);
		super.initGui();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
			case 0:
				changeHands();
				break;
			case 1:
				resetHands();
				mc.displayGuiScreen(new GuiConfig());
				break;
			case 8:
				changeChat();
				mc.displayGuiScreen(new GuiConfig());
				break;
			case 9:
				changeUpdate();
				mc.displayGuiScreen(new GuiConfig());
				break;
		}
		super.actionPerformed(button);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		switch (keyCode) {
			case Keyboard.KEY_E:
			case Keyboard.KEY_G:
				mc.displayGuiScreen(null);
				break;
		}
		super.keyTyped(typedChar, keyCode);
	}
}
