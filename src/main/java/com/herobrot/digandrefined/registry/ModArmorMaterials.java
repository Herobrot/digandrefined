package com.herobrot.digandrefined.registry;

import java.util.EnumMap;
import java.util.Map;

import com.herobrot.digandrefined.DigandRefined;
import com.herobrot.digandrefined.item.Grade;
import com.herobrot.digandrefined.item.GradedMetal;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, DigandRefined.MODID);

    private static final ArmorItem.Type[] PIECES = {
            ArmorItem.Type.HELMET,
            ArmorItem.Type.CHESTPLATE,
            ArmorItem.Type.LEGGINGS,
            ArmorItem.Type.BOOTS
    };

    private static final Map<GradedMetal, Map<Grade, DeferredHolder<ArmorMaterial, ArmorMaterial>>> MATERIALS = new EnumMap<>(GradedMetal.class);

    static {
        for (GradedMetal metal : GradedMetal.values()) {
            Map<Grade, DeferredHolder<ArmorMaterial, ArmorMaterial>> byGrade = new EnumMap<>(Grade.class);
            for (Grade grade : Grade.values()) byGrade.put(grade, ARMOR_MATERIALS.register(grade.id() + "_" + metal.gearName(), () -> create(metal, grade)));
            MATERIALS.put(metal, byGrade);
        }
    }

    public static Holder<ArmorMaterial> get(GradedMetal metal, Grade grade) {
        return MATERIALS.get(metal).get(grade);
    }

    private static ArmorMaterial create(GradedMetal metal, Grade grade) {
        ArmorMaterial base = metal.armorBase().value();
        Map<ArmorItem.Type, Integer> defense = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : PIECES) defense.put(type, grade.scale(base.getDefense(type)));
        return new ArmorMaterial(defense, grade.scale(base.enchantmentValue()), base.equipSound(),
                () -> Ingredient.of(metal.repairTag(grade)), base.layers(),
                base.toughness() * grade.multiplier(), base.knockbackResistance());
    }
}