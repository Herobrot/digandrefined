package com.herobrot.digandrefined.item;

public record SpearStats(
        float attackDuration,
        float damageMultiplier,
        float delay,
        float dismountTime,
        float dismountThreshold,
        float knockbackTime,
        float knockbackThreshold,
        float damageTime,
        float damageThreshold) {
}