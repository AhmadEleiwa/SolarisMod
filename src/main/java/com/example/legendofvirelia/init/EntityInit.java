package com.example.legendofvirelia.init;

import com.example.legendofvirelia.ExampleMod;
import com.example.legendofvirelia.entity.ExampleEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExampleMod.MODID);
    public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE_ENTITY = ENTITIES.register("solaris_spirit",
            ()-> EntityType.Builder.<ExampleEntity>of(ExampleEntity::new, MobCategory.CREATURE)
                    .sized(0.8f, 0.8f)
                    .build(new ResourceLocation(ExampleMod.MODID, "solaris_spirit").toString())
            );
}
