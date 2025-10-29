package net.atobaazul.textile;

import net.atobaazul.textile.registries.TextileItems;
import net.atobaazul.textile.registries.TextileLootModifiers;
import net.atobaazul.textile.registries.TextileMaterials;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(Textile.MOD_ID)
public class Textile {
    public static final String MOD_ID = "textile";

    public Textile(IEventBus bus, ModContainer modContainer) {
        bus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (Textile) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        //NeoForge.EVENT_BUS.register(this);

        TextileItems.ITEMS.register(bus);
        TextileLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(bus);
        TextileMaterials.MATERIALS.register(bus);

        bus.addListener(this::registerColorHandler);
    }

    public static ResourceLocation textileResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void registerColorHandler(RegisterColorHandlersEvent.Item event) {
        TextileItems.COTTON_CLOTHES.forEach(item -> {
            event.register((stack, tintIndex) -> tintIndex > 0 ? -1 : DyedItemColor.getOrDefault(stack, 0xFFFFFFFF), item);
        });

        TextileItems.LINEN_CLOTHES.forEach(item -> {
            event.register((stack, tintIndex) -> tintIndex > 0 ? -1 : DyedItemColor.getOrDefault(stack, 0xFFE380), item);
        });
    }
}
