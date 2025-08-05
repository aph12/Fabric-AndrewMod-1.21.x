package net.andrew.andrewmod.item;

import net.andrew.andrewmod.AndrewMod;
import net.andrew.andrewmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * ModItemGroups creates custom creative tabs for AndrewMod items.
 * Organizes astralium content into logical groups for easy access in creative mode.
 * Each group has a specific theme and contains related items and blocks.
 *
 * @author Andrew Herrera
 * @version 1.0
 */
public class ModItemGroups {
    /**
     * Creative tab containing glimmerberry food items.
     * Uses glimmerberry as the tab icon.
     */
    public static final ItemGroup GLIMMERBERRY_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AndrewMod.MOD_ID, "glimmerberry"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.glimmerberry"))
                    .icon(() -> new ItemStack(ModItems.GLIMMERBERRY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.GLIMMERBERRY);
                    }).build());
    /**
     * Creative tab containing astralium materials and crafting ingredients.
     * Uses raw astralium as the tab icon and includes both raw and refined astralium.
     */
    public static final ItemGroup ASTRALIUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AndrewMod.MOD_ID, "astralium"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.astralium"))
                    .icon(() -> new ItemStack(ModItems.RAW_ASTRALIUM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_ASTRALIUM);
                        entries.add(ModItems.ASTRALIUM_INGOT);
                    }).build());
    /**
     * Creative tab containing astralium blocks and building materials.
     * Uses astralium ore as the tab icon.
     */
    public static final ItemGroup ASTRALIUM_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AndrewMod.MOD_ID, "astralium_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.astralium_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.ASTRALIUM_ORE)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ASTRALIUM_ORE);
                        entries.add(ModBlocks.ASTRALIUM_BLOCK);
                    }).build());

    /**
     * Registers all custom item groups and logs the registration process.
     * This method should be called during mod initialization to ensure all creative tabs
     * are properly registered and accessible in creative mode.
     */
    public static void registerItemGroups() {
        AndrewMod.LOGGER.info("Registering Item Groups for " + AndrewMod.MOD_ID);
    }
}
