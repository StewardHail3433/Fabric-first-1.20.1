package net.stewardhail3433.stew3433mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.stewardhail3433.stew3433mod.Stew3433Mod;
import net.stewardhail3433.stew3433mod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup Stew3433ModGroup = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Stew3433Mod.MOD_ID, "stew3433mod"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.stew3433mod"))
                    .icon(() -> new ItemStack(ModItems.ZORIUM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ZORIUM);
                        entries.add(ModItems.RAW_ZORIUM);


                        entries.add(ModBlocks.DEEPSLATE_ZORIUM_ORE.asItem());
                        entries.add(ModBlocks.ZORIUM_BLOCK.asItem());
                        entries.add(ModBlocks.TAWIN_LOG.asItem());
                        entries.add(ModBlocks.STRIPPED_TAWIN_LOG.asItem());

                        entries.add(ModItems.ZORIUM_SWORD);
                        entries.add(ModItems.ZORIUM_PICKAXE);
                        entries.add(ModItems.ZORIUM_AXE);
                        entries.add(ModItems.ZORIUM_SHOVEL);
                        entries.add(ModItems.ZORIUM_HOE);

                        entries.add(ModItems.ZORIUM_HELMET);
                        entries.add(ModItems.ZORIUM_CHESTPLATE);
                        entries.add(ModItems.ZORIUM_LEGGINGS);
                        entries.add(ModItems.ZORIUM_BOOTS);
                        
                    }).
                    build());


    public static void registerItemGroups() {
        Stew3433Mod.LOGGER.info("Registering Item Groups for " + Stew3433Mod.MOD_ID);
    }
}