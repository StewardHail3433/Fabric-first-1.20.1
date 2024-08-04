package net.stewardhail3433.stew3433mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.stewardhail3433.stew3433mod.Stew3433Mod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup Stew3433ModGroup = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Stew3433Mod.MOD_ID, "stew3433mod"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.stew3433mod"))
                    .icon(() -> new ItemStack(ModItems.ZORIUM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ZORIUM);
                        entries.add(ModItems.RAW_ZORIUM);
                    }).build());


    public static void registerItemGroups() {
        Stew3433Mod.LOGGER.info("Registering Item Groups for " + Stew3433Mod.MOD_ID);
    }
}