package com.herobrot.digandrefined.registry;

import java.util.EnumMap;
import java.util.Map;

import com.herobrot.digandrefined.DigandRefined;
import com.herobrot.digandrefined.item.ArmorSet;
import com.herobrot.digandrefined.item.Grade;
import com.herobrot.digandrefined.item.GradedMetal;
import com.herobrot.digandrefined.item.GradedTier;
import com.herobrot.digandrefined.item.ToolSet;
import net.minecraft.core.Holder;
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

    // Diamante
    public static final DeferredItem<Item> IMPURE_DIAMOND = ITEMS.registerSimpleItem("impure_diamond");
    public static final DeferredItem<Item> PURE_DIAMOND = ITEMS.registerSimpleItem("pure_diamond");

    private static final Map<GradedMetal, Map<Grade, ToolSet>> TOOLS = new EnumMap<>(GradedMetal.class);
    private static final Map<GradedMetal, Map<Grade, ArmorSet>> ARMOR = new EnumMap<>(GradedMetal.class);

    static {
        for (GradedMetal metal : GradedMetal.values()) {
            Map<Grade, ToolSet> toolsByGrade = new EnumMap<>(Grade.class);
            Map<Grade, ArmorSet> armorByGrade = new EnumMap<>(Grade.class);
            for (Grade grade : Grade.values()) {
                toolsByGrade.put(grade, createToolSet(metal, grade));
                armorByGrade.put(grade, createArmorSet(metal, grade));
            }
            TOOLS.put(metal, toolsByGrade);
            ARMOR.put(metal, armorByGrade);
        }
    }

    public static ToolSet tools(GradedMetal metal, Grade grade) { return TOOLS.get(metal).get(grade); }

    public static ArmorSet armor(GradedMetal metal, Grade grade) { return ARMOR.get(metal).get(grade); }

    private static ToolSet createToolSet(GradedMetal metal, Grade grade) {
        GradedTier tier = new GradedTier(metal.base(), grade, metal.repairTag(grade));
        String prefix = grade.id() + "_" + metal.gearName() + "_";
        return new ToolSet(
                pickaxe(prefix + "pickaxe", tier),
                axe(prefix + "axe", tier, metal.axeDamage(), metal.axeSpeed()),
                shovel(prefix + "shovel", tier),
                hoe(prefix + "hoe", tier, metal.hoeDamage(), metal.hoeSpeed()),
                sword(prefix + "sword", tier)
        );
    }

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

    private static ArmorSet createArmorSet(GradedMetal metal, Grade grade) {
        Holder<ArmorMaterial> material = ModArmorMaterials.get(metal, grade);
        String prefix = grade.id() + "_" + metal.gearName() + "_";
        return new ArmorSet(
                armorPiece(prefix + "helmet", material, ArmorItem.Type.HELMET, metal, grade),
                armorPiece(prefix + "chestplate", material, ArmorItem.Type.CHESTPLATE, metal, grade),
                armorPiece(prefix + "leggings", material, ArmorItem.Type.LEGGINGS, metal, grade),
                armorPiece(prefix + "boots", material, ArmorItem.Type.BOOTS, metal, grade));
    }

    private static DeferredItem<ArmorItem> armorPiece(String name, Holder<ArmorMaterial> material,
                                                      ArmorItem.Type type, GradedMetal metal, Grade grade) {
        int durability = grade.scale(type.getDurability(metal.armorDurabilityFactor()));
        return ITEMS.registerItem(name, props -> new ArmorItem(material, type, props.durability(durability)));
    }
}