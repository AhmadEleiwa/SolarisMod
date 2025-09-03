package com.example.legendofvirelia.client.renderer;

import com.example.legendofvirelia.ExampleMod;
import com.example.legendofvirelia.client.model.ExampleEntityModel;
import com.example.legendofvirelia.entity.ExampleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityRenderer extends MobRenderer<ExampleEntity,  ExampleEntityModel> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(ExampleMod.MODID, "textures/entity/solaris_spirit.png");


    public ExampleEntityRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new ExampleEntityModel(ctx.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(ExampleEntity entity) {
        return TEXTURE;
    }
}
