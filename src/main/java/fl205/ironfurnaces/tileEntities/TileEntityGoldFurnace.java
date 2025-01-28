package fl205.ironfurnaces.tileEntities;

import fl205.ironfurnaces.IronFurnaces;

import static fl205.ironfurnaces.IronFurnaces.config;

public class TileEntityGoldFurnace extends TileEntityCustomFurnace {
	public TileEntityGoldFurnace(){
		super(config.getInt("Speed.goldFurnace"), config.getInt("Fuel Yield.goldFurnace"), IronFurnaces.furnaceGoldIdle.id());
	}
}
