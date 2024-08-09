package net.stewardhail3433.stew3433mod.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.stewardhail3433.stew3433mod.block.ModBlocks;
import net.stewardhail3433.stew3433mod.item.ModItems;
import net.stewardhail3433.stew3433mod.util.ModTags;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.TAWIN_LOGS)
            .add(ModBlocks.TAWIN_LOG.asItem())
            .add(ModBlocks.STRIPPED_TAWIN_LOG.asItem());
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
            .add(ModItems.ZORIUM_HELMET)
            .add(ModItems.ZORIUM_CHESTPLATE)
            .add(ModItems.ZORIUM_LEGGINGS)
            .add(ModItems.ZORIUM_BOOTS);
    }
}