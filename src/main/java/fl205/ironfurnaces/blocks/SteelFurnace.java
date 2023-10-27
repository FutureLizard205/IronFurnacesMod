package fl205.ironfurnaces.blocks;

import fl205.ironfurnaces.tileEntities.TileEntitySteelFurnace;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import static fl205.ironfurnaces.IronFurnaces.config;

public class SteelFurnace extends CustomFurnace {
	public SteelFurnace(String key, int id, Material material, boolean flag) {
		super(key, id, material, flag, config.getInt("ids.steelFurnaceActiveID"), config.getInt("ids.steelFurnaceIdleID"));
	}
	@Override
	protected TileEntity getNewBlockEntity() {
		return new TileEntitySteelFurnace();
	}
}
