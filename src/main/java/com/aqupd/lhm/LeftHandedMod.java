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
}
