package net.atobaazul.textile;

import com.mojang.logging.LogUtils;
import net.atobaazul.textile.block.TextileBlocks;
import net.atobaazul.textile.block_entities.TextileBlockEntities;
import net.atobaazul.textile.client.ClientEventHandler;
import net.atobaazul.textile.crop.TextileCrop;
import net.atobaazul.textile.loot.ModLootModifiers;
import net.atobaazul.textile.registries.TextileCreativeModeTabs;
import net.atobaazul.textile.registries.TextileItems;
import net.atobaazul.textile.util.TextileLoot;
import net.atobaazul.textile.worldgen.TextileFeatures;
import net.dries007.tfc.common.TFCCreativeTabs;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Textile.MOD_ID)
public class Textile {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "textile";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Textile() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();


        TextileItems.register(bus);
        TextileCreativeModeTabs.TABS.register(bus);
        ModLootModifiers.register(bus);
        TextileBlocks.BLOCKS.register(bus);
        TextileFeatures.FEATURES.register(bus);

        TextileLoot.CONDITIONS.register(bus);
        TextileLoot.LOOT_FUNCTIONS.register(bus);
        TextileLoot.NUMBER_PROVIDERS.register(bus);

        // Register the commonSetup method for modloading
        bus.addListener(this::commonSetup);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            ClientEventHandler.init();
        }
        TextileBlockEntities.BLOCK_ENTITIES.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        bus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == TFCCreativeTabs.EARTH.tab().get()) {
            event.accept(TextileBlocks.WILD_CROPS.get(TextileCrop.COTTON));
            event.accept(TextileBlocks.WILD_CROPS.get(TextileCrop.FLAX));
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }





    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            /*CuriosRendererRegistry.register(TFCTextileItems.SILK_PANTS.get(), RenderCurio::new);
            CuriosRendererRegistry.register(TFCTextileItems.SILK_SHIRT.get(), RenderCurio::new);
            CuriosRendererRegistry.register(TFCTextileItems.SILK_HAT.get(), RenderCurio::new);*/
        }

        @SubscribeEvent
        public static void registerColorHandlers(RegisterColorHandlersEvent.Item event)
        {
            event.register( //Not sure what the tint index here does. Copied this from some example in GitHub.
                    (stack, tintIndex) -> tintIndex > 0 ? -1 : ((DyeableLeatherItem) stack.getItem()).getColor(stack),
                    TextileItems.LINEN_HAT.get(), TextileItems.LINEN_SHIRT.get(), TextileItems.LINEN_PANTS.get(),
                    TextileItems.COTTON_HAT.get(), TextileItems.COTTON_SHIRT.get(), TextileItems.COTTON_PANTS.get(),
                    TextileItems.BURLAP_HAT.get(), TextileItems.BURLAP_SHIRT.get(), TextileItems.BURLAP_PANTS.get(),
                    TextileItems.SILK_HAT.get(), TextileItems.SILK_SHIRT.get(), TextileItems.SILK_PANTS.get(),
                    TextileItems.WOOL_HAT.get(), TextileItems.WOOL_SHIRT.get(), TextileItems.WOOL_PANTS.get()
            );
        }
    }
}
