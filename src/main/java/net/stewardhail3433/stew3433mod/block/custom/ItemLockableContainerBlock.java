package net.stewardhail3433.stew3433mod.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.stewardhail3433.stew3433mod.block.entity.ItemLockableContainerBlockEntity;
import net.stewardhail3433.stew3433mod.block.entity.ModBlockEntities;
import net.stewardhail3433.stew3433mod.block.entity.StaffBuilderBlockEntity;

import org.jetbrains.annotations.Nullable;

import com.mojang.serialization.MapCodec;

public class ItemLockableContainerBlock extends BlockWithEntity {
    private static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 16);
    private Item key;
    
    public ItemLockableContainerBlock(Settings settings, Item key) {
        super(settings);
        this.key = key;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public void setKey(Item x) {
        key = x;
    }

    public Item getKey() {
        return key;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ItemLockableContainerBlockEntity(pos, state);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof StaffBuilderBlockEntity) {
                ItemScatterer.spawn(world, pos, (ItemLockableContainerBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        // TODO Auto-generated method stub
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = ((ItemLockableContainerBlockEntity) world.getBlockEntity(pos));

            if (((ItemLockableContainerBlockEntity) world.getBlockEntity(pos)).getlocked()) {
                player.addExperience(100);
            } else {
                if (screenHandlerFactory != null) {
                    player.openHandledScreen(screenHandlerFactory);
                }
            }
        }
        return ActionResult.SUCCESS_NO_ITEM_USED;
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
            PlayerEntity player, Hand hand, BlockHitResult hit) {
                if (!world.isClient) {
                    NamedScreenHandlerFactory screenHandlerFactory = ((ItemLockableContainerBlockEntity) world.getBlockEntity(pos));
        
                    if (((ItemLockableContainerBlockEntity) world.getBlockEntity(pos)).getlocked()) {
                        if (screenHandlerFactory != null && stack.getItem().equals(key)) {
                            player.openHandledScreen(screenHandlerFactory);
                            ((ItemLockableContainerBlockEntity) world.getBlockEntity(pos)).setlocked(false);
                        } else {
                            player.addExperience(100);
                        }
                    } else {
                        if (screenHandlerFactory != null) {
                            player.openHandledScreen(screenHandlerFactory);
                        }
                    }
                }
        
                return ItemActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.STAFF_BUILDER_BLOCK_ENTITY,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCodec'");
    }
}