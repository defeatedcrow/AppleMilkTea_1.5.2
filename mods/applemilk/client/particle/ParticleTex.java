package mods.applemilk.client.particle;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
 
/**
 * パーティクル用の画像登録クラス
 */
public class ParticleTex {
	private static ParticleTex instance;
 
	String[] iconNames = {"applemilk:particle_blink", "applemilk:particle_orb", "applemilk:particle_cloud"};
	Icon icons[];
 
	public static ParticleTex getInstance() {
		if (instance == null) {
			instance = new ParticleTex();
		}
 
		return instance;
	}
 
	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void handleTextureRemap(TextureStitchEvent.Pre event) {
		if (event.map.textureType == 1) {
			this.getInstance().registerIcons(event.map);
		}
	}
 
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		icons = new Icon[iconNames.length];
		for(int i = 0; i < icons.length; ++i) {
			icons[i] = par1IconRegister.registerIcon(iconNames[i]);
		}
	}
 
	@SideOnly(Side.CLIENT)
	public Icon getIcon(String iconName) {
		for(int i = 0; i < iconNames.length; ++i) {
			if(iconName.equalsIgnoreCase(iconNames[i])) {
				return icons[i];
			}
		}
		return null;
	}
 
}
