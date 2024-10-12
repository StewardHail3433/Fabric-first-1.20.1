package net.stewardhail3433.stew3433mod.screen.container;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.stewardhail3433.stew3433mod.block.entity.ItemLockableContainerBlockEntity;
import net.stewardhail3433.stew3433mod.block.entity.data.ItemLockableContainerData;
import net.stewardhail3433.stew3433mod.screen.ModScreenHandlers;

public class ItemLockableContainerScreenHandler extends ScreenHandler {
    private final ScreenHandlerContext context;

    private final Inventory inventory;

    public final ItemLockableContainerBlockEntity blockEntity;

    public ItemLockableContainerScreenHandler(int syncId, PlayerInventory playerInventory, ItemLockableContainerData data) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(data.pos()));
    }


    public ItemLockableContainerScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity) {
        super(ModScreenHandlers.ITEM_LOCKABLE_CONTAINER_SCREEN_HANDLER, syncId);
        checkSize(((Inventory) blockEntity), 27);
        this.inventory = ((Inventory) blockEntity);
        inventory.onOpen(playerInventory.player);
        this.blockEntity = (ItemLockableContainerBlockEntity) blockEntity;
        context = ScreenHandlerContext.create(playerInventory.player.getWorld(), blockEntity.getPos());

        for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				int k = j + i * 9;
                this.addSlot(new Slot(inventory, k, 9 + j * 18, 18 + i * 18));
            }
        }

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }


    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();

            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }


    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
