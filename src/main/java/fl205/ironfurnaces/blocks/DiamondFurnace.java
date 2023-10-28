package fl205.ironfurnaces.blocks;

import fl205.ironfurnaces.tileEntities.TileEntityDiamondFurnace;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;

import static fl205.ironfurnaces.IronFurnaces.config;

public class DiamondFurnace extends CustomFurnace {

	public DiamondFurnace(String key, int id, Material material, boolean flag) {
		super(key, id, material, flag, config.getInt("ids.diamondFurnaceActiveID"), config.getInt("ids.diamondFurnaceIdleID"));
	}
	protected TileEntity getNewBlockEntity() {
		return new TileEntityDiamondFurnace();
	}
}
