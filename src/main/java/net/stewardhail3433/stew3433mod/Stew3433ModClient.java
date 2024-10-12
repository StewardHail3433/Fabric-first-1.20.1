package net.stewardhail3433.stew3433mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.stewardhail3433.stew3433mod.block.ModBlocks;
import net.stewardhail3433.stew3433mod.screen.ModScreenHandlers;
import net.stewardhail3433.stew3433mod.screen.container.ItemLockableContainerScreen;
import net.stewardhail3433.stew3433mod.screen.staff_builder.StaffBuilderScreen;

public class Stew3433ModClient implements ClientModInitializer{

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TAWIN_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TAWIN_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TAWIN_TRAPDOOR, RenderLayer.getCutout());

        HandledScreens.register(ModScreenHandlers.STAFF_BUILDER_SCREEN_HANDLER, StaffBuilderScreen::new);
        HandledScreens.register(ModScreenHandlers.ITEM_LOCKABLE_CONTAINER_SCREEN_HANDLER, ItemLockableContainerScreen::new);
    }
    
}
