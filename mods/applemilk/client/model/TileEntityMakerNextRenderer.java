package mods.applemilk.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.tile.TileMakerNext;
import mods.applemilk.api.TeaRecipe;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntityMakerNextRenderer extends TileEntitySpecialRenderer
{
    private static String makerTex = new String("/mods/applemilk/textures/blocks/contents_milk.png");
    private static final String emptyTex = new String("/mods/applemilk/textures/blocks/contents_water.png");
    public static TileEntityMakerNextRenderer makerRenderer;
    private ModelMakerNext nextModel = new ModelMakerNext();

    public void renderTileEntityMakerAt(TileMakerNext par1Tile, double par2, double par4, double par6, float par8)
    {
        this.setRotation((float)par2, (float)par4, (float)par6, par1Tile.getID(), par1Tile.getMilked());
    }

    /**
     * Associate a TileEntityRenderer with this TileEntitySpecialRenderer
     */
    public void setTileEntityRenderer(TileEntityRenderer par1TileEntityRenderer)
    {
        super.setTileEntityRenderer(par1TileEntityRenderer);
        makerRenderer = this;
    }

    public void setRotation(float par1, float par2, float par3, byte par4, boolean milk)
    {
        ModelMakerNext model = this.nextModel;
        String tex = TeaRecipe.getTex(par4);
        makerTex = new String(tex);

        if (par4 == 0)
        {
        	this.bindTextureByName(emptyTex);
        }
        else
        {
        	this.bindTextureByName(makerTex);
        }
        
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        if (milk)
        {
        	GL11.glColor4f(2.0F, 2.0F, 2.0F, 1.0F);
        }
        else
        {
        	
        	GL11.glColor4f(1.2F, 1.2F, 1.2F, 0.9F);
        }
        GL11.glTranslatef((float)par1 + 0.5F, (float)par2 + 1.5F, (float)par3 + 0.5F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glRotatef((float)0.0F, 0.0F, -1.0F, 0.0F);
        model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityMakerAt((TileMakerNext)par1TileEntity, par2, par4, par6, par8);
    }
}