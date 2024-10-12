package net.stewardhail3433.stew3433mod.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.stewardhail3433.stew3433mod.block.ModBlocks;
import net.stewardhail3433.stew3433mod.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<WrapperLookup> registryLookupFuture) {
        super(dataOutput, registryLookupFuture);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ZORIUM_BLOCK);
        addDrop(ModBlocks.TAWIN_LOG);
        addDrop(ModBlocks.STRIPPED_TAWIN_LOG);
        addDrop(ModBlocks.TAWIN_DIRT);
        addDrop(ModBlocks.TAWIN_PLANKS);
        addDrop(ModBlocks.TAWIN_STAIRS);
        addDrop(ModBlocks.TAWIN_FENCE);
        addDrop(ModBlocks.TAWIN_TRAPDOOR);
        addDrop(ModBlocks.TAWIN_BUTTON);
        addDrop(ModBlocks.TAWIN_DOOR);
        addDrop(ModBlocks.TAWIN_PRESSURE_PLATE);
        addDrop(ModBlocks.TAWIN_FENCE_GATE);
        addDrop(ModBlocks.TAWIN_SLAB);


        addDrop(ModBlocks.DEEPSLATE_ZORIUM_ORE, ModOreDrops(ModBlocks.DEEPSLATE_ZORIUM_ORE, ModItems.RAW_ZORIUM));
    }


    // @SuppressWarnings({ "rawtypes", "unchecked" })
    public LootTable.Builder ModOreDrops(Block drop, Item item) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return dropsWithSilkTouch(drop, 
            applyExplosionDecay(drop,
                ItemEntry.builder(item)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(5)))
                    .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
            )
        );

    }
}