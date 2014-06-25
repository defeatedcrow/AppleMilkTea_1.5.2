package mods.applemilk.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.tile.TileChopsticksBox;
import mods.applemilk.handler.Util;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntityChopsticksRenderer extends TileEntitySpecialRenderer
{
    private static final String SticksTex = new String(Util.getEntityTexturePassNoAlt() + "chopsticks.png");
    public static TileEntityChopsticksRenderer sticksRenderer;
    private ModelChopsticks sticksModel = new ModelChopsticks();

    public void renderTileEntitySticksAt(TileChopsticksBox par1TileSticks, double par2, double par4, double par6, float par8)
    {
        this.setRotation((float)par2, (float)par4, (float)par6, par1TileSticks.blockMetadata, par1TileSticks);
    }

    /**
     * Associate a TileEntityRenderer with this TileEntitySpecialRenderer
     */
    public void setTileEntityRenderer(TileEntityRenderer par1TileEntityRenderer)
    {
        super.setTileEntityRenderer(par1TileEntityRenderer);
        sticksRenderer = this;
    }

    public void setRotation(float par1, float par2, float par3, int par4, TileChopsticksBox tile)
    {
        ModelChopsticks modelSticks = this.sticksModel;
        byte l = (byte)tile.getBlockMetadata();
        
        this.bindTextureByName(SticksTex);
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef((float)par1 + 0.5F, (float)par2 + 1.5F, (float)par3 + 0.5F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
        this.sticksModel.render((Entity)null, 0.0F, 0.0F, 0.0F, l, 0.0F, 0.0625F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntitySticksAt((TileChopsticksBox)par1TileEntity, par2, par4, par6, par8);
    }
}
