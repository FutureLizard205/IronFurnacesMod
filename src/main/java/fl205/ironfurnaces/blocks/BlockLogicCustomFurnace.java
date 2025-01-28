package fl205.ironfurnaces.blocks;

import fl205.ironfurnaces.tileEntities.TileEntityCustomFurnace;
import net.minecraft.core.Global;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicRotatable;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

import static fl205.ironfurnaces.IronFurnaces.*;

public abstract class BlockLogicCustomFurnace extends BlockLogicRotatable {
	protected final boolean isActive;
	public static boolean keepFurnaceInventory = false;
	protected final int activeId;
	protected final int idleID;
	public BlockLogicCustomFurnace(Block<?> block, boolean isActive, int activeID, int idleID) {
		super(block, Material.metal);
		this.isActive = isActive;
		this.activeId = activeID;
		this.idleID = idleID;
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case PICK_BLOCK:
			case EXPLOSION:
			case PROPER_TOOL:
			case SILK_TOUCH:
			case PISTON_CRUSH:
				return new ItemStack[]{new ItemStack(Blocks.getBlock(idleID))};
			default:
				return null;
		}
	}

	public void animationTick(World world, int x, int y, int z, Random rand) {
		if (this.isActive) {
			int l = world.getBlockMetadata(x, y, z);
			double poxX = (double)x + 0.5;
			double posY = (double)y + 0.0 + (double)(rand.nextFloat() * 6.0F / 16.0F);
			double posZ = (double)z + 0.5;
			double f3 = 0.5199999809265137;
			double f4 = (rand.nextFloat() * 0.6F - 0.3F);
			if (l == 4) {
				world.spawnParticle("smoke", poxX - f3, posY, posZ + f4, 0.0, 0.0, 0.0, 0);
				world.spawnParticle("flame", poxX - f3, posY, posZ + f4, 0.0, 0.0, 0.0, 0);
			} else if (l == 5) {
				world.spawnParticle("smoke", poxX + f3, posY, posZ + f4, 0.0, 0.0, 0.0, 0);
				world.spawnParticle("flame", poxX + f3, posY, posZ + f4, 0.0, 0.0, 0.0, 0);
			} else if (l == 2) {
				world.spawnParticle("smoke", poxX + f4, posY, posZ - f3, 0.0, 0.0, 0.0, 0);
				world.spawnParticle("flame", poxX + f4, posY, posZ - f3, 0.0, 0.0, 0.0, 0);
			} else if (l == 3) {
				world.spawnParticle("smoke", poxX + f4, posY, posZ + f3, 0.0, 0.0, 0.0, 0);
				world.spawnParticle("flame", poxX + f4, posY, posZ + f3, 0.0, 0.0, 0.0, 0);
			}

		}
	}

	public boolean onBlockRightClicked(World world, int x, int y, int z, Player player, Side side, double xPlaced, double yPlaced) {
		if (!world.isClientSide) {
			TileEntityCustomFurnace tileEntityCustomFurnace = (TileEntityCustomFurnace) world.getTileEntity(x, y, z);
			player.displayFurnaceScreen(tileEntityCustomFurnace);
		}
		return true;
	}

	public static void updateFurnaceBlockState(boolean lit, @NotNull World world, int x, int y, int z, int idleID) {
		int meta = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if (tileentity == null) {
			String msg = "CustomFurnace is missing Tile Entity at x: " + x + " y: " + y + " z: " + z + ", block will be removed!";
			if (Global.BUILD_CHANNEL.isUnstableBuild()) {
				throw new RuntimeException(msg);
			} else {
				world.setBlockWithNotify(x, y, z, 0);
				LOGGER.warn(msg);
			}
		} else {
			keepFurnaceInventory = true;
			int alreadyLit;
			int currentId = tileentity.getBlockId();
			if (tileentity.getBlockId() == idleID) {
				alreadyLit = 0;
			} else {
				alreadyLit = 1;
			}
			if (lit) {
				world.setBlockWithNotify(x, y, z, currentId+1-alreadyLit);
			} else {
				world.setBlockWithNotify(x, y, z, currentId-alreadyLit);
			}

			keepFurnaceInventory = false;
			world.setBlockMetadataWithNotify(x, y, z, meta);
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
	}
}
