package mods.applemilk.handler;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class LoadTofuHandler {
	
	public static Item tofuKinu;
	public static Item bucketTounyu;
	public static Item negi;

	public void load() {
		
		//ここでもOreDicの機能でアイテムを取得しているので、専用クラスにする意味は薄い。
		//強いて言えば、豆腐クラフト様の未導入時に間違って読み込んでしまうミスを減らす程度か。
		ArrayList<ItemStack> kinu = OreDictionary.getOres("tofuKinu");
		ArrayList<ItemStack> tounyu = OreDictionary.getOres("bucketSoymilk");
		ArrayList<ItemStack> naganegi = OreDictionary.getOres("leek");
		
		if (kinu.size() > 0){
			tofuKinu = kinu.get(0).getItem();
		}
		if (tounyu.size() > 0){
			bucketTounyu = tounyu.get(0).getItem();
			if (bucketTounyu != null) {
				LoadModHandler.registerModItems("bucketSoy", new ItemStack(bucketTounyu, 1, 0));
			}
		}
		if (naganegi.size() > 0){
			negi = naganegi.get(0).getItem();
		}
	}
	
	

}
