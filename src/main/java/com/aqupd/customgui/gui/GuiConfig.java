package com.aqupd.customgui.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.io.IOException;
import java.util.Collections;

import static com.aqupd.customgui.CustomHandGUI.MOD_ID;
import static com.aqupd.customgui.util.Configuration.*;

public class GuiConfig extends GuiScreen {

	GuiButton buttons;
	GuiSlider sliders;

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GL11.glColor4f(1, 1, 1, 1);
		mc.renderEngine.bindTexture(new ResourceLocation(MOD_ID, "textures/gui/ConfigGUI.png"));
		if (isLeftHand) drawTexturedModalRect(width / 2 + 10, height - 44 - 84 - 16 - 128, 0, 0, 128, 128);
		else drawTexturedModalRect(width / 2 + 10, height - 44 - 84 - 16 - 128, 128, 0, 128, 128);
		drawCenteredString(Minecraft.getMinecraft().fontRendererObj, I18n.format("config.aqupd.position"),width/2 + 75 + 2, height - 44 - 84 - 16, 16777215);
		drawCenteredString(Minecraft.getMinecraft().fontRendererObj, I18n.format("config.aqupd.rotation"),width/2 - 75 - 2, height - 44 - 84 - 16, 16777215);
		drawCenteredString(Minecraft.getMinecraft().fontRendererObj, "Hand GUI Editor",width/2, 10, 16777215);

		super.drawScreen(mouseX, mouseY, partialTicks);
		for (GuiButton guiButton : buttonList) {
			if (guiButton != null && guiButton.isMouseOver()) {
				switch (guiButton.id) {
					case 0:
						drawHoveringText(Collections.singletonList(I18n.format("config.aqupd.swaphands.desc")), mouseX, mouseY, fontRendererObj);
						break;
					case 1:
						drawHoveringText(Collections.singletonList(I18n.format("config.aqupd.resetposition.desc")), mouseX, mouseY, fontRendererObj);
						break;
					case 8:
						drawHoveringText(Collections.singletonList(I18n.format("config.aqupd.swapchat.desc")), mouseX, mouseY, fontRendererObj);
						break;
					case 9:
						drawHoveringText(Collections.singletonList(I18n.format("config.aqupd.autorefresh.desc")), mouseX, mouseY, fontRendererObj);
						break;
				}
			}
		}
	}

	@Override
	public void initGui() {
		buttonList.clear();
		buttonList.add(buttons = new GuiButton(0, width / 2 - 128/2, height - 44,
				128, 20, I18n.format("config.aqupd.swaphands")));
		buttonList.add(buttons = new GuiButton(8, width / 2 - 128/2 - 128 - 2, height - 44,
				128, 20, I18n.format("config.aqupd.swapchat") + ": " + (swapChat ? I18n.format("gui.yes") : I18n.format("gui.no"))));
		buttonList.add(buttons = new GuiButton(9, width / 2 + 128/2 + 2, height - 44,
				128, 20, I18n.format("config.aqupd.autorefresh") + ": " + (update ? I18n.format("gui.yes") : I18n.format("gui.no"))));
		buttonList.add(buttons = new GuiButton(1, width / 2 - 64, height - 44 - 22,
				128, 20, I18n.format("config.aqupd.resetposition")));

		buttonList.add(
			sliders =
				new GuiSlider(
					new GuiSliderResponder(),
					2,
					width / 2 + 2,
					height - 44 - 44,
					"z",
					-10F,
					1F,
					(float) zGui,
					(id, name, value) -> name + ": " + String.format("%.2f", value)
				)
		);
		buttonList.add(
			sliders =
				new GuiSlider(
					new GuiSliderResponder(),
					3,
					width / 2 + 2,
					height - 44 - 64,
					"y",
					-5F,
					5F,
					(float) yGui,
					(id, name, value) -> name + ": " + String.format("%.2f", value)
				)
		);
		buttonList.add(
			sliders =
				new GuiSlider(
					new GuiSliderResponder(),
					4,
					width / 2 + 2,
					height - 44 - 84,
					"x",
					-5F,
					10F,
					(float) xGui,
					(id, name, value) -> name + ": " + String.format("%.2f", value)
				)
		);

		buttonList.add(
			sliders =
				new GuiSlider(
					new GuiSliderResponder(),
					5,
					width / 2 - 152,
					height - 44 - 44,
					"z",
					-179F,
					180F,
					zRot,
					(id, name, value) -> name + ": " + (int) value
				)
		);
		buttonList.add(
			sliders =
				new GuiSlider(
					new GuiSliderResponder(),
					6,
					width / 2 - 152,
					height - 44 - 64,
					"y",
					-179F,
					180F,
					yRot,
					(id, name, value) -> name + ": " + (int) value
				)
		);
		buttonList.add(
			sliders =
				new GuiSlider(
					new GuiSliderResponder(),
					7,
					width / 2 - 152,
					height - 44 - 84,
					"x",
					-179F,
					180F,
					xRot,
					(id, name, value) -> name + ": " + (int) value
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
