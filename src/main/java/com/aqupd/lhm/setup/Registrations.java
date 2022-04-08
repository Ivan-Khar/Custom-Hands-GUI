package com.aqupd.lhm.setup;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class Registrations {
    public static KeyBinding swapHands = new KeyBinding("key.aqupd.changehands", Keyboard.KEY_F, "key.categories.gameplay");
    public static void init(){
        ClientRegistry.registerKeyBinding(swapHands);
    }

}
