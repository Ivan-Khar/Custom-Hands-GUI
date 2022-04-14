package com.aqupd.customgui.listeners;

import com.aqupd.customgui.gui.GuiConfig;
import com.aqupd.customgui.setup.Registrations;
import com.aqupd.customgui.util.Configuration;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventListener {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onKeyPressed(KeyInputEvent event) {
		if (Registrations.keyBindings[0].isPressed()) {
			Configuration.changeHands();
		}
		else if (Registrations.keyBindings[1].isPressed()) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiConfig());
		}
		else if (Registrations.keyBindings[2].isPressed()) {
			Configuration.resetHands();
		}
		else if (Registrations.keyBindings[3].isPressed()) {
			Configuration.randomizeHands();
		}
	}
}
