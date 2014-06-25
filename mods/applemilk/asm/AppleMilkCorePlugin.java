package mods.applemilk.asm;

import java.io.File;
import java.util.Map;
import java.util.logging.Logger;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

/**
* Original code was created by A.K.
*/
public class AppleMilkCorePlugin implements IFMLLoadingPlugin {
	
	public static boolean allowLoad;
	public static int range = Byte.MAX_VALUE;
	private final String BR = System.getProperty("line.separator");
	
    public static Logger logger = Logger.getLogger("AppleMilkCore");
    
    @Override
    public String[] getASMTransformerClass() {
        return new String[]{
                "mods.applemilk.asm.PotionArrayEXTransformer"
        };
    }

    @Override
    public String getModContainerClass() {
        return "mods.applemilk.asm.AppleMilkCoreModContainer";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        if (data.containsKey("mcLocation"))
        {
            File mcLocation = (File) data.get("mcLocation");
            File configLocation = new File(mcLocation, "config");
            File configFile = new File(configLocation, "DCsAppleMilk.cfg");
            
//            loadConfig(configFile);
        }
    }
    
    private void loadConfig(File configFile)
    {
    	Configuration config = new Configuration(configFile);
        config.load();
        Property a = config.get("general", "EnableLoadCore", true,
        		"Enable to load AppleMilkCore. If you want to disable AppleMilkCore, please set false."
    					+ BR +"For example, for avoiding crash cause of conflict with MCPC+.");
        Property b = config.get("general", "SetNewPotionIDRange", Byte.MAX_VALUE,
        		"Set new potion ID range. It must be bigger than 32, and smaller than 256.");
        
        allowLoad = a.getBoolean(true);
        range = b.getInt();
        
        config.save();
    }
    
	@Override
	public String[] getLibraryRequestClass() {
		return null;
	}
}
