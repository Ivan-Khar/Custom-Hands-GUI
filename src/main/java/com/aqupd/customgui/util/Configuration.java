package com.aqupd.customgui.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.aqupd.customgui.CustomHandGUI.LOGGER;
import static com.aqupd.customgui.CustomHandGUI.logprefix;

public class Configuration {
    public static boolean isLeftHand = true;
    public static boolean swapChat = false;
    public static boolean update = false;
    public static double xGui = 0;
    public static double yGui = 0;
    public static double zGui = 0;

    public static float xRot = 0.0F;
    public static float yRot = 0.0F;
    public static float zRot = 0.0F;

    private static final File configFile = new File("./config/AqMods/CHGUI.properties");

    public static void changeHands() {
        isLeftHand = !isLeftHand;
        saveOptions();
    }
    public static void changeChat() {
        swapChat = !swapChat;
        saveOptions();
    }
    public static void changeUpdate() {
        update = !update;
        saveOptions();
    }

    public static void resetHands() {
        xGui = 0;
        yGui = 0;
        zGui = 0;
        xRot = 0.0F;
        yRot = 0.0F;
        zRot = 0.0F;
        saveOptions();
    }

    public static void setHandPos(String xyz, Double value) {
        switch (xyz) {
            case "x":
                xGui = value;
                break;
            case "y":
                yGui = value;
                break;
            case "z":
                zGui = value;
                break;
        }
        saveOptions();
    }

    public static void setHandRot(String xyz, Float value) {
        switch (xyz) {
            case "x":
                xRot = value;
                break;
            case "y":
                yRot = value;
                break;
            case "z":
                zRot = value;
                break;
        }
        saveOptions();
    }

    public static void loadOptions() throws IOException {
        if (!configFile.exists() || configFile.length() == 0) saveOptions();

        BufferedReader bufferedreader = new BufferedReader(new FileReader(configFile));
        String s = "";

        while ((s = bufferedreader.readLine()) != null) {
            String[] astring = s.split(":");

            if (astring[0].equals("xGui")) xGui = Double.parseDouble(astring[1]);
            if (astring[0].equals("yGui")) yGui = Double.parseDouble(astring[1]);
            if (astring[0].equals("zGui")) zGui = Double.parseDouble(astring[1]);
            if (astring[0].equals("xRot")) xRot = Float.parseFloat(astring[1]);
            if (astring[0].equals("yRot")) yRot = Float.parseFloat(astring[1]);
            if (astring[0].equals("zRot")) zRot = Float.parseFloat(astring[1]);
            if (astring[0].equals("isLeftHand")) isLeftHand = Boolean.parseBoolean(astring[1]);
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
                printwriter.println("xGui:" + xGui);
                printwriter.println("yGui:" + yGui);
                printwriter.println("zGui:" + zGui);
                printwriter.println("xRot:" + xRot);
                printwriter.println("yRot:" + yRot);
                printwriter.println("zRot:" + zRot);
                printwriter.println("isLeftHand:" + isLeftHand);
                printwriter.println("swapChat:" + swapChat);
                printwriter.println("update:" + update);
                printwriter.close();
            }
        }
        catch(Exception exception){
            LOGGER.error((String) logprefix + "Failed to save options", (Throwable) exception);
        }
    }
}
