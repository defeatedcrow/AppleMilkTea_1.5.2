package mods.applemilk.event;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import mods.applemilk.api.events.EatEdiblesEvent;
import mods.applemilk.common.DCsAppleMilk;

public class SampleEdiblesEvent {
	
	@ForgeSubscribe
	public void EatEdiblesEvent(EatEdiblesEvent event)
	{
		ItemStack item = event.edibles;
		if (item != null && item.getItem().itemID == DCsAppleMilk.teacupBlock.blockID)
		{
			event.setResult(Result.ALLOW);
			event.setCanceled(true);
		}
	}

}
