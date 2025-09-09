package com.example.legendofvirelia;

import com.example.legendofvirelia.init.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LegendOfVirelia.MODID)
public class LegendOfVirelia
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "legendofvirelia";

    public LegendOfVirelia(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCK.register(modEventBus);
        CreativeTabInit.TABS.register(modEventBus);



    }
    // Add this method inside your ExampleMod class

}
