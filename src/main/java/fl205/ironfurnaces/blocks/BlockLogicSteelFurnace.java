package fl205.ironfurnaces.blocks;

import fl205.ironfurnaces.tileEntities.TileEntitySteelFurnace;
import net.minecraft.core.block.Block;

import static fl205.ironfurnaces.IronFurnaces.config;

public class BlockLogicSteelFurnace extends BlockLogicCustomFurnace {
	public BlockLogicSteelFurnace(Block<?> block, boolean isActive) {
		super(block, isActive, config.getInt("IDs.steelFurnaceIdleID") + 1, config.getInt("IDs.steelFurnaceIdleID"));
		block.withEntity(TileEntitySteelFurnace::new);
	}
}
