package com.herobrot.digandrefined.registry;

import com.herobrot.digandrefined.item.Grade;
import com.herobrot.digandrefined.item.GradedTier;

import net.minecraft.world.item.Tiers;

public class ModTiers {
    public static final GradedTier IMPURE_IRON = new GradedTier(Tiers.IRON, Grade.IMPURE, ModTags.IMPURE_IRON_INGOT);
    public static final GradedTier PURE_IRON = new GradedTier(Tiers.IRON, Grade.PURE, ModTags.PURE_IRON_INGOT);

    public static final GradedTier IMPURE_GOLD = new GradedTier(Tiers.GOLD, Grade.IMPURE, ModTags.IMPURE_GOLD_INGOT);
    public static final GradedTier PURE_GOLD = new GradedTier(Tiers.GOLD, Grade.PURE, ModTags.PURE_GOLD_INGOT);

    public static final GradedTier IMPURE_DIAMOND = new GradedTier(Tiers.DIAMOND, Grade.IMPURE, ModTags.IMPURE_DIAMOND);
    public static final GradedTier PURE_DIAMOND = new GradedTier(Tiers.DIAMOND, Grade.PURE, ModTags.PURE_DIAMOND);
}