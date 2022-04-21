package com.aqupd.customgui.listeners;

import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.io.IOException;

import static com.aqupd.customgui.util.Configuration.loadOptions;
import static com.aqupd.customgui.util.Configuration.update;

public class EventListener {

	private int i = 0;
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) throws IOException {
		if (i == 80) {
			if (update) loadOptions();
			i = 0;
		}
		i++;
	}

	@SubscribeEvent
	public void onKeyPressed(InputEvent.KeyInputEvent event) {
		/*
		if (Registrations.keyBindings[0].isPressed()) {
			AbstractOption.MAIN_HAND.toggle(this, 1);
			Minecraft.getMinecraft().gameSettings.sendSettingsToServer();

		}
		else if (Registrations.keyBindings[1].isPressed()) {
			Minecraft.getInstance().displayGuiScreen(new GuiConfig());
		}
		else if (Registrations.keyBindings[2].isPressed()) {
			Configuration.resetHands();
		}
		else if (Registrations.keyBindings[3].isPressed()) {
			Configuration.randomizeHands();
		}
		 */
	}
}
