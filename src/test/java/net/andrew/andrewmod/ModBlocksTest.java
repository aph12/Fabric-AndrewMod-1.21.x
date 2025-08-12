package net.andrew.andrewmod;

import net.andrew.andrewmod.block.ModBlocks;
import net.minecraft.Bootstrap;
import net.minecraft.SharedConstants;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ModBlocks functionality.
 * Tests that methods in ModBlocks work properly.
 *
 * https://docs.fabricmc.net/develop/automatic-testing
 *
 * @author Andrew Herrera
 * @version 1.0
 */
public class ModBlocksTest {
    @BeforeAll
    public static void beforeAll() {
        SharedConstants.createGameVersion();
        Bootstrap.initialize();

        //Register mod blocks after minecraft is initialized
        ModBlocks.registerModBlocks();
    }
    /**
     * Tests that mod blocks are properly initialized as static final fields.
     * This verifies the blocks exist and are not null after class loading.
     */
    @Test
    public void testModBlocksInitialization() {
        //Check that all mod blocks are initialized and not null
        assertNotNull(ModBlocks.ASTRALIUM_ORE);
        assertNotNull(ModBlocks.ASTRALIUM_BLOCK);
    }
    /**
     * Tests that registerModBlocks() method works without crashing.
     * The method being tested registers blocks and logs the process.
     */
    @Test
    public void testRegisterModBlocks() {
        //Call the method and check it doesnt crash.
        ModBlocks.registerModBlocks();

        assertTrue(true);
    }
    /**
     * Tests that all expected blocks are properly registered.
     * This verifies the registerBlock method worked as it should.
     */
    @Test
    public void testBlockRegistration() {
        //All blocks should be registered and not null
        assertNotNull(ModBlocks.ASTRALIUM_ORE);
    }
    /**
     * Tests that blocks are actually in Minecraft's registry.
     */
    @Test
    public void testBlocksAreInRegistry() {
        //Check if blocks are in Minecraft's registry
        Identifier astraliumOreId = Identifier.of("andrewmod", "astralium_ore");

        assertTrue(Registries.BLOCK.containsId(astraliumOreId));
    }
    /**
     * Tests that registry blocks match static fields.
     */
    @Test
    public void testRegistryBlocksMatch() {
        assertEquals(ModBlocks.ASTRALIUM_ORE, Registries.BLOCK.get(Identifier.of("andrewmod", "astralium_ore")));
    }
    /**
     * Tests that blocks are instances of the Block class.
     */
    @Test
    public void testBlockType() {
        //Blocks should be of type Block
        assertTrue(ModBlocks.ASTRALIUM_ORE instanceof Block);
    }
}
