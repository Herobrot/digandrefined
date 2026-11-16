package com.herobrot.digandrefined.item;

import java.util.Locale;

public enum Grade {
    IMPURE(0.75f),
    PURE(1.5f);

    private final float multiplier;

    Grade(float multiplier) { this.multiplier = multiplier; }

    public float multiplier() { return multiplier; }

    public String id() { return name().toLowerCase(Locale.ROOT); }
}