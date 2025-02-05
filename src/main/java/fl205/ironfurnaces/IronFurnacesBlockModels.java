package fl205.ironfurnaces;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelHorizontalRotation;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.core.util.helper.Side;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

import static fl205.ironfurnaces.IronFurnaces.*;

public class IronFurnacesBlockModels implements ModelEntrypoint {

	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {
		ModelHelper.setBlockModel(furnaceIronIdle, () -> new BlockModelHorizontalRotation<>(furnaceIronIdle)
			.setTex(0, "ironfurnaces:block/ironfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/ironfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/ironfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/ironfurnaceidlefront", Side.NORTH));

		ModelHelper.setBlockModel(furnaceIronActive, () -> new BlockModelHorizontalRotation<>(furnaceIronActive)
			.setTex(0, "ironfurnaces:block/ironfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/ironfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/ironfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/ironfurnaceactivefront", Side.NORTH));

		ModelHelper.setBlockModel(furnaceGoldIdle, () -> new BlockModelHorizontalRotation<>(furnaceGoldIdle)
			.setTex(0, "ironfurnaces:block/goldfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/goldfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/goldfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/goldfurnaceidlefront", Side.NORTH));

		ModelHelper.setBlockModel(furnaceGoldActive, () -> new BlockModelHorizontalRotation<>(furnaceGoldActive)
			.setTex(0, "ironfurnaces:block/goldfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/goldfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/goldfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/goldfurnaceactivefront", Side.NORTH));

		ModelHelper.setBlockModel(furnaceDiamondIdle, () -> new BlockModelHorizontalRotation<>(furnaceDiamondIdle)
			.setTex(0, "ironfurnaces:block/diamondfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/diamondfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/diamondfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/diamondfurnaceidlefront", Side.NORTH));

		ModelHelper.setBlockModel(furnaceDiamondActive, () -> new BlockModelHorizontalRotation<>(furnaceDiamondActive)
			.setTex(0, "ironfurnaces:block/diamondfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/diamondfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/diamondfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/diamondfurnaceactivefront", Side.NORTH));

		ModelHelper.setBlockModel(furnaceSteelIdle, () -> new BlockModelHorizontalRotation<>(furnaceSteelIdle)
			.setTex(0, "ironfurnaces:block/steelfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/steelfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/steelfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/steelfurnaceidlefront", Side.NORTH));

		ModelHelper.setBlockModel(furnaceSteelActive, () -> new BlockModelHorizontalRotation<>(furnaceSteelActive)
			.setTex(0, "ironfurnaces:block/steelfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/steelfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/steelfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/steelfurnaceactivefront", Side.NORTH));
	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {

	}

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {

	}
}
