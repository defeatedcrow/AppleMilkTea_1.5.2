package mods.applemilk.common.block;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.UP;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockChalcedony extends BlockBreakable{
	
	@SideOnly(Side.CLIENT)
    private Icon[] color;
	
	public BlockChalcedony  (int blockid, Material material, boolean flag)
	{
		super(blockid, "applemilk:chalcedony", material, flag);
		this.setHardness(1.5F);
		this.setResistance(2.0F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setLightValue(0.0F);
	}
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return this.blockID;
	}
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
    {
        return 1;
    }
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
    }
	
	public int getMobilityFlag()
    {
        return 0;
    }
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		int i = MathHelper.clamp_int(par2, 0, 4);
		return color[i];
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
		for(int i = 0; i < 3; ++i)
		{
			par3List.add(new ItemStack(this, 1, i));
		}
		par3List.add(new ItemStack(this, 1, 4));
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.color = new Icon[5];
		
		this.color[0] = par1IconRegister.registerIcon("applemilk:chalcedony");
        this.color[1] = par1IconRegister.registerIcon("applemilk:chalcedony_orange");
        this.color[2] = par1IconRegister.registerIcon("applemilk:chalcedony_white");
        this.color[3] = par1IconRegister.registerIcon("applemilk:chalcedony_white");
        this.color[4] = par1IconRegister.registerIcon("applemilk:whitepanel");
		
	}

}