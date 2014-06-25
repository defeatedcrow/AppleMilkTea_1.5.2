package mods.applemilk.api;

import mods.applemilk.common.AMTLogger;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * 当MODののアイテム、ブロックを取得する際に使用するクラスです。
 * <br>String型で指定します。名称はこのクラス内のコメントをご確認下さい。
 */
public class ItemAPI {
	
	public static ItemStack getItem(String itemName, int meta)
	{
		ItemStack target = null;
		try {
			Object obj = Class.forName(packageName()).getField(itemName).get(null);
			if (obj instanceof Item) {
				target = new ItemStack ((Item)obj, 1, meta);
			}
			else if (obj instanceof ItemStack) {
				target = (ItemStack) obj;
			}
			return target;
		}
		catch (Exception e) {
			AMTLogger.info("Failed to get item: " + itemName);
			return null;
		}
	}
	
	public static ItemStack getBlock(String blockName, int meta)
	{
		ItemStack target = null;
		try {
			Object obj = Class.forName(packageName()).getField(blockName).get(null);
			if (obj instanceof Block) {
				target = new ItemStack ((Block)obj, 1, meta);
			}
			else if (obj instanceof ItemStack) {
				target = (ItemStack) obj;
			}
			return target;
		}
		catch (Exception e) {
			AMTLogger.info("Failed to get block: " + blockName);
			return null;
		}
	}
	
