package net.andrew.andrewmod.item;

import net.andrew.andrewmod.AndrewMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

/**
 * ModArmorMaterials defines custom armor materials for AndrewMod armor sets.
 * This class creates astralium armor material with balanced protection values
 * positioned between diamond and netherite tiers for enhanced gameplay progression.
 *
 * Implementation follows tutorial code structure adapted for this mod's requirements.
 * The EnumMap approach and registration pattern provide modern Minecraft compatability
 * while allowing customization of armor stats, sounds, and repair materials.
 *
 * @author Andrew Herrera
 * @version 1.0
 */
public class ModArmorMaterials {
    /**
     * Astralium armmor material
     *
     * This armor material provides enhanced enchantability while maintaining balanced
     * protection values. Configured to serve as a meaningful upgrade from diamond
     * while not overpowering the netherite tier.
     *
     * Configuration Details:
     * - Protection values: Helmet(3), Chestplate(8), Leggings(6), Boots(3) = 20 Total
     * - Enchantability: 20
     * - Equip Sound: Diamond armor sound effect
     * - Repair ingredient: Astralium ingots
     * - Toughness: 0
     * - Knockback resistance: 0
     *
     * Uses EnumMap to define protection values per armor piece type.
     */
    public static final RegistryEntry<ArmorMaterial> ASTRALIUM_ARMOR_MATERIAL = registerArmorMaterial("astralium",
            () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 2);
                    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.ASTRALIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(AndrewMod.MOD_ID, "astralium"))), 0, 0));
    /**
     * Registers an armor material with Minecraft's registry system.
     *
     * This method handles the registration process for custom armor materials,
     * creating proper identifiers and integrating with Minecraft's material system.
     * Implementation follows standard Minecraft modding registration patterns.
     * @param name The string identifier for the armor material
     * @param material Supplier function that creates the ArmorMaterial when needed
     * @return RegistryEntry for the registered armor material
     */
    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(AndrewMod.MOD_ID, name), material.get());
    }
}
