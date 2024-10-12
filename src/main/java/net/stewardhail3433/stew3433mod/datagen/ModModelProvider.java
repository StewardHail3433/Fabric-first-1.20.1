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
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ZORIUM_BLOCK);
        
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ZORIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TAWIN_DIRT);
        blockStateModelGenerator.registerLog(ModBlocks.TAWIN_LOG).log(ModBlocks.TAWIN_LOG);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_TAWIN_LOG).log(ModBlocks.STRIPPED_TAWIN_LOG);

        BlockStateModelGenerator.BlockTexturePool tawinPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TAWIN_PLANKS);

        tawinPlanksPool.stairs(ModBlocks.TAWIN_STAIRS);
        tawinPlanksPool.slab(ModBlocks.TAWIN_SLAB);
        tawinPlanksPool.button(ModBlocks.TAWIN_BUTTON);
        tawinPlanksPool.pressurePlate(ModBlocks.TAWIN_PRESSURE_PLATE);
        tawinPlanksPool.fence(ModBlocks.TAWIN_FENCE);
        tawinPlanksPool.fenceGate(ModBlocks.TAWIN_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.TAWIN_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.TAWIN_TRAPDOOR);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TAWIN_LEAVES);

        BlockStateModelGenerator.BlockTexturePool ergoRockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ERGO_ROCK);
        ergoRockPool.stairs(ModBlocks.ERGO_ROCK_STAIRS);
        ergoRockPool.slab(ModBlocks.ERGO_ROCK_SLAB);
        ergoRockPool.button(ModBlocks.ERGO_ROCK_BUTTON);
        ergoRockPool.pressurePlate(ModBlocks.ERGO_ROCK_PRESSURE_PLATE);

        BlockStateModelGenerator.BlockTexturePool cobbledErgoRockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COBBLED_ERGO_ROCK);
        cobbledErgoRockPool.stairs(ModBlocks.COBBLED_ERGO_ROCK_STAIRS);
        cobbledErgoRockPool.slab(ModBlocks.COBBLED_ERGO_ROCK_SLAB);
        cobbledErgoRockPool.button(ModBlocks.COBBLED_ERGO_ROCK_BUTTON);
        cobbledErgoRockPool.pressurePlate(ModBlocks.COBBLED_ERGO_ROCK_PRESSURE_PLATE);
        cobbledErgoRockPool.wall(ModBlocks.COBBLED_ERGO_ROCK_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STAFF_BUILDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COOL_CONTAINER);

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

        // itemModelGenerator.register(ModItems.TAWIN_STAFF, Models.GENERATED);

        
    }
}