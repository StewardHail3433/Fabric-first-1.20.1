package net.stewardhail3433.stew3433mod.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.stewardhail3433.stew3433mod.Stew3433Mod;

public class ModBlocks {
    public static final Block DEEPSLATE_ZORIUM_ORE = registerBlock("deepslate_zorium_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3,6), AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS).sounds(BlockSoundGroup.DEEPSLATE).strength(2f)));
    public static final Block ZORIUM_BLOCK = registerBlock("zorium_block", new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK).strength(2f)));
    public static final Block TAWIN_LOG = registerBlock("tawin_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).requiresTool()));
    public static final Block STRIPPED_TAWIN_LOG = registerBlock("stripped_tawin_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).requiresTool()));

    public static void addItemsToBuildingBlocksItemGroup(FabricItemGroupEntries entries) {
        entries.add(DEEPSLATE_ZORIUM_ORE.asItem());
        entries.add(ZORIUM_BLOCK.asItem());
    }
    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Stew3433Mod.MOD_ID, name),  block);
    }

    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(Stew3433Mod.MOD_ID, name),new BlockItem(block, new Item.Settings()));
    }

    private static void registerStrippableBlocks() {
        StrippableBlockRegistry.register(TAWIN_LOG, STRIPPED_TAWIN_LOG);
    }

    public static void registerModBlocks() {
        Stew3433Mod.LOGGER.info("Registering Mod Blocks for " + Stew3433Mod.MOD_ID);
        registerStrippableBlocks();

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addItemsToBuildingBlocksItemGroup);
    }
}
