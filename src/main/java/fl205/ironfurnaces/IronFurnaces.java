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
import net.minecraft.core.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.RecipeHelper;
import turniplabs.halplibe.util.ConfigHandler;

import java.util.Properties;


public class IronFurnaces implements ModInitializer {
    public static final String MOD_ID = "ironfurnaces";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Config file manager
	public static final ConfigHandler config;
	static {
		// Config
		Properties prop = new Properties();
		prop.setProperty("ids.ironFurnaceIdleID", "664");
		prop.setProperty("ids.ironFurnaceActiveID", "665");
		prop.setProperty("speed.ironFurnace", "125");
		prop.setProperty("fuelYield.ironFurnace", "125");
		prop.setProperty("ids.goldFurnaceIdleID", "666");
		prop.setProperty("ids.goldFurnaceActiveID", "667");
		prop.setProperty("speed.goldFurnace", "160");
		prop.setProperty("fuelYield.goldFurnace", "80");
		prop.setProperty("ids.diamondFurnaceIdleID", "668");
		prop.setProperty("ids.diamondFurnaceActiveID", "669");
		prop.setProperty("speed.diamondFurnace", "200");
		prop.setProperty("fuelYield.diamondFurnace", "150");
		prop.setProperty("ids.steelFurnaceIdleID", "674");
		prop.setProperty("ids.steelFurnaceActiveID", "675");
		prop.setProperty("speed.steelFurnace", "100");
		prop.setProperty("fuelYield.steelFurnace", "250");

		config = new ConfigHandler(MOD_ID, prop);
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
		.build(new IronFurnace("furnace.iron.active", config.getInt("ids.ironFurnaceActiveID"), Material.metal, true));

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
		.build(new GoldFurnace("furnace.gold.active", config.getInt("ids.goldFurnaceActiveID"), Material.metal, true));

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
		.build(new DiamondFurnace("furnace.diamond.active", config.getInt("ids.diamondFurnaceActiveID"), Material.metal, true));

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
		.build(new SteelFurnace("furnace.steel.active", config.getInt("ids.steelFurnaceActiveID"), Material.metal, true));

	@Override
    public void onInitialize() {
		EntityHelper.createTileEntity(TileEntityIronFurnace.class, "Iron Furnace");
		EntityHelper.createTileEntity(TileEntityGoldFurnace.class, "Gold Furnace");
		EntityHelper.createTileEntity(TileEntityDiamondFurnace.class, "Diamond Furnace");
		EntityHelper.createTileEntity(TileEntitySteelFurnace.class, "Steel Furnace");

		//Recipes
		RecipeHelper.Crafting.createRecipe(furnaceIronIdle, 1, new Object[]{
			"AAA",
			"ABA",
			"AAA",
			'A', Item.ingotIron,
			'B', Block.furnaceStoneIdle
		});
		RecipeHelper.Crafting.createRecipe(furnaceGoldIdle, 1, new Object[]{
			"AAA",
			"ABA",
			"AAA",
			'A', Item.ingotGold,
			'B', furnaceIronIdle
		});
		RecipeHelper.Crafting.createRecipe(furnaceDiamondIdle, 1, new Object[]{
			"AAA",
			"ABA",
			"AAA",
			'A', Item.diamond,
			'B', furnaceGoldIdle
		});
		RecipeHelper.Crafting.createRecipe(furnaceSteelIdle, 1, new Object[]{
			"AAA",
			"ABA",
			"AAA",
			'A', Item.ingotSteel,
			'B', furnaceIronIdle
		});

		if (FabricLoader.getInstance().isModLoaded("btwaila")) {
			IronFurnacesTooltips ironFurnacesTooltips = new IronFurnacesTooltips();
			ironFurnacesTooltips.addTooltip();
		}

		LOGGER.info("IronFurnaces mod initialized.");
	}
}
