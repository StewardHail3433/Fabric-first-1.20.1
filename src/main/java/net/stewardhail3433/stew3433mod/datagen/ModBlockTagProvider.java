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

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
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
                .add(ModBlocks.STRIPPED_TAWIN_LOG);
                

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")))
                .add(ModBlocks.DEEPSLATE_ZORIUM_ORE)
                .add(ModBlocks.ZORIUM_BLOCK);
        
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_5")))
                .add(ModBlocks.TAWIN_LOG)
                .add(ModBlocks.STRIPPED_TAWIN_LOG);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .add(ModBlocks.TAWIN_LOG)
                .add(ModBlocks.STRIPPED_TAWIN_LOG);

        getOrCreateTagBuilder(ModTags.Blocks.TAWIN_LOGS)
                .add(ModBlocks.TAWIN_LOG)
                .add(ModBlocks.STRIPPED_TAWIN_LOG);
    }
    
}
