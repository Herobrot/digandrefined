package com.herobrot.digandrefined.registry;

import com.herobrot.digandrefined.DigandRefined;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DigandRefined.MODID);

    // Hierro
    public static final DeferredItem<Item> IMPURE_RAW_IRON = ITEMS.registerSimpleItem("impure_raw_iron");
    public static final DeferredItem<Item> PURE_RAW_IRON = ITEMS.registerSimpleItem("pure_raw_iron");
    public static final DeferredItem<Item> IMPURE_IRON_INGOT = ITEMS.registerSimpleItem("impure_iron_ingot");
    public static final DeferredItem<Item> PURE_IRON_INGOT = ITEMS.registerSimpleItem("pure_iron_ingot");

    // Cobre
    public static final DeferredItem<Item> IMPURE_RAW_COPPER = ITEMS.registerSimpleItem("impure_raw_copper");
    public static final DeferredItem<Item> PURE_RAW_COPPER = ITEMS.registerSimpleItem("pure_raw_copper");
    public static final DeferredItem<Item> IMPURE_COPPER_INGOT = ITEMS.registerSimpleItem("impure_copper_ingot");
    public static final DeferredItem<Item> PURE_COPPER_INGOT = ITEMS.registerSimpleItem("pure_copper_ingot");

    // Oro
    public static final DeferredItem<Item> IMPURE_RAW_GOLD = ITEMS.registerSimpleItem("impure_raw_gold");
    public static final DeferredItem<Item> PURE_RAW_GOLD = ITEMS.registerSimpleItem("pure_raw_gold");
    public static final DeferredItem<Item> IMPURE_GOLD_INGOT = ITEMS.registerSimpleItem("impure_gold_ingot");
    public static final DeferredItem<Item> PURE_GOLD_INGOT = ITEMS.registerSimpleItem("pure_gold_ingot");

    // Carbón
    public static final DeferredItem<Item> IMPURE_COAL = ITEMS.registerSimpleItem("impure_coal");
    public static final DeferredItem<Item> PURE_COAL = ITEMS.registerSimpleItem("pure_coal");

    // Diamante
    public static final DeferredItem<Item> IMPURE_DIAMOND = ITEMS.registerSimpleItem("impure_diamond");
    public static final DeferredItem<Item> PURE_DIAMOND = ITEMS.registerSimpleItem("pure_diamond");
}