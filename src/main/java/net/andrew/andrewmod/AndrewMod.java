package net.andrew.andrewmod;

import net.andrew.andrewmod.block.ModBlocks;
import net.andrew.andrewmod.item.ModItemGroups;
import net.andrew.andrewmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *AndrewMod is the main mod class that handles initialization of all mod content.
 * This mod adds astralium-themed items, blocks, and creative tabs to Minecraft.
 * The mod focuses on astralium ore and related materials for crafting and building.
 *
 * Resources used:
 * https://www.youtube.com/watch?v=oU8-qV-ZtUY&list=PLKGarocXCE1H_HxOYihQMq0mlpqiUJj4L&ab_channel=ModdingbyKaupenjoe
 * https://docs.fabricmc.net/develop/
 *
 * @author Andrew Herrera
 * @version 1.0
 */
public class AndrewMod implements ModInitializer {
	/**
	 * The unique identifier for this mod.
	 * Used throughout the mod for registering items, blocks, and other content.
	 */
	public static final String MOD_ID = "andrewmod";
	/**
	 * Logger instance for writing mod information to console and log files.
	 * Uses the mod ID as the logger name for clear identification of log messages
	 */
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	/**
	 * Main initialization method called when Minecraft loads the mod.
	 * Registers all mod content in the correct oder: blocks, items, then creative tabs.
	 * This ensures all dependencies are available when creative tabs are populated.
	 */
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}