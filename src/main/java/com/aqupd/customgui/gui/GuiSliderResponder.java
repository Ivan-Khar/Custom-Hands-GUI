package com.aqupd.customgui.gui;

import com.aqupd.customgui.util.Configuration;
import net.minecraft.client.gui.GuiPageButtonList;

public class GuiSliderResponder implements GuiPageButtonList.GuiResponder {

	@Override
	public void func_175321_a(int id, boolean idk) {}

	@Override
	public void onTick(int id, float value) {
		String val = String.format(java.util.Locale.US,"%.2f", value);
		String valint = String.valueOf(Math.floor(value));
		switch (id) {
			case 2:
				Configuration.setHandPos("z", Double.parseDouble(val));
				break;
			case 3:
				Configuration.setHandPos("y", Double.parseDouble(val));
				break;
			case 4:
				Configuration.setHandPos("x", Double.parseDouble(val));
				break;
			case 5:
				Configuration.setHandRot("z", Float.parseFloat(valint));
				break;
			case 6:
				Configuration.setHandRot("y", Float.parseFloat(valint));
				break;
			case 7:
				Configuration.setHandRot("x", Float.parseFloat(valint));
				break;
		}
	}

	@Override
	public void func_175319_a(int id, String text) {}
}
