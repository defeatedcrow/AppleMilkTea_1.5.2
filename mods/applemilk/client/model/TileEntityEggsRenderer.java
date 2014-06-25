package mods.applemilk.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.tile.TileEggs;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntityEggsRenderer extends TileEntitySpecialRenderer
{
    private static final String EggsTexWhite = new String("/mods/applemilk/textures/blocks/whitepanel.png");
    private static final String EggsTexBlack = new String("/mods/applemilk/textures/blocks/teppann.png");
    public static TileEntityEggsRenderer EggsRenderer;
    private ModelEggs eggsModel = new ModelEggs();

    public void renderTileEntityEggsAt(TileEggs par1TileEggs, double par2, double par4, double par6, float par8)
    {
        this.setRotation((float)par2, (float)par4, (float)par6, par1TileEggs.blockMetadata, par1TileEggs);
    }

    /**
     * Associate a TileEntityRenderer with this TileEntitySpecialRenderer
     */
    public void setTileEntityRenderer(TileEntityRenderer par1TileEntityRenderer)
    {
        super.setTileEntityRenderer(par1TileEntityRenderer);
        EggsRenderer = this;
    }

    public void setRotation(float par1, float par2, float par3, int par4, TileEggs tile)
    {
        ModelEggs modelEggs = this.eggsModel;
        byte l = (byte)tile.getBlockMetadata();
        
        if ((l & 1) == 0)this.bindTextureByName(EggsTexWhite);
        else this.bindTextureByName(EggsTexBlack);
        
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef((float)par1 + 0.5F, (float)par2 + 1.5F, (float)par3 + 0.5F);
        if (l > 1) GL11.glTranslatef(0.0F, -0.2F, 0.0F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
        this.eggsModel.render((Entity)null, 0.0F, 0.0F, 0.0F, l, 0.0F, 0.0625F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityEggsAt((TileEggs)par1TileEntity, par2, par4, par6, par8);
    }
}
