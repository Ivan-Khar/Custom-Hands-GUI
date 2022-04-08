package com.aqupd.lhm.listeners;

import com.aqupd.lhm.LeftHanbldMod;
import com.aqupd.lhm.setup.Registrations;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventListener {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onKeyPressed(KeyInputEvent event){
        if(Registrations.swapHands.isKeyDown()) LeftHanbldMod.changeHands();
    }
}
