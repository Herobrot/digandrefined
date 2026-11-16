package com.herobrot.digandrefined.registry;

import com.herobrot.digandrefined.DigandRefined;
import com.herobrot.digandrefined.item.GradedTier;
import net.minecraft.world.item.*;
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
    public static final DeferredItem<AxeItem> IMPURE_IRON_AXE = axe("impure_iron_axe", ModTiers.IMPURE_IRON, 6.0f, -3.1f);
    public static final DeferredItem<ShovelItem> IMPURE_IRON_SHOVEL = shovel("impure_iron_shovel", ModTiers.IMPURE_IRON);
    public static final DeferredItem<HoeItem> IMPURE_IRON_HOE = hoe("impure_iron_hoe", ModTiers.IMPURE_IRON, -2.0f, -1.0f);
    public static final DeferredItem<SwordItem> IMPURE_IRON_SWORD = sword("impure_iron_sword", ModTiers.IMPURE_IRON);
    public static final DeferredItem<PickaxeItem> PURE_IRON_PICKAXE = pickaxe("pure_iron_pickaxe", ModTiers.PURE_IRON);
    public static final DeferredItem<AxeItem> PURE_IRON_AXE = axe("pure_iron_axe", ModTiers.PURE_IRON, 6.0f, -3.1f);
    public static final DeferredItem<ShovelItem> PURE_IRON_SHOVEL = shovel("pure_iron_shovel", ModTiers.PURE_IRON);
    public static final DeferredItem<HoeItem> PURE_IRON_HOE = hoe("pure_iron_hoe", ModTiers.PURE_IRON, -2.0f, -1.0f);
    public static final DeferredItem<SwordItem> PURE_IRON_SWORD = sword("pure_iron_sword", ModTiers.PURE_IRON);

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
    public static final DeferredItem<AxeItem> IMPURE_GOLDEN_AXE = axe("impure_golden_axe", ModTiers.IMPURE_GOLD, 6.0f, -3.0f);
    public static final DeferredItem<ShovelItem> IMPURE_GOLDEN_SHOVEL = shovel("impure_golden_shovel", ModTiers.IMPURE_GOLD);
    public static final DeferredItem<HoeItem> IMPURE_GOLDEN_HOE = hoe("impure_golden_hoe", ModTiers.IMPURE_GOLD, 0.0f, -3.0f);
    public static final DeferredItem<SwordItem> IMPURE_GOLDEN_SWORD = sword("impure_golden_sword", ModTiers.IMPURE_GOLD);
    public static final DeferredItem<PickaxeItem> PURE_GOLD_PICKAXE = pickaxe("pure_golden_pickaxe", ModTiers.PURE_GOLD);
    public static final DeferredItem<AxeItem> PURE_GOLDEN_AXE = axe("pure_golden_axe", ModTiers.PURE_GOLD, 6.0f, -3.0f);
    public static final DeferredItem<ShovelItem> PURE_GOLDEN_SHOVEL = shovel("pure_golden_shovel", ModTiers.PURE_GOLD);
    public static final DeferredItem<HoeItem> PURE_GOLDEN_HOE = hoe("pure_golden_hoe", ModTiers.PURE_GOLD, 0.0f, -3.0f);
    public static final DeferredItem<SwordItem> PURE_GOLDEN_SWORD = sword("pure_golden_sword", ModTiers.PURE_GOLD);

    // Diamante
    public static final DeferredItem<Item> IMPURE_DIAMOND = ITEMS.registerSimpleItem("impure_diamond");
    public static final DeferredItem<Item> PURE_DIAMOND = ITEMS.registerSimpleItem("pure_diamond");
    public static final DeferredItem<PickaxeItem> IMPURE_DIAMOND_PICKAXE = pickaxe("impure_diamond_pickaxe", ModTiers.IMPURE_DIAMOND);
    public static final DeferredItem<AxeItem> IMPURE_DIAMOND_AXE = axe("impure_diamond_axe", ModTiers.IMPURE_DIAMOND, 5.0f, -3.0f);
    public static final DeferredItem<ShovelItem> IMPURE_DIAMOND_SHOVEL = shovel("impure_diamond_shovel", ModTiers.IMPURE_DIAMOND);
    public static final DeferredItem<HoeItem> IMPURE_DIAMOND_HOE = hoe("impure_diamond_hoe", ModTiers.IMPURE_DIAMOND, -3.0f, 0.0f);
    public static final DeferredItem<SwordItem> IMPURE_DIAMOND_SWORD = sword("impure_diamond_sword", ModTiers.IMPURE_DIAMOND);
    public static final DeferredItem<PickaxeItem> PURE_DIAMOND_PICKAXE = pickaxe("pure_diamond_pickaxe", ModTiers.PURE_DIAMOND);
    public static final DeferredItem<AxeItem> PURE_DIAMOND_AXE = axe("pure_diamond_axe", ModTiers.PURE_DIAMOND, 5.0f, -3.0f);
    public static final DeferredItem<ShovelItem> PURE_DIAMOND_SHOVEL = shovel("pure_diamond_shovel", ModTiers.PURE_DIAMOND);
    public static final DeferredItem<HoeItem> PURE_DIAMOND_HOE = hoe("pure_diamond_hoe", ModTiers.PURE_DIAMOND, -3.0f, 0.0f);
    public static final DeferredItem<SwordItem> PURE_DIAMOND_SWORD = sword("pure_diamond_sword", ModTiers.PURE_DIAMOND);

    private static DeferredItem<PickaxeItem> pickaxe(String name, GradedTier tier) {
        return ITEMS.registerItem(name, props -> new PickaxeItem(
                tier, props.attributes(PickaxeItem.createAttributes(
                tier, tier.scaledBaseDamage(1.0f), -2.8f))));
    }

    private static DeferredItem<AxeItem> axe(String name, GradedTier tier, float vanillaBaseDamage, float attackSpeed) {
        return ITEMS.registerItem(name, props -> new AxeItem(
                tier, props.attributes(AxeItem.createAttributes(
                tier, tier.scaledBaseDamage(vanillaBaseDamage), attackSpeed))));
    }

    private static DeferredItem<ShovelItem> shovel(String name, GradedTier tier) {
        return ITEMS.registerItem(name, props -> new ShovelItem(
                tier, props.attributes(ShovelItem.createAttributes(
                tier, tier.scaledBaseDamage(1.5f), -3.0f))));
    }

    private static DeferredItem<HoeItem> hoe(String name, GradedTier tier, float vanillaBaseDamage, float attackSpeed) {
        return ITEMS.registerItem(name, props -> new HoeItem(
                tier, props.attributes(HoeItem.createAttributes(
                tier, tier.scaledBaseDamage(vanillaBaseDamage), attackSpeed))));
    }

    private static DeferredItem<SwordItem> sword(String name, GradedTier tier) {
        return ITEMS.registerItem(name, props -> new SwordItem(
                tier, props.attributes(SwordItem.createAttributes(
                tier, tier.scaledBaseDamage(3.0f), -2.4f))));
    }
}