package lach_01298.qmd.particleChamber.tile;

import lach_01298.qmd.particleChamber.ParticleChamber;
import nc.block.property.BlockProperties;
import nc.multiblock.cuboidal.CuboidalPartPositionType;

public class TileParticleChamberCasing extends TileParticleChamberPart
{

	public TileParticleChamberCasing()
	{
		super(CuboidalPartPositionType.EXTERIOR);
	}



	@Override
	public void onMachineAssembled(ParticleChamber controller)
	{
		super.onMachineAssembled(controller);
		if (!getWorld().isRemote && getPartPosition().isFrame())
		{
			if (getWorld().getBlockState(getPos()).withProperty(BlockProperties.FRAME, false) != null)
			{
				getWorld().setBlockState(getPos(),
						getWorld().getBlockState(getPos()).withProperty(BlockProperties.FRAME, true), 2);
			}
		}
	}

	@Override
	public void onMachineBroken()
	{
		if (!getWorld().isRemote && getPartPosition().isFrame())
		{
			if (getWorld().getBlockState(getPos()).withProperty(BlockProperties.FRAME, false) != null)
			{
				getWorld().setBlockState(getPos(),
						getWorld().getBlockState(getPos()).withProperty(BlockProperties.FRAME, false), 2);
			}
		}
		super.onMachineBroken();
	}



}
