package com.herobrot.digandrefined.datagen;

import com.herobrot.digandrefined.DigandRefined;
import com.herobrot.digandrefined.registry.ModItems;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    private final String lang;

    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, DigandRefined.MODID, locale);
        this.lang = locale;
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + DigandRefined.MODID, "Dig and Refined");

        if (lang.equals("es_es")) {
            addItem(ModItems.IMPURE_RAW_IRON, "Hierro en bruto impuro");
            addItem(ModItems.PURE_RAW_IRON, "Hierro en bruto puro");
            addItem(ModItems.IMPURE_IRON_INGOT, "Lingote de hierro impuro");
            addItem(ModItems.PURE_IRON_INGOT, "Lingote de hierro puro");
            addItem(ModItems.IMPURE_RAW_COPPER, "Cobre en bruto impuro");
            addItem(ModItems.PURE_RAW_COPPER, "Cobre en bruto puro");
            addItem(ModItems.IMPURE_COPPER_INGOT, "Lingote de cobre impuro");
            addItem(ModItems.PURE_COPPER_INGOT, "Lingote de cobre puro");
            addItem(ModItems.IMPURE_RAW_GOLD, "Oro en bruto impuro");
            addItem(ModItems.PURE_RAW_GOLD, "Oro en bruto puro");
            addItem(ModItems.IMPURE_GOLD_INGOT, "Lingote de oro impuro");
            addItem(ModItems.PURE_GOLD_INGOT, "Lingote de oro puro");
            addItem(ModItems.IMPURE_COAL, "Carbón impuro");
            addItem(ModItems.PURE_COAL, "Carbón puro");
            addItem(ModItems.IMPURE_DIAMOND, "Diamante impuro");
            addItem(ModItems.PURE_DIAMOND, "Diamante puro");
        } else {
            addItem(ModItems.IMPURE_RAW_IRON, "Impure Raw Iron");
            addItem(ModItems.PURE_RAW_IRON, "Pure Raw Iron");
            addItem(ModItems.IMPURE_IRON_INGOT, "Impure Iron Ingot");
            addItem(ModItems.PURE_IRON_INGOT, "Pure Iron Ingot");
            addItem(ModItems.IMPURE_RAW_COPPER, "Impure Raw Copper");
            addItem(ModItems.PURE_RAW_COPPER, "Pure Raw Copper");
            addItem(ModItems.IMPURE_COPPER_INGOT, "Impure Copper Ingot");
            addItem(ModItems.PURE_COPPER_INGOT, "Pure Copper Ingot");
            addItem(ModItems.IMPURE_RAW_GOLD, "Impure Raw Gold");
            addItem(ModItems.PURE_RAW_GOLD, "Pure Raw Gold");
            addItem(ModItems.IMPURE_GOLD_INGOT, "Impure Gold Ingot");
            addItem(ModItems.PURE_GOLD_INGOT, "Pure Gold Ingot");
            addItem(ModItems.IMPURE_COAL, "Impure Coal");
            addItem(ModItems.PURE_COAL, "Pure Coal");
            addItem(ModItems.IMPURE_DIAMOND, "Impure Diamond");
            addItem(ModItems.PURE_DIAMOND, "Pure Diamond");
        }
    }
}