package net.atobaazul.textile;

import net.atobaazul.textile.client.render.ScarfRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import static net.atobaazul.textile.registries.TextileItems.*;

@Mod(value = Textile.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Textile.MOD_ID, value = Dist.CLIENT)
public class TextileClient {
    public TextileClient(ModContainer container) {

    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        CuriosRendererRegistry.register(WOOL_SCARF.get(), () -> new ScarfRenderer(Minecraft.getInstance().getEntityModels().bakeLayer(ScarfRenderer.LAYER)));
        CuriosRendererRegistry.register(SILK_SCARF.get(), () -> new ScarfRenderer(Minecraft.getInstance().getEntityModels().bakeLayer(ScarfRenderer.LAYER)));
        CuriosRendererRegistry.register(COTTON_SCARF.get(), () -> new ScarfRenderer(Minecraft.getInstance().getEntityModels().bakeLayer(ScarfRenderer.LAYER)));
    }

    @SubscribeEvent
    public static void onLayerRegister(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ScarfRenderer.LAYER, () -> LayerDefinition.create(ScarfRenderer.mesh(), 1, 1));
    }

}
