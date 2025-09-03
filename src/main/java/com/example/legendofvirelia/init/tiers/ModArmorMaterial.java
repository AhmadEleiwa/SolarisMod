package com.example.legendofvirelia.init.tiers;

import com.example.legendofvirelia.ExampleMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class ModArmorMaterial implements ArmorMaterial {
    private final int[] durabilityForType;
    private final int[] defenseForType;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final Supplier<Ingredient> repairMaterial;
    private final String name;
    private final float toughness;
    private final float knockbackResistance;

    // Custom fields for full set effects and flight
    private final MobEffectInstance fullSetEffect;

    public ModArmorMaterial(
            int[] durabilityForType,
            int[] defenseForType,
            int enchantability,
            SoundEvent equipSound,
            Supplier<Ingredient> repairMaterial,
            String name,
            float toughness,
            float knockbackResistance,
            MobEffectInstance fullSetEffect
    ) {
        this.durabilityForType = durabilityForType;
        this.defenseForType = defenseForType;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.repairMaterial = repairMaterial;
        this.name = name;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.fullSetEffect = fullSetEffect;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return durabilityForType[type.ordinal()];
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return defenseForType[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }

    @Override
    public String getName() {
        return ExampleMod.MODID + ":" + name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }

    // Custom getters
    public MobEffectInstance getFullSetEffect() { return fullSetEffect; }
}
