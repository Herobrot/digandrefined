package com.herobrot.digandrefined.datagen;

import java.util.concurrent.CompletableFuture;

import com.herobrot.digandrefined.DigandRefined;
import com.herobrot.digandrefined.registry.ModItems;
import com.herobrot.digandrefined.registry.ModTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CompletableFuture.completedFuture(TagsProvider.TagLookup.empty()), DigandRefined.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModTags.IMPURE_RAW_IRON).add(ModItems.IMPURE_RAW_IRON.get());
        tag(ModTags.PURE_RAW_IRON).add(ModItems.PURE_RAW_IRON.get());
        tag(ModTags.IMPURE_IRON_INGOT).add(ModItems.IMPURE_IRON_INGOT.get());
        tag(ModTags.PURE_IRON_INGOT).add(ModItems.PURE_IRON_INGOT.get());

        tag(ModTags.IMPURE_RAW_COPPER).add(ModItems.IMPURE_RAW_COPPER.get());
        tag(ModTags.PURE_RAW_COPPER).add(ModItems.PURE_RAW_COPPER.get());
        tag(ModTags.IMPURE_COPPER_INGOT).add(ModItems.IMPURE_COPPER_INGOT.get());
        tag(ModTags.PURE_COPPER_INGOT).add(ModItems.PURE_COPPER_INGOT.get());

        tag(ModTags.IMPURE_RAW_GOLD).add(ModItems.IMPURE_RAW_GOLD.get());
        tag(ModTags.PURE_RAW_GOLD).add(ModItems.PURE_RAW_GOLD.get());
        tag(ModTags.IMPURE_GOLD_INGOT).add(ModItems.IMPURE_GOLD_INGOT.get());
        tag(ModTags.PURE_GOLD_INGOT).add(ModItems.PURE_GOLD_INGOT.get());

        tag(ModTags.IMPURE_COAL).add(ModItems.IMPURE_COAL.get());
        tag(ModTags.PURE_COAL).add(ModItems.PURE_COAL.get());

        tag(ModTags.IMPURE_DIAMOND).add(ModItems.IMPURE_DIAMOND.get());
        tag(ModTags.PURE_DIAMOND).add(ModItems.PURE_DIAMOND.get());

        tag(ItemTags.PICKAXES)
                .add(ModItems.IMPURE_IRON_PICKAXE.get())
                .add(ModItems.PURE_IRON_PICKAXE.get())
                .add(ModItems.IMPURE_GOLD_PICKAXE.get())
                .add(ModItems.PURE_GOLD_PICKAXE.get())
                .add(ModItems.IMPURE_DIAMOND_PICKAXE.get())
                .add(ModItems.PURE_DIAMOND_PICKAXE.get());

        tag(ItemTags.AXES)
                .add(ModItems.IMPURE_IRON_AXE.get(), ModItems.PURE_IRON_AXE.get())
                .add(ModItems.IMPURE_GOLDEN_AXE.get(), ModItems.PURE_GOLDEN_AXE.get())
                .add(ModItems.IMPURE_DIAMOND_AXE.get(), ModItems.PURE_DIAMOND_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.IMPURE_IRON_SHOVEL.get(), ModItems.PURE_IRON_SHOVEL.get())
                .add(ModItems.IMPURE_GOLDEN_SHOVEL.get(), ModItems.PURE_GOLDEN_SHOVEL.get())
                .add(ModItems.IMPURE_DIAMOND_SHOVEL.get(), ModItems.PURE_DIAMOND_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.IMPURE_IRON_HOE.get(), ModItems.PURE_IRON_HOE.get())
                .add(ModItems.IMPURE_GOLDEN_HOE.get(), ModItems.PURE_GOLDEN_HOE.get())
                .add(ModItems.IMPURE_DIAMOND_HOE.get(), ModItems.PURE_DIAMOND_HOE.get());
        tag(ItemTags.SWORDS)
                .add(ModItems.IMPURE_IRON_SWORD.get(), ModItems.PURE_IRON_SWORD.get())
                .add(ModItems.IMPURE_GOLDEN_SWORD.get(), ModItems.PURE_GOLDEN_SWORD.get())
                .add(ModItems.IMPURE_DIAMOND_SWORD.get(), ModItems.PURE_DIAMOND_SWORD.get());
    }
}