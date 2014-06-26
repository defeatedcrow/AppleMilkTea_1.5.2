package mods.applemilk.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.entity.EntityMelonBomb;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderDummyEntity extends Render
{
    private static final String melonTextures = new String("/mods/applemilk/textures/entity/compressedmelon.png");

    public RenderDummyEntity()
    {
        this.shadowSize = 0.0F;
    }

    /**
     * 何もしない。
     */
    public void renderDummy(EntityMelonBomb par1EntityMelon, double par2, double par4, double par6, float par8, float par9)
    {
    	
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
    	
    }
}
