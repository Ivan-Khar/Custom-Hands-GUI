package com.aqupd.customgui.util;

import static com.aqupd.customgui.CustomHandGUI.LOGGER;
import static com.aqupd.customgui.CustomHandGUI.logprefix;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Configuration {

	public static boolean swapChat = false;
	public static boolean update = false;
	public static boolean lefthandedit = false;
	public static double x1Gui = 0;
	public static double y1Gui = 0;
	public static double z1Gui = 0;
	public static double x2Gui = 0;
	public static double y2Gui = 0;
	public static double z2Gui = 0;

	public static float x1Rot = 0.0F;
	public static float y1Rot = 0.0F;
	public static float z1Rot = 0.0F;
	public static float x2Rot = 0.0F;
	public static float y2Rot = 0.0F;
	public static float z2Rot = 0.0F;

	private static final File configFile = new File("./config/AqMods/CHGUI.properties");

	public static void changeChat() {
		swapChat = !swapChat;
		saveOptions();
	}

	public static void changeUpdate() {
		update = !update;
		saveOptions();
	}

	public static void resetHand() {
		if(lefthandedit) {
			x2Gui = 0;
			y2Gui = 0;
			z2Gui = 0;
			x2Rot = 0.0F;
			y2Rot = 0.0F;
			z2Rot = 0.0F;
		} else {
			x1Gui = 0;
			y1Gui = 0;
			z1Gui = 0;
			x1Rot = 0.0F;
			y1Rot = 0.0F;
			z1Rot = 0.0F;
		}
		saveOptions();
	}

	public static void resetHands() {
		x2Gui = 0;
		y2Gui = 0;
		z2Gui = 0;
		x2Rot = 0.0F;
		y2Rot = 0.0F;
		z2Rot = 0.0F;
		x1Gui = 0;
		y1Gui = 0;
		z1Gui = 0;
		x1Rot = 0.0F;
		y1Rot = 0.0F;
		z1Rot = 0.0F;
		saveOptions();
	}

	public static void randomizeHands() {
		x1Gui = Math.random() * -1 + 0.5;
		y1Gui = Math.random() * -1 + 1;
		z1Gui = Math.random() * -2;
		x2Gui = Math.random() * -1 + 0.5;
		y2Gui = Math.random() * -1 + 1;
		z2Gui = Math.random() * -2;
		saveOptions();
	}

	public static void setHandPos(String nxyz, Double value) {
		switch (nxyz) {
			case "1x":
				x1Gui = value;
				break;
			case "1y":
				y1Gui = value;
				break;
			case "1z":
				z1Gui = value;
				break;
			case "2x":
				x2Gui = value;
				break;
			case "2y":
				y2Gui = value;
				break;
			case "2z":
				z2Gui = value;
				break;
		}
		saveOptions();
	}

	public static void setHandRot(String nxyz, Float value) {
		switch (nxyz) {
			case "1x":
				x1Rot = value;
				break;
			case "1y":
				y1Rot = value;
				break;
			case "1z":
				z1Rot = value;
				break;
			case "2x":
				x2Rot = value;
				break;
			case "2y":
				y2Rot = value;
				break;
			case "2z":
				z2Rot = value;
				break;
		}
		saveOptions();
	}

	public static void loadOptions() throws IOException {
		if (!configFile.exists() || configFile.length() == 0) saveOptions();

		BufferedReader bufferedreader = new BufferedReader(new FileReader(configFile));
		String s;

		while ((s = bufferedreader.readLine()) != null) {
			String[] astring = s.split(":");

			if (astring[0].equals("x1Gui")) x1Gui = Double.parseDouble(astring[1]);
			if (astring[0].equals("y1Gui")) y1Gui = Double.parseDouble(astring[1]);
			if (astring[0].equals("z1Gui")) z1Gui = Double.parseDouble(astring[1]);
			if (astring[0].equals("x1Rot")) x1Rot = Float.parseFloat(astring[1]);
			if (astring[0].equals("y1Rot")) y1Rot = Float.parseFloat(astring[1]);
			if (astring[0].equals("z1Rot")) z1Rot = Float.parseFloat(astring[1]);
			if (astring[0].equals("x2Gui")) x2Gui = Double.parseDouble(astring[1]);
			if (astring[0].equals("y2Gui")) y2Gui = Double.parseDouble(astring[1]);
			if (astring[0].equals("z2Gui")) z2Gui = Double.parseDouble(astring[1]);
			if (astring[0].equals("x2Rot")) x2Rot = Float.parseFloat(astring[1]);
			if (astring[0].equals("y2Rot")) y2Rot = Float.parseFloat(astring[1]);
			if (astring[0].equals("z2Rot")) z2Rot = Float.parseFloat(astring[1]);
			if (astring[0].equals("swapChat")) swapChat = Boolean.parseBoolean(astring[1]);
			if (astring[0].equals("update")) update = Boolean.parseBoolean(astring[1]);
		}
	}

	public static void saveOptions() {
		try {
			Files.createDirectories(Paths.get("./config/AqMods/"));

			if (!configFile.exists()) configFile.createNewFile();
			if (configFile.exists()) {
				PrintWriter printwriter = new PrintWriter(new FileWriter(configFile));
				printwriter.println("x1Gui:" + x1Gui);
				printwriter.println("y1Gui:" + y1Gui);
				printwriter.println("z1Gui:" + z1Gui);
				printwriter.println("x1Rot:" + x1Rot);
				printwriter.println("y1Rot:" + y1Rot);
				printwriter.println("z1Rot:" + z1Rot);
				printwriter.println("x2Gui:" + x2Gui);
				printwriter.println("y2Gui:" + y2Gui);
				printwriter.println("z2Gui:" + z2Gui);
				printwriter.println("x2Rot:" + x2Rot);
				printwriter.println("y2Rot:" + y2Rot);
				printwriter.println("z2Rot:" + z2Rot);
				printwriter.println("swapChat:" + swapChat);
				printwriter.println("update:" + update);
				printwriter.close();
			}
		} catch (Exception exception) {
			LOGGER.error(logprefix + "Failed to save options", exception);
		}
	}
}
