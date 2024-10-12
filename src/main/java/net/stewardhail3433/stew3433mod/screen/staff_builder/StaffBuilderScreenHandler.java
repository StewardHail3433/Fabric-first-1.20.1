package net.stewardhail3433.stew3433mod.screen.staff_builder;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.stewardhail3433.stew3433mod.block.entity.StaffBuilderBlockEntity;
import net.stewardhail3433.stew3433mod.block.entity.data.StaffBuilderData;
import net.stewardhail3433.stew3433mod.screen.ModScreenHandlers;

public class StaffBuilderScreenHandler extends ScreenHandler {
    private final ScreenHandlerContext context;

    private final Inventory inventory;

    public final StaffBuilderBlockEntity blockEntity;

    public StaffBuilderScreenHandler(int syncId, PlayerInventory playerInventory, StaffBuilderData data) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(data.pos()));
    }


    public StaffBuilderScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity) {
        super(ModScreenHandlers.STAFF_BUILDER_SCREEN_HANDLER, syncId);
        checkSize(((Inventory) blockEntity), 16);
        this.inventory = ((Inventory) blockEntity);
        inventory.onOpen(playerInventory.player);
        this.blockEntity = (StaffBuilderBlockEntity) blockEntity;
        context = ScreenHandlerContext.create(playerInventory.player.getWorld(), blockEntity.getPos());

        for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				int k = j + i * 5;
                this.addSlot(new Slot(inventory, k, 27 + j * 18, 17 + i * 18));
            }
        }

        this.addSlot(new RestrictedSlot(inventory, 15, 135, 35));
        

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

            if (invSlot == 15) { // Check if the player is interacting with the output slot
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }

                // Consume the ingredients
                for (int i = 0; i < 15; i++) {
                    ItemStack stackInSlot = this.inventory.getStack(i);
                    if (!stackInSlot.isEmpty()) {
                        stackInSlot.decrement(1);
                        if (stackInSlot.isEmpty()) {
                            this.inventory.setStack(i, ItemStack.EMPTY);
                        }
                    }
                }
            } else if (invSlot < this.inventory.size()) {
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
        return this.inventory.canPlayerUse(player);
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

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);

        // Check if the world is not client-side
        this.context.run((world, pos) -> this.dropInventory(player, this.inventory));
    }

    private class RestrictedSlot extends Slot {
    
        public RestrictedSlot(Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }
    
        @Override
        public boolean canInsert(ItemStack stack) {
            return false;
        }
    
        @Override
        public boolean canTakeItems(PlayerEntity playerEntity) {
            return super.canTakeItems(playerEntity);
        }

        @Override
        public void onTakeItem(PlayerEntity player, ItemStack stack) {
            super.onTakeItem(player, stack);

            // Calculate how many items were taken
            int amountTaken = stack.getCount();

            // Subtract the correct number of items from each input slot
            for (int i = 0; i < 15; i++) {
                ItemStack stackInSlot = inventory.getStack(i);
                if (!stackInSlot.isEmpty()) {
                    stackInSlot.decrement(amountTaken);
                    if (stackInSlot.isEmpty()) {
                        inventory.setStack(i, ItemStack.EMPTY);
                    }
                }
            }
        }
    }
    
        
} 

