package net.stewardhail3433.stew3433mod.block.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.stewardhail3433.stew3433mod.Stew3433Mod;
import net.stewardhail3433.stew3433mod.block.ModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<StaffBuilderBlockEntity> STAFF_BUILDER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Stew3433Mod.MOD_ID, "staff_builder_be"),
                BlockEntityType.Builder.create(StaffBuilderBlockEntity::new,
                            ModBlocks.STAFF_BUILDER).build());

    public static final BlockEntityType<ItemLockableContainerBlockEntity> ITEM_LOCKABLE_CONTAINER_BLOCK_ENTITY =
                            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Stew3433Mod.MOD_ID, "item_lockable_container_be"),
                                BlockEntityType.Builder.create(ItemLockableContainerBlockEntity::new,
                                            ModBlocks.COOL_CONTAINER).build());

    public static void registerBlockEntities() {
        Stew3433Mod.LOGGER.info("Registering Block Entities for " + Stew3433Mod.MOD_ID);
    }
}
