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
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;


public class IronFurnaces implements ModInitializer, GameStartEntrypoint {
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
		.build(new IronFurnace("furnace.iron.idle", config.getInt("IDs.ironFurnaceIdleID"), Material.metal, false));

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
		.build(new IronFurnace("furnace.iron.active", furnaceIronIdle.id + 1, Material.metal, true));

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
		.build(new GoldFurnace("furnace.gold.idle", config.getInt("IDs.goldFurnaceIdleID"), Material.metal, false));

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
		.build(new GoldFurnace("furnace.gold.active", furnaceGoldIdle.id + 1, Material.metal, true));

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
		.build(new DiamondFurnace("furnace.diamond.idle", config.getInt("IDs.diamondFurnaceIdleID"), Material.metal, false));

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
		.build(new DiamondFurnace("furnace.diamond.active", furnaceDiamondIdle.id + 1, Material.metal, true));

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
		.build(new SteelFurnace("furnace.steel.idle", config.getInt("IDs.steelFurnaceIdleID"), Material.metal, false));

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
		.build(new SteelFurnace("furnace.steel.active", furnaceSteelIdle.id + 1, Material.metal, true));


	@Override
    public void onInitialize() {
		// Tile Entities
		EntityHelper.Core.createTileEntity(TileEntityIronFurnace.class, "Iron Furnace");
		EntityHelper.Core.createTileEntity(TileEntityGoldFurnace.class, "Gold Furnace");
		EntityHelper.Core.createTileEntity(TileEntityDiamondFurnace.class, "Diamond Furnace");
		EntityHelper.Core.createTileEntity(TileEntitySteelFurnace.class, "Steel Furnace");

		LOGGER.info("IronFurnaces mod initialized.");
	}

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}
}
