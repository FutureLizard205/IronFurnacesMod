package fl205.ironfurnaces.blocks;

import fl205.ironfurnaces.tileEntities.TileEntityCustomFurnace;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockTileEntityRotatable;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import java.util.Random;

public abstract class CustomFurnace extends BlockTileEntityRotatable {
	protected final boolean isActive;
	protected Random furnaceRand = new Random();
	protected static boolean keepFurnaceInventory = false;
	protected final int activeId;
	protected final int idleID;
	public CustomFurnace(String key, int id, Material material, boolean flag, int activeID, int idleID) {
		super(key, id, material);
		this.isActive = flag;
		this.activeId = activeID;
		this.idleID = idleID;
	}
	public void onBlockAdded(World world, int i, int j, int k) {
		super.onBlockAdded(world, i, j, k);
		this.setDefaultDirection(world, i, j, k);
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case PICK_BLOCK:
			case PROPER_TOOL:
			case SILK_TOUCH:
				return new ItemStack[]{new ItemStack(Block.blocksList[idleID])};
			default:
				return null;
		}
	}

	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		if (this.isActive) {
			int l = world.getBlockMetadata(x, y, z);
			float f = (float)x + 0.5F;
			float f1 = (float)y + 0.0F + rand.nextFloat() * 6.0F / 16.0F;
			float f2 = (float)z + 0.5F;
			float f3 = 0.52F;
			float f4 = rand.nextFloat() * 0.6F - 0.3F;
			if (l == 4) {
				world.spawnParticle("smoke", f - f3, f1, f2 + f4, 0.0, 0.0, 0.0);
				world.spawnParticle("flame", f - f3, f1, f2 + f4, 0.0, 0.0, 0.0);
			} else if (l == 5) {
				world.spawnParticle("smoke", f + f3, f1, f2 + f4, 0.0, 0.0, 0.0);
				world.spawnParticle("flame", f + f3, f1, f2 + f4, 0.0, 0.0, 0.0);
			} else if (l == 2) {
				world.spawnParticle("smoke", f + f4, f1, f2 - f3, 0.0, 0.0, 0.0);
				world.spawnParticle("flame", f + f4, f1, f2 - f3, 0.0, 0.0, 0.0);
			} else if (l == 3) {
				world.spawnParticle("smoke", f + f4, f1, f2 + f3, 0.0, 0.0, 0.0);
				world.spawnParticle("flame", f + f4, f1, f2 + f3, 0.0, 0.0, 0.0);
			}

		}
	}

	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		if (!world.isClientSide) {
			TileEntityCustomFurnace tileEntityCustomFurnace = (TileEntityCustomFurnace) world.getBlockTileEntity(x, y, z);
			player.displayGUIFurnace(tileEntityCustomFurnace);
		}
		return true;
	}

	public void updateFurnaceBlockState(boolean lit, World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);
		if (tileentity == null) {
			String msg = "CustomFurnace is missing Tile Entity at x: " + x + " y: " + y + " z: " + z + ", block will be removed!";
			world.setBlockWithNotify(x, y, z, 0);
			System.out.println(msg);
		} else {
			keepFurnaceInventory = true;
			if (lit) {
				world.setBlockWithNotify(x, y, z, activeId);
			} else {
				world.setBlockWithNotify(x, y, z, idleID);
			}

			keepFurnaceInventory = false;
			world.setBlockMetadataWithNotify(x, y, z, meta);
			tileentity.validate();
			world.setBlockTileEntity(x, y, z, tileentity);
		}
	}

	public void onBlockRemoval(World world, int x, int y, int z) {
		if (!keepFurnaceInventory) {
			TileEntityCustomFurnace tileEntityCustomFurnace = (TileEntityCustomFurnace) world.getBlockTileEntity(x, y, z);

			for (int l = 0; l < tileEntityCustomFurnace.getSizeInventory(); ++l) {
				ItemStack itemstack = tileEntityCustomFurnace.getStackInSlot(l);
				if (itemstack != null) {
					float f = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
					float f1 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
					float f2 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

					while (itemstack.stackSize > 0) {
						int i1 = this.furnaceRand.nextInt(21) + 10;
						if (i1 > itemstack.stackSize) {
							i1 = itemstack.stackSize;
						}

						itemstack.stackSize -= i1;
						EntityItem entityitem = new EntityItem(world, (float) x + f, (float) y + f1, (float) z + f2, new ItemStack(itemstack.itemID, i1, itemstack.getMetadata()));
						float f3 = 0.05F;
						entityitem.xd = (float) this.furnaceRand.nextGaussian() * f3;
						entityitem.yd = (float) this.furnaceRand.nextGaussian() * f3 + 0.2F;
						entityitem.zd = (float) this.furnaceRand.nextGaussian() * f3;
						world.entityJoinedWorld(entityitem);
					}
				}
			}
		}

		super.onBlockRemoval(world, x, y, z);
	}
}
