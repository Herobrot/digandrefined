package com.herobrot.digandrefined.item;

import com.herobrot.digandrefined.registry.ModTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;

public enum GradedMetal {
    COPPER(ToolMaterial.COPPER,
            ArmorMaterials.COPPER,
            "copper",
            "cobre",
            7.0f,
            -3.2f,
            -1.0f,
            -2.0f,
            ModTags.IMPURE_COPPER_INGOT,
            ModTags.PURE_COPPER_INGOT,
            new SpearStats(
                    0.85f,
                    0.82f,
                    0.65f,
                    4.0f,
                    12.0f,
                    8.25f,
                    5.1f,
                    12.5f,
                    4.6f
            )
    ),
    IRON(ToolMaterial.IRON,
            ArmorMaterials.IRON,
            "iron",
            "hierro",
            6.0f,
            -3.1f,
            -2.0f,
            -1.0f,
            ModTags.IMPURE_IRON_INGOT,
            ModTags.PURE_IRON_INGOT,
            new SpearStats(
                    0.95f,
                    0.95f,
                    0.6f,
                    2.5f,
                    11.0f,
                    6.75f,
                    5.1f,
                    11.25f,
                    4.6f
            )),
    GOLD(ToolMaterial.GOLD,
            ArmorMaterials.GOLD,
            "golden",
            "oro",
            6.0f,
            -3.0f,
            0.0f,
            -3.0f,
            ModTags.IMPURE_GOLD_INGOT,
            ModTags.PURE_GOLD_INGOT,
            new SpearStats(
                    0.95f,
                    0.7f,
                    0.7f,
                    3.5f,
                    13.0f,
                    8.5f,
                    5.1f,
                    13.75f,
                    4.6f
            )
    ),
    DIAMOND(ToolMaterial.DIAMOND,
            ArmorMaterials.DIAMOND,
            "diamond",
            "diamante",
            5.0f,
            -3.0f,
            -3.0f,
            0.0f,
            ModTags.IMPURE_DIAMOND,
            ModTags.PURE_DIAMOND,
            new SpearStats(
                    1.05f,
                    1.075f,
                    0.5f,
                    3.0f,
                    10.0f,
                    6.5f,
                    5.1f,
                    10.0f,
                    4.6f
            )
    );

    private final ToolMaterial toolBase;
    private final ArmorMaterial armorBase;
    private final String gearName;
    private final String spanishName;
    private final float axeDamage;
    private final float axeSpeed;
    private final float hoeDamage;
    private final float hoeSpeed;
    private final TagKey<Item> impureTag;
    private final TagKey<Item> pureTag;
    private final SpearStats spear;

    GradedMetal(ToolMaterial toolBase, ArmorMaterial armorBase, String gearName, String spanishName,
                float axeDamage, float axeSpeed, float hoeDamage, float hoeSpeed,
                TagKey<Item> impureTag, TagKey<Item> pureTag, SpearStats spear) {
        this.toolBase = toolBase;
        this.armorBase = armorBase;
        this.gearName = gearName;
        this.spanishName = spanishName;
        this.axeDamage = axeDamage;
        this.axeSpeed = axeSpeed;
        this.hoeDamage = hoeDamage;
        this.hoeSpeed = hoeSpeed;
        this.impureTag = impureTag;
        this.pureTag = pureTag;
        this.spear = spear;
    }

    public ToolMaterial toolBase() { return toolBase; }

    public ArmorMaterial armorBase() { return armorBase; }

    public String gearName() { return gearName; }

    public String spanishName() { return spanishName; }

    public float axeDamage() { return axeDamage; }

    public float axeSpeed() { return axeSpeed; }

    public float hoeDamage() { return hoeDamage; }

    public float hoeSpeed() { return hoeSpeed; }

    public SpearStats spear() { return spear; }

    public TagKey<Item> repairTag(Grade grade) { return grade == Grade.IMPURE ? impureTag : pureTag; }
}