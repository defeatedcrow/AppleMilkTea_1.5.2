package mods.applemilk.api.events;

import mods.applemilk.api.recipe.ITeaRecipe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

/**
 * TeaMakerの右クリックで呼ばれるメソッド。
 * 特定のアイテムに右クリック動作を新規に追加したり、または特定アイテムをの動作を削除するのに使える。
 * */
@Cancelable
public class TeamakerRightClickEvent extends Event{
	
	public final TileEntity teaMaker;
	public final int remain;
	public final ITeaRecipe currentRecpe;
	
	public final EntityPlayer player;
	
	public final int x;
	public final int y;
	public final int z;
	
	public TeamakerRightClickEvent (EntityPlayer entityplayer, int X, int Y, int Z, TileEntity tile, int rem, ITeaRecipe recipe)
	{
		this.player = entityplayer;
		this.x = X;
		this.y = Y;
		this.z = Z;
		this.teaMaker = tile;
		this.remain = rem;
		this.currentRecpe = recipe;
	}
	
	

}
