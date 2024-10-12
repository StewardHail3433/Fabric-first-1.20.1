package net.stewardhail3433.stew3433mod.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.stewardhail3433.stew3433mod.block.ModBlocks;
import net.stewardhail3433.stew3433mod.util.ModTags;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

        public ModBlockTagProvider(FabricDataOutput output,
                        CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
                super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
                getOrCreateTagBuilder(BlockTags.LOGS)
                        .add(ModBlocks.TAWIN_LOG)
                        .add(ModBlocks.STRIPPED_TAWIN_LOG);

                getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                        .add(ModBlocks.TAWIN_LOG)
                        .add(ModBlocks.STRIPPED_TAWIN_LOG);

                getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                        .add(ModBlocks.DEEPSLATE_ZORIUM_ORE)
                        .add(ModBlocks.ZORIUM_BLOCK);

                getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                        .add(ModBlocks.TAWIN_LOG)
                        .add(ModBlocks.STRIPPED_TAWIN_LOG)
                        .add(ModBlocks.TAWIN_PLANKS)
                        .add(ModBlocks.TAWIN_STAIRS)
                        .add(ModBlocks.TAWIN_FENCE)
                        .add(ModBlocks.TAWIN_TRAPDOOR)
                        .add(ModBlocks.TAWIN_BUTTON)
                        .add(ModBlocks.TAWIN_DOOR)
                        .add(ModBlocks.TAWIN_PRESSURE_PLATE)
                        .add(ModBlocks.TAWIN_FENCE_GATE)
                        .add(ModBlocks.TAWIN_SLAB);

                getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                        .add(ModBlocks.TAWIN_DIRT);

                getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")))
                        .add(ModBlocks.DEEPSLATE_ZORIUM_ORE)
                        .add(ModBlocks.ZORIUM_BLOCK);

                getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_5")))
                        .add(ModBlocks.TAWIN_LOG)
                        .add(ModBlocks.STRIPPED_TAWIN_LOG)
                        .add(ModBlocks.TAWIN_PLANKS)
                        .add(ModBlocks.TAWIN_STAIRS)
                        .add(ModBlocks.TAWIN_FENCE)
                        .add(ModBlocks.TAWIN_TRAPDOOR)
                        .add(ModBlocks.TAWIN_BUTTON)
                        .add(ModBlocks.TAWIN_DOOR)
                        .add(ModBlocks.TAWIN_PRESSURE_PLATE)
                        .add(ModBlocks.TAWIN_FENCE_GATE)
                        .add(ModBlocks.TAWIN_SLAB)
                        .add(ModBlocks.TAWIN_DIRT);

                getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                        .add(ModBlocks.TAWIN_LOG)
                        .add(ModBlocks.STRIPPED_TAWIN_LOG)
                        .add(ModBlocks.TAWIN_PLANKS)
                        .add(ModBlocks.TAWIN_STAIRS)
                        .add(ModBlocks.TAWIN_FENCE)
                        .add(ModBlocks.TAWIN_TRAPDOOR)
                        .add(ModBlocks.TAWIN_BUTTON)
                        .add(ModBlocks.TAWIN_DOOR)
                        .add(ModBlocks.TAWIN_PRESSURE_PLATE)
                        .add(ModBlocks.TAWIN_FENCE_GATE)
                        .add(ModBlocks.TAWIN_SLAB)
                        .add(ModBlocks.TAWIN_DIRT);

                getOrCreateTagBuilder(ModTags.Blocks.TAWIN_LOGS)
                        .add(ModBlocks.TAWIN_LOG)
                        .add(ModBlocks.STRIPPED_TAWIN_LOG);

                getOrCreateTagBuilder(BlockTags.FENCES)
                        .add(ModBlocks.TAWIN_FENCE);

                getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                        .add(ModBlocks.TAWIN_FENCE_GATE);

                getOrCreateTagBuilder(BlockTags.STAIRS)
                        .add(ModBlocks.TAWIN_STAIRS)
                        .add(ModBlocks.ERGO_ROCK_STAIRS)
                        .add(ModBlocks.COBBLED_ERGO_ROCK_STAIRS);;

                getOrCreateTagBuilder(BlockTags.SLABS)
                        .add(ModBlocks.TAWIN_SLAB)
                        .add(ModBlocks.ERGO_ROCK_BUTTON)
                        .add(ModBlocks.COBBLED_ERGO_ROCK_BUTTON);

                getOrCreateTagBuilder(BlockTags.BUTTONS)
                        .add(ModBlocks.TAWIN_BUTTON)
                        .add(ModBlocks.ERGO_ROCK_BUTTON)
                        .add(ModBlocks.COBBLED_ERGO_ROCK_BUTTON);

                getOrCreateTagBuilder(BlockTags.DOORS)
                        .add(ModBlocks.TAWIN_DOOR);

                getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                        .add(ModBlocks.TAWIN_TRAPDOOR);

                getOrCreateTagBuilder(BlockTags.PLANKS)
                        .add(ModBlocks.TAWIN_PLANKS);

                getOrCreateTagBuilder(BlockTags.LEAVES)
                        .add(ModBlocks.TAWIN_LEAVES);
                
                getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                        .add(ModBlocks.TAWIN_PRESSURE_PLATE)
                        .add(ModBlocks.ERGO_ROCK_PRESSURE_PLATE)
                        .add(ModBlocks.COBBLED_ERGO_ROCK_PRESSURE_PLATE);

                getOrCreateTagBuilder(BlockTags.WALLS)
                        .add(ModBlocks.COBBLED_ERGO_ROCK_WALL);

        }

}
