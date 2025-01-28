package fl205.ironfurnaces.tileEntities;

import fl205.ironfurnaces.blocks.BlockLogicCustomFurnace;
import java.util.List;
import java.util.Random;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntityFurnace;
import net.minecraft.core.crafting.LookupFuelFurnace;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryFurnace;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.item.Items;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public abstract class TileEntityCustomFurnace extends TileEntityFurnace {
	private final Random random = new Random();
	protected final int speedModifier;
	protected final int fuelYieldModifier;
	protected final int idleID;
	public TileEntityCustomFurnace(int speedModifier, int fuelYieldModifier, int idleID){
		this.speedModifier = speedModifier;
		this.fuelYieldModifier = fuelYieldModifier;
		this.idleID = idleID;
		maxCookTime = 20000 / speedModifier;
	}

	public void tick() {
		boolean isBurnTimeHigherThan0 = this.currentBurnTime > 0;
		boolean furnaceUpdated = false;
		if (this.currentBurnTime > 0) {
			--this.currentBurnTime;
		}

		if (this.worldObj == null || !this.worldObj.isClientSide) {
			if ((this.worldObj == null || this.worldObj.getBlockId(this.x, this.y, this.z) == idleID) && this.currentBurnTime == 0 && this.furnaceItemStacks[0] == null && this.furnaceItemStacks[1] != null && this.furnaceItemStacks[1].itemID == Blocks.COBBLE_NETHERRACK.id()) {
				--this.furnaceItemStacks[1].stackSize;
				if (this.furnaceItemStacks[1].stackSize <= 0) {
					this.furnaceItemStacks[1] = null;
				}

				this.updateFurnace(true);
				furnaceUpdated = true;
			}

			if (this.currentBurnTime == 0 && this.canSmelt()) {
				this.maxBurnTime = this.currentBurnTime = this.getBurnTimeFromItem(this.furnaceItemStacks[1]);
				if (this.currentBurnTime > 0) {
					furnaceUpdated = true;
					if (this.furnaceItemStacks[1] != null) {
						if (this.furnaceItemStacks[1].getItem() == Items.BUCKET_LAVA) {
							this.furnaceItemStacks[1] = new ItemStack(Items.BUCKET);
						} else {
							--this.furnaceItemStacks[1].stackSize;
							if (this.furnaceItemStacks[1].stackSize <= 0) {
								this.furnaceItemStacks[1] = null;
							}
						}
					}
				}
			}

			if (this.isBurning() && this.canSmelt()) {
				++this.currentCookTime;
				if (this.currentCookTime == this.maxCookTime) {
					this.currentCookTime = 0;
					this.smeltItem();
					furnaceUpdated = true;
				}
			} else {
				this.currentCookTime = 0;
			}

			if (isBurnTimeHigherThan0 != this.currentBurnTime > 0) {
				furnaceUpdated = true;
				this.updateFurnace(false);
			}
		}

		if (furnaceUpdated) {
			this.setChanged();
		}

	}

	private boolean canSmelt() {
		if (this.furnaceItemStacks[0] == null) {
			return false;
		} else {
			List<RecipeEntryFurnace> list = Registries.RECIPES.getAllFurnaceRecipes();
			ItemStack itemstack = null;
			for (RecipeEntryFurnace recipeEntryBase : list) {
				if (recipeEntryBase != null && recipeEntryBase.matches(this.furnaceItemStacks[0])) {
					itemstack = recipeEntryBase.getOutput();
				}
			}

			if (itemstack == null) {
				return false;
			} else if (this.furnaceItemStacks[2] == null) {
				return true;
			} else if (!this.furnaceItemStacks[2].isItemEqual(itemstack)) {
				return false;
			} else if (this.furnaceItemStacks[2].stackSize < this.getMaxStackSize() && this.furnaceItemStacks[2].stackSize < this.furnaceItemStacks[2].getMaxStackSize()) {
				return true;
			} else {
				return this.furnaceItemStacks[2].stackSize < itemstack.getMaxStackSize();
			}
		}
	}

	protected void updateFurnace(boolean forceLit) {
		if (this.worldObj != null) {
			BlockLogicCustomFurnace.updateFurnaceBlockState(forceLit | this.currentBurnTime > 0, this.worldObj, this.x, this.y, this.z, idleID);
		} else if (this.carriedBlock != null) {
			this.carriedBlock.blockId = forceLit | this.currentBurnTime > 0 ? idleID + 1 : idleID;
		}
	}

	private int getBurnTimeFromItem(ItemStack itemStack) {
		return itemStack == null ? 0 : ((fuelYieldModifier * (LookupFuelFurnace.instance.getFuelYield(itemStack.getItem().id)))/speedModifier);
	}

	public void dropContents(World world, int x, int y, int z) {
		if (!BlockLogicCustomFurnace.keepFurnaceInventory) {
			for(int l = 0; l < this.getContainerSize(); ++l) {
				ItemStack itemstack = this.getItem(l);
				if (itemstack != null) {
					float f = this.random.nextFloat() * 0.8F + 0.1F;
					float f1 = this.random.nextFloat() * 0.8F + 0.1F;
					float f2 = this.random.nextFloat() * 0.8F + 0.1F;

					while(itemstack.stackSize > 0) {
						int i1 = this.random.nextInt(21) + 10;
						if (i1 > itemstack.stackSize) {
							i1 = itemstack.stackSize;
						}

						itemstack.stackSize -= i1;
						EntityItem entityItem = new EntityItem(world, (float)x + f, (float)y + f1, (float)z + f2, new ItemStack(itemstack.itemID, i1, itemstack.getMetadata()));
						float f3 = 0.05F;
						entityItem.xd = (float)this.random.nextGaussian() * f3;
						entityItem.yd = (float)this.random.nextGaussian() * f3 + 0.2F;
						entityItem.zd = (float)this.random.nextGaussian() * f3;
						world.entityJoinedWorld(entityItem);
					}
				}
			}
		}

	}
}
