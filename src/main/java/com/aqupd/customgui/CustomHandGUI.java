package com.aqupd.customgui;

import com.aqupd.customgui.listeners.EventListener;
import com.aqupd.customgui.setup.Registrations;
import com.aqupd.customgui.util.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static com.aqupd.customgui.util.Configuration.loadOptions;
import static com.aqupd.customgui.util.Configuration.update;

@Mod(modid = CustomHandGUI.MOD_ID, name = CustomHandGUI.MOD_NAME, version = CustomHandGUI.VERSION, clientSideOnly = true)
public class CustomHandGUI {

	public static final String MOD_ID = "customgui";
	public static final String MOD_NAME = "Custom Hand Gui mod";
	public static final String VERSION = "1.4";
	public static final Logger LOGGER = LogManager.getLogger();
	public static String logprefix = "[AqUpd's " + MOD_NAME + "] ";

	public static long xguitimer = 0;
	public static long yguitimer = 0;
	public static long zguitimer = 0;

	public static long xrottimer = 0;
	public static long yrottimer = 0;
	public static long zrottimer = 0;

	private int i = 0;
	private final EventListener eventListener;

	public CustomHandGUI() throws IOException {
		Registrations.init();
		this.eventListener = new EventListener();
		Configuration.loadOptions();
		FMLCommonHandler.instance().bus().register(this);
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) throws IOException {
		if (i == 80) {
			if (update) loadOptions();
			i = 0;
		}
		i++;
	}

	@Mod.EventHandler
	public void onFMLInitializationEvent(FMLInitializationEvent ev) {
		MinecraftForge.EVENT_BUS.register(eventListener);
	}
}
