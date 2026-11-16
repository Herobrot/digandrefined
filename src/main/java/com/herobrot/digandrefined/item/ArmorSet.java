package com.herobrot.digandrefined.item;

import net.minecraft.world.item.ArmorItem;
import net.neoforged.neoforge.registries.DeferredItem;

public record ArmorSet(
        DeferredItem<ArmorItem> helmet,
        DeferredItem<ArmorItem> chestplate,
        DeferredItem<ArmorItem> leggings,
        DeferredItem<ArmorItem> boots) {
}