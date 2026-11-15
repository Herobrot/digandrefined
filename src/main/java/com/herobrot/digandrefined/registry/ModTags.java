package com.herobrot.digandrefined.registry;

import com.herobrot.digandrefined.DigandRefined;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static final TagKey<Item> IMPURE_RAW_IRON = tag("raw_materials/iron/impure");
    public static final TagKey<Item> PURE_RAW_IRON = tag("raw_materials/iron/pure");
    public static final TagKey<Item> IMPURE_IRON_INGOT = tag("ingots/iron/impure");
    public static final TagKey<Item> PURE_IRON_INGOT = tag("ingots/iron/pure");

    public static final TagKey<Item> IMPURE_RAW_COPPER = tag("raw_materials/copper/impure");
    public static final TagKey<Item> PURE_RAW_COPPER = tag("raw_materials/copper/pure");
    public static final TagKey<Item> IMPURE_COPPER_INGOT = tag("ingots/copper/impure");
    public static final TagKey<Item> PURE_COPPER_INGOT = tag("ingots/copper/pure");

    public static final TagKey<Item> IMPURE_RAW_GOLD = tag("raw_materials/gold/impure");
    public static final TagKey<Item> PURE_RAW_GOLD = tag("raw_materials/gold/pure");
    public static final TagKey<Item> IMPURE_GOLD_INGOT = tag("ingots/gold/impure");
    public static final TagKey<Item> PURE_GOLD_INGOT = tag("ingots/gold/pure");

    public static final TagKey<Item> IMPURE_COAL = tag("coals/impure");
    public static final TagKey<Item> PURE_COAL = tag("coals/pure");

    public static final TagKey<Item> IMPURE_DIAMOND = tag("gems/diamond/impure");
    public static final TagKey<Item> PURE_DIAMOND = tag("gems/diamond/pure");

    private static TagKey<Item> tag(String path) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DigandRefined.MODID, path));
    }
}