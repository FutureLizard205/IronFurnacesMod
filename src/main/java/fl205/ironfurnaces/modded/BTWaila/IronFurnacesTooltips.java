package fl205.ironfurnaces.modded.BTWaila;

import fl205.ironfurnaces.IronFurnaces;
import fl205.ironfurnaces.tileEntities.TileEntityDiamondFurnace;
import fl205.ironfurnaces.tileEntities.TileEntityGoldFurnace;
import fl205.ironfurnaces.tileEntities.TileEntityIronFurnace;
import fl205.ironfurnaces.tileEntities.TileEntitySteelFurnace;
import net.minecraft.core.block.entity.TileEntityFurnace;
import toufoumaster.btwaila.TooltipGroup;
import toufoumaster.btwaila.TooltipRegistry;
import toufoumaster.btwaila.tooltips.block.FurnaceTooltip;

public class IronFurnacesTooltips extends FurnaceTooltip {
	public void addTooltip() {
		IronFurnaces.LOGGER.info("Adding BTWaila tooltips for: " + this.getClass().getSimpleName());
		TooltipGroup tooltipGroup = new TooltipGroup(IronFurnaces.MOD_ID, TileEntityFurnace.class, this);
		tooltipGroup.addTooltip(TileEntityIronFurnace.class);
		tooltipGroup.addTooltip(TileEntityGoldFurnace.class);
		tooltipGroup.addTooltip(TileEntityDiamondFurnace.class);
		tooltipGroup.addTooltip(TileEntitySteelFurnace.class);
		TooltipRegistry.tooltipMap.add(tooltipGroup);
	}
}
