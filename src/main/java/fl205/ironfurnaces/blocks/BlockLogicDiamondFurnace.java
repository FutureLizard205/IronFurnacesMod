package fl205.ironfurnaces.blocks;

import fl205.ironfurnaces.tileEntities.TileEntityDiamondFurnace;
import net.minecraft.core.block.Block;

import static fl205.ironfurnaces.IronFurnaces.config;

public class BlockLogicDiamondFurnace extends BlockLogicCustomFurnace {
	public BlockLogicDiamondFurnace(Block<?> block, boolean isActive) {
		super(block, isActive, config.getInt("IDs.diamondFurnaceIdleID") + 1, config.getInt("IDs.diamondFurnaceIdleID"));
		block.withEntity(TileEntityDiamondFurnace::new);
	}
}
