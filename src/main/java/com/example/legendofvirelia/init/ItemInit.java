package com.example.legendofvirelia.init;

import com.example.legendofvirelia.ExampleMod;
import com.example.legendofvirelia.init.tiers.ModArmorItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<BlockItem> EXAMPLE_BLOCK_ITEM = CreativeTabInit.addToTab(ITEMS.register("aetherium_ore",
            ()-> new BlockItem(BlockInit.AETHERIOUM_BLOCK.get(),
                    new Item.Properties().rarity(Rarity.COMMON)
            )));
    public static final  RegistryObject<Item> RAW_AETHERIOUM= CreativeTabInit.addToTab(ITEMS.register("raw_aetherium",
            ()-> new Item(new Item.Properties())
    ));
    public static final  RegistryObject<Item> AETHERIOUM_INGOT = CreativeTabInit.addToTab(ITEMS.register("aetherium_ingot",
            ()-> new Item(new Item.Properties())
    ));

    public static final RegistryObject<Item> SOLARIS_ORE_ITEM =  CreativeTabInit.addToTab(ITEMS.register("solaris_fragment",
            () -> new Item(
                    new Item.Properties()
            )
            ));
    public static final  RegistryObject<Item> SOLARIS_ITEM = CreativeTabInit.addToTab(ITEMS.register("solaris_ingot",
            ()-> new Item(new Item.Properties())
            ));

    public static final RegistryObject<SwordItem> SALORIS_SWORD =CreativeTabInit.addToTab( ITEMS.register("solaris_sword",
            ()-> new SwordItem(
                    TierInit.SALORIS,
                    10,
                    -2.4f,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            )
            ));

    public static final RegistryObject<ArmorItem> SALORIS_HELMET = CreativeTabInit.addToTab(ITEMS.register("solaris_helmet",
            () -> new ModArmorItem(
                    ArmorMaterialInit.SOLARIS,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .fireResistant()
            )));

    public static final RegistryObject<ArmorItem> SALORIS_CHESTPLATE = CreativeTabInit.addToTab(ITEMS.register("solaris_chestplate",
            () -> new ModArmorItem(
                    ArmorMaterialInit.SOLARIS,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .fireResistant()
            )));

    public static final RegistryObject<ArmorItem> SALORIS_LEGGINGS = CreativeTabInit.addToTab(ITEMS.register("solaris_leggings",
            () -> new ModArmorItem(
                    ArmorMaterialInit.SOLARIS,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
                            .fireResistant()
            )));

    public static final RegistryObject<ArmorItem> SALORIS_BOOTS = CreativeTabInit.addToTab(ITEMS.register("solaris_boots",
            () -> new ModArmorItem(
                    ArmorMaterialInit.SOLARIS,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .fireResistant()
            )));

    public static final RegistryObject<ForgeSpawnEggItem> EXAMPLE_SPAWN_EGG = CreativeTabInit.addToTab(ITEMS.register("examle_spwan_egg",
            () -> new ForgeSpawnEggItem(
                    EntityInit.EXAMPLE_ENTITY, 0xff2211, 0x121212, new Item.Properties())));

}
