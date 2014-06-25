package mods.applemilk.client;

import org.lwjgl.opengl.GL11;

import mods.applemilk.common.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderChocoPan implements ISimpleBlockRenderingHandler{
	
	private Icon boxIcon;
	private Icon contentsIcon;
	private Icon contentsIcon2;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		this.boxIcon = DCsAppleMilk.flintBlock.getBlockTextureFromSide(1);
		int ID = block.blockID;
		
		if (modelID == this.getRenderId())
		{
			//box
			renderInvCuboid(renderer, block,  3.0F/16.0F, 0.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 2.0F/16.0F, 13.0F/16.0F,  this.boxIcon);
			
			renderInvCuboid(renderer, block,  1.0F/16.0F, 7.0F/16.0F, 7.0F/16.0F, 2.0F/16.0F, 8.0F/16.0F, 9.0F/16.0F,  this.boxIcon);
			renderInvCuboid(renderer, block,  14.0F/16.0F, 7.0F/16.0F, 7.0F/16.0F, 15.0F/16.0F, 8.0F/16.0F, 9.0F/16.0F,  this.boxIcon);
			
			renderInvCuboid(renderer, block,  2.0F/16.0F, 0.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 8.0F/16.0F, 14.0F/16.0F,  this.boxIcon);
			renderInvCuboid(renderer, block,  13.0F/16.0F, 0.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F, 8.0F/16.0F, 14.0F/16.0F,  this.boxIcon);
			renderInvCuboid(renderer, block,  3.0F/16.0F, 0.0F/16.0F, 2.0F/16.0F, 13.0F/16.0F, 8.0F/16.0F, 4.0F/16.0F,  this.boxIcon);
			renderInvCuboid(renderer, block,  3.0F/16.0F, 0.0F/16.0F, 13.0F/16.0F, 13.0F/16.0F, 8.0F/16.0F, 14.0F/16.0F,  this.boxIcon);
			
		}
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		int ID = block.blockID;
		int meta = (world.getBlockMetadata(x, y, z) & 1);
		this.boxIcon = DCsAppleMilk.chalcedony.getIcon(1, 4);
		
		if (modelId == this.getRenderId())
		{
			//box
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(3.0F/16.0F, 0.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 2.0F/16.0F, 13.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			
			
			if (meta == 0)
			{
				renderer.setOverrideBlockTexture(this.boxIcon);
				block.setBlockBounds(1.0F/16.0F, 7.0F/16.0F, 6.0F/16.0F, 2.0F/16.0F, 8.0F/16.0F, 10.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.boxIcon);
				block.setBlockBounds(14.0F/16.0F, 7.0F/16.0F, 6.0F/16.0F, 15.0F/16.0F, 8.0F/16.0F, 10.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
			}
			else
			{
				renderer.setOverrideBlockTexture(this.boxIcon);
				block.setBlockBounds(6.0F/16.0F, 7.0F/16.0F, 1.0F/16.0F, 10.0F/16.0F, 8.0F/16.0F, 2.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
				
				renderer.setOverrideBlockTexture(this.boxIcon);
				block.setBlockBounds(6.0F/16.0F, 7.0F/16.0F, 14.0F/16.0F, 10.0F/16.0F, 8.0F/16.0F, 15.0F/16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
			}
			
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(2.0F/16.0F, 0.0F/16.0F, 2.0F/16.0F, 3.0F/16.0F, 8.0F/16.0F, 14.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(13.0F/16.0F, 0.0F/16.0F, 2.0F/16.0F, 14.0F/16.0F, 8.0F/16.0F, 14.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(3.0F/16.0F, 0.0F/16.0F, 2.0F/16.0F, 13.0F/16.0F, 8.0F/16.0F, 3.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setOverrideBlockTexture(this.boxIcon);
			block.setBlockBounds(3.0F/16.0F, 0.0F/16.0F, 13.0F/16.0F, 13.0F/16.0F, 8.0F/16.0F, 14.0F/16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			
			
			renderer.clearOverrideBlockTexture();
			block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			renderer.setRenderBoundsFromBlock(block);
			return true;
		}
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		
		return true;
	}

	@Override
	public int getRenderId() {
		
		return DCsAppleMilk.modelChocoPan;
	}
	
	private void renderInvCuboid(RenderBlocks renderer, Block block, float minX, float minY, float minZ, float maxX, float maxY, float maxZ, Icon icon)
	{
		Tessellator tessellator = Tessellator.instance;
		block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		renderer.setRenderBoundsFromBlock(block);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		block.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		renderer.setRenderBoundsFromBlock(block);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1F, 0.0F);
		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, icon);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, icon);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1F);
		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, icon);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, icon);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0.0F, 0.0F);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, icon);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, icon);
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		renderer.setRenderBoundsFromBlock(block);
	}
}
