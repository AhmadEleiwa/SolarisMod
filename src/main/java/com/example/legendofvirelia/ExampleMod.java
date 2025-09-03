package com.example.legendofvirelia;

import com.example.legendofvirelia.init.BlockInit;
import com.example.legendofvirelia.init.CreativeTabInit;
import com.example.legendofvirelia.init.EntityInit;
import com.example.legendofvirelia.init.ItemInit;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import javax.swing.text.html.parser.Entity;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.MODID)
public class ExampleMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "legendofvirelia";

    public ExampleMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCK.register(modEventBus);
        CreativeTabInit.TABS.register(modEventBus);

        EntityInit.ENTITIES.register(modEventBus);

    }
    // Add this method inside your ExampleMod class

}
