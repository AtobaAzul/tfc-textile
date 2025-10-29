package net.atobaazul.textile.events.client;

import net.atobaazul.textile.client.TextileIClientExtensions;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

import static net.atobaazul.textile.Textile.MOD_ID;
import static net.atobaazul.textile.registries.TextileItems.COTTON_CLOTHES;
import static net.atobaazul.textile.registries.TextileItems.LINEN_CLOTHES;

@EventBusSubscriber(value = Dist.CLIENT, modid = MOD_ID)
public class ClientEvents {
    @SubscribeEvent
    private static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        TextileIClientExtensions clientExtension = new TextileIClientExtensions();

        LINEN_CLOTHES.forEach((item) -> event.registerItem(clientExtension, item));
        COTTON_CLOTHES.forEach((item) -> event.registerItem(clientExtension, item));
    }
}
