package net.atobaazul.textile.registries;

import com.momosoftworks.coldsweat.core.init.ModCreativeTabs;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.atobaazul.textile.Textile.MOD_ID;
import static net.atobaazul.textile.registries.TextileItems.*;

public class TextileCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TEXTILE_RESOURCES = CREATIVE_MODE_TABS.register("textile_resources", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.textile.resources"))
            .withTabsBefore(ModCreativeTabs.COLD_SWEAT_TAB.getKey())
            .icon(() -> COTTON_BALL.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(PRIMITIVE_INSULATION); 
            
                FURS.forEach(output::accept);
            
                output.accept(COTTON_BALL);
                output.accept(COTTON_STRING);
                output.accept(COTTON_CLOTH);
                output.accept(FLAX);
                output.accept(FLAX_FIBER);
                output.accept(LINEN_CLOTH);
            }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TEXTILE_CLOTHING = CREATIVE_MODE_TABS.register("textile_clothing", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.textile.clothing"))
            .withTabsBefore(TEXTILE_RESOURCES.getKey())
            .icon(() -> GRIZZLY_BEAR_CLOTHES.getFirst().get().getDefaultInstance())
            .displayItems((parameters, output) -> {

                BLACK_BEAR_CLOTHES.forEach(output::accept);
                CARIBOU_CLOTHES.forEach(output::accept);
                COUGAR_CLOTHES.forEach(output::accept);
                CROCODILE_CLOTHES.forEach(output::accept);
                DIREWOLF_CLOTHES.forEach(output::accept);
                GRIZZLY_BEAR_CLOTHES.forEach(output::accept);
                LION_CLOTHES.forEach(output::accept);
                PANTHER_CLOTHES.forEach(output::accept);
                POLAR_BEAR_CLOTHES.forEach(output::accept);
                SABERTOOTH_CLOTHES.forEach(output::accept);
                TIGER_CLOTHES.forEach(output::accept);
                BISON_CLOTHES.forEach(output::accept);
                YAK_CLOTHES.forEach(output::accept);

                RAW_HIDE_CLOTHES.forEach(output::accept);
                LINEN_CLOTHES.forEach(output::accept);
                COTTON_CLOTHES.forEach(output::accept);
            }).build());


}
