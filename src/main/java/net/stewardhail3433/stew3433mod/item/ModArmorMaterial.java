package net.stewardhail3433.stew3433mod.item;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.stewardhail3433.stew3433mod.Stew3433Mod;

public class ModArmorMaterial {
	public static final RegistryEntry<ArmorMaterial> ZORIUM;

	@SuppressWarnings("unused")
	private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.tryParse(Stew3433Mod.MOD_ID + ":" + id)));
		return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
	}

	private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
			EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<>(ArmorItem.Type.class); 
		ArmorItem.Type[] var9 = Type.values();
		int var10 = var9.length;

		for(int var11 = 0; var11 < var10; ++var11) {
			ArmorItem.Type type = var9[var11];
			enumMap.put(type, (Integer)defense.get(type));
		}

		return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.tryParse(Stew3433Mod.MOD_ID + ":" + id), new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance));
	}
	static {
		ZORIUM = register("zorium", Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), (map) -> {
			map.put(ArmorItem.Type.BOOTS, 4);
			map.put(ArmorItem.Type.LEGGINGS, 7);
			map.put(ArmorItem.Type.CHESTPLATE, 8);
			map.put(ArmorItem.Type.HELMET, 3);
			map.put(ArmorItem.Type.BODY, 12);
		}), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.4F, 0.3F, () -> {
			return Ingredient.ofItems(ModItems.ZORIUM);
		});
	}
	
	// public static final RegistryEntry<ArmorMaterial> LEATHER;

	// private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

	// private final String name;
	// private final int durabilityMultiplier;
	// private final int[] protectionAmounts; // {helmet, chestplate, leggings, boots}
	// private final int enchantability;
	// private final SoundEvent equipSound;
	// private final float toughness;
	// private final float knockbackResistance;
	// private final Supplier<Ingredient> repairIngredientSupplier;

	// private ModArmorMaterial(
	// 	String name,
	// 	int durabilityMultiplier,
	// 	int[] protectionAmounts,
	// 	int enchantability,
	// 	SoundEvent equipSound,
	// 	float toughness,
	// 	float knockbackResistance,
	// 	Supplier<Ingredient> repairIngredientSupplier
	// ) {
	// 	this.name = name;
	// 	this.durabilityMultiplier = durabilityMultiplier;
	// 	this.protectionAmounts = protectionAmounts;
	// 	this.enchantability = enchantability;
	// 	this.equipSound = equipSound;
	// 	this.toughness = toughness;
	// 	this.knockbackResistance = knockbackResistance;
	// 	this.repairIngredientSupplier = repairIngredientSupplier;
	// }

    // @Override
	// public int getDurability(ArmorItem.Type type) {
	// 	return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
	// }

	// @Override
	// public int getProtection(ArmorItem.Type type) {
	// 	return this.protectionAmounts[type.ordinal()];
	// }

	// @Override
	// public int getEnchantability() {
	// 	return this.enchantability;
	// }

	// @Override
	// public SoundEvent getEquipSound() {
	// 	return this.equipSound;
	// }

	// @Override
	// public Ingredient getRepairIngredient() {
	// 	return this.repairIngredientSupplier.get();
	// }

	// @Override
	// public String getName() {
	// 	return Stew3433Mod.MOD_ID + ":" + this.name;
	// }

	// @Override
	// public float getToughness() {
	// 	return this.toughness;
	// }

	// @Override
	// public float getKnockbackResistance() {
	// 	return this.knockbackResistance;
	// }
}
