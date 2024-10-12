package net.stewardhail3433.stew3433mod.item.custom.staff;

import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.world.World;

public interface StaffMaterial {

    int getDurability();

    int getMaxChargeTime();

    float getAttackDamage();

    float getBaseVelocity();

    float getMaxVelocity();

    float getBaseInaccuracy();

    float getMinInaccuracy();

    ProjectileEntity createProjectile(World world, double x, double y, double z);
}
