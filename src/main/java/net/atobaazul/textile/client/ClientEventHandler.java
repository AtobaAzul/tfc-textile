package net.atobaazul.textile.client;

import net.atobaazul.textile.block.TextileBlocks;
import net.dries007.tfc.client.IGhostBlockHandler;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.function.Predicate;

public class ClientEventHandler {


    public static void init() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(ClientEventHandler::clientSetup);

    }

    @SuppressWarnings("deprecation")
    public static void clientSetup(FMLClientSetupEvent event) {
        final RenderType cutout = RenderType.cutout();
        final RenderType cutoutMipped = RenderType.cutoutMipped();
        final Predicate<RenderType> ghostBlock = rt -> rt == cutoutMipped || rt == Sheets.translucentCullBlockSheet();

        TextileBlocks.CROPS.values().forEach(reg -> {
            if (reg.get() instanceof IGhostBlockHandler) {
                ItemBlockRenderTypes.setRenderLayer(reg.get(), ghostBlock);
            } else {
                ItemBlockRenderTypes.setRenderLayer(reg.get(), cutout);
            }
        });
        TextileBlocks.DEAD_CROPS.values().forEach(reg -> ItemBlockRenderTypes.setRenderLayer(reg.get(), cutout));
        TextileBlocks.WILD_CROPS.values().forEach(reg -> ItemBlockRenderTypes.setRenderLayer(reg.get(), cutout));
    }
}