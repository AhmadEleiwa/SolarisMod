package com.example.legendofvirelia.init;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class TierInit {
    public static final ForgeTier SOLARIS = new ForgeTier(
            4,
            2800,
            10.0f,             // Mining speed (slightly faster than Netherite’s 9.0f)
            0,                 // Attack damage bonus (1 more than Netherite’s 4)
            18,
            TagInit.NEEDS_SALORIS_TOOL,
            () -> Ingredient.of(ItemInit.SOLARIS_ITEM::get)
    );
    public static  final ForgeTier AETHERIUM = new ForgeTier(
            3,
            1800,
            11.0f,
            0,
            15,
            TagInit.NEEDS_AETHEROUM_TOOL,
            () -> Ingredient.of(ItemInit.AETHERIOUM_INGOT::get)
    );
}
