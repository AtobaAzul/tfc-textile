package net.atobaazul.textile.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.codehaus.plexus.util.dag.Vertex;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

import static net.atobaazul.textile.Textile.textileResource;

@OnlyIn(Dist.CLIENT)
public class ScarfRenderer implements ICurioRenderer {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(textileResource("scarf"), "scarf");
    private final HumanoidModel<LivingEntity> model;

    public ScarfRenderer(ModelPart part) {
        this.model = new HumanoidModel<>(part);
    }

    public static MeshDefinition mesh() {
        CubeListBuilder builder = new CubeListBuilder();
        MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
        mesh.getRoot().addOrReplaceChild("head", builder, PartPose.ZERO);
        return mesh;
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack itemStack, SlotContext slotContext, PoseStack poseStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource multiBufferSource, int i, float v, float v1, float v2, float v3, float v4, float v5) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        LivingEntity entity = slotContext.entity();
        Level level = entity.level();
        BakedModel scarfModel = itemRenderer.getModel(itemStack, level, entity, getSeedForItemStack(itemStack));


        //main scarf part
        ICurioRenderer.followHeadRotations(slotContext.entity(), model.head);
        poseStack.translate(model.head.x / 16.0, model.head.y / 16.0, model.head.z / 16.0);
        poseStack.mulPose(Axis.ZP.rotation(model.head.zRot));
        poseStack.mulPose(Axis.YP.rotation(model.head.yRot));
        poseStack.mulPose(Axis.XP.rotation(model.head.xRot));

        itemRenderer.renderStatic(itemStack, ItemDisplayContext.HEAD, i, OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, level, 0);
        poseStack.popPose();

        //dangling part
        poseStack.pushPose();

        ICurioRenderer.followBodyRotations(slotContext.entity(), model);
        poseStack.translate(model.body.x / 16.0, model.body.y / 16.0, model.body.z / 16.0);
        poseStack.mulPose(Axis.ZP.rotation(model.body.zRot));
        poseStack.mulPose(Axis.YP.rotation(0/*model.body.yRot*/));
        poseStack.mulPose(Axis.XP.rotation(0/*model.body.xRot*/));

        itemRenderer.renderStatic(itemStack, ItemDisplayContext.NONE, i, OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, level, 0);
        poseStack.popPose();
    }

    private static int getSeedForItemStack(ItemStack stack) {
        return stack.isEmpty() ? 187 : Item.getId(stack.getItem()) + stack.getDamageValue();
    }
}
