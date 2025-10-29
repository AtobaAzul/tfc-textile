package net.atobaazul.textile.datagen.providers;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static net.atobaazul.textile.Textile.MOD_ID;

public class TextileLangProvider extends LanguageProvider {
    public TextileLangProvider(PackOutput output) {
        super(output, MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        /*this.addItem(TFCColdSweatItems.BURLAP_CHESTPLATE, "Burlap Shirt");
        this.addItem(TFCColdSweatItems.BURLAP_HELMET, "Burlap Hat");
        this.addItem(TFCColdSweatItems.BURLAP_LEGGINGS, "Burlap Pants");*/

    }
}
