package com.example.legendofvirelia.init;

import com.example.legendofvirelia.ExampleMod;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCK =  DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);

    public static final RegistryObject<DropExperienceBlock> AETHERIOUM_BLOCK = BLOCK.register("aetherium_ore",
            () -> new DropExperienceBlock(
                    BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                            .requiresCorrectToolForDrops()
                            .strength(3.0f, 6.0f)

                    ,
                    UniformInt.of(2,4)
            )
    );
}
