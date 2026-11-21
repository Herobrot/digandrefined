package com.herobrot.digandrefined.registry;

import com.herobrot.digandrefined.DigandRefined;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootPredicates;
import net.minecraft.world.level.storage.loot.providers.number.ints.ConditionalValue;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

public class ModContextIntProviders {
    public static final ResourceKey<ContextIntProvider> IMPURE_COAL_TIME = key("cooking/time_impure_coal");
    public static final ResourceKey<ContextIntProvider> PURE_COAL_TIME = key("cooking/time_pure_coal");

    private static ResourceKey<ContextIntProvider> key(String path) {
        return ResourceKey.create(Registries.CONTEXT_INT_PROVIDER,
                Identifier.fromNamespaceAndPath(DigandRefined.MODID, path));
    }

    public static void bootstrap(BootstrapContext<ContextIntProvider> context) {
        Holder<LootItemCondition> fastFurnace = context.lookup(Registries.PREDICATE).getOrThrow(LootPredicates.FAST_FURNACE);
        context.register(IMPURE_COAL_TIME, burnTime(fastFurnace, 1200));
        context.register(PURE_COAL_TIME, burnTime(fastFurnace, 2400));
    }

    private static ContextIntProvider burnTime(Holder<LootItemCondition> fastFurnace, int normalTicks) {
        return new ConditionalValue(fastFurnace,
                ContextIntProviders.exactly(normalTicks / 2),
                ContextIntProviders.exactly(normalTicks));
    }
}