package mods.applemilk.handler;

import com.google.common.base.Optional;

import mods.applemilk.common.AMTLogger;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class LoadBoPHandler {
	
	public static ItemStack bopBerry;
	
	public void load() {
		
		Object obj;
		try {
			obj = Class.forName("biomesoplenty.configuration.BOPConfiguration").getField("foodID").get(null);
			if (obj != null && obj instanceof Integer) {
				Integer item = (Integer) obj;
				bopBerry = new ItemStack(item, 1, 0);
			
				if (bopBerry != null) {
					OreDictionary.registerOre("cropRaspberry", bopBerry);
					LoadModHandler.registerModItems("berry", bopBerry);
					AMTLogger.debugInfo("Succeeded to get BoP's berry");
				}
			}
		}
		catch (Exception e) {
	        AMTLogger.debugInfo("Failed to register ModItems");
	        e.printStackTrace(System.err);
	    }
		
		
		
	}

}
