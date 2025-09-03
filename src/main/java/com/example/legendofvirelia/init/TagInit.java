package com.example.legendofvirelia.init;

import com.example.legendofvirelia.ExampleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;


public class TagInit {

    public static final TagKey<Block> NEEDS_SALORIS_TOOL = tag("needs_saloris_tool");

    private static TagKey<Block> tag(String name){
        return BlockTags.create(new ResourceLocation(ExampleMod.MODID, name));
    }
}
