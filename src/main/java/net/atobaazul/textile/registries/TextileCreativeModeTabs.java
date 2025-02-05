package net.atobaazul.textile.registries;

import net.atobaazul.textile.Textile;
import net.atobaazul.textile.crop.TextileCrop;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TextileCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Textile.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TEXTILE_INGREDIENTS = TABS.register("textile_ingredients", () -> CreativeModeTab.builder().icon(() -> new ItemStack(TextileItems.PRIMITIVE_INSULATION.get())).title(Component.literal("Textile: Ingredients")).displayItems((pParameters, pOutput) -> {
        pOutput.accept(TextileItems.CROP_SEEDS.get(TextileCrop.FLAX).get());
        pOutput.accept(TextileItems.CROP_SEEDS.get(TextileCrop.COTTON).get());

        pOutput.accept(TextileItems.COTTON_BALL.get());
        pOutput.accept(TextileItems.FLAX.get());

        pOutput.accept(TextileItems.FLAX_FIBER.get());
        pOutput.accept(TextileItems.COTTON_STRING.get());

        pOutput.accept(TextileItems.PRIMITIVE_INSULATION.get());

        pOutput.accept(TextileItems.LINEN_CLOTH.get());
        pOutput.accept(TextileItems.COTTON_CLOTH.get());

        pOutput.accept(TextileItems.BLACK_BEAR_FUR.get());
        pOutput.accept(TextileItems.GRIZZLY_BEAR_FUR.get());

        pOutput.accept(TextileItems.CARIBOU_FUR.get());
        pOutput.accept(TextileItems.POLAR_BEAR_FUR.get());
        pOutput.accept(TextileItems.DIREWOLF_FUR.get());

        pOutput.accept(TextileItems.COUGAR_FUR.get());
        pOutput.accept(TextileItems.LION_FUR.get());
        pOutput.accept(TextileItems.TIGER_FUR.get());
        pOutput.accept(TextileItems.PANTHER_FUR.get());
        pOutput.accept(TextileItems.CROCODILE_LEATHER.get());

    }).build());
    public static final RegistryObject<CreativeModeTab> TEXTILE_CLOTHING = TABS.register("textile_clothing", () -> CreativeModeTab.builder().icon(() -> new ItemStack(TextileItems.GRIZZLY_BEAR_HAT.get())).title(Component.literal("Textile: Clothing")).displayItems((pParameters, pOutput) -> {

        pOutput.accept(TextileItems.COTTON_HAT.get());
        pOutput.accept(TextileItems.COTTON_SHIRT.get());
        pOutput.accept(TextileItems.COTTON_PANTS.get());

        pOutput.accept(TextileItems.WOOL_HAT.get());
        pOutput.accept(TextileItems.WOOL_SHIRT.get());
        pOutput.accept(TextileItems.WOOL_PANTS.get());

        pOutput.accept(TextileItems.SILK_HAT.get());
        pOutput.accept(TextileItems.SILK_SHIRT.get());
        pOutput.accept(TextileItems.SILK_PANTS.get());

        pOutput.accept(TextileItems.LINEN_HAT.get());
        pOutput.accept(TextileItems.LINEN_SHIRT.get());
        pOutput.accept(TextileItems.LINEN_PANTS.get());

        pOutput.accept(TextileItems.BURLAP_HAT.get());
        pOutput.accept(TextileItems.BURLAP_SHIRT.get());
        pOutput.accept(TextileItems.BURLAP_PANTS.get());

        pOutput.accept(TextileItems.RAW_HAT.get());
        pOutput.accept(TextileItems.RAW_SHIRT.get());
        pOutput.accept(TextileItems.RAW_PANTS.get());

        pOutput.accept(TextileItems.BLACK_BEAR_HAT.get());
        pOutput.accept(TextileItems.BLACK_BEAR_SHIRT.get());
        pOutput.accept(TextileItems.BLACK_BEAR_PANTS.get());
        pOutput.accept(TextileItems.BLACK_BEAR_BOOTS.get());

        pOutput.accept(TextileItems.GRIZZLY_BEAR_HAT.get());
        pOutput.accept(TextileItems.GRIZZLY_BEAR_SHIRT.get());
        pOutput.accept(TextileItems.GRIZZLY_BEAR_PANTS.get());
        pOutput.accept(TextileItems.GRIZZLY_BEAR_BOOTS.get());

        pOutput.accept(TextileItems.CARIBOU_HAT.get());
        pOutput.accept(TextileItems.CARIBOU_SHIRT.get());
        pOutput.accept(TextileItems.CARIBOU_PANTS.get());
        pOutput.accept(TextileItems.CARIBOU_BOOTS.get());

        pOutput.accept(TextileItems.POLAR_BEAR_HAT.get());
        pOutput.accept(TextileItems.POLAR_BEAR_SHIRT.get());
        pOutput.accept(TextileItems.POLAR_BEAR_PANTS.get());
        pOutput.accept(TextileItems.POLAR_BEAR_BOOTS.get());

        pOutput.accept(TextileItems.DIREWOLF_HAT.get());
        pOutput.accept(TextileItems.DIREWOLF_SHIRT.get());
        pOutput.accept(TextileItems.DIREWOLF_PANTS.get());
        pOutput.accept(TextileItems.DIREWOLF_BOOTS.get());

        pOutput.accept(TextileItems.COUGAR_HAT.get());
        pOutput.accept(TextileItems.COUGAR_SHIRT.get());
        pOutput.accept(TextileItems.COUGAR_PANTS.get());
        pOutput.accept(TextileItems.COUGAR_BOOTS.get());

        pOutput.accept(TextileItems.LION_HAT.get());
        pOutput.accept(TextileItems.LION_SHIRT.get());
        pOutput.accept(TextileItems.LION_PANTS.get());
        pOutput.accept(TextileItems.LION_BOOTS.get());

        pOutput.accept(TextileItems.TIGER_HAT.get());
        pOutput.accept(TextileItems.TIGER_SHIRT.get());
        pOutput.accept(TextileItems.TIGER_PANTS.get());
        pOutput.accept(TextileItems.TIGER_BOOTS.get());

        pOutput.accept(TextileItems.PANTHER_HAT.get());
        pOutput.accept(TextileItems.PANTHER_SHIRT.get());
        pOutput.accept(TextileItems.PANTHER_PANTS.get());
        pOutput.accept(TextileItems.PANTHER_BOOTS.get());

        pOutput.accept(TextileItems.CROCODILE_HAT.get());
        pOutput.accept(TextileItems.CROCODILE_SHIRT.get());
        pOutput.accept(TextileItems.CROCODILE_PANTS.get());
        pOutput.accept(TextileItems.CROCODILE_BOOTS.get());

        pOutput.accept(TextileItems.SABERTOOTH_HAT.get());
        pOutput.accept(TextileItems.SABERTOOTH_SHIRT.get());
        pOutput.accept(TextileItems.SABERTOOTH_PANTS.get());
        pOutput.accept(TextileItems.SABERTOOTH_BOOTS.get());
    }).build());


    public static void register(IEventBus bus) {
        TABS.register(bus);
    }
}
