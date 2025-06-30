package net.andrew.andrewmod;

import net.andrew.andrewmod.item.ModItems;
import net.minecraft.Bootstrap;
import net.minecraft.SharedConstants;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.TestOnly;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ModItems functionality.
 * Test item registration logic, naming conventions, and item properties.
 * Uses Fabric Loader JUnit to properly initialize Minecraft for testing.
 *
 * https://docs.fabricmc.net/develop/automatic-testing
 *
 * @author Andrew Herrera
 * @version 1.0
 */
public class ModItemsTest {
    /**
     * Initialize Minecraft before running tests.
     * This allows us to test actual Minecraft objects like items.
     */
    @BeforeAll
    public static void beforeAll() {
        //Initialize minecraft to allow for tests
        SharedConstants.createGameVersion();
        Bootstrap.initialize();
        //Register mod items after minecraft is initialized
        ModItems.registerModItems();
    }
    /**
     * Tests that mod items are properly initialized as static final fields.
     * This verifies the items exist and are not null after class loading.
     */
    @Test
    public void testModItemsInitialization() {
        //Check that all mod items are initialized and not null
        assertNotNull(ModItems.GLIMMERBERRY);
        assertNotNull(ModItems.RAW_ASTRALIUM);
        assertNotNull(ModItems.ASTRALIUM_INGOT);

        //Check items are unique instances
        assertNotSame(ModItems.GLIMMERBERRY, ModItems.RAW_ASTRALIUM);
        assertNotSame(ModItems.RAW_ASTRALIUM, ModItems.ASTRALIUM_INGOT);
        assertNotSame(ModItems.GLIMMERBERRY, ModItems.ASTRALIUM_INGOT);
    }
    /**
     * Tests that registerModItems() method works without crashing.
     * The method being tested registers items and adds them to creative tabs.
     */
    @Test
    public void testRegisterModItems() {
        //Call the method and ensure it doesn't crash
        ModItems.registerModItems();

        assertTrue(true);
    }
    /**
     * Tests that all expected items are properly registered.
     * This ensures the registerItem method worked as it should.
     */
    @Test
    public void testItemRegistration() {
        //All items should be registered and have proper identifiers
        assertNotNull(ModItems.GLIMMERBERRY);
        assertNotNull(ModItems.RAW_ASTRALIUM);
        assertNotNull(ModItems.ASTRALIUM_INGOT);

        //Items should be properly configured
        assertNotNull(ModItems.GLIMMERBERRY.getDefaultStack());
        assertNotNull(ModItems.RAW_ASTRALIUM.getDefaultStack());
        assertNotNull(ModItems.ASTRALIUM_INGOT.getDefaultStack());
    }
    /**
     * Tests that items are actually in Minecraft's registry.
     */
    @Test
    public void testItemsAreInRegistry() {
        //Check if items are in Minecraft's registry
        Identifier glimmerberryId = Identifier.of("andrewmod", "glimmerberry");
        Identifier rawAstraliumId = Identifier.of("andrewmod", "raw_astralium");
        Identifier astraliumIngotId = Identifier.of("andrewmod", "astralium_ingot");

        assertTrue(Registries.ITEM.containsId(glimmerberryId));
        assertTrue(Registries.ITEM.containsId(rawAstraliumId));
        assertTrue(Registries.ITEM.containsId(astraliumIngotId));
    }
    /**
     * Tests that registry items match static fields
     */
    @Test
    public void testRegistryItemsMatchFields() {
        assertEquals(ModItems.GLIMMERBERRY, Registries.ITEM.get(Identifier.of("andrewmod", "glimmerberry")));
        assertEquals(ModItems.RAW_ASTRALIUM, Registries.ITEM.get(Identifier.of("andrewmod", "raw_astralium")));
        assertEquals(ModItems.ASTRALIUM_INGOT, Registries.ITEM.get(Identifier.of("andrewmod", "astralium_ingot")));
    }
    /**
     * Tests that items are instances of the Item class.
     */
    @Test
    public void testItemType() {
        //Items should be of type Item
        assertTrue(ModItems.GLIMMERBERRY instanceof Item);
        assertTrue(ModItems.RAW_ASTRALIUM instanceof Item);
        assertTrue(ModItems.ASTRALIUM_INGOT instanceof Item);
    }
}
