package com.herobrot.digandrefined.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

public record ArmorSet(
        DeferredItem<@NotNull Item> helmet,
        DeferredItem<@NotNull Item> chestplate,
        DeferredItem<@NotNull Item> leggings,
        DeferredItem<@NotNull Item> boots) {}