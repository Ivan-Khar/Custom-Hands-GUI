package com.aqupd.lhm.gui;

import com.aqupd.lhm.LeftHandedMod;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiPageButtonList;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

public class GuiConfig extends GuiScreen {

    GuiButton buttons;
    GuiSlider sliders;
    private GuiPageButtonList.GuiResponder guiResponder;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GL11.glColor4f(1,1,1,1);
        mc.renderEngine.bindTexture(new ResourceLocation(LeftHandedMod.MOD_ID, "textures/gui/ConfigGUI.png"));
        drawDefaultBackground();
        //drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {

        buttonList.clear();
        buttonList.add(buttons = new GuiButton(0, width/2-32, height-42, 64, 20, "Swap Hands"));
        buttonList.add(sliders = new GuiSlider(guiResponder, 0, width/2, height/2, "xPos", -0.5F, 0.25F, 0, (id, name, value) -> name + " " + value));
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch(button.id){
            case 0:
                LeftHandedMod.changeHands();
                break;
            case 1:
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
