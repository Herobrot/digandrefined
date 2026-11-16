package com.herobrot.digandrefined.datagen;

import java.util.concurrent.CompletableFuture;

import com.herobrot.digandrefined.DigandRefined;
import com.herobrot.digandrefined.item.ArmorSet;
import com.herobrot.digandrefined.item.Grade;
import com.herobrot.digandrefined.item.GradedMetal;
import com.herobrot.digandrefined.item.ToolSet;
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

        for (GradedMetal metal : GradedMetal.values())
            for (Grade grade : Grade.values()) {
                ToolSet set = ModItems.tools(metal, grade);
                tag(ItemTags.PICKAXES).add(set.pickaxe().get());
                tag(ItemTags.AXES).add(set.axe().get());
                tag(ItemTags.SHOVELS).add(set.shovel().get());
                tag(ItemTags.HOES).add(set.hoe().get());
                tag(ItemTags.SWORDS).add(set.sword().get());
                ArmorSet armor = ModItems.armor(metal, grade);
                tag(ItemTags.HEAD_ARMOR).add(armor.helmet().get());
                tag(ItemTags.CHEST_ARMOR).add(armor.chestplate().get());
                tag(ItemTags.LEG_ARMOR).add(armor.leggings().get());
                tag(ItemTags.FOOT_ARMOR).add(armor.boots().get());
                tag(ItemTags.TRIMMABLE_ARMOR).add(
                        armor.helmet().get(),
                        armor.chestplate().get(),
                        armor.leggings().get(),
                        armor.boots().get()
                );
            }
    }
}