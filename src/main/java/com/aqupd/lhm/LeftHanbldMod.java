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


@Mod(modid = LeftHanbldMod.MOD_ID, name = LeftHanbldMod.MOD_NAME, version = LeftHanbldMod.VERSION, clientSideOnly = true)
public class LeftHanbldMod {
	public static final String MOD_ID = "lhm";
	public static final String MOD_NAME = "Hypixel Addons";
	public static final String VERSION = "0.0.4";

	public static boolean isLeftHand = true;

	private final EventListener eventListener;

	public LeftHanbldMod() {
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
