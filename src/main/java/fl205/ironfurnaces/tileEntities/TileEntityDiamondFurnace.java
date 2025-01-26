package fl205.ironfurnaces.tileEntities;

import fl205.ironfurnaces.IronFurnaces;

import static fl205.ironfurnaces.IronFurnaces.config;

public class TileEntityDiamondFurnace extends TileEntityCustomFurnace {
	public TileEntityDiamondFurnace(){
		super(config.getInt("Speed.diamondFurnace"), config.getInt("Fuel Yield.diamondFurnace"), IronFurnaces.furnaceDiamondIdle);
	}
	public String getInvName() {
		return "Diamond Furnace";
	}
}
