package com.aqupd.customgui.setup;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Registrations {

	public static KeyBinding[] keyBindings;

	public static void init() {
		keyBindings = new KeyBinding[4];
		keyBindings[0] = new KeyBinding("key.aqupd.changehands", 72, "key.aqupd.categories.handgui");
		keyBindings[1] = new KeyBinding("key.aqupd.configgui", 71, "key.aqupd.categories.handgui");
		keyBindings[2] = new KeyBinding("key.aqupd.resethands", 75, "key.aqupd.categories.handgui");
		keyBindings[3] = new KeyBinding("key.aqupd.randomize", 74, "key.aqupd.categories.handgui");
		for (KeyBinding keyBinding : keyBindings) {
			ClientRegistry.registerKeyBinding(keyBinding);
		}
	}
}
