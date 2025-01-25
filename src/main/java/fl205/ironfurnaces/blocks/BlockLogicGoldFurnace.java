package fl205.ironfurnaces.blocks;

import fl205.ironfurnaces.tileEntities.TileEntityGoldFurnace;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;

import static fl205.ironfurnaces.IronFurnaces.config;

public class BlockLogicGoldFurnace extends BlockLogicCustomFurnace {
	public BlockLogicGoldFurnace(Block<?> block, boolean flag) {
		super(block, flag, config.getInt("IDs.goldFurnaceIdleID") + 1, config.getInt("IDs.goldFurnaceIdleID"));
		block.withEntity(TileEntityGoldFurnace::new);
	}
}
