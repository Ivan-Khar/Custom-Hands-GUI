package com.aqupd.lhm.listeners;

import com.aqupd.lhm.LeftHandedMod;
import com.aqupd.lhm.gui.GuiConfig;
import com.aqupd.lhm.setup.Registrations;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventListener {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onKeyPressed(KeyInputEvent event) {
		if (Registrations.keyBindings[0].isKeyDown()) LeftHandedMod.changeHands();
		if (Registrations.keyBindings[1].isKeyDown()) Minecraft.getMinecraft().displayGuiScreen(new GuiConfig());
	}
}
