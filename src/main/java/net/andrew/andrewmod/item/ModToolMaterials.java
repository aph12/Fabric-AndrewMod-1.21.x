package net.andrew.andrewmod.item;

import com.google.common.base.Suppliers;
import net.andrew.andrewmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;
/**
 * ModToolMaterials defines custom tool materials for AndrewMod tools.
 * This enum implements Minecraft's ToolMaterial interface to create astralium tools
 * with balanced stats positioned between diamond and netherite tiers.
 *
 * The astralium material provides enhanced durability and mining speed compared to diamond
 * while maintaining balanced gameplay progression.
 *
 * Most implementation methods are standard Minecraft ToolMaterial requirements,
 * with the key customization being the astralium material definition.
 *
 * @author Andrew Herrera
 * @version 1.0
 */


public enum ModToolMaterials implements ToolMaterial {
    /**
     * Astralium tool material with balanced stats between diamond and netherite.
     *
     * Parameters:
     * INCORRECT_FOR_ASTRALIUM_TOOL: Inverse tag defining blocks this tool mines poorly
     * 1800: Durability - between diamond's 1561 and netherite's 2031
     * 8.5F: Mining speed multiplier
     * 3.5F: Attack damage bonus
     * 12: Enchantability - higher than diamond's 10
     * Repair ingredient: Astralium Ingots
     */
    ASTRALIUM(ModTags.Blocks.INCORRECT_FOR_ASTRALIUM_TOOL, 1800, 8.5F,
            3.5F, 12, () -> Ingredient.ofItems(ModItems.ASTRALIUM_INGOT));

    /**
     * The following fields, constructor, and methods are standard ToolMaterial interface
     * implementations required by Minecraft. This boilerplate code was adapted from
     * Minecraft's internal tool material structure following tutorial guidance.
     *
     * These methods provide the framework for accessing the astralium material properties
     * defined in the enum constant above.
     */
    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(
            final TagKey<Block> inverseTag,
            final int itemDurability,
            final float miningSpeed,
            final float attackDamage,
            final int enchantability,
            final Supplier<Ingredient> repairIngredient
    ) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}

