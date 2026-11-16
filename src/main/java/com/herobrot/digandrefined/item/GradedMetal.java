package com.herobrot.digandrefined.item;

import com.herobrot.digandrefined.registry.ModTags;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public enum GradedMetal {
    IRON(Tiers.IRON, "iron", 6.0f, -3.1f, -2.0f, -1.0f, ModTags.IMPURE_IRON_INGOT, ModTags.PURE_IRON_INGOT),
    GOLD(Tiers.GOLD, "golden", 6.0f, -3.0f, 0.0f, -3.0f, ModTags.IMPURE_GOLD_INGOT, ModTags.PURE_GOLD_INGOT),
    DIAMOND(Tiers.DIAMOND, "diamond", 5.0f, -3.0f, -3.0f, 0.0f, ModTags.IMPURE_DIAMOND, ModTags.PURE_DIAMOND);

    private final Tiers base;
    private final String gearName;
    private final float axeDamage;
    private final float axeSpeed;
    private final float hoeDamage;
    private final float hoeSpeed;
    private final TagKey<Item> impureTag;
    private final TagKey<Item> pureTag;

    GradedMetal(Tiers base, String gearName, float axeDamage, float axeSpeed, float hoeDamage, float hoeSpeed,
                TagKey<Item> impureTag, TagKey<Item> pureTag) {
        this.base = base;
        this.gearName = gearName;
        this.axeDamage = axeDamage;
        this.axeSpeed = axeSpeed;
        this.hoeDamage = hoeDamage;
        this.hoeSpeed = hoeSpeed;
        this.impureTag = impureTag;
        this.pureTag = pureTag;
    }

    public Tiers base() { return base; }

    /** Nombre usado por el equipamiento vanilla: iron, golden, diamond. */
    public String gearName() { return gearName; }

    public float axeDamage() { return axeDamage; }

    public float axeSpeed() { return axeSpeed; }

    public float hoeDamage() { return hoeDamage; }

    public float hoeSpeed() { return hoeSpeed; }

    public TagKey<Item> repairTag(Grade grade) {
        return grade == Grade.IMPURE ? impureTag : pureTag;
    }
}