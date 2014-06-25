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
public class RenderWipeBox implements ISimpleBlockRenderingHandler{
	
	private Icon boxIcon;
	private Icon[] wipeIcon = new Icon[5];
	private Icon wipe2;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		int meta = metadata;
		this.boxIcon = DCsAppleMilk.wipeBox.getIcon(0, 0);
		this.wipeIcon[0] = DCsAppleMilk.wipeBox.getIcon(0, 1);
		this.wipeIcon[1] = DCsAppleMilk.wipeBox.getIcon(1, 1);
		this.wipeIcon[2] = DCsAppleMilk.wipeBox.getIcon(2, 1);
		this.wipeIcon[3] = DCsAppleMilk.wipeBox.getIcon(3, 1);
		this.wipeIcon[4] = DCsAppleMilk.wipeBox.getIcon(4, 1);
		this.wipe2 = DCsAppleMilk.wipeBox2.getBlockTextureFromSide(0);
		
		if (modelID == this.getRenderId())
		{
			if (block.blockID == DCsAppleMilk.wipeBox.blockID)
			{
				if ((meta & 1) == 0)
				{
					//bottom
					renderInvCuboid(renderer, block,  3.0F/16.0F, 0.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 8.0F/16.0F, 13.0F/16.0F,  this.boxIcon);
				}
				else
				{
					renderInvCuboid(renderer, block,  3.0F/16.0F, 0.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 7.0F/16.0F, 4.0F/16.0F,  this.wipeIcon[2]);
					renderInvCuboid(renderer, block,  3.0F/16.0F, 0.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F, 7.0F/16.0F, 13.0F/16.0F,  this.wipeIcon[2]);
					renderInvCuboid(renderer, block,  3.0F/16.0F, 0.0F/16.0F, 4.0F/16.0F, 4.0F/16.0F, 7.0F/16.0F, 12.0F/16.0F,  this.wipeIcon[3]);
					renderInvCuboid(renderer, block,  12.0F/16.0F, 0.0F/16.0F, 4.0F/16.0F, 13.0F/16.0F, 7.0F/16.0F, 12.0F/16.0F,  this.wipeIcon[3]);
					renderInvCuboid(renderer, block,  3.0F/16.0F, 7.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 8.0F/16.0F, 13.0F/16.0F,  this.wipeIcon[1]);
					renderInvCuboid(renderer, block,  4.0F/16.0F, 0.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 1.0F/16.0F, 12.0F/16.0F,  this.wipeIcon[0]);
				}
			}
			else if (block.blockID == DCsAppleMilk.wipeBox2.blockID)
			{
				renderInvCuboid(renderer, block,  2.0F/16.0F, 0.0F/16.0F, 3.0F/16.0F, 14.0F/16.0F, 10.0F/16.0F, 13.0F/16.0F,  this.wipe2);
			}
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		int meta = world.getBlockMetadata(x, y, z);
		this.boxIcon = DCsAppleMilk.wipeBox.getIcon(0, 0);
		this.wipeIcon[0] = DCsAppleMilk.wipeBox.getIcon(0, 1);
		this.wipeIcon[1] = DCsAppleMilk.wipeBox.getIcon(1, 1);
		this.wipeIcon[2] = DCsAppleMilk.wipeBox.getIcon(2, 1);
		this.wipeIcon[3] = DCsAppleMilk.wipeBox.getIcon(3, 1);
		this.wipeIcon[4] = DCsAppleMilk.wipeBox.getIcon(4, 1);
		
		if (modelId == this.getRenderId())
		{
			 if (block.blockID == DCsAppleMilk.wipeBox.blockID)
				{
					if (((meta & 1) == 0) && meta < 3)
					{
						renderer.setOverrideBlockTexture(this.boxIcon);
						block.setBlockBounds(3.0F/16.0F, 0.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 8.0F/16.0F, 13.0F/16.0F);
						renderer.setRenderBoundsFromBlock(block);
						renderer.renderStandardBlock(block, x, y, z);
					}
					else
					{
//						renderer.setOverrideBlockTexture(this.wipeIcon[2]);
//						block.setBlockBounds(4.0F/16.0F, 0.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 7.0F/16.0F, 4.0F/16.0F);
//						renderer.setRenderBoundsFromBlock(block);
//						renderer.renderStandardBlock(block, x, y, z);
//						
//						renderer.setOverrideBlockTexture(this.wipeIcon[2]);
//						block.setBlockBounds(4.0F/16.0F, 0.0F/16.0F, 12.0F/16.0F, 13.0F/16.0F, 7.0F/16.0F, 13.0F/16.0F);
//						renderer.setRenderBoundsFromBlock(block);
//						renderer.renderStandardBlock(block, x, y, z);
//						
//						renderer.setOverrideBlockTexture(this.wipeIcon[3]);
//						block.setBlockBounds(3.0F/16.0F, 0.0F/16.0F, 3.0F/16.0F, 4.0F/16.0F, 7.0F/16.0F, 13.0F/16.0F);
//						renderer.setRenderBoundsFromBlock(block);
//						renderer.renderStandardBlock(block, x, y, z);
//						
//						renderer.setOverrideBlockTexture(this.wipeIcon[3]);
//						block.setBlockBounds(12.0F/16.0F, 0.0F/16.0F, 4.0F/16.0F, 13.0F/16.0F, 7.0F/16.0F, 12.0F/16.0F);
//						renderer.setRenderBoundsFromBlock(block);
//						renderer.renderStandardBlock(block, x, y, z);
//						
//						renderer.setOverrideBlockTexture(this.wipeIcon[1]);
//						block.setBlockBounds(3.0F/16.0F, 7.0F/16.0F, 3.0F/16.0F, 13.0F/16.0F, 8.0F/16.0F, 13.0F/16.0F);
//						renderer.setRenderBoundsFromBlock(block);
//						renderer.renderStandardBlock(block, x, y, z);
//						
//						renderer.setOverrideBlockTexture(this.wipeIcon[0]);
//						block.setBlockBounds(4.0F/16.0F, 0.0F/16.0F, 4.0F/16.0F, 12.0F/16.0F, 1.0F/16.0F, 12.0F/16.0F);
//						renderer.setRenderBoundsFromBlock(block);
//						renderer.renderStandardBlock(block, x, y, z);
					}
					
					if (meta > 1)
					{
						renderer.setOverrideBlockTexture(this.wipeIcon[4]);
						block.setBlockBounds(0.0F/16.0F, 0.0F/16.0F, 0.0F/16.0F, 16.0F/16.0F, 16.0F/16.0F, 16.0F/16.0F);
						renderer.setRenderBoundsFromBlock(block);
						renderer.renderCrossedSquares(block, x, y, z);
					}
				}
			 
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
		
		return DCsAppleMilk.modelWipe;
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
