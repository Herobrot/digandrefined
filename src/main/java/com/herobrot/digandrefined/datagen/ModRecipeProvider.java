package com.herobrot.digandrefined.datagen;

import com.herobrot.digandrefined.DigandRefined;
import com.herobrot.digandrefined.item.ArmorSet;
import com.herobrot.digandrefined.item.Grade;
import com.herobrot.digandrefined.item.GradedMetal;
import com.herobrot.digandrefined.item.ToolSet;
import com.herobrot.digandrefined.registry.ModItems;

import net.minecraft.advancements.Advancement;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;

public class ModRecipeProvider extends RecipeProvider {
    private static final float IMPURE_XP = 0.75f;
    private static final float PURE_XP = 1.5f;
    private static final int SMELTING_TIME = 200;

    public ModRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput, DigandRefined.MODID);
    }

    @Override
    protected void buildRecipes() {
        cook(ModItems.IMPURE_RAW_IRON, ModItems.IMPURE_IRON_INGOT, 0.7f * IMPURE_XP);
        cook(ModItems.PURE_RAW_IRON, ModItems.PURE_IRON_INGOT, 0.7f * PURE_XP);

        cook(ModItems.ROUGH_COPPER, ModItems.IMPURE_COPPER_INGOT, 0.7f * IMPURE_XP);
        cook(ModItems.PURE_RAW_COPPER, ModItems.PURE_COPPER_INGOT, 0.7f * PURE_XP);

        cook(ModItems.IMPURE_RAW_GOLD, ModItems.IMPURE_GOLD_INGOT, IMPURE_XP);
        cook(ModItems.PURE_RAW_GOLD, ModItems.PURE_GOLD_INGOT, PURE_XP);

        for (GradedMetal metal : GradedMetal.values())
            for (Grade grade : Grade.values()) {
                TagKey<Item> material = metal.repairTag(grade);
                toolSet(material, ModItems.tools(metal, grade));
                armorSet(material, ModItems.armor(metal, grade));
            }
    }

    private void cook(ItemLike raw, ItemLike ingot, float xp) {
        String name = getItemName(ingot);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(raw), RecipeCategory.MISC, CookingBookCategory.MISC,
                        ingot, xp, SMELTING_TIME)
                .unlockedBy(getHasName(raw), has(raw))
                .save(output, name + "_from_smelting");

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(raw), RecipeCategory.MISC, CookingBookCategory.MISC,
                        ingot, xp, SMELTING_TIME)
                .unlockedBy(getHasName(raw), has(raw))
                .save(output, name + "_from_blasting");
    }

    private void toolSet(TagKey<Item> material, ToolSet set) {
        shapedGear(RecipeCategory.TOOLS, set.pickaxe(), material, "MMM", " # ", " # ");
        shapedGear(RecipeCategory.TOOLS, set.axe(), material, "MM", "M#", " #");
        shapedGear(RecipeCategory.TOOLS, set.shovel(), material, "M", "#", "#");
        shapedGear(RecipeCategory.TOOLS, set.hoe(), material, "MM", " #", " #");
        shapedGear(RecipeCategory.COMBAT, set.sword(), material, "M", "M", "#");
        shapedGear(RecipeCategory.COMBAT, set.spear(), material, "  M", " # ", "#  ");
    }

    private void armorSet(TagKey<Item> material, ArmorSet set) {
        shapedGear(RecipeCategory.COMBAT, set.helmet(), material, "MMM", "M M");
        shapedGear(RecipeCategory.COMBAT, set.chestplate(), material, "M M", "MMM", "MMM");
        shapedGear(RecipeCategory.COMBAT, set.leggings(), material, "MMM", "M M", "M M");
        shapedGear(RecipeCategory.COMBAT, set.boots(), material, "M M", "M M");
    }

    private void shapedGear(RecipeCategory category, ItemLike result, TagKey<Item> material, String... pattern) {
        ShapedRecipeBuilder builder = shaped(category, result).define('M', material);
        if (String.join("", pattern).contains("#")) builder.define('#', Items.STICK);
        for (String row : pattern) builder.pattern(row);
        builder.unlockedBy("has_material", has(material)).save(output);
    }
}