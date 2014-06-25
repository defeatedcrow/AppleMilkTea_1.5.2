package mods.applemilk.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiButtonAutoMaker extends GuiButton
{
    protected static int buttonType = 0;

    public GuiButtonAutoMaker(int par1, int par2, int par3, int par4)
    {
        super(par1, par2, par3, 16, 16, "Mode Change");
        this.buttonType = par4;
    }

    /**
     * Draws this button to the screen.
     */
    public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.drawButton)
        {
            par1Minecraft.renderEngine.bindTexture(GuiAutoMaker.textureForButton());
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            boolean flag = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            int k = 0;
            int l = 176;

            if (this.buttonType == 0)
            {
            	l += 64;
            }
            else
            {
            	l += (this.width*this.buttonType);
            }
            

            this.drawTexturedModalRect(this.xPosition, this.yPosition, l, 0, this.width, this.height);
        }
    }
}
