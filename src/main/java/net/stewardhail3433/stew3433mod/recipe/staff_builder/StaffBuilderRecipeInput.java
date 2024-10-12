package net.stewardhail3433.stew3433mod.recipe.staff_builder;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.util.collection.DefaultedList;

public class StaffBuilderRecipeInput implements RecipeInput {
    private final DefaultedList<ItemStack> inventory;

    public StaffBuilderRecipeInput(DefaultedList<ItemStack> inventory) {
        this.inventory = inventory;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return inventory.get(index);
    }

    @Override
    public int getSize() {
        return inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : inventory) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    // Custom method to get a stack at a specific row and column
    public ItemStack getStackAt(int row, int column) {
        int index = row * 5 + column;
        return inventory.get(index);
    }

    // Override equals to compare inventory contents
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StaffBuilderRecipeInput)) return false;
        StaffBuilderRecipeInput other = (StaffBuilderRecipeInput) obj;
        return inventory.equals(other.inventory);
    }

    @Override
    public int hashCode() {
        return inventory.hashCode();
    }

    // Add any other necessary methods here if needed
}
