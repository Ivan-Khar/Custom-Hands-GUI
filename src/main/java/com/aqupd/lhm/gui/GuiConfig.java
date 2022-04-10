package com.aqupd.lhm.gui;

import com.aqupd.lhm.LeftHandedMod;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

import static com.aqupd.lhm.LeftHandedMod.*;

public class GuiConfig extends GuiScreen {

    GuiButton buttons;
    GuiSlider sliders;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GL11.glColor4f(1,1,1,1);
        mc.renderEngine.bindTexture(new ResourceLocation(LeftHandedMod.MOD_ID, "textures/gui/ConfigGUI.png"));
        //drawDefaultBackground();
        //drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {

        buttonList.clear();
        buttonList.add(buttons = new GuiButton(0, width/2-32, height-42, 64, 20, "Swap Hands"));
        buttonList.add(buttons = new GuiButton(1, width/2-64, height/2+30, 128, 20, "Reset Position"));

        buttonList.add(sliders = new GuiSlider(new GuiSliderResponder(), 2, width/2, height/2-30,
                "xPos", -0.5F, 0.25F, (float) xGui, (id,name,value)->name+" "+String.format("%.2f", value)));
        buttonList.add(sliders = new GuiSlider(new GuiSliderResponder(), 3, width/2, height/2-10,
                "yPos", -0.5F, 0.25F, (float) yGui, (id,name,value)->name+" "+String.format("%.2f", value)));
        buttonList.add(sliders = new GuiSlider(new GuiSliderResponder(), 4, width/2, height/2+10,
                "zPos", -0.5F, 0.25F, (float) zGui, (id,name,value)->name+" "+String.format("%.2f", value)));

        buttonList.add(sliders = new GuiSlider(new GuiSliderResponder(), 5, width/2-75, height/2-50,
                "Angle", -90, 90, angle, (id,name,value)->name+" "+String.format("%.0f", value)));
        buttonList.add(sliders = new GuiSlider(new GuiSliderResponder(), 6, width/2-150, height/2-30,
                "xRot", -0.5F, 0.5F, xRot, (id,name,value)->name+" "+String.format("%.2f", value)));
        buttonList.add(sliders = new GuiSlider(new GuiSliderResponder(), 7, width/2-150, height/2-10,
                "yRot", -0.5F, 0.5F, yRot, (id,name,value)->name+" "+String.format("%.2f", value)));
        buttonList.add(sliders = new GuiSlider(new GuiSliderResponder(), 8, width/2-150, height/2+10,
                "zRot", -0.5F, 0.5F, zRot, (id,name,value)->name+" "+String.format("%.2f", value)));
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch(button.id){
            case 0:
                LeftHandedMod.changeHands();
                break;
            case 1:
                LeftHandedMod.resetHands();
                break;
        }
        super.actionPerformed(button);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        switch(keyCode){
            case Keyboard.KEY_E:
            case Keyboard.KEY_G:
                mc.displayGuiScreen(null);
                break;
        }
        super.keyTyped(typedChar, keyCode);
    }
}
