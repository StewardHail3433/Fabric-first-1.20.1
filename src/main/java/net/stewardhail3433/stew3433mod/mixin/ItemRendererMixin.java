package net.stewardhail3433.stew3433mod.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.stewardhail3433.stew3433mod.Stew3433Mod;
import net.stewardhail3433.stew3433mod.item.ModItems;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useItemModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ModItems.TAWIN_STAFF) && renderMode != ModelTransformationMode.GUI) {
            if (renderMode == ModelTransformationMode.FIRST_PERSON_LEFT_HAND || 
                renderMode == ModelTransformationMode.FIRST_PERSON_RIGHT_HAND || 
                renderMode == ModelTransformationMode.THIRD_PERSON_LEFT_HAND || 
                renderMode == ModelTransformationMode.THIRD_PERSON_RIGHT_HAND) {
                
                return ((ItemRendererAccessor)this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of(Stew3433Mod.MOD_ID, "tawin_staff_3d"), "inventory"));
            }

            return ((ItemRendererAccessor)this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier( Identifier.of(Stew3433Mod.MOD_ID, "tawin_staff"), "inventory"));
        }
        return value;

    }
}
