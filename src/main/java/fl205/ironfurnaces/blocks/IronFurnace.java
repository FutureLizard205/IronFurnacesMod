package fl205.ironfurnaces.blocks;

import fl205.ironfurnaces.tileEntities.TileEntityIronFurnace;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;

import static fl205.ironfurnaces.IronFurnaces.config;

public class IronFurnace extends CustomFurnace {
	public IronFurnace(String key, int id, Material material, boolean flag) {
		super(key, id, material, flag, config.getInt("ids.ironFurnaceIdleID") + 1, config.getInt("ids.ironFurnaceIdleID"));
	}
	@Override
	protected TileEntity getNewBlockEntity() {
		return new TileEntityIronFurnace();
	}
}
