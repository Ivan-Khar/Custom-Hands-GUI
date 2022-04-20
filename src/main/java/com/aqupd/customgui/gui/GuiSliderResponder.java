package com.aqupd.customgui.gui;

import com.aqupd.customgui.util.Configuration;
import net.minecraft.client.gui.GuiPageButtonList;

import static com.aqupd.customgui.util.Configuration.lefthandedit;

public class GuiSliderResponder implements GuiPageButtonList.GuiResponder {
	@Override
	public void setEntryValue(int id, boolean value) {

	}

	@Override
	public void setEntryValue(int id, float value) {
		String val = String.format(java.util.Locale.US, "%.2f", value);
		String valint = String.valueOf(Math.floor(value));
		if(lefthandedit) {
			switch (id) {
				case 2:
					Configuration.setHandPos("2z", Double.parseDouble(val));
					break;
				case 3:
					Configuration.setHandPos("2y", Double.parseDouble(val));
					break;
				case 4:
					Configuration.setHandPos("2x", Double.parseDouble(val));
					break;
				case 5:
					Configuration.setHandRot("2z", Float.parseFloat(valint));
					break;
				case 6:
					Configuration.setHandRot("2y", Float.parseFloat(valint));
					break;
				case 7:
					Configuration.setHandRot("2x", Float.parseFloat(valint));
					break;
			}
		} else {
			switch (id) {
				case 2:
					Configuration.setHandPos("1z", Double.parseDouble(val));
					break;
				case 3:
					Configuration.setHandPos("1y", Double.parseDouble(val));
					break;
				case 4:
					Configuration.setHandPos("1x", Double.parseDouble(val));
					break;
				case 5:
					Configuration.setHandRot("1z", Float.parseFloat(valint));
					break;
				case 6:
					Configuration.setHandRot("1y", Float.parseFloat(valint));
					break;
				case 7:
					Configuration.setHandRot("1x", Float.parseFloat(valint));
					break;
			}
		}
	}

	@Override
	public void setEntryValue(int id, String value) {

	}
}
