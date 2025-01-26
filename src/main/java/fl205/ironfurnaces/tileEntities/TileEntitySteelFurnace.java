package fl205.ironfurnaces.tileEntities;

import fl205.ironfurnaces.IronFurnaces;
import fl205.ironfurnaces.blocks.BlockLogicCustomFurnace;

import static fl205.ironfurnaces.IronFurnaces.config;

public class TileEntitySteelFurnace extends TileEntityCustomFurnace {
	public TileEntitySteelFurnace(){
		super(config.getInt("Speed.steelFurnace"), config.getInt("Fuel Yield.steelFurnace"), IronFurnaces.furnaceSteelIdle);
	}
	public String getInvName() {
		return "Steel Furnace";
	}
}
