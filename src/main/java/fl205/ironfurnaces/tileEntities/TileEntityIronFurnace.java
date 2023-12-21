package fl205.ironfurnaces.tileEntities;

import fl205.ironfurnaces.IronFurnaces;
import fl205.ironfurnaces.blocks.CustomFurnace;

import static fl205.ironfurnaces.IronFurnaces.config;

public class TileEntityIronFurnace extends TileEntityCustomFurnace {
	public TileEntityIronFurnace(){
		super(config.getInt("Speed.ironFurnace"), config.getInt("Fuel Yield.ironFurnace"), (CustomFurnace) IronFurnaces.furnaceIronIdle);
	}
	public String getInvName() {
		return "Iron Furnace";
	}
}
