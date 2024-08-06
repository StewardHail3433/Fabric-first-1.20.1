package net.stewardhail3433.stew3433mod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.stewardhail3433.stew3433mod.Stew3433Mod;

public class ModItems {
    public static final Item ZORIUM = registerItem("zorium", new Item(new FabricItemSettings()));
    public static final Item RAW_ZORIUM = registerItem("raw_zorium", new Item(new FabricItemSettings()));
    public static final Item ZORIUM_SWORD = registerItem("zorium_sword", new SwordItem(ModToolMaterial.ZORIUM, 4, -2.4F, new FabricItemSettings()));
    public static final Item ZORIUM_SHOVEL = registerItem("zorium_shovel", new ShovelItem(ModToolMaterial.ZORIUM, 1, -3F, new FabricItemSettings()));
    public static final Item ZORIUM_PICKAXE = registerItem("zorium_pickaxe", new PickaxeItem(ModToolMaterial.ZORIUM, 1, -2.8F, new FabricItemSettings()));
    public static final Item ZORIUM_AXE = registerItem("zorium_axe", new AxeItem(ModToolMaterial.ZORIUM, 6, -3.0F, new FabricItemSettings()));
    public static final Item ZORIUM_HOE = registerItem("zorium_hoe", new HoeItem(ModToolMaterial.ZORIUM, -4, 0.0F, new FabricItemSettings()));


    public static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(ZORIUM);
        entries.add(RAW_ZORIUM);
        entries.add(ZORIUM_SWORD);
    }

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Stew3433Mod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Stew3433Mod.LOGGER.info("Registering Mod Items for " + Stew3433Mod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
