package com.herobrot.digandrefined.item;

import java.util.function.Function;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public enum ArmorPiece {
    HELMET("Helmet", "Casco", "o", ArmorSet::helmet),
    CHESTPLATE("Chestplate", "Peto", "o", ArmorSet::chestplate),
    LEGGINGS("Leggings", "Grebas", "as", ArmorSet::leggings),
    BOOTS("Boots", "Botas", "as", ArmorSet::boots);

    private final String englishName;
    private final String spanishName;
    private final String spanishEnding;
    private final Function<ArmorSet, DeferredItem<? extends Item>> accessor;

    ArmorPiece(String englishName, String spanishName, String spanishEnding,
               Function<ArmorSet, DeferredItem<? extends Item>> accessor) {
        this.englishName = englishName;
        this.spanishName = spanishName;
        this.spanishEnding = spanishEnding;
        this.accessor = accessor;
    }

    public String englishName() { return englishName; }

    public String spanishName() { return spanishName; }

    public String spanishEnding() { return spanishEnding; }

    public DeferredItem<? extends Item> item(ArmorSet set) { return accessor.apply(set); }
}