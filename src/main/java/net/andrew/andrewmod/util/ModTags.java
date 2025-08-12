package net.andrew.andrewmod.util;

import net.andrew.andrewmod.AndrewMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

/**
 * ModTags defines custom tag keys for categorizing blocks and items in AndrewMod.
 * Tags are used to group related blocks/items together for tool compatibility,
 * recipe ingredients, and other game mechanics.
 *
 * This system allows astralium tools to reference groups of blocks rather than individual block types,
 * making the tool system more flexible and maintainable.
 * The actual block/item assignments are defined in JSON data files.
 *
 * @author Andrew Herrera
 * @version 1.0
 */
public class ModTags {
    /**
     * Block tags for defining tool mining compatibility and block categorization.
     * These tags work with astralium tools to determine mining effectiveness.
     */
    public static class Blocks {
        /**
         * Tag for blocks that require astralium-tier tools to mine effectively.
         * Includes all blocks that diamond tools can mine, positioning astralium
         * tools between diamond and netherite tiers in mining capability.
         */
        public static final TagKey<Block> NEEDS_ASTRALIUM_TOOL = createTag("needs_astralium_tool");
        /**
         * Tag for blocks that astralium tools cannot mine effectively.
         * Uses inverse logic, defines blocks where astralium tools perform poorly.
         */
        public static final TagKey<Block> INCORRECT_FOR_ASTRALIUM_TOOL = createTag("incorrect_for_astralium_tool");
        /**
         * Creates a block tag with the mod's namespace.
         * Generates proper identifier format for use in data files and tool logic.
         * @param name The tag name - andrewmod:name
         * @return TagKey for referencing this tag in code and data files
         */
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(AndrewMod.MOD_ID, name));
        }
    }
    /**
     * Item tags for categorizing items, currently unused.
     * Could be used for recipe ingredients, repair materials, etc.
     */
    public static class Items {
        /**
         * Creates an item tag with the mod's namespace.
         * @param name The tag name - andrewmod:name
         * @return TagKey for referencing this tag in code and data files
         */
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(AndrewMod.MOD_ID, name));
        }
    }
}
