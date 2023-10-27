package fl205.ironfurnaces.tileEntities;

import fl205.ironfurnaces.IronFurnaces;
import fl205.ironfurnaces.blocks.CustomFurnace;

import static fl205.ironfurnaces.IronFurnaces.config;
public class TileEntityGoldFurnace extends TileEntityCustomFurnace {
	public TileEntityGoldFurnace(){
		super(config.getInt("speed.goldFurnace"), config.getInt("fuelYield.goldFurnace"), (CustomFurnace) IronFurnaces.furnaceGoldIdle);
	}
	public String getInvName() {
		return "Gold Furnace";
	}
}
