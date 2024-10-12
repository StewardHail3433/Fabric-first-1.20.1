package net.stewardhail3433.stew3433mod.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.stewardhail3433.stew3433mod.Stew3433Mod;
import net.stewardhail3433.stew3433mod.block.custom.ItemLockableContainerBlock;
import net.stewardhail3433.stew3433mod.block.custom.StaffBuilderBlock;

public class ModBlocks {
    public static final Block DEEPSLATE_ZORIUM_ORE = registerBlock("deepslate_zorium_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3,6), AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS).sounds(BlockSoundGroup.DEEPSLATE).strength(2f)));
    public static final Block ZORIUM_BLOCK = registerBlock("zorium_block", new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK).strength(2f)));
    
    public static final Block TAWIN_LOG = registerBlock("tawin_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).requiresTool()));
    public static final Block STRIPPED_TAWIN_LOG = registerBlock("stripped_tawin_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).requiresTool()));
    
    public static final Block TAWIN_DIRT = registerBlock("tawin_dirt", new PillarBlock(AbstractBlock.Settings.copy(Blocks.DIRT).requiresTool()));
    
    public static final Block TAWIN_PLANKS = registerBlock("tawin_planks", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block TAWIN_STAIRS = registerBlock("tawin_stairs", new StairsBlock(TAWIN_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block TAWIN_FENCE = registerBlock("tawin_fence", new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)));
    public static final Block TAWIN_TRAPDOOR = registerBlock("tawin_trapdoor", new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block TAWIN_BUTTON = registerBlock("tawin_button", new ButtonBlock(BlockSetType.OAK, 2, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)));
    public static final Block TAWIN_DOOR = registerBlock("tawin_door", new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block TAWIN_PRESSURE_PLATE = registerBlock("tawin_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)));
    public static final Block TAWIN_FENCE_GATE = registerBlock("tawin_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)));
    public static final Block TAWIN_SLAB = registerBlock("tawin_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));
    public static final Block TAWIN_LEAVES = registerBlock("tawin_leaves", new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).strength(4f).nonOpaque()));
    
    public static final Block ERGO_ROCK = registerBlock("ergo_rock", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(2.1f).requiresTool()));
    public static final Block COBBLED_ERGO_ROCK = registerBlock("cobbled_ergo_rock", new Block(AbstractBlock.Settings.copy(Blocks.COBBLED_DEEPSLATE).strength(1.9f).requiresTool()));

    public static final Block ERGO_ROCK_STAIRS = registerBlock("ergo_rock_stairs", new StairsBlock(ERGO_ROCK.getDefaultState(), AbstractBlock.Settings.copy(Blocks.STONE_STAIRS)));
    public static final Block ERGO_ROCK_BUTTON = registerBlock("ergo_rock_button", new ButtonBlock(BlockSetType.STONE, 5, AbstractBlock.Settings.copy(TAWIN_BUTTON)));
    public static final Block ERGO_ROCK_PRESSURE_PLATE = registerBlock("ergo_rock_pressure_plate", new PressurePlateBlock(BlockSetType.STONE, AbstractBlock.Settings.copy(Blocks.STONE_PRESSURE_PLATE)));
    public static final Block ERGO_ROCK_SLAB = registerBlock("ergo_rock_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE_SLAB)));

    public static final Block COBBLED_ERGO_ROCK_STAIRS = registerBlock("cobbled_ergo_rock_stairs", new StairsBlock(ERGO_ROCK.getDefaultState(), AbstractBlock.Settings.copy(Blocks.STONE_STAIRS)));
    public static final Block COBBLED_ERGO_ROCK_BUTTON = registerBlock("cobbled_ergo_rock_button", new ButtonBlock(BlockSetType.STONE, 5, AbstractBlock.Settings.copy(TAWIN_BUTTON)));
    public static final Block COBBLED_ERGO_ROCK_PRESSURE_PLATE = registerBlock("cobbled_ergo_rock_pressure_plate", new PressurePlateBlock(BlockSetType.STONE, AbstractBlock.Settings.copy(Blocks.STONE_PRESSURE_PLATE)));
    public static final Block COBBLED_ERGO_ROCK_SLAB = registerBlock("cobbled_ergo_rock_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE_SLAB)));
    public static final Block COBBLED_ERGO_ROCK_WALL = registerBlock("cobbled_ergo_rock_wall", new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICK_WALL)));

    public static final Block STAFF_BUILDER = registerBlock("staff_builder", new StaffBuilderBlock(AbstractBlock.Settings.create().mapColor(MapColor.BLUE).instrument(NoteBlockInstrument.BASS).strength(2.5F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block COOL_CONTAINER = registerBlock("cool_container", new ItemLockableContainerBlock(AbstractBlock.Settings.create().mapColor(MapColor.BLUE).instrument(NoteBlockInstrument.BASS).strength(2.5F).sounds(BlockSoundGroup.WOOD).burnable(), Items.DIAMOND));

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
