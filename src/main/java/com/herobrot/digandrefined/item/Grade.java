package com.herobrot.digandrefined.item;

import java.util.Locale;

public enum Grade {
    IMPURE(0.75f, "impur"),
    PURE(1.5f, "pur");

    private final float multiplier;
    private final String spanishStem;

    Grade(float multiplier, String spanishStem) {
        this.multiplier = multiplier;
        this.spanishStem = spanishStem;
    }

    public int scale(int value) { return Math.max(1, Math.round(value * multiplier)); }

    public float multiplier() { return multiplier; }

    public String id() { return name().toLowerCase(Locale.ROOT); }

    public String spanishStem() { return spanishStem; }
}