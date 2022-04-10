package com.aqupd.lhm.gui;

import static com.aqupd.lhm.LeftHandedMod.*;

import com.aqupd.lhm.LeftHandedMod;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiConfig extends GuiScreen {

	GuiButton buttons;
	GuiSlider sliders;

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GL11.glColor4f(1, 1, 1, 1);
		mc.renderEngine.bindTexture(new ResourceLocation(LeftHandedMod.MOD_ID, "textures/gui/ConfigGUI.png"));
		drawTexturedModalRect(width / 2 + 10, height / 2 - 172, 0, 0, 128, 128);

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	public void initGui() {
		buttonList.clear();
		buttonList.add(buttons = new GuiButton(0, width / 2 - 32, height - 44, 64, 20, "Swap Hands"));
		buttonList.add(buttons = new GuiButton(1, width / 2 - 64, height / 2 + 32, 128, 20, "Reset Position"));

		buttonList.add(
			sliders =
				new GuiSlider(
					new GuiSliderResponder(),
					2,
					width / 2 + 2,
					height / 2 - 30,
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
					3,
					width / 2 + 2,
					height / 2 - 10,
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
					height / 2 + 10,
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
					5,
					width / 2 - 152,
					height / 2 - 30,
					"xRot",
					-90F,
					90F,
					xRot,
					(id, name, value) -> name + " " + (int) value
				)
		);
		buttonList.add(
			sliders =
				new GuiSlider(
					new GuiSliderResponder(),
					6,
					width / 2 - 152,
					height / 2 - 10,
					"yRot",
					-90F,
					90F,
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
					height / 2 + 10,
					"zRot",
					-90F,
					90F,
					zRot,
					(id, name, value) -> name + " " + (int) value
				)
		);
		super.initGui();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
			case 0:
				LeftHandedMod.changeHands();
				break;
			case 1:
				LeftHandedMod.resetHands();
				mc.displayGuiScreen(null);
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
