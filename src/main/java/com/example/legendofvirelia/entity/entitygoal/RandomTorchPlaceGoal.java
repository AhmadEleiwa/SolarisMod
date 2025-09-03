package com.example.legendofvirelia.entity.entitygoal;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.EnumSet;

public class RandomTorchPlaceGoal extends Goal {
    private final Mob mob;
    private final int range;
    private final int cooldown;
    private int ticksSinceLastPlace;

    public RandomTorchPlaceGoal(Mob mob, int range, int cooldown) {
        this.mob = mob;
        this.range = range;
        this.cooldown = cooldown;
        this.setFlags(EnumSet.noneOf(Goal.Flag.class)); // Doesn't interfere with movement
    }

    @Override
    public boolean canUse() {
        if (ticksSinceLastPlace < cooldown) {
            ticksSinceLastPlace++;
            return false;
        }

        // Random chance to place a torch
        return mob.getRandom().nextInt(100) == 0;
    }

    @Override
    public boolean canContinueToUse() {
        return false; // Single-tick action
    }

    @Override
    public void start() {
        BlockPos torchPos = findValidTorchPosition();
        if (torchPos != null && placeTorch(torchPos)) {
            ticksSinceLastPlace = 0;
        }
    }

    private BlockPos findValidTorchPosition() {
        RandomSource random = mob.getRandom();
        Level level = mob.level();
        BlockPos mobPos = mob.blockPosition();

        // Try multiple times to find a valid position
        for (int attempts = 0; attempts < 10; attempts++) {
            int offsetX = random.nextInt(range * 2) - range;
            int offsetY = random.nextInt(range) - range / 2;
            int offsetZ = random.nextInt(range * 2) - range;

            BlockPos candidatePos = mobPos.offset(offsetX, offsetY, offsetZ);

            if (canPlaceTorchAt(candidatePos)) {
                return candidatePos;
            }
        }

        return null;
    }

    private boolean canPlaceTorchAt(BlockPos pos) {
        Level level = mob.level();

        // Check if position is air
        if (!level.getBlockState(pos).isAir()) {
            return false;
        }

        // Check if there's a solid block below
        BlockPos below = pos.below();
        BlockState blockBelow = level.getBlockState(below);

        // Make sure the block below can support a torch
        return blockBelow.isSolid() &&
                !blockBelow.is(Blocks.MAGMA_BLOCK) && // Avoid magma blocks
                Blocks.TORCH.defaultBlockState().canSurvive(level, pos);

    }

    private boolean placeTorch(BlockPos pos) {
        Level level = mob.level();

        if (level.isClientSide) {
            return false; // Only place on server side
        }

        // Place the torch
        BlockState torchState = Blocks.TORCH.defaultBlockState();
        return level.setBlock(pos, torchState, 3); // Flag 3 = notify neighbors and clients
    }
}