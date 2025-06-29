package net.andrew.andrewmod;

import net.fabricmc.api.ClientModInitializer;

/**
 * AndrewModClient handles client-side initialization for AndrewMod.
 * This class is responsible for registering client-only features such as advanced visual elements
 * Currently empty as the mod uses the default rendering for all content.
 *
 * @author Andrew Herrera
 * @version 1.0
 */
public class AndrewModClient implements ClientModInitializer {
    /**
     * Client-side initialization method called when the Minecraft client loads the mod.
     * Currently empty as all mod content uses default Minecraft rendering.
     * Stuff like custom models, particles etc. would be registered here.
     */
    @Override
    public void onInitializeClient() {

    }
}
