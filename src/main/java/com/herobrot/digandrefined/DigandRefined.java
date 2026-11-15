package com.herobrot.digandrefined;

import com.herobrot.digandrefined.datagen.DataGenerators;
import com.herobrot.digandrefined.registry.ModCreativeTabs;
import com.herobrot.digandrefined.registry.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(DigandRefined.MODID)
public class DigandRefined {
    public static final String MODID = "digandrefined";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DigandRefined(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.TABS.register(modEventBus);
        modEventBus.addListener(DataGenerators::gatherData);
    }
}
