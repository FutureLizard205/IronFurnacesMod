package fl205.ironfurnaces.blocks;

import fl205.ironfurnaces.tileEntities.TileEntityIronFurnace;
import net.minecraft.core.block.Block;

import static fl205.ironfurnaces.IronFurnaces.config;

public class BlockLogicIronFurnace extends BlockLogicCustomFurnace {
	public BlockLogicIronFurnace(Block<?> block, boolean isActive) {
		super(block, isActive, config.getInt("IDs.ironFurnaceIdleID"));
		block.withEntity(TileEntityIronFurnace::new);
	}
}
