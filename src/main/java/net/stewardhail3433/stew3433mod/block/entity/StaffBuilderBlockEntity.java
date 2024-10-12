package net.stewardhail3433.stew3433mod.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.stewardhail3433.stew3433mod.block.entity.data.StaffBuilderData;
import net.stewardhail3433.stew3433mod.recipe.ModRecipeType;
import net.stewardhail3433.stew3433mod.recipe.staff_builder.StaffBuilderRecipeInput;
import net.stewardhail3433.stew3433mod.screen.staff_builder.StaffBuilderScreenHandler;

public class StaffBuilderBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory{

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(16, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 15;

    public StaffBuilderBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STAFF_BUILDER_BLOCK_ENTITY, pos, state);
    }
    

    @Override
    public Text getDisplayName() {
        return Text.literal("Staff Builder Station");
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new StaffBuilderScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Object getScreenOpeningData(ServerPlayerEntity player) {
        return new StaffBuilderData(this.pos);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) {
            return;
        }
    
        // Wrap the inventory in the StaffBuilderRecipeInput
        StaffBuilderRecipeInput recipeInput = new StaffBuilderRecipeInput(this.inventory);
    
        // Get the RecipeManager instance
        RecipeManager recipeManager = world.getRecipeManager();
    
        // Try to find the first matching recipe
        recipeManager.getFirstMatch(ModRecipeType.STAFF_BUILDER_TYPE, recipeInput, world)
    .ifPresent(recipeEntry -> {
        ItemStack result = recipeEntry.value().craft(recipeInput, world.getRegistryManager());

        // Add the result to the output slot if possible
        if (this.inventory.get(OUTPUT_SLOT).isEmpty()) {
            this.inventory.set(OUTPUT_SLOT, result);
        } else {
            // Handle existing items in the output slot (stack, drop, etc.)
        }
    });
    }
}
