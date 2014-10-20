package mods.applemilk.api.edibles;

import mods.applemilk.api.events.EatEdiblesEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;

/**
 * 食べられるブロックの作成を補助するためのクラス。
 * <br>ブロックのItemBlockクラスに継承させることで、そのブロックを食べられるようにする。
 * <br>デフォルト動作では、返却容器はなし、飲食時の効果は空腹度回復のポーション効果である。
 */
public class EdibleItemBlock extends ItemBlock implements IEdibleItem {

	public EdibleItemBlock(int itemId) {
		super(itemId);
	}
	
	/**
	 * 食べる動作
	 */
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		boolean flag = false;
		EatEdiblesEvent event = new EatEdiblesEvent(par2World, par3EntityPlayer, par1ItemStack);
		
		MinecraftForge.EVENT_BUS.post(event);
		
		if (event.hasResult() && event.getResult() == Result.ALLOW)
		{
			if (!par3EntityPlayer.capabilities.isCreativeMode)
	        {
	            --par1ItemStack.stackSize;
	        }
			flag = true;
		}
		
        if (event.isCanceled())
        {
            return par1ItemStack;
        }
		
        
		int meta = par1ItemStack.getItemDamage();
		
		if (!flag){
			if (!par3EntityPlayer.capabilities.isCreativeMode)
	        {
	            --par1ItemStack.stackSize;
	        }
		}
		this.returnItemStack(par3EntityPlayer, meta);
		par3EntityPlayer.getFoodStats().addStats(this.getFoodStatus(meta), this.getFoodStatus(meta));
		
		if (!par2World.isRemote && this.effectOnEaten(meta) != null)
		{
			par3EntityPlayer.addPotionEffect(this.effectOnEaten(meta));
		}

        return par1ItemStack;
    }
	
	/**
	 * ガリガリ咀嚼する時間
	 */
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }

	/**
	 * 飲食時のエフェクト。
	 */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
    	return EnumAction.eat;
    }
	
    /**
     * 右クリック動作時に飲食効果を呼び出すメソッド。
     * <br>カーソルが特定のブロックをターゲットしている時は呼び出されないので、
     * 何もない方向を向いておく必要がある。
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
    
    /**
     * 空容器の返却を行うメソッド。
     */
	private boolean returnItemStack(EntityPlayer player, int meta) {
		ItemStack ret = this.getReturnContainer(meta);
		if (ret != null) {
			if (!player.inventory.addItemStackToInventory(ret))
	    	{
	    		player.entityDropItem(ret, 1);
	    		return true;
	    	}
		}
		return false;
	}

	/**
	 * 返却される空容器をメタデータ毎に定義する。
	 */
	@Override
	public ItemStack getReturnContainer(int meta) {
		
		return null;
	}

	/**
	 * 飲食時のポーション効果をメタデータ毎に定義する。
	 * <br>1.5ではSaturationポーションが存在しないため、仮対応で短い持続回復を加えている。
	 */
	@Override
	public PotionEffect effectOnEaten(int meta) {
		
		return new PotionEffect(Potion.regeneration.id, 1, 0);
	}
	
	@Override
	public int getFoodStatus(int meta) {
		return 4;
	}

}
