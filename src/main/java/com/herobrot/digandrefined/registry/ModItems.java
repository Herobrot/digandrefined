package com.herobrot.digandrefined.registry;

import com.herobrot.digandrefined.DigandRefined;
import com.herobrot.digandrefined.item.GradedTier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DigandRefined.MODID);

    // Carbón
    public static final DeferredItem<Item> IMPURE_COAL = ITEMS.registerSimpleItem("impure_coal");
    public static final DeferredItem<Item> PURE_COAL = ITEMS.registerSimpleItem("pure_coal");

    // Hierro
    public static final DeferredItem<Item> IMPURE_RAW_IRON = ITEMS.registerSimpleItem("impure_raw_iron");
    public static final DeferredItem<Item> PURE_RAW_IRON = ITEMS.registerSimpleItem("pure_raw_iron");
    public static final DeferredItem<Item> IMPURE_IRON_INGOT = ITEMS.registerSimpleItem("impure_iron_ingot");
    public static final DeferredItem<Item> PURE_IRON_INGOT = ITEMS.registerSimpleItem("pure_iron_ingot");
    public static final DeferredItem<PickaxeItem> IMPURE_IRON_PICKAXE = pickaxe("impure_iron_pickaxe", ModTiers.IMPURE_IRON);
    public static final DeferredItem<PickaxeItem> PURE_IRON_PICKAXE = pickaxe("pure_iron_pickaxe", ModTiers.PURE_IRON);

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
    public static final DeferredItem<PickaxeItem> IMPURE_GOLD_PICKAXE = pickaxe("impure_golden_pickaxe", ModTiers.IMPURE_GOLD);
    public static final DeferredItem<PickaxeItem> PURE_GOLD_PICKAXE = pickaxe("pure_golden_pickaxe", ModTiers.PURE_GOLD);

    // Diamante
    public static final DeferredItem<Item> IMPURE_DIAMOND = ITEMS.registerSimpleItem("impure_diamond");
    public static final DeferredItem<Item> PURE_DIAMOND = ITEMS.registerSimpleItem("pure_diamond");
    public static final DeferredItem<PickaxeItem> IMPURE_DIAMOND_PICKAXE = pickaxe("impure_diamond_pickaxe", ModTiers.IMPURE_DIAMOND);
    public static final DeferredItem<PickaxeItem> PURE_DIAMOND_PICKAXE = pickaxe("pure_diamond_pickaxe", ModTiers.PURE_DIAMOND);

    private static DeferredItem<PickaxeItem> pickaxe(String name, GradedTier tier) {
        return ITEMS.registerItem(name, props -> new PickaxeItem(
                tier, props.attributes(PickaxeItem.createAttributes(
                        tier, tier.scaledBaseDamage(1.0f), -2.8f))));
    }
}