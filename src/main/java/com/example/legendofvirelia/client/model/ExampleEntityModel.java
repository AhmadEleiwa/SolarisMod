package com.example.legendofvirelia.client.model;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.example.legendofvirelia.ExampleMod;
import com.example.legendofvirelia.client.animation.CustomModelAnimation;
import com.example.legendofvirelia.entity.ExampleEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

public class ExampleEntityModel extends HierarchicalModel<ExampleEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ExampleMod.MODID, "example_entity"), "main");
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart bone;
    private final ModelPart leggings3;
    private final ModelPart leggings4;
    private final ModelPart leggings;
    private final ModelPart leggings2;
    private final ModelPart leftArm;
    private final ModelPart rightArm;

    public ExampleEntityModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
        this.bone = this.body.getChild("bone");
        this.leggings3 = this.bone.getChild("leggings3");
        this.leggings4 = this.bone.getChild("leggings4");
        this.leggings = this.bone.getChild("leggings");
        this.leggings2 = this.bone.getChild("leggings2");
        this.leftArm = this.body.getChild("leftArm");
        this.rightArm = this.body.getChild("rightArm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -1.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

        PartDefinition bone = body.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 1.0F));

        PartDefinition leggings3 = bone.addOrReplaceChild("leggings3", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(4, 30).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(8, 30).addBox(0.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 30).addBox(-2.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(16, 30).addBox(-2.0F, 4.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(20, 30).addBox(1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 2.0F));

        PartDefinition leggings4 = bone.addOrReplaceChild("leggings4", CubeListBuilder.create().texOffs(0, 32).addBox(-3.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(32, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(32, 2).addBox(0.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(4, 32).addBox(-2.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(32, 4).addBox(0.0F, 4.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(32, 6).addBox(1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -11.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition leggings = bone.addOrReplaceChild("leggings", CubeListBuilder.create().texOffs(0, 26).addBox(-3.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(4, 26).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(8, 26).addBox(0.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 26).addBox(-2.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(16, 26).addBox(0.0F, 4.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(20, 26).addBox(1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, -4.0F));

        PartDefinition leggings2 = bone.addOrReplaceChild("leggings2", CubeListBuilder.create().texOffs(0, 28).addBox(-3.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(4, 28).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(8, 28).addBox(0.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 28).addBox(-2.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(16, 28).addBox(-1.0F, 4.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(20, 28).addBox(1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -11.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(24, 16).addBox(-3.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, 0.5F, 0.0F, 0.0F, 0.5236F));

        PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(24, 25).addBox(0.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -3.0F, 0.5F, 0.0F, 0.0F, -0.5236F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

    @Override
    public ModelPart root() {
        return this.body;
    }


    @Override
    public void setupAnim(@NotNull ExampleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        root().getAllParts().forEach(ModelPart::resetPose);

//        float speed = Mth.clamp(limbSwingAmount, 0.0F, 1.0F);
        animate(entity.idleAnimationState, CustomModelAnimation.IDLE, ageInTicks, 1.0f);
        if(!entity.isInWaterOrBubble()) {
            animateWalk(CustomModelAnimation.WALK, limbSwing, limbSwingAmount, 1.0F, 2.5F);

        } else {

        }
        ModelPart head = this.head; // or root().getChild("head")
        if (head != null) {
            head.yRot += netHeadYaw * ((float) Math.PI / 180F);
            head.xRot += headPitch * ((float) Math.PI / 180F);
        }
    }

}