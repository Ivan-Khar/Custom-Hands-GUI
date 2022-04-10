package com.aqupd.lhm.setup;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class Registrations {

	public static KeyBinding[] keyBindings;

	public static void init() {
		keyBindings = new KeyBinding[2];
		keyBindings[0] = new KeyBinding("key.aqupd.changehands", Keyboard.KEY_F, "key.categories.gameplay");
		keyBindings[1] = new KeyBinding("key.aqupd.configgui", Keyboard.KEY_G, "key.categories.gameplay");

		for (KeyBinding keyBinding : keyBindings) {
			ClientRegistry.registerKeyBinding(keyBinding);
		}
	}
}
