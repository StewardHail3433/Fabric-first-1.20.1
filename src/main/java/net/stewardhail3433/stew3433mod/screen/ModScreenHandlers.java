package net.stewardhail3433.stew3433mod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.stewardhail3433.stew3433mod.Stew3433Mod;
import net.stewardhail3433.stew3433mod.block.entity.data.ItemLockableContainerData;
import net.stewardhail3433.stew3433mod.block.entity.data.StaffBuilderData;
import net.stewardhail3433.stew3433mod.screen.container.ItemLockableContainerScreenHandler;
import net.stewardhail3433.stew3433mod.screen.staff_builder.StaffBuilderScreenHandler;

public class ModScreenHandlers {

    public static final ScreenHandlerType<StaffBuilderScreenHandler> STAFF_BUILDER_SCREEN_HANDLER =
    Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Stew3433Mod.MOD_ID, "staff_builder"), new ExtendedScreenHandlerType<>(StaffBuilderScreenHandler::new, StaffBuilderData.PACKET_CODEC));

    public static final ScreenHandlerType<ItemLockableContainerScreenHandler> ITEM_LOCKABLE_CONTAINER_SCREEN_HANDLER =
    Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Stew3433Mod.MOD_ID, "item_lockable_container"), new ExtendedScreenHandlerType<>(ItemLockableContainerScreenHandler::new, ItemLockableContainerData.PACKET_CODEC));

    public static void registerScreenHandlers() {
        Stew3433Mod.LOGGER.info("Registering Screen Handlers for " + Stew3433Mod.MOD_ID);
    }

}
