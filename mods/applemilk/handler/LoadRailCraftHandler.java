package mods.applemilk.handler;

import mods.applemilk.common.DCsAppleMilk;
import mods.railcraft.api.crafting.RailcraftCraftingManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;

public class LoadRailCraftHandler {
	
	private static LiquidStack creosote;
	
	public void load()
	{
		if (LiquidDictionary.getCanonicalLiquid("Creosote Oil") != null)
		{
			this.creosote = LiquidDictionary.getLiquid("Creosote Oil", 500);
			if (this.creosote != null)
			{
				RailcraftCraftingManager.cokeOven.addRecipe(new ItemStack(DCsAppleMilk.woodBox, 1, 0), false, false,
						new ItemStack(DCsAppleMilk.charcoalBox, 1, 0), this.creosote, 1800);
				RailcraftCraftingManager.cokeOven.addRecipe(new ItemStack(DCsAppleMilk.woodBox, 1, 1), false, false,
						new ItemStack(DCsAppleMilk.charcoalBox, 1, 0), this.creosote, 1800);
				RailcraftCraftingManager.cokeOven.addRecipe(new ItemStack(DCsAppleMilk.woodBox, 1, 2), false, false,
						new ItemStack(DCsAppleMilk.charcoalBox, 1, 0), this.creosote, 1800);
				RailcraftCraftingManager.cokeOven.addRecipe(new ItemStack(DCsAppleMilk.woodBox, 1, 3), false, false,
						new ItemStack(DCsAppleMilk.charcoalBox, 1, 0), this.creosote, 1800);
			}
			
		}
	}

}
