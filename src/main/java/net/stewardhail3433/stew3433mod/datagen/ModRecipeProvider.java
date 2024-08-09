package net.stewardhail3433.stew3433mod.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.util.Identifier;
import net.stewardhail3433.stew3433mod.block.ModBlocks;
import net.stewardhail3433.stew3433mod.item.ModItems;
import net.stewardhail3433.stew3433mod.util.ModTags;

public class ModRecipeProvider extends FabricRecipeProvider {
        private static final List<ItemConvertible> ZORIUM_SMELTABLES = List.of(ModItems.RAW_ZORIUM,
                        ModBlocks.DEEPSLATE_ZORIUM_ORE);

        public ModRecipeProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registryLookupFuture) {
                super(output, registryLookupFuture);
        }

        @Override
        public void generate(RecipeExporter exporter) {

                offerSmelting(exporter, ZORIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ZORIUM,
                                0.7f, 200, "ruby");
                offerBlasting(exporter, ZORIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ZORIUM,
                                0.7f, 100, "ruby");

                offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ZORIUM,
                                RecipeCategory.DECORATIONS,
                                ModBlocks.ZORIUM_BLOCK);

                ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ZORIUM_SWORD, 1)
                                .pattern("Z")
                                .pattern("Z")
                                .pattern("B")
                                .input('Z', ModItems.ZORIUM)
                                .input('B', Items.BLAZE_ROD)
                                .criterion(hasItem(ModItems.ZORIUM), conditionsFromItem(ModItems.ZORIUM))
                                .criterion(hasItem(ModItems.ZORIUM_SWORD), conditionsFromItem(ModItems.ZORIUM_SWORD))
                                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.ZORIUM_SWORD)));

                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ZORIUM_PICKAXE)
                                .pattern("ZZZ")
                                .pattern(" B ")
                                .pattern(" B ")
                                .input('Z', ModItems.ZORIUM)
                                .input('B', Items.BLAZE_ROD)
                                .criterion(hasItem(ModItems.ZORIUM), conditionsFromItem(ModItems.ZORIUM))
                                .criterion(hasItem(ModItems.ZORIUM_PICKAXE),
                                                conditionsFromItem(ModItems.ZORIUM_PICKAXE))
                                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.ZORIUM_PICKAXE)));

                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ZORIUM_AXE)
                                .pattern("ZZ")
                                .pattern("BZ")
                                .pattern("B ")
                                .input('Z', ModItems.ZORIUM)
                                .input('B', Items.BLAZE_ROD)
                                .criterion(hasItem(ModItems.ZORIUM), conditionsFromItem(ModItems.ZORIUM))
                                .criterion(hasItem(ModItems.ZORIUM_AXE), conditionsFromItem(ModItems.ZORIUM_AXE))
                                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.ZORIUM_AXE)));

                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ZORIUM_SHOVEL)
                                .pattern("Z")
                                .pattern("B")
                                .pattern("B")
                                .input('Z', ModItems.ZORIUM)
                                .input('B', Items.BLAZE_ROD)
                                .criterion(hasItem(ModItems.ZORIUM), conditionsFromItem(ModItems.ZORIUM))
                                .criterion(hasItem(ModItems.ZORIUM_SHOVEL), conditionsFromItem(ModItems.ZORIUM_SHOVEL))
                                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.ZORIUM_SHOVEL)));

                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ZORIUM_HOE)
                                .pattern("ZZ")
                                .pattern(" B")
                                .pattern(" B")
                                .input('Z', ModItems.ZORIUM)
                                .input('B', Items.BLAZE_ROD)
                                .criterion(hasItem(ModItems.ZORIUM), conditionsFromItem(ModItems.ZORIUM))
                                .criterion(hasItem(ModItems.ZORIUM_HOE), conditionsFromItem(ModItems.ZORIUM_HOE))
                                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.ZORIUM_HOE)));

                ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ZORIUM_CHESTPLATE)
                                .pattern("Z Z")
                                .pattern("TZT")
                                .pattern("ZZZ")
                                .input('Z', ModItems.ZORIUM)
                                .input('T', ModTags.Items.TAWIN_LOGS)
                                .criterion(hasItem(ModItems.ZORIUM), conditionsFromItem(ModItems.ZORIUM))
                                .criterion(hasItem(ModItems.ZORIUM_CHESTPLATE),
                                                conditionsFromItem(ModItems.ZORIUM_CHESTPLATE))
                                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.ZORIUM_CHESTPLATE)));

                ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ZORIUM_HELMET)
                                .pattern("ZZZ")
                                .pattern("Z Z")
                                .pattern("   ")
                                .input('Z', ModItems.ZORIUM)
                                .criterion(hasItem(ModItems.ZORIUM), conditionsFromItem(ModItems.ZORIUM))
                                .criterion(hasItem(ModItems.ZORIUM_HELMET), conditionsFromItem(ModItems.ZORIUM_HELMET))
                                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.ZORIUM_HELMET)));

                ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ZORIUM_LEGGINGS)
                                .pattern("ZZZ")
                                .pattern("Z Z")
                                .pattern("Z Z")
                                .input('Z', ModItems.ZORIUM)
                                .criterion(hasItem(ModItems.ZORIUM), conditionsFromItem(ModItems.ZORIUM))
                                .criterion(hasItem(ModItems.ZORIUM_LEGGINGS),
                                                conditionsFromItem(ModItems.ZORIUM_LEGGINGS))
                                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.ZORIUM_LEGGINGS)));

                ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ZORIUM_BOOTS)
                                .pattern("   ")
                                .pattern("Z Z")
                                .pattern("Z Z")
                                .input('Z', ModItems.ZORIUM)
                                .criterion(hasItem(ModItems.ZORIUM), conditionsFromItem(ModItems.ZORIUM))
                                .criterion(hasItem(ModItems.ZORIUM_BOOTS), conditionsFromItem(ModItems.ZORIUM_BOOTS))
                                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.ZORIUM_BOOTS)));
        }

}