package com.example.legendofvirelia.commands;
import com.example.legendofvirelia.world.CustomTeleporter;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;

public class TeleportCommand {

    public static LiteralArgumentBuilder<CommandSourceStack> register() {
        return Commands.literal("tpdim")
                .then(Commands.argument("dimension", net.minecraft.commands.arguments.ResourceLocationArgument.id())
                        .executes(ctx -> {
                            ServerPlayer player = ctx.getSource().getPlayerOrException();
                            ResourceLocation dimId = net.minecraft.commands.arguments.ResourceLocationArgument.getId(ctx, "dimension");
                            ResourceKey<Level> key = ResourceKey.create(Registries.DIMENSION, dimId);

                            ServerLevel targetWorld = player.server.getLevel(key);
                            if (targetWorld == null) {
                                ctx.getSource().sendFailure(net.minecraft.network.chat.Component.literal("Unknown dimension: " + dimId));
                                return 0;
                            }

                            player.changeDimension(targetWorld, new CustomTeleporter(player.blockPosition()));
                            ctx.getSource().sendSuccess(() ->
                                    net.minecraft.network.chat.Component.literal("Teleported to " + dimId), true);

                            return Command.SINGLE_SUCCESS;
                        }));
    }
}
