package mods.applemilk.potion;

import mods.applemilk.api.potion.PotionReflexBase;
import mods.applemilk.common.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;

/**
 * 当て身ポーション。
 * このポーションは効果時間中にダメージを受けると発動し、Amplifierが一段階下がる。
 * */
public class PotionReflex extends PotionReflexBase{
	
	public PotionReflex(int par1, boolean par2, int par3, boolean par4)
    {
        super(par1, par2, par3, par4);
    }
	
	@Override
	public boolean effectFormer(EntityLiving target, DamageSource source, PotionEffect effect, float amount)
	{
		boolean succeed = false;
		
		if (amount < 5.0F){
			amount = 5.0F;
		}
		
		int amp = effect.getAmplifier();
		
		if (effect.getPotionID() == DCsConfig.potionIDReflex)//反射
		{
			/* 攻撃元のエンティティがいない場合は何もしない*/
			if (source instanceof EntityDamageSource)
			{
				EntityDamageSource source2 = (EntityDamageSource) source;
				Entity attacker = source2.getEntity();
				
				if (attacker != null)
				{
					if (attacker instanceof EntityLiving)//生き物の時はダメージやノックバック処理を行う
					{
						EntityLiving livingAttacker = (EntityLiving) attacker;
						//ノックバック
						float range = livingAttacker.rotationYaw;
						livingAttacker.addVelocity(livingAttacker.motionX * (-1.0D) / (double)range, 0.1D, livingAttacker.motionZ * (-1.0D) / (double)range);
						//magic属性のダメージ
						livingAttacker.attackEntityFrom(DamageSource.magic, (int)amount*amp);
						//プレイヤーには鈴の音が聞こえる（暫定）
						target.worldObj.playSoundAtEntity(target, "defeatedcrow:suzu", 1.0F, 1.2F);
						succeed = true;
					}
					else if (amp > 0)
					{
						//生き物でない場合は何もしないが、無効化効果は働く
						target.worldObj.playSoundAtEntity(target, "defeatedcrow:suzu", 1.0F, 1.2F);
						succeed = true;
					}
				}
				else if (amp > 1)//レベルがII以上のときは、攻撃対象が居ない場合でも別のターゲットを取る
				{
					EntityLiving around;
					if (target instanceof EntityPlayer)
					{
						around = ((EntityPlayer)target).func_94060_bK();
					}
					else
					{
						around = target.func_94060_bK();
					}
					
					//プレイヤーや飼いならしモブ以外のてきとうなモブに八つ当りする
					if (around != null && !(around instanceof EntityPlayer) && !(around instanceof EntityTameable))
					{
						//ノックバック
						float range = around.rotationYaw;
						around.addVelocity(around.motionX * (-1.0D) / (double)range, 0.1D, around.motionZ * (-1.0D) / (double)range);
						//magic属性のダメージ
						around.attackEntityFrom(DamageSource.magic, (int)amount*amp);
						//プレイヤーには鈴の音が聞こえる（暫定）
						target.worldObj.playSoundAtEntity(target, "defeatedcrow:suzu", 1.0F, 1.2F);
						succeed = true;
					}
				}
				
			}
		}
		
		if (effect.getPotionID() == DCsConfig.potionIDAbsEXP)
		{
			if (target instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) target;
				int get = Math.round(Math.abs(amount));
				boolean flag = false;
				
				if (amp > 2)
				{
					flag = true;
				}
				else if (amp > 1 && (source.isExplosion() || source.isFireDamage()))
				{
					flag = true;
				}
				else
				{
					flag = (source instanceof EntityDamageSource);
				}
				
				if (flag) {
					player.addExperience(get);
					succeed = true;
				}
			}
		}
		
		if (effect.getPotionID() == DCsConfig.potionIDAbsHeal)
		{
			if (target instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) target;
				boolean flag = false;
				
				if (amp > 2)
				{
					flag = true;
				}
				else if (amp > 1 && (source.isExplosion() || source.isFireDamage()))
				{
					flag = true;
				}
				else
				{
					flag = (source instanceof EntityDamageSource);
				}
				
				if (flag) {
					player.heal((int)amount*2);
					succeed = true;
				}
			}
		}
		
		return succeed;
	}

}
