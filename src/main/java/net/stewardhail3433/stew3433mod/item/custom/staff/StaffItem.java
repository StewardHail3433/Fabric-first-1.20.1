package net.stewardhail3433.stew3433mod.item.custom.staff;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class StaffItem extends Item {
    private StaffMaterial material;
    private int chargeTime;

    public StaffItem(Settings settings, StaffMaterial material, int chargeTime) {
        super(settings);
        this.material = material;
        this.chargeTime = chargeTime;

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;
            int chargeTime = this.getMaxUseTime(stack) - remainingUseTicks;

            float chargeRatio = (float) chargeTime / material.getMaxChargeTime();
            chargeRatio = Math.min(chargeRatio, 1.0F);

            // Calculate velocity and inaccuracy based on charge ratio
            float velocity = this.material.getBaseVelocity() + (this.material.getMaxVelocity() - this.material.getBaseVelocity()) * chargeRatio;
            float inaccuracy = this.material.getBaseInaccuracy() - (this.material.getBaseInaccuracy() - this.material.getMinInaccuracy()) * chargeRatio;

            if (!world.isClient) {
                Vec3d lookDirection = player.getRotationVec(1.0F);
                double x = player.getX();
                double y = player.getY() + player.getEyeHeight(player.getPose());
                double z = player.getZ();

                ProjectileEntity projectile = this.material.createProjectile(world, x, y, z);
                if (projectile != null) {
                    projectile.setVelocity(lookDirection.x, lookDirection.y, lookDirection.z, velocity, inaccuracy);
                    world.spawnEntity(projectile);
                }
            }

            // Apply cooldown based on the charge time
            int cooldownTime = (int) (this.chargeTime + 40 * (1.0F - chargeRatio)); // Base cooldown plus additional time for lesser charges
            player.getItemCooldownManager().set(this, cooldownTime);
        }
    }

    public int getMaxUseTime(ItemStack stack) {
        return this.material.getMaxChargeTime();
    }

}
