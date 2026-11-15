package com.herobrot.digandrefined.item;

public enum Grade {
    IMPURE(0.75f),
    PURE(1.5f);

    private final float multiplier;

    Grade(float multiplier) { this.multiplier = multiplier; }

    public float multiplier() { return multiplier; }
}