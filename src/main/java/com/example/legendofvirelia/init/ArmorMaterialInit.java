package com.example.legendofvirelia.init;


import com.example.legendofvirelia.init.tiers.ModArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorMaterialInit {
    public static final ModArmorMaterial SOLARIS = new ModArmorMaterial(
            new int[] { 500, 1200, 600, 400 },
            new int[] { 11, 18, 17, 11 },
            20,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ItemInit.SOLARIS_ITEM::get),
            "solaris",
            10f,
            0.15f,
            new MobEffectInstance(MobEffects.REGENERATION,200, 1,false,false, true)
    );
}
