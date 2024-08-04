package net.stewardhail3433.stew3433mod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.stewardhail3433.stew3433mod.Stew3433Mod;

public class ModBlocks {
    public static final Block DEEPSLATE_ZORIUM_ORE = registerBlock("deepslate_zorium_ore", new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS).sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block ZORIUM_BLOCK = registerBlock("zorium_block", new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));
    
    
    public static void addItemsToBuildingBlocksItemGroup(FabricItemGroupEntries entries) {
        entries.add(DEEPSLATE_ZORIUM_ORE.asItem());
        entries.add(ZORIUM_BLOCK.asItem());
    }
    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Stew3433Mod.MOD_ID, name),  block);
    }

    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Stew3433Mod.MOD_ID, name),new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Stew3433Mod.LOGGER.info("Registering Mod Blocks for " + Stew3433Mod.MOD_ID);

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addItemsToBuildingBlocksItemGroup);
    }
}
