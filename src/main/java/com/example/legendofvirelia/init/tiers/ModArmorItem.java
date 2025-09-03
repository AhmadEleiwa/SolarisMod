package com.example.legendofvirelia.init.tiers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ModArmorItem extends ArmorItem {
    private final MobEffectInstance effect;
    public ModArmorItem(ArmorMaterial material, Type type, Properties properties, MobEffectInstance effect) {
        super(material, type, properties);
        this.effect = effect;
    }
    public ModArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
        effect = null;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            if (hasFullSuitOfArmorOn(player)) {
                applyFullSetEffects(player);
            }
        }
    }
    private void applyFullSetEffects(Player player) {
        ItemStack helmet = player.getInventory().getArmor(3);
        ArmorMaterial material = ((ArmorItem) helmet.getItem()).getMaterial();

        if (material instanceof ModArmorMaterial modMaterial) {
            MobEffectInstance effect = modMaterial.getFullSetEffect();
            if (effect != null) {
                if (!player.hasEffect(effect.getEffect()) || player.getEffect(effect.getEffect()).getDuration() <= 20) {
                    player.addEffect(new MobEffectInstance(effect));

                }
            }
        }
    }
    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        if (helmet.isEmpty() || chestplate.isEmpty() || leggings.isEmpty() || boots.isEmpty()) {
            return false;
        }

        ArmorMaterial material = ((ArmorItem) helmet.getItem()).getMaterial();
        return boots.getItem() instanceof ArmorItem && ((ArmorItem) boots.getItem()).getMaterial() == material
                && leggings.getItem() instanceof ArmorItem && ((ArmorItem) leggings.getItem()).getMaterial() == material
                && chestplate.getItem() instanceof ArmorItem && ((ArmorItem) chestplate.getItem()).getMaterial() == material
                && helmet.getItem() instanceof ArmorItem && ((ArmorItem) helmet.getItem()).getMaterial() == material;
    }


}
