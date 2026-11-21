package com.herobrot.digandrefined.registry;

import com.herobrot.digandrefined.DigandRefined;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DigandRefined.MODID);

    public static final DeferredHolder<CreativeModeTab, @NotNull CreativeModeTab> MAIN = TABS.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + DigandRefined.MODID))
                    .icon(() -> new ItemStack(Items.IRON_INGOT))
                    .displayItems((params, output) -> ModItems.ITEMS.getEntries().forEach(entry -> output.accept(entry.get())))
                    .build());
}