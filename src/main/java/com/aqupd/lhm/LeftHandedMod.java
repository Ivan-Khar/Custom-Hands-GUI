/*
 * Hypixel Addons - A customizable quality of life mod for Hypixel
 * Copyright (c) 2021 kr45732
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.aqupd.lhm;

import com.aqupd.lhm.listeners.EventListener;
import com.aqupd.lhm.setup.Registrations;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;


@Mod(modid = LeftHandedMod.MOD_ID, name = LeftHandedMod.MOD_NAME, version = LeftHandedMod.VERSION, clientSideOnly = true)
public class LeftHandedMod {
	public static final String MOD_ID = "lhm";
	public static final String MOD_NAME = "Left Handed Mod";
	public static final String VERSION = "1.1";

	public static boolean isLeftHand = true;
	public static double xGui = 0;
	public static double yGui = 0;
	public static double zGui = 0;

	public static float angle = 0.0F;
	public static float xRot = 0.0F;
	public static float yRot = 0.0F;
	public static float zRot = 0.0F;

	private final EventListener eventListener;

	public LeftHandedMod() {
		Registrations.init();
		this.eventListener = new EventListener();
	}

	@Mod.EventHandler
	public void onFMLInitializationEvent(FMLInitializationEvent ev) {
		MinecraftForge.EVENT_BUS.register(eventListener);
	}

	public static void changeHands(){
		isLeftHand = !isLeftHand;
	}

	public static void resetHands(){
		xGui = 0;
		yGui = 0;
		zGui = 0;
		angle = 0;
		xRot = 0.0F;
		yRot = 0.0F;
		zRot = 0.0F;
	}

	public static void setHandPos(String xyz, Double value){
		switch(xyz){
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
	}
	public static void setHandRot(String axyz, Float value){
		switch(axyz){
			case "a":
				angle = value;
				break;
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
	}
}
