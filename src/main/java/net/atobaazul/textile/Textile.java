package net.atobaazul.textile;

import net.atobaazul.textile.registries.*;
import net.dries007.tfc.util.climate.ClimateRange;
import net.dries007.tfc.util.data.DataManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.util.Locale;

import static net.atobaazul.textile.registries.TextileItems.LEATHER_APRON;

@Mod(Textile.MOD_ID)
public class Textile {
    public static final String MOD_ID = "textile";

    public static final DataManager.Reference<ClimateRange> FLAX_CLIMATE_RANGE = registerClimateRange("crop/flax");
    public static final DataManager.Reference<ClimateRange> COTTON_CLIMATE_RANGE = registerClimateRange("crop/cotton");

    public Textile(IEventBus bus, ModContainer modContainer) {
        bus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (Textile) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        //NeoForge.EVENT_BUS.register(this);

        TextileItems.ITEMS.register(bus);
        TextileLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(bus);
        TextileMaterials.MATERIALS.register(bus);
        TextileCreativeTabs.CREATIVE_MODE_TABS.register(bus);

        bus.addListener(this::registerColorHandler);

        TextileBlocks.BLOCKS.register(bus);
        TextileBlocks.BLOCK_ENTITIES.register(bus);
    }

    private static DataManager.Reference<ClimateRange> registerClimateRange(String name) {
        return ClimateRange.MANAGER.getReference(textileResource(name.toLowerCase(Locale.ROOT)));

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
            event.register((stack, tintIndex) -> tintIndex > 0 ? -1 : DyedItemColor.getOrDefault(stack, 0xFFe9dcbd), item);
        });

        event.register((stack, tintIndex) -> tintIndex > 0 ? -1 : DyedItemColor.LEATHER_COLOR, LEATHER_APRON);
    }
}
