package net.stewardhail3433.stew3433mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
// import net.minecraft.item.ArmorItem;
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
import net.stewardhail3433.stew3433mod.item.custom.staff.StaffItem;
import net.stewardhail3433.stew3433mod.item.custom.staff.StaffMaterials;

public class ModItems {
    public static final Item ZORIUM = registerItem("zorium", new Item(new Item.Settings()));
    public static final Item RAW_ZORIUM = registerItem("raw_zorium", new Item(new Item.Settings()));

    public static final Item ZORIUM_SWORD = registerItem("zorium_sword", new SwordItem(ModToolMaterial.ZORIUM, (new Item.Settings()).attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.ZORIUM,  4, -2.4F))));
    public static final Item ZORIUM_SHOVEL = registerItem("zorium_shovel", new ShovelItem(ModToolMaterial.ZORIUM, (new Item.Settings()).attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.ZORIUM,  1, -3F))));
    public static final Item ZORIUM_PICKAXE = registerItem("zorium_pickaxe", new PickaxeItem(ModToolMaterial.ZORIUM, (new Item.Settings()).attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterial.ZORIUM, 1, -2.8F))));
    public static final Item ZORIUM_AXE = registerItem("zorium_axe", new AxeItem(ModToolMaterial.ZORIUM, (new Item.Settings()).attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterial.ZORIUM, 6, -3.0F))));
    public static final Item ZORIUM_HOE = registerItem("zorium_hoe", new HoeItem(ModToolMaterial.ZORIUM, (new Item.Settings()).attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterial.ZORIUM, -4, 0.0F))));

    public static final Item ZORIUM_HELMET = registerItem("zorium_helmet", new ArmorItem(ModArmorMaterial.ZORIUM, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(net.minecraft.item.ArmorItem.Type.HELMET.getMaxDamage(38))));
    public static final Item ZORIUM_CHESTPLATE = registerItem("zorium_chestplate", new ArmorItem(ModArmorMaterial.ZORIUM, ArmorItem.Type.CHESTPLATE, (new Item.Settings()).maxDamage(net.minecraft.item.ArmorItem.Type.CHESTPLATE.getMaxDamage(38))));
    public static final Item ZORIUM_LEGGINGS = registerItem("zorium_leggings", new ArmorItem(ModArmorMaterial.ZORIUM, ArmorItem.Type.LEGGINGS, (new Item.Settings()).maxDamage(net.minecraft.item.ArmorItem.Type.LEGGINGS.getMaxDamage(38))));
    public static final Item ZORIUM_BOOTS = registerItem("zorium_boots", new ArmorItem(ModArmorMaterial.ZORIUM, ArmorItem.Type.BOOTS, (new Item.Settings()).maxDamage(net.minecraft.item.ArmorItem.Type.BOOTS.getMaxDamage(38))));

    public static final Item TAWIN_STAFF = registerItem("tawin_staff", new StaffItem(new Item.Settings(), StaffMaterials.TAWIN, 20));
    
    public static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(ZORIUM);
        entries.add(RAW_ZORIUM);
        entries.add(ZORIUM_SWORD);
    }

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Stew3433Mod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Stew3433Mod.LOGGER.info("Registering Mod Items for " + Stew3433Mod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
