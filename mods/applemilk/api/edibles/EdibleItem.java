package mods.applemilk.api.edibles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * 食べられるアイテムの作成を補助するためのクラス。
 * <br>同じ処理（容器返却処理）を複数のアイテムに重複して追加するのは面倒だし見た目も良くないので作成。
 * <br>デフォルト動作では、返却容器はなし、飲食時の効果は空腹度回復のポーション効果である。
 */
public class EdibleItem extends ItemBlock implements IEdibleItem {
	
	public EdibleItem(int itemId) {
		super(itemId);
	}
	
	/**
	 * 食べる動作
	 */
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		int meta = par1ItemStack.getItemDamage();
		
		if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }
		this.returnItemStack(par3EntityPlayer, meta);
		par3EntityPlayer.getFoodStats().addStats(this.getFoodStatus(meta), this.getFoodStatus(meta));
		
		if (!par2World.isRemote)
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
	 * <br>注意点として、ItemFoodのような空腹度回復効果ではなく、
	 * ポーション効果のSaturationを利用して空腹度回復を行っている。
	 */
	@Override
	public PotionEffect effectOnEaten(int meta) {
		
		return new PotionEffect(Potion.field_76443_y.id, 2, 2);
	}

	@Override
	public int getFoodStatus(int meta) {
		return 4;
	}

}
