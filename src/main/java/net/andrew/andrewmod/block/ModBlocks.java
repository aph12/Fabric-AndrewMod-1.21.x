package net.andrew.andrewmod.block;

import net.andrew.andrewmod.AndrewMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

/**
 * ModBlocks is a registry class for all custom blocks in AndrewMod.
 * This class handles registration of astralium-related blocks and their block items.
 * All blocks are automatically registered with corresponding block items for creative mode.
 *
 * @author Andrew Herrera
 * @version 1.0
 */
public class ModBlocks {
    /**
     * Astralium ore block, drops experience when mined and requires a tool.
     * Drops 2-5 experience points and has amethyst block sound effects.
     */
    public static final Block ASTRALIUM_ORE = registerBlock("astralium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().sounds(BlockSoundGroup.AMETHYST_BLOCK)
                            .strength(3.0f, 3.0f)
                            .requiresTool()));
    /**
     * Astralium block, a storage block made from 9 astralium ingots.
     * Used for compact storage and decorative building.
     */
    public static final Block ASTRALIUM_BLOCK = registerBlock("astralium_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL)
                    .strength(5.0f, 6.0f)
                    .requiresTool()));
    /**
     * Registers a block with the Minecraft block registry and creates a corresponding block item.
     * This method handles both block and item registration in one call.
     * @param name The string identifier for the block
     * @param block The block instance to register
     * @return The registered block instance
     */
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AndrewMod.MOD_ID, name), block);
    }
    /**
     * Registers a block item for the given block in the item registry.
     * This allows the block to appear in creative mode and be held as an item.
     * @param name The string identifier for the block item
     * @param block The block to create an item for
     */
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(AndrewMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    /**
     * Registers all mod blocks and logs the registration process.
     * This method should be called during mod initialization to ensure all blocks
     * are properly registered and accessible in game.
     */
    public static void registerModBlocks() {
        AndrewMod.LOGGER.info("Registering Mod Blocks for " + AndrewMod.MOD_ID);
    }

}
