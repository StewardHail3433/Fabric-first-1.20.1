package net.stewardhail3433.stew3433mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.stewardhail3433.stew3433mod.block.ModBlocks;
import net.stewardhail3433.stew3433mod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool zoriumPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ZORIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ZORIUM_ORE);
        blockStateModelGenerator.registerLog(ModBlocks.TAWIN_LOG).log(ModBlocks.TAWIN_LOG);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_TAWIN_LOG).log(ModBlocks.STRIPPED_TAWIN_LOG);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ZORIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ZORIUM, Models.GENERATED);

        itemModelGenerator.register(ModItems.ZORIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ZORIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ZORIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ZORIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ZORIUM_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZORIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZORIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZORIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZORIUM_BOOTS));
    }
}