package com.herobrot.digandrefined.item;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class GradedTier implements Tier {
    private static final float PLAYER_BASE_DAMAGE = 1.0f;

    private final Tier base;
    private final float multiplier;
    private final Ingredient repairIngredient;

    public GradedTier(Tier base, Grade grade, TagKey<Item> repairTag) {
        this.base = base;
        this.multiplier = grade.multiplier();
        this.repairIngredient = Ingredient.of(repairTag);
    }

    @Override
    public int getUses() { return Math.max(1, Math.round(base.getUses() * multiplier)); }

    @Override
    public float getSpeed() { return base.getSpeed() * multiplier; }

    @Override
    public float getAttackDamageBonus() { return base.getAttackDamageBonus(); }

    @Override
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() { return base.getIncorrectBlocksForDrops(); }

    @Override
    public int getEnchantmentValue() {
        return Math.max(1, Math.round(base.getEnchantmentValue() * multiplier));
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() { return repairIngredient; }

    public float scaledBaseDamage(float vanillaBaseDamage) {
        float bonus = base.getAttackDamageBonus();
        float vanillaTotal = PLAYER_BASE_DAMAGE + vanillaBaseDamage + bonus;
        return vanillaTotal * multiplier - PLAYER_BASE_DAMAGE - bonus;
    }
}