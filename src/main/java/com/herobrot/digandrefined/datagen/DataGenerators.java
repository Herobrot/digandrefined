package com.herobrot.digandrefined.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {
    public static void gatherData(GatherDataEvent event) {
        PackOutput output = event.getGenerator().getPackOutput();
        event.getGenerator().addProvider(event.includeClient(), new ModItemModelProvider(output, event.getExistingFileHelper()));
        event.getGenerator().addProvider(event.includeClient(), new ModLanguageProvider(output, "en_us"));
        event.getGenerator().addProvider(event.includeClient(), new ModLanguageProvider(output, "es_es"));

        event.getGenerator().addProvider(event.includeServer(), new ModItemTagsProvider(output, event.getLookupProvider(), event.getExistingFileHelper()));
        event.getGenerator().addProvider(event.includeServer(), new ModRecipeProvider(output, event.getLookupProvider()));
        event.getGenerator().addProvider(event.includeServer(), new ModDataMapProvider(output, event.getLookupProvider()));
    }
}