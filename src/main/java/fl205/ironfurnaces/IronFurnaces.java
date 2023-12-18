package fl205.ironfurnaces;

import fl205.ironfurnaces.blocks.DiamondFurnace;
import fl205.ironfurnaces.blocks.GoldFurnace;
import fl205.ironfurnaces.blocks.IronFurnace;
import fl205.ironfurnaces.blocks.SteelFurnace;
import fl205.ironfurnaces.modded.BTWaila.IronFurnacesTooltips;
import fl205.ironfurnaces.tileEntities.TileEntityDiamondFurnace;
import fl205.ironfurnaces.tileEntities.TileEntityGoldFurnace;
import fl205.ironfurnaces.tileEntities.TileEntityIronFurnace;
import fl205.ironfurnaces.tileEntities.TileEntitySteelFurnace;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
// import net.minecraft.core.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;
// import turniplabs.halplibe.helper.RecipeHelper;
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

		toml.addCategory("recipeEnabled")
			.addEntry("ironFurnace", true)
			.addEntry("goldFurnace", true)
			.addEntry("diamondFurnace", true)
			.addEntry("steelFurnace", true);

		toml.addCategory("ids")
			.addEntry("ironFurnaceIdleID", 664)
			.addEntry("goldFurnaceIdleID", 666)
			.addEntry("diamondFurnaceIdleID", 668)
			.addEntry("steelFurnaceIdleID", 674);

		toml.addCategory( "speed")
			.addEntry("ironFurnace", 125)
			.addEntry("goldFurnace", 160)
			.addEntry("diamondFurnace", 200)
			.addEntry("steelFurnace", 100);

		toml.addCategory("fuelYield")
			.addEntry("ironFurnace", 125)
			.addEntry("goldFurnace", 80)
			.addEntry("diamondFurnace", 150)
			.addEntry("steelFurnace", 250);

		config = new TomlConfigHandler(null, MOD_ID, toml);
	}


	// Blocks

	public static final Block furnaceIronIdle = new BlockBuilder(MOD_ID)
		.setBlockSound(BlockSounds.METAL)
		.setHardness(5.0F)
		.setResistance(10.0F)
		.setSideTextures("ironfurnaceside.png")
		.setNorthTexture("ironfurnaceidlefront.png")
		.setBottomTexture("ironfurnacebottom.png")
		.setTopTexture("ironfurnacetop.png")
		.setImmovable()
		.setTags(BlockTags.MINEABLE_BY_PICKAXE)
		.build(new IronFurnace("furnace.iron.idle", config.getInt("ids.ironFurnaceIdleID"), Material.metal, false));

	public static final Block furnaceIronActive = new BlockBuilder(MOD_ID)
		.setBlockSound(BlockSounds.METAL)
		.setHardness(5.0F)
		.setResistance(10.0F)
		.setSideTextures("ironfurnaceside.png")
		.setNorthTexture("ironfurnaceactivefront.png")
		.setBottomTexture("ironfurnacebottom.png")
		.setTopTexture("ironfurnacetop.png")
		.setLuminance(13)
		.setImmovable()
		.setTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_PICKAXE)
		.build(new IronFurnace("furnace.iron.active", config.getInt("ids.ironFurnaceIdleID") + 1, Material.metal, true));

	public static final Block furnaceGoldIdle = new BlockBuilder(MOD_ID)
		.setBlockSound(BlockSounds.METAL)
		.setHardness(5.0F)
		.setResistance(10.0F)
		.setSideTextures("goldfurnaceside.png")
		.setNorthTexture("goldfurnaceidlefront.png")
		.setBottomTexture("goldfurnacebottom.png")
		.setTopTexture("goldfurnacetop.png")
		.setImmovable()
		.setTags(BlockTags.MINEABLE_BY_PICKAXE)
		.build(new GoldFurnace("furnace.gold.idle", config.getInt("ids.goldFurnaceIdleID"), Material.metal, false));

	public static final Block furnaceGoldActive = new BlockBuilder(MOD_ID)
		.setBlockSound(BlockSounds.METAL)
		.setHardness(5.0F)
		.setResistance(10.0F)
		.setSideTextures("goldfurnaceside.png")
		.setNorthTexture("goldfurnaceactivefront.png")
		.setBottomTexture("goldfurnacebottom.png")
		.setTopTexture("goldfurnacetop.png")
		.setLuminance(13)
		.setImmovable()
		.setTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_PICKAXE)
		.build(new GoldFurnace("furnace.gold.active", config.getInt("ids.goldFurnaceIdleID") + 1, Material.metal, true));

	public static final Block furnaceDiamondIdle = new BlockBuilder(MOD_ID)
		.setBlockSound(BlockSounds.METAL)
		.setHardness(5.0F)
		.setResistance(10.0F)
		.setSideTextures("diamondfurnaceside.png")
		.setNorthTexture("diamondfurnaceidlefront.png")
		.setBottomTexture("diamondfurnacebottom.png")
		.setTopTexture("diamondfurnacetop.png")
		.setImmovable()
		.setTags(BlockTags.MINEABLE_BY_PICKAXE)
		.build(new DiamondFurnace("furnace.diamond.idle", config.getInt("ids.diamondFurnaceIdleID"), Material.metal, false));

	public static final Block furnaceDiamondActive = new BlockBuilder(MOD_ID)
		.setBlockSound(BlockSounds.METAL)
		.setHardness(5.0F)
		.setResistance(10.0F)
		.setSideTextures("diamondfurnaceside.png")
		.setNorthTexture("diamondfurnaceactivefront.png")
		.setBottomTexture("diamondfurnacebottom.png")
		.setTopTexture("diamondfurnacetop.png")
		.setLuminance(13)
		.setImmovable()
		.setTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_PICKAXE)
		.build(new DiamondFurnace("furnace.diamond.active", config.getInt("ids.diamondFurnaceIdleID") + 1, Material.metal, true));

	public static final Block furnaceSteelIdle = new BlockBuilder(MOD_ID)
		.setBlockSound(BlockSounds.METAL)
		.setHardness(5.0F)
		.setResistance(2000.0F)
		.setSideTextures("steelfurnaceside.png")
		.setNorthTexture("steelfurnaceidlefront.png")
		.setBottomTexture("steelfurnacebottom.png")
		.setTopTexture("steelfurnacetop.png")
		.setImmovable()
		.setTags(BlockTags.MINEABLE_BY_PICKAXE)
		.build(new SteelFurnace("furnace.steel.idle", config.getInt("ids.steelFurnaceIdleID"), Material.metal, false));

	public static final Block furnaceSteelActive = new BlockBuilder(MOD_ID)
		.setBlockSound(BlockSounds.METAL)
		.setHardness(5.0F)
		.setResistance(2000.0F)
		.setSideTextures("steelfurnaceside.png")
		.setNorthTexture("steelfurnaceactivefront.png")
		.setBottomTexture("steelfurnacebottom.png")
		.setTopTexture("steelfurnacetop.png")
		.setLuminance(13)
		.setImmovable()
		.setTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_PICKAXE)
		.build(new SteelFurnace("furnace.steel.active", config.getInt("ids.steelFurnaceIdleID") + 1, Material.metal, true));


	@Override
    public void onInitialize() {
		// Tile Entities
		EntityHelper.createTileEntity(TileEntityIronFurnace.class, "Iron Furnace");
		EntityHelper.createTileEntity(TileEntityGoldFurnace.class, "Gold Furnace");
		EntityHelper.createTileEntity(TileEntityDiamondFurnace.class, "Diamond Furnace");
		EntityHelper.createTileEntity(TileEntitySteelFurnace.class, "Steel Furnace");

		/*Recipes
		String[] names = {"iron", "gold", "diamond", "steel"};
		Block[] furnaces = {furnaceIronIdle, furnaceGoldIdle, furnaceDiamondIdle, furnaceSteelIdle};
		Item[] recipeMaterials = {Item.ingotIron, Item.ingotGold, Item.diamond, Item.ingotSteel};
		Block[] recipeFurnaces = {Block.furnaceStoneIdle, furnaceIronIdle, furnaceGoldIdle, furnaceGoldIdle};
		for (int i = 0; i < furnaces.length; i++) {
			if (config.getBoolean("recipeEnabled." + names[i] + "Furnace")) {
				RecipeHelper.Crafting.createRecipe(furnaces[i], 1, new Object[]{
					"AAA",
					"ABA",
					"AAA",
					'A', recipeMaterials[i],
					'B', recipeFurnaces[i]
				});
			}
		}
		 */

		// BTWaila Integration
		if (FabricLoader.getInstance().isModLoaded("btwaila")) {
			IronFurnacesTooltips ironFurnacesTooltips = new IronFurnacesTooltips();
			ironFurnacesTooltips.addTooltip();
		}

		LOGGER.info("IronFurnaces mod initialized.");
	}


	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {

	}
}
