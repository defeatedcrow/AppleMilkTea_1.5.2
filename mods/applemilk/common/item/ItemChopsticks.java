package mods.applemilk.common.item;

import java.util.List;

import net.minecraft.src.*;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.texture.IconRegister;
import mods.applemilk.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemChopsticks extends Item {
	
	@SideOnly(Side.CLIENT)
    private Icon iconType[];
	
	private static final String[] itemType = new String[] {"", "_2"};
	
	public ItemChopsticks (int itemId){
		super (itemId);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		maxStackSize = 64;

	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, 2);
        return this.iconType[j];
    }
	
	@Override
	public int getMetadata(int par1) {
		return par1;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return super.getUnlocalizedName() + "_" + par1ItemStack.getItemDamage();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0 ; i < 2 ; i++)
		{
			par3List.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister){
		this.iconType = new Icon[2];

        for (int i = 0; i < 2; ++i)
        {
            this.iconType[i] = par1IconRegister.registerIcon("applemilk:chopsticks" + itemType[i]);
        }
	}

}
