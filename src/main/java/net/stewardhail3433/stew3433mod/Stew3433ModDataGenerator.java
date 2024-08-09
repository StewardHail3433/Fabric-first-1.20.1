package net.stewardhail3433.stew3433mod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.stewardhail3433.stew3433mod.datagen.ModBlockTagProvider;
import net.stewardhail3433.stew3433mod.datagen.ModItemTagProvider;
import net.stewardhail3433.stew3433mod.datagen.ModLootTableProvider;
import net.stewardhail3433.stew3433mod.datagen.ModModelProvider;
import net.stewardhail3433.stew3433mod.datagen.ModRecipeProvider;

public class Stew3433ModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
	}
}
