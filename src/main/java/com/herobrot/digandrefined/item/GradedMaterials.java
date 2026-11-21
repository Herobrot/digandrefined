package com.herobrot.digandrefined.item;

import java.util.EnumMap;
import java.util.Map;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

public final class GradedMaterials {
    private static final float PLAYER_BASE_DAMAGE = 1.0f;
    private static final ArmorType[] PIECES = {
            ArmorType.HELMET, ArmorType.CHESTPLATE, ArmorType.LEGGINGS, ArmorType.BOOTS };

    private GradedMaterials() {}

    public static ToolMaterial tool(GradedMetal metal, Grade grade) {
        ToolMaterial base = metal.toolBase();
        return new ToolMaterial(base.incorrectBlocksForDrops(), grade.scale(base.durability()),
                base.speed() * grade.multiplier(), base.attackDamageBonus(),
                grade.scale(base.enchantmentValue()), metal.repairTag(grade)
        );
    }

    public static float scaledBaseDamage(ToolMaterial material, Grade grade, float vanillaBaseline) {
        float bonus = material.attackDamageBonus();
        float vanillaTotal = PLAYER_BASE_DAMAGE + vanillaBaseline + bonus;
        return vanillaTotal * grade.multiplier() - PLAYER_BASE_DAMAGE - bonus;
    }

    public static ArmorMaterial armor(GradedMetal metal, Grade grade) {
        ArmorMaterial base = metal.armorBase();
        Map<ArmorType, Integer> defense = new EnumMap<>(ArmorType.class);
        for (ArmorType type : PIECES) defense.put(type, grade.scale(base.defense().getOrDefault(type, 0)));
        return new ArmorMaterial(grade.scale(base.durability()), defense, grade.scale(base.enchantmentValue()),
                base.equipSound(), base.toughness() * grade.multiplier(), base.knockbackResistance(),
                metal.repairTag(grade), base.assetId()
        );
    }
}