package net.stewardhail3433.stew3433mod.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.stewardhail3433.stew3433mod.block.entity.data.ItemLockableContainerData;
import net.stewardhail3433.stew3433mod.screen.container.ItemLockableContainerScreenHandler;

public class ItemLockableContainerBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory{

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(27, ItemStack.EMPTY);
    private String name;
    private boolean locked = true;
    public ItemLockableContainerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ITEM_LOCKABLE_CONTAINER_BLOCK_ENTITY, pos, state);
    }

    public void setlocked(Boolean x) {
        locked = x;
    }

    public Boolean getlocked() {
        return locked;
    }

    public void setDisplayName(String x) {
        name = x;
    }

    @Override
    public Text getDisplayName() {
        if (name ==null) { return Text.literal("NULL NAME");}
        return Text.literal(name);
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ItemLockableContainerScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Object getScreenOpeningData(ServerPlayerEntity player) {
        return new ItemLockableContainerData(this.pos);
    }
    
    @Override
    protected void writeNbt(NbtCompound nbt, WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putBoolean("item_lockable_container.locked", locked);
    }

    @Override
    protected void readNbt(NbtCompound nbt, WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        locked = nbt.getBoolean("item_lockable_container.locked");
        
    }
}
