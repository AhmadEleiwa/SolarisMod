package com.example.legendofvirelia.world;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class CustomTeleporter implements ITeleporter {
    private final BlockPos targetPos;

    public CustomTeleporter(BlockPos targetPos) {
        this.targetPos = targetPos;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld,
                              float yaw, Function<Boolean, Entity> repositionEntity) {

        Entity repositioned = repositionEntity.apply(false);

        if (repositioned instanceof ServerPlayer player) {
            player.teleportTo(destWorld,
                    targetPos.getX() + 0.5,
                    targetPos.getY(),
                    targetPos.getZ() + 0.5,
                    yaw,
                    player.getXRot());
        } else {
            repositioned.moveTo(
                    targetPos.getX() + 0.5,
                    targetPos.getY(),
                    targetPos.getZ() + 0.5,
                    yaw,
                    repositioned.getXRot()
            );
        }

        return repositioned;
    }

    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
        return new PortalInfo(
                new Vec3(targetPos.getX() + 0.5, targetPos.getY(), targetPos.getZ() + 0.5),
                Vec3.ZERO,
                entity.getYRot(),
                entity.getXRot()
        );
    }
}
