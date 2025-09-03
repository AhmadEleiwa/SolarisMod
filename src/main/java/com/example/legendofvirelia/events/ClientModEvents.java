package com.example.legendofvirelia.events;


import com.example.legendofvirelia.ExampleMod;
import com.example.legendofvirelia.client.model.ExampleEntityModel;
import com.example.legendofvirelia.client.renderer.ExampleEntityRenderer;
import com.example.legendofvirelia.entity.ExampleEntity;
import com.example.legendofvirelia.init.EntityInit;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(EntityInit.EXAMPLE_ENTITY.get(), ExampleEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ExampleEntityModel.LAYER_LOCATION, ExampleEntityModel::createBodyLayer);
    }
}
