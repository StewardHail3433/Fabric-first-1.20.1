package net.stewardhail3433.stew3433mod.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.stewardhail3433.stew3433mod.Stew3433Mod;
import net.stewardhail3433.stew3433mod.recipe.staff_builder.StaffBuildingRecipe;

public class ModRecipeType {
    public static final RecipeSerializer<StaffBuildingRecipe> STAFF_BUILDING_SERIALIZER = Registry.register(
        Registries.RECIPE_SERIALIZER, Identifier.of(Stew3433Mod.MOD_ID, "staff_building"), new StaffBuildingRecipe.Serializer()
    );


    public static final RecipeType<StaffBuildingRecipe> STAFF_BUILDER_TYPE = Registry.register(
        Registries.RECIPE_TYPE, Identifier.of(Stew3433Mod.MOD_ID, StaffBuildingRecipe.Type.ID), StaffBuildingRecipe.Type.INSTANCE
    );
    
    public static void registerRecipeType() {
        Stew3433Mod.LOGGER.info("Registering RecipeType for " + Stew3433Mod.MOD_ID);
        RecipeSerializer.register(StaffBuildingRecipe.Serializer.ID, StaffBuildingRecipe.Serializer.INSTANCE);
    }
}
