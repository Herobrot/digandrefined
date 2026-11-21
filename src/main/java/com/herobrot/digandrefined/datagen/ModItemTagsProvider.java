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
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jetbrains.annotations.NotNull;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, DigandRefined.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModTags.IMPURE_RAW_IRON).add(ModItems.IMPURE_RAW_IRON.key());
        tag(ModTags.PURE_RAW_IRON).add(ModItems.PURE_RAW_IRON.key());
        tag(ItemTags.TRIM_MATERIALS).add(ModItems.IMPURE_IRON_INGOT.key());
        tag(ModTags.IMPURE_IRON_INGOT).add(ModItems.IMPURE_IRON_INGOT.key());
        tag(ItemTags.TRIM_MATERIALS).add(ModItems.PURE_IRON_INGOT.key());
        tag(ModTags.PURE_IRON_INGOT).add(ModItems.PURE_IRON_INGOT.key());

        tag(ModTags.ROUGH_COPPER).add(ModItems.ROUGH_COPPER.key());
        tag(ModTags.PURE_RAW_COPPER).add(ModItems.PURE_RAW_COPPER.key());
        tag(ItemTags.TRIM_MATERIALS).add(ModItems.IMPURE_COPPER_INGOT.key());
        tag(ModTags.IMPURE_COPPER_INGOT).add(ModItems.IMPURE_COPPER_INGOT.key());
        tag(ItemTags.TRIM_MATERIALS).add(ModItems.PURE_COPPER_INGOT.key());
        tag(ModTags.PURE_COPPER_INGOT).add(ModItems.PURE_COPPER_INGOT.key());

        tag(ModTags.IMPURE_RAW_GOLD).add(ModItems.IMPURE_RAW_GOLD.key());
        tag(ModTags.PURE_RAW_GOLD).add(ModItems.PURE_RAW_GOLD.key());
        tag(ItemTags.TRIM_MATERIALS).add(ModItems.IMPURE_GOLD_INGOT.key());
        tag(ModTags.IMPURE_GOLD_INGOT).add(ModItems.IMPURE_GOLD_INGOT.key());
        tag(ItemTags.TRIM_MATERIALS).add(ModItems.PURE_GOLD_INGOT.key());
        tag(ModTags.PURE_GOLD_INGOT).add(ModItems.PURE_GOLD_INGOT.key());

        tag(ModTags.IMPURE_COAL).add(ModItems.IMPURE_COAL.key());
        tag(ModTags.PURE_COAL).add(ModItems.PURE_COAL.key());

        tag(ItemTags.TRIM_MATERIALS).add(ModItems.IMPURE_DIAMOND.key());
        tag(ModTags.IMPURE_DIAMOND).add(ModItems.IMPURE_DIAMOND.key());
        tag(ItemTags.TRIM_MATERIALS).add(ModItems.PURE_DIAMOND.key());
        tag(ModTags.PURE_DIAMOND).add(ModItems.PURE_DIAMOND.key());

        for (GradedMetal metal : GradedMetal.values()) {
            for (Grade grade : Grade.values()) {
                ToolSet tools = ModItems.tools(metal, grade);
                tag(ItemTags.PICKAXES).add(tools.pickaxe().key());
                tag(ItemTags.AXES).add(tools.axe().key());
                tag(ItemTags.SHOVELS).add(tools.shovel().key());
                tag(ItemTags.HOES).add(tools.hoe().key());
                tag(ItemTags.SWORDS).add(tools.sword().key());
                tag(ItemTags.SPEARS).add(tools.spear().key());

                ArmorSet armor = ModItems.armor(metal, grade);
                tag(ItemTags.HEAD_ARMOR).add(armor.helmet().key());
                tag(ItemTags.CHEST_ARMOR).add(armor.chestplate().key());
                tag(ItemTags.LEG_ARMOR).add(armor.leggings().key());
                tag(ItemTags.FOOT_ARMOR).add(armor.boots().key());
                tag(ItemTags.TRIMMABLE_ARMOR).add(armor.helmet().key());
                tag(ItemTags.TRIMMABLE_ARMOR).add(armor.chestplate().key());
                tag(ItemTags.TRIMMABLE_ARMOR).add(armor.leggings().key());
                tag(ItemTags.TRIMMABLE_ARMOR).add(armor.boots().key());
            }
        }
    }
}