package mods.applemilk.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.common.tile.TileJPBowl;
import mods.applemilk.handler.Util;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntityBowlJPRenderer extends TileEntitySpecialRenderer
{
    private static final String BowlJPTex1 = new String(Util.getEntityTexturePassNoAlt() + "bowlJP_sakura.png");
    private static final String BowlJPTex2 = new String(Util.getEntityTexturePassNoAlt() + "bowlJP_bluepattern.png");
    private static final String BowlJPTex3= new String(Util.getEntityTexturePassNoAlt() + "bowlJP_whiteporcelain.png");
    public static TileEntityBowlJPRenderer BowlRenderer;
    private ModelBowlJP bowlJPModel = new ModelBowlJP();

    public void renderTileEntityBowlAt(TileJPBowl par1TileJPBowl, double par2, double par4, double par6, float par8)
    {
        this.setRotation((float)par2, (float)par4, (float)par6, par1TileJPBowl.blockMetadata, par1TileJPBowl);
    }

    /**
     * Associate a TileEntityRenderer with this TileEntitySpecialRenderer
     */
    public void setTileEntityRenderer(TileEntityRenderer par1TileEntityRenderer)
    {
        super.setTileEntityRenderer(par1TileEntityRenderer);
        BowlRenderer = this;
    }

    public void setRotation(float par1, float par2, float par3, int par4, TileJPBowl tile)
    {
        ModelBowlJP modelBowlJP = this.bowlJPModel;
        byte l = (byte)tile.getBlockMetadata();
        
        this.bindTextureByName(BowlJPTex1);
        if (Util.getCupRender() == 1) this.bindTextureByName(BowlJPTex1);
        else if (Util.getCupRender() == 2) this.bindTextureByName(BowlJPTex2);
        else this.bindTextureByName(BowlJPTex3);
        
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef((float)par1 + 0.5F, (float)par2 + 1.5F, (float)par3 + 0.5F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
        this.bowlJPModel.render((Entity)null, 0.0F, 0.0F, 0.0F, l, 0.0F, 0.0625F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityBowlAt((TileJPBowl)par1TileEntity, par2, par4, par6, par8);
    }
}