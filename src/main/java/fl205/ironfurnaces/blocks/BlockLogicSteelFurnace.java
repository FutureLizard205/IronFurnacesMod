package fl205.ironfurnaces.blocks;

import fl205.ironfurnaces.tileEntities.TileEntitySteelFurnace;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;

import static fl205.ironfurnaces.IronFurnaces.config;

public class BlockLogicSteelFurnace extends BlockLogicCustomFurnace {
	public BlockLogicSteelFurnace(Block<?> block, boolean flag) {
		super(block, flag, config.getInt("IDs.steelFurnaceIdleID") + 1, config.getInt("IDs.steelFurnaceIdleID"));
		block.withEntity(TileEntitySteelFurnace::new);
	}
}
