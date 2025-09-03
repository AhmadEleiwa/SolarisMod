package com.example.legendofvirelia.entity.entitygoal;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class RandomFlyingGoal extends Goal {
    private final FlyingMob mob;
    private final double speed;
    private final int horizontalRange;
    private final int verticalRange;
    private final int cooldownTicks;

    private Vec3 targetPosition;
    private int ticksSinceLastTarget;

    public RandomFlyingGoal(FlyingMob mob, double speed) {
        this(mob, speed, 16, 8, 60);
    }

    public RandomFlyingGoal(FlyingMob mob, double speed, int horizontalRange, int verticalRange, int cooldownTicks) {
        this.mob = mob;
        this.speed = speed;
        this.horizontalRange = horizontalRange;
        this.verticalRange = verticalRange;
        this.cooldownTicks = cooldownTicks;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        // Don't interrupt existing movement
        if (mob.getMoveControl().hasWanted()) {
            return false;
        }

        // Cooldown to prevent constant retargeting
        if (ticksSinceLastTarget < cooldownTicks) {
            ticksSinceLastTarget++;
            return false;
        }

        // Random chance to start moving
        return mob.getRandom().nextInt(5) == 0;
    }

    @Override
    public boolean canContinueToUse() {
        // Continue until we reach the target or get stuck
        return targetPosition != null &&
                !mob.getNavigation().isDone() &&
                mob.distanceToSqr(targetPosition) > 4.0;
    }

    @Override
    public void start() {
        targetPosition = findRandomTarget();
        if (targetPosition != null) {
            mob.getMoveControl().setWantedPosition(targetPosition.x, targetPosition.y, targetPosition.z, speed);
            ticksSinceLastTarget = 0;
        }
    }

    @Override
    public void stop() {
        targetPosition = null;
        ticksSinceLastTarget = 0;
    }

    @Override
    public void tick() {
        // Optional: Add slight randomization during flight for more natural movement
        if (targetPosition != null && mob.getRandom().nextInt(40) == 0) {
            RandomSource random = mob.getRandom();
            Vec3 currentTarget = targetPosition;
            Vec3 offset = new Vec3(
                    (random.nextDouble() - 0.5) * 2.0,
                    (random.nextDouble() - 0.5) * 2.0,
                    (random.nextDouble() - 0.5) * 2.0
            );
            Vec3 adjustedTarget = currentTarget.add(offset);

            // Ensure the adjusted target is still valid
            if (isValidTarget(adjustedTarget)) {
                mob.getMoveControl().setWantedPosition(adjustedTarget.x, adjustedTarget.y, adjustedTarget.z, speed);
            }
        }
    }

    private Vec3 findRandomTarget() {
        RandomSource random = mob.getRandom();
        Level level = mob.level();

        // Try multiple times to find a valid target
        for (int attempts = 0; attempts < 10; attempts++) {
            double offsetX = (random.nextInt(horizontalRange * 2) - horizontalRange);
            double offsetY = (random.nextInt(verticalRange * 2) - verticalRange);
            double offsetZ = (random.nextInt(horizontalRange * 2) - horizontalRange);

            Vec3 potential = mob.position().add(offsetX, offsetY, offsetZ);

            // Clamp Y to reasonable bounds
            potential = new Vec3(
                    potential.x,
                    Mth.clamp(potential.y, level.getMinBuildHeight() + 10, level.getMaxBuildHeight() - 10),
                    potential.z
            );

            if (isValidTarget(potential)) {
                return potential;
            }
        }

        // Fallback: just move up a bit
        return mob.position().add(0, 5, 0);
    }

    private boolean isValidTarget(Vec3 target) {
        Level level = mob.level();

        // Basic bounds checking
        if (target.y < level.getMinBuildHeight() + 5 || target.y > level.getMaxBuildHeight() - 5) {
            return false;
        }

        // Check if target is in a reasonable area (not in solid blocks)
        // This is a simplified check - you might want more sophisticated validation
        return level.noCollision(mob, mob.getBoundingBox().move(
                target.x - mob.getX(),
                target.y - mob.getY(),
                target.z - mob.getZ()
        ));
    }
}