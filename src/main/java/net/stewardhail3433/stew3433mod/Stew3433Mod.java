package net.stewardhail3433.stew3433mod;

import net.fabricmc.api.ModInitializer;
import net.stewardhail3433.stew3433mod.block.ModBlocks;
import net.stewardhail3433.stew3433mod.block.entity.ModBlockEntities;
import net.stewardhail3433.stew3433mod.item.ModItemGroups;
import net.stewardhail3433.stew3433mod.item.ModItems;
import net.stewardhail3433.stew3433mod.recipe.ModRecipeType;
import net.stewardhail3433.stew3433mod.screen.ModScreenHandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stew3433Mod implements ModInitializer {
	public static final String MOD_ID = "stew3433mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModItemGroups.registerItemGroups();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		ModRecipeType.registerRecipeType();
	}
}