package fl205.ironfurnaces.tileEntities;

import fl205.ironfurnaces.IronFurnaces;
import fl205.ironfurnaces.blocks.CustomFurnace;

import static fl205.ironfurnaces.IronFurnaces.config;

public class TileEntitySteelFurnace extends TileEntityCustomFurnace {
	public TileEntitySteelFurnace(){
		super(config.getInt("speed.steelFurnace"), config.getInt("fuelYield.steelFurnace"), (CustomFurnace) IronFurnaces.furnaceSteelIdle);
	}
	public String getInvName() {
		return "Steel Furnace";
	}
}
