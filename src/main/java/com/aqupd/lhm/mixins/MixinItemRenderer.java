package com.aqupd.lhm.mixins;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.aqupd.lhm.LeftHandedMod.isLeftHand;
import static org.lwjgl.opengl.GL11.GL_BACK;
import static org.lwjgl.opengl.GL11.GL_FRONT;

@Mixin(ItemRenderer.class)
public class MixinItemRenderer {

    @Shadow
    private ItemStack itemToRender;

    @Inject(method = "renderItemInFirstPerson(F)V", at = @At(value = "HEAD"))
    public void renderItemInFirstPerson(float partialTicks, CallbackInfo ci) {
        if(isLeftHand){
            GlStateManager.scale(-1, 1, 1);
            if (this.itemToRender != null) {
                GlStateManager.cullFace(GL_FRONT);
            } else {
                GlStateManager.cullFace(GL_BACK);
            }
        } else {
            GlStateManager.scale(1, 1, 1);
        }
    }
}