package com.herobrot.digandrefined.datagen;

import java.util.concurrent.CompletableFuture;

import com.herobrot.digandrefined.DigandRefined;
import com.herobrot.digandrefined.registry.ModItems;
import com.herobrot.digandrefined.registry.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

public class ModRecipeProvider extends RecipeProvider {
    private static final float IMPURE_XP = 0.75f;
    private static final float PURE_XP = 1.5f;
    private static final int SMELTING_TIME = 200;
    private static final int BLASTING_TIME = 100;

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        cook(output, ModItems.IMPURE_RAW_IRON, ModItems.IMPURE_IRON_INGOT, 0.7f * IMPURE_XP);
        cook(output, ModItems.PURE_RAW_IRON, ModItems.PURE_IRON_INGOT, 0.7f * PURE_XP);

        cook(output, ModItems.IMPURE_RAW_COPPER, ModItems.IMPURE_COPPER_INGOT, 0.7f * IMPURE_XP);
        cook(output, ModItems.PURE_RAW_COPPER, ModItems.PURE_COPPER_INGOT, 0.7f * PURE_XP);

        cook(output, ModItems.IMPURE_RAW_GOLD, ModItems.IMPURE_GOLD_INGOT, IMPURE_XP);
        cook(output, ModItems.PURE_RAW_GOLD, ModItems.PURE_GOLD_INGOT, PURE_XP);

        pickaxe(output, ModItems.IMPURE_IRON_PICKAXE, ModTags.IMPURE_IRON_INGOT);
        pickaxe(output, ModItems.PURE_IRON_PICKAXE, ModTags.PURE_IRON_INGOT);

        pickaxe(output, ModItems.IMPURE_GOLD_PICKAXE, ModTags.IMPURE_GOLD_INGOT);
        pickaxe(output, ModItems.PURE_GOLD_PICKAXE, ModTags.PURE_GOLD_INGOT);

        pickaxe(output, ModItems.IMPURE_DIAMOND_PICKAXE, ModTags.IMPURE_DIAMOND);
        pickaxe(output, ModItems.PURE_DIAMOND_PICKAXE, ModTags.PURE_DIAMOND);
    }

    private void cook(RecipeOutput output, DeferredItem<Item> raw, DeferredItem<Item> ingot, float xp) {
        String name = ingot.getId().getPath();

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(raw), RecipeCategory.MISC, ingot, xp, SMELTING_TIME)
                .unlockedBy(getHasName(raw), has(raw))
                .save(output, ResourceLocation.fromNamespaceAndPath(DigandRefined.MODID, name + "_from_smelting"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(raw), RecipeCategory.MISC, ingot, xp, BLASTING_TIME)
                .unlockedBy(getHasName(raw), has(raw))
                .save(output, ResourceLocation.fromNamespaceAndPath(DigandRefined.MODID, name + "_from_blasting"));
    }

    private void pickaxe(RecipeOutput output, DeferredItem<PickaxeItem> pickaxe, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe)
                .define('M', material)
                .define('#', Items.STICK)
                .pattern("MMM")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_material", has(material))
                .save(output);
    }
}