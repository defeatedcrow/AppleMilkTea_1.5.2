package mods.applemilk.handler;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.applemilk.common.AMTLogger;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class LoadBambooHandler {
	
	public static Item bambooBasket;
	public static Item bambooMugimeshi;

	public void load() {
		
		//やっていることはOreDictionaryから辞書登録名で検索してくるだけ
		//なので本当は、竹MOD様のロードを確認しなくてもエラーは起こらない
		ArrayList<ItemStack> basket = OreDictionary.getOres("bambooBasket");
		ArrayList<ItemStack> mugimeshi = OreDictionary.getOres("wheatRice");
		
		if (basket.size() > 0){
			bambooBasket = basket.get(0).getItem();
		}
		if (mugimeshi.size() > 0){
			bambooMugimeshi = mugimeshi.get(0).getItem();
		}
	}
	
	//専用クラスにお引っ越し
	public void loadBambooItems()//BambooMod様のアイテムのうち、鉱石辞書登録されていないものはココを使う
	{
		try
		{
			Object obj = Class.forName("mod_Bamboo").getField("sakuraLog").get(null);
			if (obj instanceof Block) {
				Block block = (Block) obj;
				ItemStack registerItem4 = new ItemStack(block, 1, 0);
				if (LoadModHandler.registerModItems("sakuraWood", registerItem4)) {
					AMTLogger.debugInfo("Succeeded to get sakuraLog");
				}
				
				if (registerItem4 != null)
				{
					GameRegistry.addRecipe(
							 new ShapedOreRecipe(
				    		  new ItemStack(DCsAppleMilk.woodBox, 1, 8),
				    		  new Object[]{
									 "XXX",
									 "XXX",
									 "XXX",
									 Character.valueOf('X'), registerItem4}));
					
					GameRegistry.addRecipe(
							 new ShapelessOreRecipe(
									 new ItemStack(block, 9, 0),
				    		  new Object[]{
							  new ItemStack(DCsAppleMilk.woodBox, 1, 8)
								 }));
				}
			}
			Object obj2 = Class.forName("mod_Bamboo").getField("campfire").get(null);
			if (obj2 instanceof Block) {
				Block block2 = (Block) obj2;
				ItemStack registerItem5 = new ItemStack(block2, 1, 0);
				if (LoadModHandler.registerModItems("furneceBlock", registerItem5)) {
					AMTLogger.debugInfo("Succeeded to get campfire");
				}
			}
			Object obj3 = Class.forName("mod_Bamboo").getField("bambooBasket").get(null);
			if (obj3 instanceof Item) {
				Item item = (Item) obj3;
				this.bambooBasket = item;
				ItemStack registerItem6 = new ItemStack(item, 1, 0);
				if (LoadModHandler.registerModItems("bambooBasket", registerItem6)) {
					AMTLogger.debugInfo("Succeeded to get bambooBasket");
				}
			}
			Object obj4 = Class.forName("mod_Bamboo").getField("bambooFood").get(null);
			if (obj4 instanceof Item) {
				Item item2 = (Item) obj4;
				this.bambooMugimeshi = item2;
				ItemStack registerItem7 = new ItemStack(item2, 1, 0);
				if (LoadModHandler.registerModItems("wheatRice", registerItem7)) {
					AMTLogger.debugInfo("Succeeded to get wheatRice");
				}
			}
		}
        catch (Exception e) {
        	AMTLogger.debugInfo("Failed to register ModItems");
          e.printStackTrace(System.err);
        }
	}

}
