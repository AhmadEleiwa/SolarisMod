package com.example.legendofvirelia.entity;

import com.example.legendofvirelia.entity.entitygoal.RandomFlyingGoal;
import com.example.legendofvirelia.init.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class ExampleEntity extends FlyingMob {
    public final AnimationState idleAnimationState = new AnimationState();

    public ExampleEntity(EntityType<ExampleEntity> type, Level level) {
        super(type, level);
        this.setMaxUpStep(1.0F);

        // Important: use FlyingMoveControl so it doesn’t behave like a ground mob
        this.moveControl = new FlyingMoveControl(this, 20, true);
    }

    public ExampleEntity(Level level, double x, double y, double z) {
        this(EntityInit.EXAMPLE_ENTITY.get(), level);
        setPos(x, y, z);
    }

    public ExampleEntity(Level level, BlockPos pos) {
        this(level, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        // Flying random movement instead of ground strolling
        this.goalSelector.addGoal(4, new RandomFlyingGoal(this, 1.0D));

        // Observation
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D) // still affects ground but less relevant
                .add(Attributes.FLYING_SPEED, 0.35D)   // main flying speed
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    public static boolean canSpawn(EntityType<ExampleEntity> entityType, LevelAccessor level,
                                   MobSpawnType spawnType, BlockPos position, RandomSource random) {
        return FlyingMob.checkMobSpawnRules(entityType, level, spawnType, position, random);
    }

    @Override
    public void tick() {
        if (level().isClientSide) {
            this.idleAnimationState.animateWhen(
                    !this.getMoveControl().hasWanted() && !this.walkAnimation.isMoving(),
                    this.tickCount
            );
        }
        super.tick();
    }
}
