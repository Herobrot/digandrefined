package com.herobrot.digandrefined.datagen;

import com.herobrot.digandrefined.DigandRefined;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, DigandRefined.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + DigandRefined.MODID, "Dig and Refined");
    }
}