	/* Values of itemName & metadata:
	 * 
	 * (foods)
	 * 
	 * baked apple 					: bakedApple
	 * apple tart 					: appleTart
	 * toffy apple (normal) 		: toffyApple
	 * toffy apple (potion effect) 	: icyToffyApple	& icy:0, airy:1, golden:2, green:3
	 * Sandwiches 					: appleSandWich & apple:0, egg:1
	 * clam							: clam & raw:0, cooked:1
	 * burnt meat					: clam & 2
	 * black egg					: clam & 3 
	 * milk candy					: EXItems & 0
	 * fruit chocolates				: chocolateFruits
	 * 								  & almond:0, peanut:1, crushed nuts:2, strawberry:3, cherry:4, berry:5, banana:6,
	 * 									cereal:7, bread:8, cookie:9, truffles:10, candy:11, apple:12
	 * 
	 * (food materials)
	 * 
	 * raw tea leaves				: leafTea
	 * green tea leaves				: EXItems & 2
	 * tea leaves					: EXItems & 3
	 * oxidized tea leaves			: EXItems & 4
	 * earl gray leaves				: EXItems & 8
	 * apple tea leaves				: EXItems & 9
	 * 
	 * condensed milk				: condensedMilk
	 * ganache						: gratedApple & 4
	 * crashed ice					: EXItems & 7
	 * 
	 * grated fruits				: gratedApple & apple:0, fruit:1, lime:5, tomato:6, berry:7
	 * honey lemon slices			: gratedApple & 2
	 * coffee powder				: gratedApple & 3
	 * 
	 * minced mushroom				: mincedFoods & 0
	 * minced fish and vegetables	: mincedFoods & 1
	 * minced chicken and rice		: mincedFoods & 2
	 * washed rice					: mincedFoods & 3
	 * materials of Kayakumeshi		: mincedFoods & 4
	 * materials of Tofu-nabe		: mincedFoods & 5
	 * minced pumpkin				: mincedFoods & 6
	 * minced BLT					: mincedFoods & 7
	 * minced chocolate				: mincedFoods & 8
	 * 
	 * (materials)
	 * 
	 * icy crystal					: icyCrystal
	 * chalcedony gear				: EXItems & 6
	 * animal glue					: EXItems & 1
	 * ink stick					: inkStick
	 * glass dust					: EXItems & 11
	 * 
	 * (tools)
	 * 
	 * chopsticks					: chopsticks & chopsticks:0, spoon:1
	 * grater						: DCgrater
	 * chalcedony knife				: chalcedonyKnife
	 * chalcedony stone cutter		: chalcedonyHammer
	 * fire starter					: firestarter
	 * 
	 * (magical items)
	 * 
	 * princess clam                : princessClam & princessclam:0, charm(flower):1, charm(butterfly):2, charm(wind):3, charm(moon):4
	 * 
	 * 
	 * Values of blockName & metadata
	 * 
	 * (containers)
	 * 
	 * log boxes					: woodBox & oak:0, spruce:1, birch:2, jungle:3, 
	 * 											(IC2)rubber:4, (TC4)great wood:5, (TC4)silver wood:6
	 *                                          (DartCraft)forceLog:7, (Bamboo)sakuraLog:8, (MapleTree)mapleLog:9, (SugiForest)sugiLog:10
	 * apple box					: appleBox
	 * charcoal container			: charcoalContainer
	 * another container			: gunpowderContainer & gunpowder:1, Kayaku:1, clay:2, clam:3
	 * vegetable bags				: vegiBag & tea leaves:0, potato:1, carrot:2, pumpkin:3, seed:4, reed:5,
	 * 								:			cactus:6, cocoa:7, nether wart:8, sugar:9
	 * mushroom block				: mushroomBox & red:0, brown:1
	 * compressed melon				: melonBomb
	 * wipe box						: wipeBox & wipe:0, kixWipe:1
	 * large paper box				: wipeBox2 (the remaining amount of paper is managed by damage value. 0-5000)
	 * egg basket					: eggBasket & normal:0, black:1
	 * 
	 * (machines)
	 * 
	 * tea maker					: teaMakerNext
	 * auto tea maker				: autoMaker
	 * ice maker					: iceMaker
	 * pan							: emptyPan
	 * cooking iron plate			: teppann
	 * empty cup					: emptyCup
	 * empty wallmug				: EXItems & 10
	 * rotary dial					: rotaryDial
	 * 
	 * (basket and table wares)
	 * 
	 * bread basket					: breadBasket (the remaining amount of bread is managed by metadata. 0-5)
	 * bottle case					: breadBasket (the remaining amount of bottle is managed by metadata. 6-14)
	 * chop sticks holder			: chopstickBox (the remaining amount of bread is managed by metadata. 0-4)
	 * bowl rack					: bowlRack
	 * 
	 * (food blocks)
	 * 
	 * tea cup(1)					: teacupBlock & milk:1, tea:2, milk tea:3, green tea:4, milk green tea:5, cocoa:6, milk cocoa:7,
	 * 												juice:8, shakes:9, lemonade:10, milk lemonade:11, coffee:12, milk coffee:13
	 * tea cup(2)					: teaCup2 & earl gray:0, milk earl gray:1, apple tea:2, milk apple tea:3,
	 * 											lime:4, tomato:5, berry:6, berry shakes:7, grape:8
	 * bowl of soups				: bowlBlock & rice:0, mushroom:1, salmon stew:2, zousui:3, kayaku:4, tofu:5, pumpkin:6, BLT:7
	 * bowl of soups (JP render)	: bowlJP & (just same as bowlBlock metadata)
	 * ice creams					: blockIcecream & milk:0, tea:1, greentea:2, cocoa:3, coffee:4, fruit:5, lemon:6,
	 * 												  lime:7, tomato:8, berry:9
	 * steak plates					: foodPlate & beef:0, pork:1, chicken:2, clam:3
	 * cocktails					: cocktail & frozen daiquiri:0, frozen sake:1, sake-tini:2, gimlet:3, black rose:4, red eye:5,
	 * 											pina colada:6, american lemonade:7, moscow mule:8, mint julep:9
	 * 
	 * bottles						: itemLargeBottle (the types and remaining amount is managed by metadata. 0-127)
	 * 									*type = metadata & 15.
	 * 									*amount = (metadata >> 4) & 7
	 * 
	 * (generated on world)
	 * sapling of tea				: saplingTea
	 * tea tree						: teaTree & normal:0, grown:1
	 * clam in sand					: clamSand & normal:0, declined:1, princess:2
	 * 
	 * (chalcedony)
	 * 
	 * flint block					: flintBlock
	 * chalcedony block				: chalcedoy & blue:0, orange:1, white:2
	 * chalcedony lamp				: cLamp & blue:0, orange:1, glass_blue:2, glass_orange:3, candlestick:4, table lamp:5,
	 *                                        white:6, glass_white:8, cube lamp:10
	 * 
	 * 
	 */
	
	private static final String packageName()
	{
		return "mods.applemilk.common.DCsAppleMilk";
	}
	
	

}
