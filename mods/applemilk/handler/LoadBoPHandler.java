package mods.applemilk.handler;

import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class LoadBoPHandler {
	
	public static ItemStack bopBerry;
	
	public void load() {
		
		Item item = Util.getModItem("BiomesOPlenty", "ItemBOPFood");
		if (item != null) {
			bopBerry = new ItemStack(item, 1, 0);
		
			if (bopBerry != null) {
				OreDictionary.registerOre("cropRaspberry", bopBerry);
				LoadModHandler.registerModItems("berry", bopBerry);
			}
		}
		
		
	}

}
