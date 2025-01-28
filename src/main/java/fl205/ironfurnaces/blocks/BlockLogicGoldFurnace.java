package fl205.ironfurnaces.blocks;

import fl205.ironfurnaces.tileEntities.TileEntityGoldFurnace;
import net.minecraft.core.block.Block;

import static fl205.ironfurnaces.IronFurnaces.config;

public class BlockLogicGoldFurnace extends BlockLogicCustomFurnace {
	public BlockLogicGoldFurnace(Block<?> block, boolean isActive) {
		super(block, isActive, config.getInt("IDs.goldFurnaceIdleID"));
		block.withEntity(TileEntityGoldFurnace::new);
	}
}
