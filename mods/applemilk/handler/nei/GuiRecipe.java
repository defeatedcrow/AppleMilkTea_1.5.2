package mods.applemilk.handler.nei;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

public class GuiRecipe extends GuiContainer{

	public GuiRecipe(Container par1Container) {
		super(par1Container);
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(new String("/mods/applemilk/textures/gui/dummygui.png"));
	}

}
