package com.example.legendofvirelia.init;

import com.example.legendofvirelia.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MODID);
    public static final List<Supplier<? extends ItemLike>> LEGEND_OF_VIRELIA_TAB_ITEMS = new ArrayList<>();
    public static final RegistryObject<CreativeModeTab> LEGEND_OF_VIRELIA_TAB = TABS.register("legend_of_virelia_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.legend_of_virelia_tab"))
                    .icon(ItemInit.SOLARIS_ITEM.get()::getDefaultInstance )
                    .displayItems((displayParameters, output) ->
                            LEGEND_OF_VIRELIA_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get())))
                    .build()
    );
    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike){
        LEGEND_OF_VIRELIA_TAB_ITEMS.add(itemLike);
        return itemLike;
    }
    @SubscribeEvent
    public static void buildContent(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ItemInit.EXAMPLE_BLOCK_ITEM);
        }
    }
}
