package net.andrew.andrewmod.item;

import net.andrew.andrewmod.AndrewMod;
import net.andrew.andrewmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * ModItems is a registry class for all custom items in AndrewMod.
 * This class handles registration of primarily astralium related items.
 * However, ModItems is also used to create and register all custom items and their placement in creative tabs.
 *
 * @author Andrew Herrera
 * @version 1.0
 */

public class ModItems {
    /**
     * Glimmerberry food item, a magical berry.
     */
    public static final Item GLIMMERBERRY = registerItem("glimmerberry", new Item(new Item.Settings()));
    /**
     * Raw astralium item, obtained from mining astralium ore, can be smelted into ingots.
     */
    public static final Item RAW_ASTRALIUM = registerItem("raw_astralium", new Item(new Item.Settings()));
    /**
     * Astralium ingot item, refined form of astralium, used for crafting tools and equipment.
     */
    public static final Item ASTRALIUM_INGOT = registerItem("astralium_ingot", new Item(new Item.Settings()));

    /**
     * Registers a new item with the Minecraft item registry.
     * This method creates a unique identifier for the item and registers it with the game.
     * @param name The string identifier for the item (must be lowercase, no spaces)
     * @param item The item instance to register
     * @return The registered item instance
     */
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AndrewMod.MOD_ID, name), item);
    }

    /**
     * Adds astralium ore block to the Natural/Ores creative tab.
     * This method is called by Fabric's ItemGroupEvents system.
     * @param entries The FabricItemGroupEntries to modify
     */
    private static void customOres(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.ASTRALIUM_ORE);
    }

    /**
     * Adds astralium related crafting ingredients to the Ingredients creative tab.
     * Includes both raw astralium and refined astralium ingots.
     * @param entries The FabricItemGroupEntries to modify
     */
    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(ASTRALIUM_INGOT);
        entries.add(RAW_ASTRALIUM);
    }

    /**
     * Adds food items to the Food and Drink creative tab.
     * Currently only includes glimmerberries.
     * @param entries The FabricItemGroupEntries to modify
     */
    private static void customFoodAndDrink(FabricItemGroupEntries entries) {
        entries.add(GLIMMERBERRY);
    }

    /**
     * Registers all mod items and adds them to the appropriate vanilla creative tabs.
     * This method should be called during mod initialization to ensure all items
     * are properly registered and accessible in the creative inventory.
     */
    public static void registerModItems() {
        AndrewMod.LOGGER.info("Registering Mod Items for " + AndrewMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::customOres);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::customFoodAndDrink);
    }
}
