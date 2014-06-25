package mods.applemilk.handler;

import mods.applemilk.common.AMTLogger;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class LoadForestryHandler {
	
	public void load()
	{
		Item item = Util.getModItem("Forestry", "waxCapsule");
		if (item != null) {
			ItemStack register = new ItemStack(item, 1, 0);
			if (register != null) {
				LoadModHandler.registerModItems("emptyCapsule", register);
			}
		}
		Item item2 = Util.getModItem("Forestry", "refractoryEmpty");
		if (item2 != null) {
			ItemStack register = new ItemStack(item2, 1, 0);
			if (register != null) {
				LoadModHandler.registerModItems("emptyRefractory", register);
			}
		}
		Item item3 = Util.getModItem("Forestry", "canEmpty");
		if (item3 != null) {
			ItemStack register = new ItemStack(item3, 1, 0);
			if (register != null) {
				LoadModHandler.registerModItems("emptyCan", register);
			}
		}
		Item item4 = Util.getModItem("Forestry", "waxCapsuleWater");
		if (item4 != null) {
			ItemStack register = new ItemStack(item4, 1, 0);
			if (register != null) {
				LoadModHandler.registerModItems("waterCapsule", register);
				if (LoadModHandler.registerModItems("containerWater", register)) {
					AMTLogger.debugInfo("Succeeded to get Forestry water capsule");
				}
			}
		}
		Item item5 = Util.getModItem("Forestry", "refractoryWater");
		if (item5 != null) {
			ItemStack register = new ItemStack(item5, 1, 0);
			if (register != null) {
				LoadModHandler.registerModItems("waterRefractory", register);
				if (LoadModHandler.registerModItems("containerWater", register)) {
					AMTLogger.debugInfo("Succeeded to get Forestry water refractory");
				}
			}
		}
		Item item6 = Util.getModItem("Forestry", "canWater");
		if (item6 != null) {
			ItemStack register = new ItemStack(item6, 1, 0);
			if (register != null) {
				LoadModHandler.registerModItems("waterCan", register);
				if (LoadModHandler.registerModItems("containerWater", register)) {
					AMTLogger.debugInfo("Succeeded to get Forestry water can");
				}
			}
		}
	}

}
