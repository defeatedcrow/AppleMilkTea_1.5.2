package mods.applemilk.common.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import mods.applemilk.common.*;
import mods.applemilk.common.tile.TileKinoko;

public class BlockMushBox extends Block{
	
	@SideOnly(Side.CLIENT)
    private Icon itemIcon;
	@SideOnly(Side.CLIENT)
    private Icon boxIcon;
	
	public BlockMushBox (int blockid)
	{
		super(blockid, Material.wood);
		this.setStepSound(Block.soundClothFootstep);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        int meta = par1World.getBlockMetadata(par2, par3, par4);
        
        if (itemstack == null)
        {
        	if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.mushroomBox,1,meta)))
        	{
        		par5EntityPlayer.entityDropItem(new ItemStack(DCsAppleMilk.mushroomBox,1,meta), 1);
        	}
        	
        	par1World.setBlockToAir(par2, par3, par4);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else if (itemstack.itemID == DCsAppleMilk.mushroomBox.blockID)
        {
        	if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.mushroomBox,1,meta)))
        	{
        		par5EntityPlayer.entityDropItem(new ItemStack(DCsAppleMilk.mushroomBox,1,meta), 1);
        	}
    		
    		par1World.setBlockToAir(par2, par3, par4);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else
        {
        	return false;
        }
    }
	
	public boolean isOpaqueCube()
	{
		return false;
	}
 
	public boolean renderAsNormalBlock() 
	{
		return false;
	}
	
	@Override
	public int getRenderType()
	{
		return DCsAppleMilk.modelKinoko;
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }
	
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }
	
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.CupBoundingBox(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }
	
	public void CupBoundingBox (int par1)
	{
		float f = 0.3F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.575F, 0.5F + f);
	}
	
//	@Override
//	public TileEntity createNewTileEntity(World world) {
//		return DCsAppleMilk.noUseCupDirection ? null : new TileKinoko();
//	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
		for(int i = 0; i < 2; ++i)
		{
			par3List.add(new ItemStack(this, 1, i));
		}
    }
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return this.blockID;
	}
	
	@Override
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = Block.mushroomRed.getIcon(0, 0);
	}

}