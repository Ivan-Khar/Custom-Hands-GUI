package com.aqupd.customgui.setup;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class Registrations {

	public static KeyBinding[] keyBindings;

	public static void init() {
		keyBindings = new KeyBinding[4];
		keyBindings[0] = new KeyBinding("key.aqupd.changehands", Keyboard.KEY_F, "key.aqupd.categories.handgui");
		keyBindings[1] = new KeyBinding("key.aqupd.configgui", Keyboard.KEY_G, "key.aqupd.categories.handgui");
		keyBindings[2] = new KeyBinding("key.aqupd.resethands", Keyboard.KEY_H, "key.aqupd.categories.handgui");
		keyBindings[3] = new KeyBinding("key.aqupd.randomize", Keyboard.KEY_J, "key.aqupd.categories.handgui");
		for (KeyBinding keyBinding : keyBindings) {
			ClientRegistry.registerKeyBinding(keyBinding);
		}
	}
}
