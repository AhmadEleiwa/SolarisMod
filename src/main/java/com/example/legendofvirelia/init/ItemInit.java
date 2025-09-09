package com.example.legendofvirelia.init;

import com.example.legendofvirelia.LegendOfVirelia;
import com.example.legendofvirelia.init.tiers.ModArmorItem;

import com.example.legendofvirelia.init.tool.MultiTool3x3Item;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LegendOfVirelia.MODID);

    public static final RegistryObject<BlockItem> EXAMPLE_BLOCK_ITEM = CreativeTabInit.addToTab(ITEMS.register("aetherium_ore",
            ()-> new BlockItem(BlockInit.AETHERIOUM_BLOCK.get(),
                    new Item.Properties().rarity(Rarity.COMMON)
            )));
    public static final RegistryObject<BlockItem> SOLARIS_BLOCK_ITEM = CreativeTabInit.addToTab(ITEMS.register("solaris_block",
            ()-> new BlockItem(BlockInit.SOLARIS_BLOCK.get(),
                    new Item.Properties().rarity(Rarity.COMMON)
            )));
    public static final RegistryObject<BlockItem> BLACK_SOLARIS_BLOCK_ITEM = CreativeTabInit.addToTab(ITEMS.register("black_solaris_block",
            ()-> new BlockItem(BlockInit.BLACK_SOLARIS_BLOCK.get(),
                    new Item.Properties().rarity(Rarity.COMMON)
            )));
    public static final RegistryObject<Item> STEEL_INGOT = CreativeTabInit.addToTab(ITEMS.register("steel_ingot",
            ()-> new Item(new Item.Properties())));

    public static final RegistryObject<BlockItem> STEEL_BLOCK_ITEM = CreativeTabInit.addToTab(ITEMS.register("steel_block",
            ()-> new BlockItem(BlockInit.STEEL_BLOCK.get(),
                    new Item.Properties().rarity(Rarity.COMMON)
            )));
    public static final RegistryObject<Item> CARBONIZED_IRON= CreativeTabInit.addToTab(ITEMS.register("carbonized_iron",
            ()-> new Item(new Item.Properties())
    ));

    public static final  RegistryObject<Item> RAW_AETHERIOUM= CreativeTabInit.addToTab(ITEMS.register("raw_aetherium",
            ()-> new Item(new Item.Properties())
    ));
    public static final  RegistryObject<Item> AETHERIOUM_DUST= CreativeTabInit.addToTab(ITEMS.register("aetherium_dust",
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
    public static final RegistryObject<Item> BLACK_SOLARIS_ITEM =  CreativeTabInit.addToTab(ITEMS.register("black_solaris_ingot",
            () -> new Item(
                    new Item.Properties()
            )));
    public static final  RegistryObject<Item> SOLARIS_ITEM = CreativeTabInit.addToTab(ITEMS.register("solaris_ingot",
            ()-> new Item(new Item.Properties())
            ));

    public static final RegistryObject<SwordItem> SOLARIS_SWORD =CreativeTabInit.addToTab( ITEMS.register("solaris_sword",
            ()-> new SwordItem(
                    TierInit.SOLARIS,
                    18,
                    -2.4f,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            )
            ));
    public static final RegistryObject<SwordItem> SOLARIS_LONG_SWORD =CreativeTabInit.addToTab( ITEMS.register("solaris_long_sword",
            ()-> new SwordItem(
                    TierInit.SOLARIS,
                    23,
                    -2.8f,
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

    public static final RegistryObject<ArmorItem> AETHERIUM_HELMET = CreativeTabInit.addToTab(ITEMS.register("aetherium_helmet",
            () -> new ModArmorItem(
                    ArmorMaterialInit.AETHERIUM,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
            )));

    public static final RegistryObject<ArmorItem> AETHERIUM_CHESTPLATE = CreativeTabInit.addToTab(ITEMS.register("aetherium_chestplate",
            () -> new ModArmorItem(
                    ArmorMaterialInit.AETHERIUM,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
            )));

    public static final RegistryObject<ArmorItem> AETHERIUM_LEGGINGS = CreativeTabInit.addToTab(ITEMS.register("aetherium_leggings",
            () -> new ModArmorItem(
                    ArmorMaterialInit.AETHERIUM,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
            )));

    public static final RegistryObject<ArmorItem> AETHERIUM_BOOTS = CreativeTabInit.addToTab(ITEMS.register("aetherium_boots",
            () -> new ModArmorItem(
                    ArmorMaterialInit.AETHERIUM,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
            )));


    public static final RegistryObject<ArmorItem> STEEL_HELMET = CreativeTabInit.addToTab(ITEMS.register("steel_helmet",
            () -> new ModArmorItem(
                    ArmorMaterialInit.STEEL,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
            )));

    public static final RegistryObject<ArmorItem> STEEL_CHESTPLATE = CreativeTabInit.addToTab(ITEMS.register("steel_chestplate",
            () -> new ModArmorItem(
                    ArmorMaterialInit.STEEL,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
            )));

    public static final RegistryObject<ArmorItem> STEEl_LEGGINGS = CreativeTabInit.addToTab(ITEMS.register("steel_leggings",
            () -> new ModArmorItem(
                    ArmorMaterialInit.STEEL,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
            )));

    public static final RegistryObject<ArmorItem> STEEL_BOOTS = CreativeTabInit.addToTab(ITEMS.register("steel_boots",
            () -> new ModArmorItem(
                    ArmorMaterialInit.STEEL,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
            )));

    public static final RegistryObject<PickaxeItem> AETHERIUM_PICKAXE = CreativeTabInit.addToTab(ITEMS.register("aetherium_pickaxe",
            () -> new PickaxeItem(
                    TierInit.AETHERIUM,
                    2,
                    -3f,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            )
            ));
    public static final RegistryObject<ShovelItem> AETHERIUM_SHOVEl = CreativeTabInit.addToTab(ITEMS.register("aetherium_shovel",
            () -> new ShovelItem(
                    TierInit.AETHERIUM,
                    2,
                    -3f,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            )
    ));
    public static final RegistryObject<AxeItem> AETHERIUM_AXE = CreativeTabInit.addToTab(ITEMS.register("aetherium_axe",
            () -> new AxeItem(
                    TierInit.AETHERIUM,
                    10,
                    -3f,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            )
    ));

    public static final RegistryObject<SwordItem> AETHERIUM_SWORD = CreativeTabInit.addToTab(ITEMS.register("aetherium_sword",
            () -> new SwordItem(
                    TierInit.AETHERIUM,
                    8,
                    -2.4f,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            )
    ));


    public static final RegistryObject<MultiTool3x3Item> WORLDBREAKER_HAMMER=CreativeTabInit.addToTab( ITEMS.register("worldbreaker_hammer",
            ()-> new MultiTool3x3Item(
                    TierInit.SOLARIS,
                    30,
                    -3.2f,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            )
    ));
    public static final RegistryObject<MultiTool3x3Item> HAMMER_TOOL=CreativeTabInit.addToTab( ITEMS.register("hammer_tool",
            ()-> new MultiTool3x3Item(
                    TierInit.SOLARIS,
                    4,
                    -3.2f,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            )
    ));

}
