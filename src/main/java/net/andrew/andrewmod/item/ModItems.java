package net.andrew.andrewmod.item;

import net.andrew.andrewmod.AndrewMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item GLIMMERBERRY = registerItem("glimmerberry", new Item(new Item.Settings()));
    //public static final Item DOG_WHISTLE = registerItem("dog_whistle", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AndrewMod.MOD_ID, name), item);
    }

    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(GLIMMERBERRY);
    //    entries.add(DOG_WHISTLE);
    }

    public static void registerModItems() {
        AndrewMod.LOGGER.info("Registering Mod Items for " + AndrewMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::customIngredients);
    }
}
