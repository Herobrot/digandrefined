package com.herobrot.digandrefined.datagen;

import com.herobrot.digandrefined.registry.ModContextIntProviders;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;

public class DataGenerators {
    public static void gatherClientData(GatherDataEvent.Client event) {
        event.createProvider(output -> new ModLanguageProvider(output, "en_us"));
        event.createProvider(output -> new ModLanguageProvider(output, "es_es"));
        event.createProvider(ModModelProvider::new);
    }

    public static void gatherServerData(GatherDataEvent.Server event) {
        event.createProvider(ModItemTagsProvider::new);
    }

    public static void gatherRegistries(GatherDataRegistryEntriesEvent event) {
        event.add(Registries.CONTEXT_INT_PROVIDER, ModContextIntProviders::bootstrap)
                .recipe(ModRecipeProvider::new);
    }
}