package com.herobrot.digandrefined.datagen;

import com.herobrot.digandrefined.DigandRefined;
import com.herobrot.digandrefined.registry.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.TieredItem;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DigandRefined.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModItems.ITEMS.getEntries().forEach(entry -> {
            String name = entry.getId().getPath();
            String vanillaName = name.replaceFirst("^(impure|pure)_", "");
            String parent = entry.get() instanceof TieredItem ? "item/handheld" : "item/generated";
            withExistingParent(name, parent)
                    .texture("layer0", ResourceLocation.withDefaultNamespace("item/" + vanillaName));
        });
    }
}