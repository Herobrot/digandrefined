package com.herobrot.digandrefined.item;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.registries.DeferredItem;

public record ToolSet(
        DeferredItem<PickaxeItem> pickaxe,
        DeferredItem<AxeItem> axe,
        DeferredItem<ShovelItem> shovel,
        DeferredItem<HoeItem> hoe,
        DeferredItem<SwordItem> sword) {
}