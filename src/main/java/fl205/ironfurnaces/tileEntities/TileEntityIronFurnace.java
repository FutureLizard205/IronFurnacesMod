package fl205.ironfurnaces.tileEntities;

import fl205.ironfurnaces.IronFurnaces;
import fl205.ironfurnaces.blocks.BlockLogicCustomFurnace;

import static fl205.ironfurnaces.IronFurnaces.config;

public class TileEntityIronFurnace extends TileEntityCustomFurnace {
	public TileEntityIronFurnace(){
		super(config.getInt("Speed.ironFurnace"), config.getInt("Fuel Yield.ironFurnace"), IronFurnaces.furnaceIronIdle);
	}
	public String getInvName() {
		return "Iron Furnace";
	}
}
