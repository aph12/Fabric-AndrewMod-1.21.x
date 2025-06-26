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

public class ModItems {
    public static final Item GLIMMERBERRY = registerItem("glimmerberry", new Item(new Item.Settings()));
    //Raw Astralium
    public static final Item RAW_ASTRALIUM = registerItem("raw_astralium", new Item(new Item.Settings()));
    //Astralium Ingot
    public static final Item ASTRALIUM_INGOT = registerItem("astralium_ingot", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AndrewMod.MOD_ID, name), item);
    }
    private static void customOres(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.ASTRALIUM_ORE);
    }
    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(ASTRALIUM_INGOT);
        entries.add(RAW_ASTRALIUM);
    }
    private static void customFoodAndDrink(FabricItemGroupEntries entries) {
        entries.add(GLIMMERBERRY);
    }

    public static void registerModItems() {
        AndrewMod.LOGGER.info("Registering Mod Items for " + AndrewMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::customOres);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::customFoodAndDrink);
    }
}
