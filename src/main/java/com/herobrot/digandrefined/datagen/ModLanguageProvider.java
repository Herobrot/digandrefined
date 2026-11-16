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
            addItem(ModItems.IMPURE_COAL, "Carbón impuro");
            addItem(ModItems.PURE_COAL, "Carbón puro");
            addItem(ModItems.IMPURE_RAW_IRON, "Hierro en bruto impuro");
            addItem(ModItems.PURE_RAW_IRON, "Hierro en bruto puro");
            addItem(ModItems.IMPURE_IRON_INGOT, "Lingote de hierro impuro");
            addItem(ModItems.PURE_IRON_INGOT, "Lingote de hierro puro");
            addItem(ModItems.IMPURE_IRON_PICKAXE, "Pico de hierro impuro");
            addItem(ModItems.PURE_IRON_PICKAXE, "Pico de hierro puro");
            addItem(ModItems.IMPURE_RAW_COPPER, "Cobre en bruto impuro");
            addItem(ModItems.PURE_RAW_COPPER, "Cobre en bruto puro");
            addItem(ModItems.IMPURE_COPPER_INGOT, "Lingote de cobre impuro");
            addItem(ModItems.PURE_COPPER_INGOT, "Lingote de cobre puro");
            addItem(ModItems.IMPURE_RAW_GOLD, "Oro en bruto impuro");
            addItem(ModItems.PURE_RAW_GOLD, "Oro en bruto puro");
            addItem(ModItems.IMPURE_GOLD_INGOT, "Lingote de oro impuro");
            addItem(ModItems.PURE_GOLD_INGOT, "Lingote de oro puro");
            addItem(ModItems.IMPURE_GOLD_PICKAXE, "Pico de oro impuro");
            addItem(ModItems.PURE_GOLD_PICKAXE, "Pico de oro puro");
            addItem(ModItems.IMPURE_DIAMOND, "Diamante impuro");
            addItem(ModItems.PURE_DIAMOND, "Diamante puro");
            addItem(ModItems.IMPURE_DIAMOND_PICKAXE, "Pico de diamante impuro");
            addItem(ModItems.PURE_DIAMOND_PICKAXE, "Pico de diamante puro");
            addItem(ModItems.IMPURE_IRON_AXE, "Hacha de hierro impura");
            addItem(ModItems.PURE_IRON_AXE, "Hacha de hierro pura");
            addItem(ModItems.IMPURE_GOLDEN_AXE, "Hacha de oro impura");
            addItem(ModItems.PURE_GOLDEN_AXE, "Hacha de oro pura");
            addItem(ModItems.IMPURE_DIAMOND_AXE, "Hacha de diamante impura");
            addItem(ModItems.PURE_DIAMOND_AXE, "Hacha de diamante pura");
            addItem(ModItems.IMPURE_IRON_SHOVEL, "Pala de hierro impura");
            addItem(ModItems.PURE_IRON_SHOVEL, "Pala de hierro pura");
            addItem(ModItems.IMPURE_GOLDEN_SHOVEL, "Pala de oro impura");
            addItem(ModItems.PURE_GOLDEN_SHOVEL, "Pala de oro pura");
            addItem(ModItems.IMPURE_DIAMOND_SHOVEL, "Pala de diamante impura");
            addItem(ModItems.PURE_DIAMOND_SHOVEL, "Pala de diamante pura");
            addItem(ModItems.IMPURE_IRON_HOE, "Azada de hierro impura");
            addItem(ModItems.PURE_IRON_HOE, "Azada de hierro pura");
            addItem(ModItems.IMPURE_GOLDEN_HOE, "Azada de oro impura");
            addItem(ModItems.PURE_GOLDEN_HOE, "Azada de oro pura");
            addItem(ModItems.IMPURE_DIAMOND_HOE, "Azada de diamante impura");
            addItem(ModItems.PURE_DIAMOND_HOE, "Azada de diamante pura");
            addItem(ModItems.IMPURE_IRON_SWORD, "Espada de hierro impura");
            addItem(ModItems.PURE_IRON_SWORD, "Espada de hierro pura");
            addItem(ModItems.IMPURE_GOLDEN_SWORD, "Espada de oro impura");
            addItem(ModItems.PURE_GOLDEN_SWORD, "Espada de oro pura");
            addItem(ModItems.IMPURE_DIAMOND_SWORD, "Espada de diamante impura");
            addItem(ModItems.PURE_DIAMOND_SWORD, "Espada de diamante pura");
        } else {
            addItem(ModItems.IMPURE_COAL, "Impure Coal");
            addItem(ModItems.PURE_COAL, "Pure Coal");
            addItem(ModItems.IMPURE_RAW_IRON, "Impure Raw Iron");
            addItem(ModItems.PURE_RAW_IRON, "Pure Raw Iron");
            addItem(ModItems.IMPURE_IRON_INGOT, "Impure Iron Ingot");
            addItem(ModItems.PURE_IRON_INGOT, "Pure Iron Ingot");
            addItem(ModItems.IMPURE_IRON_PICKAXE, "Impure Iron Pickaxe");
            addItem(ModItems.PURE_IRON_PICKAXE, "Pure Iron Pickaxe");
            addItem(ModItems.IMPURE_RAW_COPPER, "Impure Raw Copper");
            addItem(ModItems.PURE_RAW_COPPER, "Pure Raw Copper");
            addItem(ModItems.IMPURE_COPPER_INGOT, "Impure Copper Ingot");
            addItem(ModItems.PURE_COPPER_INGOT, "Pure Copper Ingot");
            addItem(ModItems.IMPURE_RAW_GOLD, "Impure Raw Gold");
            addItem(ModItems.PURE_RAW_GOLD, "Pure Raw Gold");
            addItem(ModItems.IMPURE_GOLD_INGOT, "Impure Gold Ingot");
            addItem(ModItems.PURE_GOLD_INGOT, "Pure Gold Ingot");
            addItem(ModItems.IMPURE_GOLD_PICKAXE, "Impure Golden Pickaxe");
            addItem(ModItems.PURE_GOLD_PICKAXE, "Pure Golden Pickaxe");
            addItem(ModItems.IMPURE_DIAMOND, "Impure Diamond");
            addItem(ModItems.PURE_DIAMOND, "Pure Diamond");
            addItem(ModItems.IMPURE_DIAMOND_PICKAXE, "Impure Diamond Pickaxe");
            addItem(ModItems.PURE_DIAMOND_PICKAXE, "Pure Diamond Pickaxe");
            addItem(ModItems.IMPURE_IRON_AXE, "Impure Iron Axe");
            addItem(ModItems.PURE_IRON_AXE, "Pure Iron Axe");
            addItem(ModItems.IMPURE_GOLDEN_AXE, "Impure Golden Axe");
            addItem(ModItems.PURE_GOLDEN_AXE, "Pure Golden Axe");
            addItem(ModItems.IMPURE_DIAMOND_AXE, "Impure Diamond Axe");
            addItem(ModItems.PURE_DIAMOND_AXE, "Pure Diamond Axe");
            addItem(ModItems.IMPURE_IRON_SHOVEL, "Impure Iron Shovel");
            addItem(ModItems.PURE_IRON_SHOVEL, "Pure Iron Shovel");
            addItem(ModItems.IMPURE_GOLDEN_SHOVEL, "Impure Golden Shovel");
            addItem(ModItems.PURE_GOLDEN_SHOVEL, "Pure Golden Shovel");
            addItem(ModItems.IMPURE_DIAMOND_SHOVEL, "Impure Diamond Shovel");
            addItem(ModItems.PURE_DIAMOND_SHOVEL, "Pure Diamond Shovel");
            addItem(ModItems.IMPURE_IRON_HOE, "Impure Iron Hoe");
            addItem(ModItems.PURE_IRON_HOE, "Pure Iron Hoe");
            addItem(ModItems.IMPURE_GOLDEN_HOE, "Impure Golden Hoe");
            addItem(ModItems.PURE_GOLDEN_HOE, "Pure Golden Hoe");
            addItem(ModItems.IMPURE_DIAMOND_HOE, "Impure Diamond Hoe");
            addItem(ModItems.PURE_DIAMOND_HOE, "Pure Diamond Hoe");
            addItem(ModItems.IMPURE_IRON_SWORD, "Impure Iron Sword");
            addItem(ModItems.PURE_IRON_SWORD, "Pure Iron Sword");
            addItem(ModItems.IMPURE_GOLDEN_SWORD, "Impure Golden Sword");
            addItem(ModItems.PURE_GOLDEN_SWORD, "Pure Golden Sword");
            addItem(ModItems.IMPURE_DIAMOND_SWORD, "Impure Diamond Sword");
            addItem(ModItems.PURE_DIAMOND_SWORD, "Pure Diamond Sword");
        }
    }
}