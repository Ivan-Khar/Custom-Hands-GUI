package com.aqupd.customgui;

import com.aqupd.customgui.listeners.EventListener;
import com.aqupd.customgui.setup.Registrations;
import com.aqupd.customgui.util.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static com.aqupd.customgui.CustomHandGUI.MOD_ID;

@Mod(MOD_ID)
public class CustomHandGUI {

	public static final String MOD_ID = "customgui";
	public static final String MOD_VERSION = "1.4";
	public static final String MOD_NAME = "Custom Hand Gui mod";
	public static final Logger LOGGER = LogManager.getLogger();
	public static String logprefix = "[AqUpd's " + MOD_NAME + "] ";

	public static boolean isLeftHand;

	public static long xguitimer = 0;
	public static long yguitimer = 0;
	public static long zguitimer = 0;

	public static long xrottimer = 0;
	public static long yrottimer = 0;
	public static long zrottimer = 0;


	public CustomHandGUI() throws IOException {
		Registrations.init();
		Configuration.loadOptions();
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new EventListener());
	}
}
