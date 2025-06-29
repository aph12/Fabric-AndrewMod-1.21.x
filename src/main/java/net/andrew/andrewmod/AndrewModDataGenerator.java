package net.andrew.andrewmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

/**
 * AndrewModDataGenerator handles automatic generation of mod data files.
 * This class is responsible for generating JSON files such as recipes, loot tables, etc.
 * Currently empty as the mod uses manually created data files.
 *
 * @author Andrew Herrera
 * @version 1.0
 */
public class AndrewModDataGenerator implements DataGeneratorEntrypoint {
	/**
	 * Data generator initialization method called during the build process.
	 * Currently empty as all mod data are manually created.
	 * This is where you would create automatic generation of repetitive data files.
	 * @param fabricDataGenerator Fabric's data generation framework instance
	 */
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

	}
}
