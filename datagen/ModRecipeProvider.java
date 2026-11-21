package com.herobrot.digandrefined.datagen;

import java.util.concurrent.CompletableFuture;

import com.herobrot.digandrefined.DigandRefined;
import com.herobrot.digandrefined.item.ArmorSet;
import com.herobrot.digandrefined.item.Grade;
import com.herobrot.digandrefined.item.GradedMetal;
import com.herobrot.digandrefined.item.ToolSet;
import com.herobrot.digandrefined.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModRecipeProvider extends RecipeProvider {
    private static final float IMPURE_XP = 0.75f;
    private static final float PURE_XP = 1.5f;
    private static final int SMELTING_TIME = 200;
    private static final int BLASTING_TIME = 100;

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes() {
        cook(output, ModItems.IMPURE_RAW_IRON, ModItems.IMPURE_IRON_INGOT, 0.7f * IMPURE_XP);
        cook(output, ModItems.PURE_RAW_IRON, ModItems.PURE_IRON_INGOT, 0.7f * PURE_XP);

        cook(output, ModItems.ROUGH_COPPER, ModItems.IMPURE_COPPER_INGOT, 0.7f * IMPURE_XP);
        cook(output, ModItems.PURE_RAW_COPPER, ModItems.PURE_COPPER_INGOT, 0.7f * PURE_XP);

        cook(output, ModItems.IMPURE_RAW_GOLD, ModItems.IMPURE_GOLD_INGOT, IMPURE_XP);
        cook(output, ModItems.PURE_RAW_GOLD, ModItems.PURE_GOLD_INGOT, PURE_XP);

        for (GradedMetal metal : GradedMetal.values())
            for (Grade grade : Grade.values()) {
                toolSet(output, metal.repairTag(grade), ModItems.tools(metal, grade));
                armorSet(output, metal.repairTag(grade), ModItems.armor(metal, grade));
            }
    }

    private void cook(RecipeOutput output, DeferredItem<Item> raw, DeferredItem<Item> ingot, float xp) {
        String name = ingot.getId().getPath();

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(raw), RecipeCategory.MISC, ingot, xp, SMELTING_TIME)
                .unlockedBy(getHasName(raw), has(raw))
                .save(output, Identifier.fromNamespaceAndPath(DigandRefined.MODID, name + "_from_smelting"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(raw), RecipeCategory.MISC, ingot, xp, BLASTING_TIME)
                .unlockedBy(getHasName(raw), has(raw))
                .save(output, Identifier.fromNamespaceAndPath(DigandRefined.MODID, name + "_from_blasting"));
    }

    private void toolSet(RecipeOutput output, TagKey<Item> material, ToolSet set) {
        shaped(output, RecipeCategory.TOOLS, set.pickaxe(), material, "MMM", " # ", " # ");
        shaped(output, RecipeCategory.TOOLS, set.axe(), material, "MM", "M#", " #");
        shaped(output, RecipeCategory.TOOLS, set.shovel(), material, "M", "#", "#");
        shaped(output, RecipeCategory.TOOLS, set.hoe(), material, "MM", " #", " #");
        shaped(output, RecipeCategory.COMBAT, set.sword(), material, "M", "M", "#");
    }

    private void armorSet(RecipeOutput output, TagKey<Item> material, ArmorSet set) {
        shaped(output, RecipeCategory.COMBAT, set.helmet(), material, "MMM", "M M");
        shaped(output, RecipeCategory.COMBAT, set.chestplate(), material, "M M", "MMM", "MMM");
        shaped(output, RecipeCategory.COMBAT, set.leggings(), material, "MMM", "M M", "M M");
        shaped(output, RecipeCategory.COMBAT, set.boots(), material, "M M", "M M");
    }

    private void shaped(RecipeOutput output, RecipeCategory category, DeferredItem<?> result,
                        TagKey<Item> material, String... pattern) {
        ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(category, result).define('M', material);
        if (String.join("", pattern).contains("#")) builder.define('#', Items.STICK);
        for (String row : pattern) builder.pattern(row);
        builder.unlockedBy("has_material", has(material)).save(output);
    }
}