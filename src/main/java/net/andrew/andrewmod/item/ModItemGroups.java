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

public class ModItemGroups {
    public static final ItemGroup GLIMMERBERRY_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AndrewMod.MOD_ID, "glimmerberry"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.glimmerberry"))
                    .icon(() -> new ItemStack(ModItems.GLIMMERBERRY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.GLIMMERBERRY);
                    }).build());

    public static final ItemGroup ASTRALIUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AndrewMod.MOD_ID, "astralium"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.astralium"))
                    .icon(() -> new ItemStack(ModItems.RAW_ASTRALIUM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_ASTRALIUM);
                        entries.add(ModItems.ASTRALIUM_INGOT);
                    }).build());

    public static final ItemGroup ASTRALIUM_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AndrewMod.MOD_ID, "astralium_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.astralium_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.ASTRALIUM_ORE)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ASTRALIUM_ORE);
                    }).build());


    public static void registerItemGroups() {
        AndrewMod.LOGGER.info("Registering Item Groups for " + AndrewMod.MOD_ID);
    }
}
