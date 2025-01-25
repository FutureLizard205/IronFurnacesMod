package fl205.ironfurnaces.blocks;

import fl205.ironfurnaces.tileEntities.TileEntityIronFurnace;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;

import static fl205.ironfurnaces.IronFurnaces.config;

public class BlockLogicIronFurnace extends BlockLogicCustomFurnace {
	public BlockLogicIronFurnace(Block<?> block, boolean flag) {
		super(block, flag, config.getInt("IDs.ironFurnaceIdleID") + 1, config.getInt("IDs.ironFurnaceIdleID"));
		block.withEntity(TileEntityIronFurnace::new);
	}
}
