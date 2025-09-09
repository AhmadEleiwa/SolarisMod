package com.example.legendofvirelia.init;


import com.example.legendofvirelia.init.tiers.ModArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorMaterialInit {
    public static final ModArmorMaterial SOLARIS = new ModArmorMaterial(
            new int[] { 900, 1200, 900, 900 },
            new int[] { 11, 18, 17, 11 },
            20,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ItemInit.SOLARIS_ITEM::get),
            "solaris",
            10f,
            0.15f,
            new MobEffectInstance(MobEffects.REGENERATION,100, 1,false,false, false)
    );
        public static final ModArmorMaterial AETHERIUM = new ModArmorMaterial(
                new int[] { 363, 529, 495, 429 },
                new int[] { 4, 9, 7, 4},
                15,
                SoundEvents.ARMOR_EQUIP_NETHERITE,
                () -> Ingredient.of(ItemInit.AETHERIOUM_INGOT::get),
                "aetherium",
                2f,
                0.05f,
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1,false,false, false)
        );
    public static final ModArmorMaterial STEEL = new ModArmorMaterial(
            new int[] { 165+20, 240+30, 225+30, 195 +20 },
            new int[] { 3, 7, 6, 2},
            15,
            SoundEvents.ARMOR_EQUIP_IRON,
            () -> Ingredient.of(ItemInit.STEEL_INGOT::get),
            "steel",
            .1f,
            0.01f,
           null
    );
}
