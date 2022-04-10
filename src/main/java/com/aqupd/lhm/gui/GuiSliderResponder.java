package com.aqupd.lhm.gui;

import com.aqupd.lhm.LeftHandedMod;
import net.minecraft.client.gui.GuiPageButtonList;

public class GuiSliderResponder implements GuiPageButtonList.GuiResponder {

	@Override
	public void func_175321_a(int id, boolean idk) {}

	@Override
	public void onTick(int id, float value) {
		switch (id) {
			case 2:
				LeftHandedMod.setHandPos("x", (double) value);
				break;
			case 3:
				LeftHandedMod.setHandPos("y", (double) value);
				break;
			case 4:
				LeftHandedMod.setHandPos("z", (double) value);
				break;
			case 5:
				LeftHandedMod.setHandRot("x", value);
				break;
			case 6:
				LeftHandedMod.setHandRot("y", value);
				break;
			case 7:
				LeftHandedMod.setHandRot("z", value);
				break;
		}
	}

	@Override
	public void func_175319_a(int id, String text) {}
}
