package net.luis.nero.common.block.entity;

import net.luis.nero.api.common.block.entity.IAnimatedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class MilestoneBlockEntity implements IAnimatedBlockEntity {
	
	private float previousRotation = 0F;
	private float currentRotation = 0F;
	
	@Override
	public float getCurrent() {
		return this.currentRotation;
	}
	
	@Override
	public float getPrevious() {
		return this.previousRotation;
	}
	
	@SuppressWarnings("unused")
	@Override
	public float getVelocity() {
		return (/*this.isProgressing()*/true ? 10F : 0F) / 100;
	}

	@Override
	public float getNext() {
		float newRotation = 0F;
		if (this.currentRotation + this.getVelocity() > 360) {
			newRotation = (this.currentRotation + this.getVelocity()) - 360;
		} else {
			newRotation = this.currentRotation + this.getVelocity();
		}
		return newRotation;
	}
	
	public static void serverTick(Level level, BlockPos pos, BlockState state, MilestoneBlockEntity milestoneTileEntity) {
		milestoneTileEntity.previousRotation = milestoneTileEntity.currentRotation;
		milestoneTileEntity.currentRotation = milestoneTileEntity.getNext();
	}

}