package mods.applemilk.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.tile.TileSteak;
import mods.applemilk.handler.Util;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntitySteakRenderer extends TileEntitySpecialRenderer
{
    private static final String steakTex = new String("/mods/applemilk/textures/entity/steak.png");
    private static final String chickenTex = new String("/mods/applemilk/textures/entity/roastedchicken.png");
    private static final String hamaguriTex = new String("/mods/applemilk/textures/entity/hamaguri.png");
    public static TileEntitySteakRenderer steakRenderer;
    private ModelSteak steakModel = new ModelSteak();

    public void renderTileEntitySteakAt(TileSteak par1TileSteak, double par2, double par4, double par6, float par8)
    {
        this.setRotation(par1TileSteak, (float)par2, (float)par4, (float)par6, par1TileSteak.getDirectionByte());
    }

    /**
     * Associate a TileEntityRenderer with this TileEntitySpecialRenderer
     */
    public void setTileEntityRenderer(TileEntityRenderer par1TileEntityRenderer)
    {
        super.setTileEntityRenderer(par1TileEntityRenderer);
        steakRenderer = this;
    }

    public void setRotation(TileSteak par0Tile, float par1, float par2, float par3, byte par4)
    {
        ModelSteak model = this.steakModel;
        byte l = (byte)par0Tile.getBlockMetadata();
        byte k = par4;
        float j = 0;
        if (k == 0) j = 180.0F;
        if (k == 1) j = -90.0F;
        if (k == 2) j = 0.0F;
        if (k == 4) j = 90.0F;

        if (l == 0 || l == 1) {
        	this.bindTextureByName(steakTex);
        }
        else if (l == 2) {
        	this.bindTextureByName(chickenTex);
        }
        else {
        	this.bindTextureByName(hamaguriTex);
        }
        
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float)par1 + 0.5F, (float)par2 + 1.5F, (float)par3 + 0.5F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
        model.render((Entity)null, 0.0F, 0.0F, 0.0F, j, 0.0F, 0.0625F, l);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();  
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntitySteakAt((TileSteak)par1TileEntity, par2, par4, par6, par8);
    }
}
