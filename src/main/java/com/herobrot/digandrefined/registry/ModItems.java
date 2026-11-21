package com.herobrot.digandrefined.registry;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.UnaryOperator;

import com.herobrot.digandrefined.DigandRefined;
import com.herobrot.digandrefined.item.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DigandRefined.MODID);

    // Carbón
    public static final DeferredItem<@NotNull Item> IMPURE_COAL = fuel("impure_coal", ModContextIntProviders.IMPURE_COAL_TIME);
    public static final DeferredItem<@NotNull Item> PURE_COAL = fuel("pure_coal", ModContextIntProviders.PURE_COAL_TIME);

    // Hierro
    public static final DeferredItem<@NotNull Item> IMPURE_RAW_IRON = simple("impure_raw_iron");
    public static final DeferredItem<@NotNull Item> PURE_RAW_IRON = simple("pure_raw_iron");
    public static final DeferredItem<@NotNull Item> IMPURE_IRON_INGOT = trimMaterial("impure_iron_ingot", TrimMaterials.IRON);
    public static final DeferredItem<@NotNull Item> PURE_IRON_INGOT = trimMaterial("pure_iron_ingot", TrimMaterials.IRON);

    // Cobre
    public static final DeferredItem<@NotNull Item> ROUGH_COPPER = simple("rough_copper");
    public static final DeferredItem<@NotNull Item> PURE_RAW_COPPER = simple("pure_raw_copper");
    public static final DeferredItem<@NotNull Item> IMPURE_COPPER_INGOT = trimMaterial("impure_copper_ingot", TrimMaterials.COPPER);
    public static final DeferredItem<@NotNull Item> PURE_COPPER_INGOT = trimMaterial("pure_copper_ingot", TrimMaterials.COPPER);

    // Oro
    public static final DeferredItem<@NotNull Item> IMPURE_RAW_GOLD = simple("impure_raw_gold");
    public static final DeferredItem<@NotNull Item> PURE_RAW_GOLD = simple("pure_raw_gold");
    public static final DeferredItem<@NotNull Item> IMPURE_GOLD_INGOT = trimMaterial("impure_gold_ingot", TrimMaterials.GOLD);
    public static final DeferredItem<@NotNull Item> PURE_GOLD_INGOT = trimMaterial("pure_gold_ingot", TrimMaterials.GOLD);

    // Diamante
    public static final DeferredItem<@NotNull Item> IMPURE_DIAMOND = trimMaterial("impure_diamond", TrimMaterials.DIAMOND);
    public static final DeferredItem<@NotNull Item> PURE_DIAMOND = trimMaterial("pure_diamond", TrimMaterials.DIAMOND);

    // Equipamiento (material -> grado -> herramientas -> armadura)
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

    private static DeferredItem<@NotNull Item> simple(String name) {
        return ITEMS.registerSimpleItem(name);
    }

    private static DeferredItem<@NotNull Item> item(String name, UnaryOperator<Item.Properties> setup) {
        return ITEMS.registerItem(name, Item::new, setup);
    }

    private static DeferredItem<@NotNull Item> fuel(String name, ResourceKey<ContextIntProvider> burnTime) {
        return item(name, props -> props.cookingFuel(burnTime));
    }

    // LOOORD, MOJANG, MASTER OF PROGRAMAR MAL AAAAAAAAAAAAA
    private static DeferredItem<@NotNull Item> spear(String name, GradedMetal metal, Grade grade, ToolMaterial material) {
        SpearStats s = metal.spear();
        double damage = GradedMaterials.scaledBaseDamage(material, grade, 0.0f) + material.attackDamageBonus();
        double speed = 1.0 / s.attackDuration() - 4.0;
        return item(name, props -> props.spear(material, s.attackDuration(), s.damageMultiplier(),
                        s.delay(), s.dismountTime(), s.dismountThreshold(), s.knockbackTime(),
                        s.knockbackThreshold(), s.damageTime(), s.damageThreshold())
                .attributes(ItemAttributeModifiers.builder()
                        .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID,
                                damage, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                        .add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID,
                                speed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                        .build())
        );
    }

    private static ToolSet createToolSet(GradedMetal metal, Grade grade) {
        ToolMaterial material = GradedMaterials.tool(metal, grade);
        String prefix = grade.id() + "_" + metal.gearName() + "_";
        return new ToolSet(
                item(prefix + "pickaxe", props -> props.pickaxe(material,
                        GradedMaterials.scaledBaseDamage(material, grade, 1.0f), -2.8f)),
                item(prefix + "axe", props -> props.axe(material,
                        GradedMaterials.scaledBaseDamage(material, grade, metal.axeDamage()), metal.axeSpeed())),
                item(prefix + "shovel", props -> props.shovel(material,
                        GradedMaterials.scaledBaseDamage(material, grade, 1.5f), -3.0f)),
                item(prefix + "hoe", props -> props.hoe(material,
                        GradedMaterials.scaledBaseDamage(material, grade, metal.hoeDamage()), metal.hoeSpeed())),
                item(prefix + "sword", props -> props.sword(material,
                        GradedMaterials.scaledBaseDamage(material, grade, 3.0f), -2.4f)),
                spear(prefix + "spear", metal, grade, material)
        );
    }

    private static ArmorSet createArmorSet(GradedMetal metal, Grade grade) {
        ArmorMaterial material = GradedMaterials.armor(metal, grade);
        String prefix = grade.id() + "_" + metal.gearName() + "_";
        return new ArmorSet(
                armorPiece(prefix + "helmet", material, ArmorType.HELMET, metal, grade),
                armorPiece(prefix + "chestplate", material, ArmorType.CHESTPLATE, metal, grade),
                armorPiece(prefix + "leggings", material, ArmorType.LEGGINGS, metal, grade),
                armorPiece(prefix + "boots", material, ArmorType.BOOTS, metal, grade)
        );
    }

    private static DeferredItem<@NotNull Item> armorPiece(String name, ArmorMaterial material, ArmorType type, GradedMetal metal, Grade grade) {
        int durability = grade.scale(type.getDurability(metal.armorBase().durability()));
        return item(name, props -> props.humanoidArmor(material, type).durability(durability));
    }

    private static DeferredItem<@NotNull Item> trimMaterial(String name, ResourceKey<TrimMaterial> material) {
        return item(name, props -> props.trimMaterial(material));
    }
}