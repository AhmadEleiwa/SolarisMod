package com.example.legendofvirelia.init;

import com.example.legendofvirelia.LegendOfVirelia;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCK =  DeferredRegister.create(ForgeRegistries.BLOCKS, LegendOfVirelia.MODID);

    public static final RegistryObject<DropExperienceBlock> AETHERIOUM_BLOCK = BLOCK.register("aetherium_ore",
            () -> new DropExperienceBlock(
                    BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                            .requiresCorrectToolForDrops()
                            .strength(3.0f, 6.0f)
                    ,
                    UniformInt.of(2,4)
            )
    );
    public static final RegistryObject<Block> SOLARIS_BLOCK = BLOCK.register("solaris_block",
            () -> new Block(
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                            .requiresCorrectToolForDrops()
                            .strength(3.0f, 6.0f)

            )
    );
    public static final RegistryObject<Block> BLACK_SOLARIS_BLOCK = BLOCK.register("black_solaris_block",
            () -> new Block(
                    BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)
                            .requiresCorrectToolForDrops()
                            .strength(3.0f, 6.0f)

            )
    );
    public static final RegistryObject<Block> STEEL_BLOCK = BLOCK.register("steel_block",
            () -> new Block(
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                            .requiresCorrectToolForDrops()
                            .strength(3.0f, 6.0f)

            )
    );

}
