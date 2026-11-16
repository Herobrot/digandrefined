package com.herobrot.digandrefined.datagen;

import com.herobrot.digandrefined.DigandRefined;
import com.herobrot.digandrefined.item.Grade;
import com.herobrot.digandrefined.item.GradedMetal;
import com.herobrot.digandrefined.item.ToolSet;
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
            addItem(ModItems.IMPURE_COAL, "Carbón impuro");
            addItem(ModItems.PURE_COAL, "Carbón puro");
            addItem(ModItems.IMPURE_RAW_IRON, "Hierro en bruto impuro");
            addItem(ModItems.PURE_RAW_IRON, "Hierro en bruto puro");
            addItem(ModItems.IMPURE_IRON_INGOT, "Lingote de hierro impuro");
            tools(ModItems.tools(GradedMetal.IRON, Grade.IMPURE), "Pico de hierro impuro", "Hacha de hierro impura", "Pala de hierro impura", "Azada de hierro impura", "Espada de hierro impura");
            addItem(ModItems.PURE_IRON_INGOT, "Lingote de hierro puro");
            tools(ModItems.tools(GradedMetal.IRON, Grade.PURE), "Pico de hierro puro", "Hacha de hierro pura", "Pala de hierro pura", "Azada de hierro pura", "Espada de hierro pura");
            addItem(ModItems.IMPURE_RAW_COPPER, "Cobre en bruto impuro");
            addItem(ModItems.PURE_RAW_COPPER, "Cobre en bruto puro");
            addItem(ModItems.IMPURE_COPPER_INGOT, "Lingote de cobre impuro");
            addItem(ModItems.PURE_COPPER_INGOT, "Lingote de cobre puro");
            addItem(ModItems.IMPURE_RAW_GOLD, "Oro en bruto impuro");
            addItem(ModItems.PURE_RAW_GOLD, "Oro en bruto puro");
            addItem(ModItems.IMPURE_GOLD_INGOT, "Lingote de oro impuro");
            tools(ModItems.tools(GradedMetal.GOLD, Grade.IMPURE), "Pico de oro impuro", "Hacha de oro impura", "Pala de oro impura", "Azada de oro impura", "Espada de oro impura");
            addItem(ModItems.PURE_GOLD_INGOT, "Lingote de oro puro");
            tools(ModItems.tools(GradedMetal.GOLD, Grade.PURE), "Pico de oro puro", "Hacha de oro pura", "Pala de oro pura", "Azada de oro pura", "Espada de oro pura");
            addItem(ModItems.IMPURE_DIAMOND, "Diamante impuro");
            tools(ModItems.tools(GradedMetal.DIAMOND, Grade.IMPURE), "Pico de diamante impuro", "Hacha de diamante impura", "Pala de diamante impura", "Azada de diamante impura", "Espada de diamante impura");
            addItem(ModItems.PURE_DIAMOND, "Diamante puro");
            tools(ModItems.tools(GradedMetal.DIAMOND, Grade.PURE), "Pico de diamante puro", "Hacha de diamante pura", "Pala de diamante pura", "Azada de diamante pura", "Espada de diamante pura");
        } else {
            addItem(ModItems.IMPURE_COAL, "Impure Coal");
            addItem(ModItems.PURE_COAL, "Pure Coal");
            addItem(ModItems.IMPURE_RAW_IRON, "Impure Raw Iron");
            addItem(ModItems.PURE_RAW_IRON, "Pure Raw Iron");
            addItem(ModItems.IMPURE_IRON_INGOT, "Impure Iron Ingot");
            tools(ModItems.tools(GradedMetal.IRON, Grade.IMPURE), "Impure Iron Pickaxe", "Impure Iron Axe", "Impure Iron Shovel", "Impure Iron Hoe", "Impure Iron Sword");
            addItem(ModItems.PURE_IRON_INGOT, "Pure Iron Ingot");
            tools(ModItems.tools(GradedMetal.IRON, Grade.PURE), "Pure Iron Pickaxe", "Pure Iron Axe", "Pure Iron Shovel", "Pure Iron Hoe", "Pure Iron Sword");
            addItem(ModItems.IMPURE_RAW_COPPER, "Impure Raw Copper");
            addItem(ModItems.PURE_RAW_COPPER, "Pure Raw Copper");
            addItem(ModItems.IMPURE_COPPER_INGOT, "Impure Copper Ingot");
            addItem(ModItems.PURE_COPPER_INGOT, "Pure Copper Ingot");
            addItem(ModItems.IMPURE_RAW_GOLD, "Impure Raw Gold");
            addItem(ModItems.PURE_RAW_GOLD, "Pure Raw Gold");
            addItem(ModItems.IMPURE_GOLD_INGOT, "Impure Gold Ingot");
            tools(ModItems.tools(GradedMetal.GOLD, Grade.IMPURE), "Impure Golden Pickaxe", "Impure Golden Axe", "Impure Golden Shovel", "Impure Golden Hoe", "Impure Golden Sword");
            addItem(ModItems.PURE_GOLD_INGOT, "Pure Gold Ingot");
            tools(ModItems.tools(GradedMetal.GOLD, Grade.PURE), "Pure Golden Pickaxe", "Pure Golden Axe", "Pure Golden Shovel", "Pure Golden Hoe", "Pure Golden Sword");
            addItem(ModItems.IMPURE_DIAMOND, "Impure Diamond");
            tools(ModItems.tools(GradedMetal.DIAMOND, Grade.IMPURE), "Impure Diamond Pickaxe", "Impure Diamond Axe", "Impure Diamond Shovel", "Impure Diamond Hoe", "Impure Diamond Sword");
            addItem(ModItems.PURE_DIAMOND, "Pure Diamond");
            tools(ModItems.tools(GradedMetal.DIAMOND, Grade.PURE), "Pure Diamond Pickaxe", "Pure Diamond Axe", "Pure Diamond Shovel", "Pure Diamond Hoe", "Pure Diamond Sword");
        }
    }

    private void tools(ToolSet set, String pickaxe, String axe, String shovel, String hoe, String sword) {
        addItem(set.pickaxe(), pickaxe);
        addItem(set.axe(), axe);
        addItem(set.shovel(), shovel);
        addItem(set.hoe(), hoe);
        addItem(set.sword(), sword);
    }
}