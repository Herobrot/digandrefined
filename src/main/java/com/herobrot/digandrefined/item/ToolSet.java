package com.herobrot.digandrefined.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

public record ToolSet(
        DeferredItem<@NotNull Item> pickaxe,
        DeferredItem<@NotNull Item> axe,
        DeferredItem<@NotNull Item> shovel,
        DeferredItem<@NotNull Item> hoe,
        DeferredItem<@NotNull Item> sword,
        DeferredItem<@NotNull Item> spear) {}