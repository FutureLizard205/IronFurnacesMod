package fl205.ironfurnaces.blocks;

import fl205.ironfurnaces.tileEntities.TileEntityGoldFurnace;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;

import static fl205.ironfurnaces.IronFurnaces.config;
public class GoldFurnace extends CustomFurnace {
	public GoldFurnace(String key, int id, Material material, boolean flag) {
		super(key, id, material, flag, config.getInt("ids.goldFurnaceIdleID") + 1, config.getInt("ids.goldFurnaceIdleID"));
	}
	@Override
	protected TileEntity getNewBlockEntity() {
		return new TileEntityGoldFurnace();
	}
}
