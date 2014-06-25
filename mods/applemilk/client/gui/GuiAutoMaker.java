package mods.applemilk.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import mods.applemilk.common.PacketHandler;
import mods.applemilk.common.tile.ContainerAutoMaker;
import mods.applemilk.common.tile.TileAutoMaker;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonMerchant;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiAutoMaker extends GuiContainer
{
    private static final String guiTextures = new String("/mods/applemilk/textures/gui/automakergui.png");
    private IInventory playerInv;
    private TileAutoMaker entityInv;
    private static final String[] modeString = new String[] {"Disabled Automated TeaMaker.", "Enabled Auto mode.", "Enabled Manual mode.", "Enabled RS mode."};

    public GuiAutoMaker(InventoryPlayer par1InventoryPlayer, TileAutoMaker tile)
    {
        super(new ContainerAutoMaker(par1InventoryPlayer, tile));
        this.playerInv = par1InventoryPlayer;
        this.entityInv = tile;
        this.ySize = 168;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
    	String s = this.entityInv.isInvNameLocalized() ? this.entityInv.getInvName() : StatCollector.translateToLocal(this.entityInv.getInvName());
		this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
		this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    private String modeMessage(int mode) {
		
		String s = "[AppleMilk] " + this.modeString[mode];
    	return s;
	}

	/**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(guiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        
        if (this.entityInv.getMode() == 0)
        {
        	this.drawTexturedModalRect(k + 80, l + 24, 176, 0, 16, 16);
        }
        else
        {
        	int i = this.entityInv.getMode();
        	this.drawTexturedModalRect(k + 80, l + 24, 176, 16 * i, 16, 16);
        }
    }
    
    public TileAutoMaker getAutoMaker()
    {
    	return this.entityInv;
    }
    
    static String textureForButton()
    {
        return guiTextures;
    }
}
