package com.herobrot.digandrefined.item;

import java.util.function.Function;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public enum GearType {
    PICKAXE("Pickaxe", "Pico", "o", ToolSet::pickaxe),
    AXE("Axe", "Hacha", "a", ToolSet::axe),
    SHOVEL("Shovel", "Pala", "a", ToolSet::shovel),
    HOE("Hoe", "Azada", "a", ToolSet::hoe),
    SWORD("Sword", "Espada", "a", ToolSet::sword),
    SPEAR("Spear", "Lanza", "a", ToolSet::spear);

    private final String englishName;
    private final String spanishName;
    private final String spanishEnding;
    private final Function<ToolSet, DeferredItem<? extends Item>> accessor;

    GearType(String englishName, String spanishName, String spanishEnding,
             Function<ToolSet, DeferredItem<? extends Item>> accessor) {
        this.englishName = englishName;
        this.spanishName = spanishName;
        this.spanishEnding = spanishEnding;
        this.accessor = accessor;
    }

    public String englishName() { return englishName; }

    public String spanishName() { return spanishName; }

    public String spanishEnding() { return spanishEnding; }

    public DeferredItem<? extends Item> item(ToolSet set) { return accessor.apply(set); }
}