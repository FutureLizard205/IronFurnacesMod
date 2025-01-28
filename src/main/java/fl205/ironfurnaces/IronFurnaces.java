package fl205.ironfurnaces;

import fl205.ironfurnaces.blocks.BlockLogicDiamondFurnace;
import fl205.ironfurnaces.blocks.BlockLogicGoldFurnace;
import fl205.ironfurnaces.blocks.BlockLogicSteelFurnace;
import fl205.ironfurnaces.tileEntities.TileEntityDiamondFurnace;
import fl205.ironfurnaces.tileEntities.TileEntityGoldFurnace;
import fl205.ironfurnaces.tileEntities.TileEntityIronFurnace;
import fl205.ironfurnaces.tileEntities.TileEntitySteelFurnace;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.block.model.BlockModelHorizontalRotation;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Items;
import net.minecraft.core.sound.BlockSounds;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.Side;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import fl205.ironfurnaces.blocks.BlockLogicIronFurnace;


public class IronFurnaces implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
    public static final String MOD_ID = "ironfurnaces";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Config TOML file manager

	public static final TomlConfigHandler config;
	static {
		// Config
		Toml toml = new Toml("Iron Furnaces Mod Config\nMore info at https://github.com/FutureLizard205/bta-IronFurnacesMod");

		toml.addCategory("IDs")
			.addEntry("ironFurnaceIdleID", 664)
			.addEntry("goldFurnaceIdleID", 666)
			.addEntry("diamondFurnaceIdleID", 668)
			.addEntry("steelFurnaceIdleID", 674);

		toml.addCategory( "Speed")
			.addEntry("ironFurnace", 125)
			.addEntry("goldFurnace", 160)
			.addEntry("diamondFurnace", 200)
			.addEntry("steelFurnace", 100);

		toml.addCategory("Fuel Yield")
			.addEntry("ironFurnace", 125)
			.addEntry("goldFurnace", 80)
			.addEntry("diamondFurnace", 150)
			.addEntry("steelFurnace", 250);

		config = new TomlConfigHandler(MOD_ID, toml);
	}


	// Blocks

	static BlockBuilder idleFurnaceBuilder = new BlockBuilder(MOD_ID)
		.setBlockSound(BlockSounds.METAL)
		.setHardness(5.0F)
		.setResistance(10.0F)
		.setImmovable()
		.setTags(BlockTags.MINEABLE_BY_PICKAXE);

	static BlockBuilder activeFurnaceBuilder = new BlockBuilder(MOD_ID)
		.setBlockSound(BlockSounds.METAL)
		.setHardness(5.0F)
		.setResistance(10.0F)
		.setLuminance(13)
		.setImmovable()
		.setTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_PICKAXE);

	@SuppressWarnings("unused")
	public static final Block<?> furnaceIronIdle = idleFurnaceBuilder
		.setBlockModel(b -> new BlockModelHorizontalRotation<>(b)
			.setTex(0, "ironfurnaces:block/ironfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/ironfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/ironfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/ironfurnaceidlefront", Side.NORTH))
		.build("furnace.iron.idle", "furnace_iron_idle", config.getInt("IDs.ironFurnaceIdleID"), b -> new BlockLogicIronFurnace(b, false));

	@SuppressWarnings("unused")
	public static final Block<?> furnaceIronActive = activeFurnaceBuilder
		.setBlockModel(b -> new BlockModelHorizontalRotation<>(b)
			.setTex(0, "ironfurnaces:block/ironfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/ironfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/ironfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/ironfurnaceactivefront", Side.NORTH))
		.build("furnace.iron.active", "furnace_iron_active", furnaceIronIdle.id() + 1, b -> new BlockLogicIronFurnace(b, true));

	@SuppressWarnings("unused")
	public static final Block<?> furnaceGoldIdle = idleFurnaceBuilder
		.setBlockModel(b -> new BlockModelHorizontalRotation<>(b)
			.setTex(0, "ironfurnaces:block/goldfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/goldfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/goldfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/goldfurnaceidlefront", Side.NORTH))
		.build("furnace.gold.idle", "furnace_gold_idle", config.getInt("IDs.goldFurnaceIdleID"), b -> new BlockLogicGoldFurnace(b, false));

	@SuppressWarnings("unused")
	public static final Block<?> furnaceGoldActive = activeFurnaceBuilder
		.setBlockModel(b -> new BlockModelHorizontalRotation<>(b)
			.setTex(0, "ironfurnaces:block/goldfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/goldfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/goldfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/goldfurnaceactivefront", Side.NORTH))
		.build("furnace.gold.active", "furnace_gold_active", furnaceGoldIdle.id() + 1, b -> new BlockLogicGoldFurnace(b, true));

	@SuppressWarnings("unused")
	public static final Block<?> furnaceDiamondIdle = idleFurnaceBuilder
		.setBlockModel(b -> new BlockModelHorizontalRotation<>(b)
			.setTex(0, "ironfurnaces:block/diamondfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/diamondfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/diamondfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/diamondfurnaceidlefront", Side.NORTH))
		.build("furnace.diamond.idle", "furnace_diamond_idle", config.getInt("IDs.diamondFurnaceIdleID"), b -> new BlockLogicDiamondFurnace(b, false));

	@SuppressWarnings("unused")
	public static final Block<?> furnaceDiamondActive = activeFurnaceBuilder
		.setBlockModel(b -> new BlockModelHorizontalRotation<>(b)
			.setTex(0, "ironfurnaces:block/diamondfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/diamondfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/diamondfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/diamondfurnaceactivefront", Side.NORTH))
		.build("furnace.diamond.active", "furnace_diamond_active", furnaceDiamondIdle.id() + 1, b -> new BlockLogicDiamondFurnace(b, true));

	@SuppressWarnings("unused")
	public static final Block<?> furnaceSteelIdle = idleFurnaceBuilder
		.setResistance(2000.0F)
		.setBlockModel(b -> new BlockModelHorizontalRotation<>(b)
			.setTex(0, "ironfurnaces:block/steelfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/steelfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/steelfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/steelfurnaceidlefront", Side.NORTH))
		.build("furnace.steel.idle", "furnace_steel_idle", config.getInt("IDs.steelFurnaceIdleID"), b -> new BlockLogicSteelFurnace(b, false));

	@SuppressWarnings("unused")
	public static final Block<?> furnaceSteelActive = activeFurnaceBuilder
		.setResistance(2000.0F)
		.setBlockModel(b -> new BlockModelHorizontalRotation<>(b)
			.setTex(0, "ironfurnaces:block/steelfurnacetop", Side.TOP)
			.setTex(0, "ironfurnaces:block/steelfurnacebottom", Side.BOTTOM)
			.setTex(0, "ironfurnaces:block/steelfurnaceside", Side.WEST, Side.EAST, Side.SOUTH)
			.setTex(0, "ironfurnaces:block/steelfurnaceactivefront", Side.NORTH))
		.build("furnace.steel.active", "furnace_steel_active", furnaceSteelIdle.id() + 1, b -> new BlockLogicSteelFurnace(b, true));

	@Override
    public void onInitialize() {
		LOGGER.info("IronFurnaces mod initialized.");
	}

    @Override
	public void beforeGameStart() {
		// Tile Entities
		EntityHelper.createTileEntity(TileEntityIronFurnace.class,  new NamespaceID(MOD_ID, "furnace_iron"));
		EntityHelper.createTileEntity(TileEntityGoldFurnace.class, new NamespaceID(MOD_ID, "furnace_gold"));
		EntityHelper.createTileEntity(TileEntityDiamondFurnace.class, new NamespaceID(MOD_ID, "furnace_diamond"));
		EntityHelper.createTileEntity(TileEntitySteelFurnace.class, new NamespaceID(MOD_ID, "furnace_steel"));
	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {
		// Furnace Template
		RecipeBuilderShaped furnace = new RecipeBuilderShaped(MOD_ID, "AAA", "AFA", "AAA");
		// Iron Furnace
		furnace.addInput('A', Items.INGOT_IRON).addInput('F', Blocks.FURNACE_STONE_IDLE).create("furnace_iron", furnaceIronIdle.getDefaultStack());
		// Gold Furnace
		furnace.addInput('A', Items.INGOT_GOLD).addInput('F', furnaceIronIdle).create("furnace_gold", furnaceGoldIdle.getDefaultStack());
		// Diamond Furnace
		furnace.addInput('A', Items.DIAMOND).addInput('F', furnaceGoldIdle).create("furnace_diamond", furnaceDiamondIdle.getDefaultStack());
		// Steel Furnace
		furnace.addInput('A', Items.INGOT_STEEL).addInput('F', furnaceGoldIdle).create("furnace_steel", furnaceSteelIdle.getDefaultStack());

	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
	}
}
