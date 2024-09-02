package net.atobaazul.tfc_textile.event;


import com.lumintorious.tfcambiental.curios.ClothesCurioRenderer;
import com.lumintorious.tfcambiental.curios.SnowshoesCurioRenderer;
import com.lumintorious.tfcambiental.item.TFCAmbientalItems;
import net.atobaazul.tfc_textile.item.TFCTextileItems;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;


public class ClientEvent {

    public static void init(IEventBus bus) {
        bus.addListener(ClientEvent::setup);
    }
    private static void setup(FMLClientSetupEvent event) {

        CuriosRendererRegistry.register(TFCTextileItems.COTTON_HAT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.COTTON_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.COTTON_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.COTTON_SOCKS.get(),ClothesCurioRenderer::new);

        CuriosRendererRegistry.register(TFCTextileItems.CROCODILE_HAT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.CROCODILE_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.CROCODILE_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.CROCODILE_BOOTS.get(),ClothesCurioRenderer::new);

        CuriosRendererRegistry.register(TFCTextileItems.LINEN_HAT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.LINEN_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.LINEN_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.LINEN_SOCKS.get(),ClothesCurioRenderer::new);


        CuriosRendererRegistry.register(TFCTextileItems.RAW_HAT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.RAW_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.RAW_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.RAW_SOCKS.get(),ClothesCurioRenderer::new);

        CuriosRendererRegistry.register(TFCTextileItems.CARIBOU_HAT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.CARIBOU_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.CARIBOU_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.CARIBOU_SOCKS.get(),ClothesCurioRenderer::new);

        CuriosRendererRegistry.register(TFCTextileItems.POLAR_HAT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.POLAR_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.POLAR_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.POLAR_SOCKS.get(),ClothesCurioRenderer::new);

        CuriosRendererRegistry.register(TFCTextileItems.COUGAR_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.COUGAR_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.COUGAR_SOCKS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.COUGAR_HAT.get(),ClothesCurioRenderer::new);

        CuriosRendererRegistry.register(TFCTextileItems.TIGER_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.TIGER_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.TIGER_SOCKS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.TIGER_HAT.get(),ClothesCurioRenderer::new);

        CuriosRendererRegistry.register(TFCTextileItems.PANTHER_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.PANTHER_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.PANTHER_SOCKS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.PANTHER_HAT.get(),ClothesCurioRenderer::new);

        CuriosRendererRegistry.register(TFCTextileItems.SABER_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.SABER_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.SABER_SOCKS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.SABER_HAT.get(),ClothesCurioRenderer::new);

        CuriosRendererRegistry.register(TFCTextileItems.COUGAR_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.COUGAR_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.COUGAR_SOCKS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.COUGAR_HAT.get(),ClothesCurioRenderer::new);

        CuriosRendererRegistry.register(TFCTextileItems.BLACKBEAR_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.BLACKBEAR_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.BLACKBEAR_SOCKS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.BLACKBEAR_HAT.get(),ClothesCurioRenderer::new);

        CuriosRendererRegistry.register(TFCTextileItems.GRIZZLYBEAR_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.GRIZZLYBEAR_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.GRIZZLYBEAR_SOCKS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.GRIZZLYBEAR_HAT.get(),ClothesCurioRenderer::new);

        CuriosRendererRegistry.register(TFCTextileItems.DIREWOLF_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.DIREWOLF_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.DIREWOLF_SOCKS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.DIREWOLF_HAT.get(),ClothesCurioRenderer::new);

        CuriosRendererRegistry.register(TFCTextileItems.LION_PANTS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.LION_SHIRT.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.LION_SOCKS.get(),ClothesCurioRenderer::new);
        CuriosRendererRegistry.register(TFCTextileItems.LION_HAT.get(),ClothesCurioRenderer::new);
    }


}
