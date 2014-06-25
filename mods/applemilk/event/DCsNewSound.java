package mods.applemilk.event;

import java.io.File;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DCsNewSound {
	
	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void SoundLoad(SoundLoadEvent event)
	{
		File dir1 = new File("resources/mod/applemilk/suzu.ogg");
		
		try
		{
			event.manager.soundPoolSounds.addSound("mod/applemilk/suzu.ogg", dir1);
		}
		catch (Exception e)
		{
			System.err.println("Failed to register one or more sounds.");
		}
		
	}

}
