package com.example.legendofvirelia.init;

import com.example.legendofvirelia.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class DimensionInit {
    public static final ResourceKey<Level> AETHERIUM_DIM = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(ExampleMod.MODID, "my_dimension"));

}
