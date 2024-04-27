package fl205.ironfurnaces;

import fl205.ironfurnaces.blocks.DiamondFurnace;
import fl205.ironfurnaces.blocks.GoldFurnace;
import fl205.ironfurnaces.blocks.IronFurnace;
import fl205.ironfurnaces.blocks.SteelFurnace;
import fl205.ironfurnaces.tileEntities.TileEntityDiamondFurnace;
import fl205.ironfurnaces.tileEntities.TileEntityGoldFurnace;
import fl205.ironfurnaces.tileEntities.TileEntityIronFurnace;
import fl205.ironfurnaces.tileEntities.TileEntitySteelFurnace;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Item;
import net.minecraft.core.sound.BlockSounds;
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

		config = new TomlConfigHandler(null, MOD_ID, toml);
	}


	// Blocks

	static BlockBuilder furnace = new BlockBuilder(MOD_ID)
		.setBlockSound(BlockSounds.METAL)
		.setHardness(5.0F)
		.setResistance(10.0F)
		.setImmovable()
		.setTags(BlockTags.MINEABLE_BY_PICKAXE);

	public static final Block furnaceIronIdle = furnace
		.setSideTextures("ironfurnaceside.png")
		.setNorthTexture("ironfurnaceidlefront.png")
		.setBottomTexture("ironfurnacebottom.png")
		.setTopTexture("ironfurnacetop.png")
		.build(new IronFurnace("furnace.iron.idle", config.getInt("IDs.ironFurnaceIdleID"), Material.metal, false));

	public static final Block furnaceIronActive = furnace
		.setSideTextures("ironfurnaceside.png")
		.setNorthTexture("ironfurnaceactivefront.png")
		.setBottomTexture("ironfurnacebottom.png")
		.setTopTexture("ironfurnacetop.png")
		.setLuminance(13)
		.setTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_PICKAXE)
		.build(new IronFurnace("furnace.iron.active", furnaceIronIdle.id + 1, Material.metal, true));

	public static final Block furnaceGoldIdle = furnace
		.setSideTextures("goldfurnaceside.png")
		.setNorthTexture("goldfurnaceidlefront.png")
		.setBottomTexture("goldfurnacebottom.png")
		.setTopTexture("goldfurnacetop.png")
		.build(new GoldFurnace("furnace.gold.idle", config.getInt("IDs.goldFurnaceIdleID"), Material.metal, false));

	public static final Block furnaceGoldActive = furnace
		.setSideTextures("goldfurnaceside.png")
		.setNorthTexture("goldfurnaceactivefront.png")
		.setBottomTexture("goldfurnacebottom.png")
		.setTopTexture("goldfurnacetop.png")
		.setLuminance(13)
		.setTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_PICKAXE)
		.build(new GoldFurnace("furnace.gold.active", furnaceGoldIdle.id + 1, Material.metal, true));

	public static final Block furnaceDiamondIdle = furnace
		.setSideTextures("diamondfurnaceside.png")
		.setNorthTexture("diamondfurnaceidlefront.png")
		.setBottomTexture("diamondfurnacebottom.png")
		.setTopTexture("diamondfurnacetop.png")
		.build(new DiamondFurnace("furnace.diamond.idle", config.getInt("IDs.diamondFurnaceIdleID"), Material.metal, false));

	public static final Block furnaceDiamondActive = furnace
		.setSideTextures("diamondfurnaceside.png")
		.setNorthTexture("diamondfurnaceactivefront.png")
		.setBottomTexture("diamondfurnacebottom.png")
		.setTopTexture("diamondfurnacetop.png")
		.setLuminance(13)
		.setTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_PICKAXE)
		.build(new DiamondFurnace("furnace.diamond.active", furnaceDiamondIdle.id + 1, Material.metal, true));

	public static final Block furnaceSteelIdle = furnace
		.setResistance(2000.0F)
		.setSideTextures("steelfurnaceside.png")
		.setNorthTexture("steelfurnaceidlefront.png")
		.setBottomTexture("steelfurnacebottom.png")
		.setTopTexture("steelfurnacetop.png")
		.build(new SteelFurnace("furnace.steel.idle", config.getInt("IDs.steelFurnaceIdleID"), Material.metal, false));

	public static final Block furnaceSteelActive = furnace
		.setResistance(2000.0F)
		.setSideTextures("steelfurnaceside.png")
		.setNorthTexture("steelfurnaceactivefront.png")
		.setBottomTexture("steelfurnacebottom.png")
		.setTopTexture("steelfurnacetop.png")
		.setLuminance(13)
		.setTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_PICKAXE)
		.build(new SteelFurnace("furnace.steel.active", furnaceSteelIdle.id + 1, Material.metal, true));


	@Override
    public void onInitialize() {
		LOGGER.info("IronFurnaces mod initialized.");
	}

    @Override
	public void beforeGameStart() {
		// Tile Entities
		EntityHelper.Core.createTileEntity(TileEntityIronFurnace.class, "Iron Furnace");
		EntityHelper.Core.createTileEntity(TileEntityGoldFurnace.class, "Gold Furnace");
		EntityHelper.Core.createTileEntity(TileEntityDiamondFurnace.class, "Diamond Furnace");
		EntityHelper.Core.createTileEntity(TileEntitySteelFurnace.class, "Steel Furnace");
	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {
		// Furnace Template
		RecipeBuilderShaped furnace = new RecipeBuilderShaped(MOD_ID, "AAA", "AFA", "AAA");
		// Iron Furnace
		furnace.addInput('A', Item.ingotIron).addInput('F', Block.furnaceStoneIdle).create("furnace_iron", furnaceIronIdle.getDefaultStack());
		// Gold Furnace
		furnace.addInput('A', Item.ingotGold).addInput('F', furnaceIronIdle).create("furnace_gold", furnaceGoldIdle.getDefaultStack());
		// Diamond Furnace
		furnace.addInput('A', Item.diamond).addInput('F', furnaceGoldIdle).create("furnace_diamond", furnaceDiamondIdle.getDefaultStack());
		// Steel Furnace
		furnace.addInput('A', Item.ingotSteel).addInput('F', furnaceGoldIdle).create("furnace_steel", furnaceSteelIdle.getDefaultStack());

	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
	}
}
