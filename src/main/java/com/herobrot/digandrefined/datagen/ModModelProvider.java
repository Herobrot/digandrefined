package com.herobrot.digandrefined.datagen;

import com.herobrot.digandrefined.DigandRefined;
import com.herobrot.digandrefined.item.ArmorSet;
import com.herobrot.digandrefined.item.Grade;
import com.herobrot.digandrefined.item.GradedMetal;
import com.herobrot.digandrefined.item.ToolSet;
import com.herobrot.digandrefined.registry.ModItems;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.trim.TrimMaterials;
import net.neoforged.neoforge.client.model.item.TrimmedArmorModel.PaletteTransform;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, DigandRefined.MODID);
    }

    @Override
    protected void registerModels(@NotNull BlockModelGenerators blockModels, @NotNull ItemModelGenerators itemModels) {
        flat(itemModels, ModItems.IMPURE_COAL, ModItems.PURE_COAL,
                ModItems.IMPURE_RAW_IRON, ModItems.PURE_RAW_IRON,
                ModItems.IMPURE_IRON_INGOT, ModItems.PURE_IRON_INGOT,
                ModItems.ROUGH_COPPER, ModItems.PURE_RAW_COPPER,
                ModItems.IMPURE_COPPER_INGOT, ModItems.PURE_COPPER_INGOT,
                ModItems.IMPURE_RAW_GOLD, ModItems.PURE_RAW_GOLD,
                ModItems.IMPURE_GOLD_INGOT, ModItems.PURE_GOLD_INGOT,
                ModItems.IMPURE_DIAMOND, ModItems.PURE_DIAMOND);

        for (GradedMetal metal : GradedMetal.values())
            for (Grade grade : Grade.values()) {
                ToolSet tools = ModItems.tools(metal, grade);
                itemModels.generateFlatItem(tools.pickaxe().get(), ModelTemplates.FLAT_HANDHELD_ITEM);
                itemModels.generateFlatItem(tools.axe().get(), ModelTemplates.FLAT_HANDHELD_ITEM);
                itemModels.generateFlatItem(tools.shovel().get(), ModelTemplates.FLAT_HANDHELD_ITEM);
                itemModels.generateFlatItem(tools.hoe().get(), ModelTemplates.FLAT_HANDHELD_ITEM);
                itemModels.generateFlatItem(tools.sword().get(), ModelTemplates.FLAT_HANDHELD_ITEM);
                itemModels.generateSpear(tools.spear().get());

                ArmorSet armor = ModItems.armor(metal, grade);
                itemModels.createFlatItemModel(armor.helmet().get(), ModelTemplates.FLAT_ITEM);
                itemModels.createFlatItemModel(armor.chestplate().get(), ModelTemplates.FLAT_ITEM);
                itemModels.createFlatItemModel(armor.leggings().get(), ModelTemplates.FLAT_ITEM);
                itemModels.createFlatItemModel(armor.boots().get(), ModelTemplates.FLAT_ITEM);
                itemModels.generateDynamicTrimmableArmorSet(armor.helmet().get(), armor.chestplate().get(),
                        armor.leggings().get(), armor.boots().get(), trimTransform(metal));
            }
    }

    @SafeVarargs
    private static void flat(ItemModelGenerators itemModels, DeferredItem<@NotNull Item>... items) {
        for (var item : items) itemModels.generateFlatItem(item.get(), ModelTemplates.FLAT_ITEM);
    }

    private static PaletteTransform trimTransform(GradedMetal metal) {
        return switch (metal) {
            case COPPER -> new PaletteTransform(TrimMaterials.Palette.COPPER, TrimMaterials.Palette.COPPER_DARKER);
            case IRON -> new PaletteTransform(TrimMaterials.Palette.IRON, TrimMaterials.Palette.IRON_DARKER);
            case GOLD -> new PaletteTransform(TrimMaterials.Palette.GOLD, TrimMaterials.Palette.GOLD_DARKER);
            case DIAMOND -> new PaletteTransform(TrimMaterials.Palette.DIAMOND, TrimMaterials.Palette.DIAMOND_DARKER);
        };
    }
}