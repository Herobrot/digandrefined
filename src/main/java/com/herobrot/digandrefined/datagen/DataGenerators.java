package com.herobrot.digandrefined.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {
    public static void gatherData(GatherDataEvent event) {
        PackOutput output = event.getGenerator().getPackOutput();
        event.getGenerator().addProvider(event.includeClient(), new ModLanguageProvider(output, "en_us"));
        event.getGenerator().addProvider(event.includeClient(), new ModLanguageProvider(output, "es_es"));
    }
}