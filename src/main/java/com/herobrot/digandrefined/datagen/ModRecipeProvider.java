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
import net.minecraft.world.item.*;
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

        toolSet(output, ModTags.IMPURE_IRON_INGOT, ModItems.IMPURE_IRON_PICKAXE, ModItems.IMPURE_IRON_AXE, ModItems.IMPURE_IRON_SHOVEL, ModItems.IMPURE_IRON_HOE, ModItems.IMPURE_IRON_SWORD);
        toolSet(output, ModTags.PURE_IRON_INGOT, ModItems.PURE_IRON_PICKAXE, ModItems.PURE_IRON_AXE, ModItems.PURE_IRON_SHOVEL, ModItems.PURE_IRON_HOE, ModItems.PURE_IRON_SWORD);
        toolSet(output, ModTags.IMPURE_GOLD_INGOT, ModItems.IMPURE_GOLD_PICKAXE, ModItems.IMPURE_GOLDEN_AXE, ModItems.IMPURE_GOLDEN_SHOVEL, ModItems.IMPURE_GOLDEN_HOE, ModItems.IMPURE_GOLDEN_SWORD);
        toolSet(output, ModTags.PURE_GOLD_INGOT, ModItems.PURE_GOLD_PICKAXE, ModItems.PURE_GOLDEN_AXE, ModItems.PURE_GOLDEN_SHOVEL, ModItems.PURE_GOLDEN_HOE, ModItems.PURE_GOLDEN_SWORD);
        toolSet(output, ModTags.IMPURE_DIAMOND, ModItems.IMPURE_DIAMOND_PICKAXE, ModItems.IMPURE_DIAMOND_AXE, ModItems.IMPURE_DIAMOND_SHOVEL, ModItems.IMPURE_DIAMOND_HOE, ModItems.IMPURE_DIAMOND_SWORD);
        toolSet(output, ModTags.PURE_DIAMOND, ModItems.PURE_DIAMOND_PICKAXE, ModItems.PURE_DIAMOND_AXE, ModItems.PURE_DIAMOND_SHOVEL, ModItems.PURE_DIAMOND_HOE, ModItems.PURE_DIAMOND_SWORD);
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

    private void toolSet(RecipeOutput output, TagKey<Item> material, DeferredItem<PickaxeItem> pickaxe,
                         DeferredItem<AxeItem> axe, DeferredItem<ShovelItem> shovel, DeferredItem<HoeItem> hoe,
                         DeferredItem<SwordItem> sword) {
        shaped(output, RecipeCategory.TOOLS, pickaxe, material, "MMM", " # ", " # ");
        shaped(output, RecipeCategory.TOOLS, axe, material, "MM", "M#", " #");
        shaped(output, RecipeCategory.TOOLS, shovel, material, "M", "#", "#");
        shaped(output, RecipeCategory.TOOLS, hoe, material, "MM", " #", " #");
        shaped(output, RecipeCategory.COMBAT, sword, material, "M", "M", "#");
    }

    private void shaped(RecipeOutput output, RecipeCategory category, DeferredItem<?> result,
                        TagKey<Item> material, String... pattern) {
        ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(category, result)
                .define('M', material)
                .define('#', Items.STICK);
        for (String row : pattern) builder.pattern(row);
        builder.unlockedBy("has_material", has(material)).save(output);
    }
}