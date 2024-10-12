package net.stewardhail3433.stew3433mod.item.custom.staff;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.world.World;

public enum StaffMaterials implements StaffMaterial {
    TAWIN(40, 4F, 4F, 4F, 4F, EntityType.WIND_CHARGE);

    private final int maxChargeTime;
	private final float baseVelocity;
	private final float maxVelocity;
	private final float baseInaccuracy;
	private final float minInaccuracy;
    private final EntityType<? extends ProjectileEntity> projectileEntityType;



    private StaffMaterials(int maxChargeTime, float baseVelocity, float maxVelocity, float baseInaccuracy, float minInaccuracy, EntityType<? extends ProjectileEntity> projectileEntityType) {
		this.maxChargeTime = maxChargeTime;
		this.baseVelocity = baseVelocity;
		this.maxVelocity = maxVelocity;
		this.baseInaccuracy = baseInaccuracy;
		this.minInaccuracy = minInaccuracy;
		this.projectileEntityType = projectileEntityType;
	}

    @Override
    public int getMaxChargeTime() {
        return this.maxChargeTime;
    }

    @Override
    public float getMaxVelocity() {
        return this.maxVelocity;
    }

    @Override
    public float getBaseInaccuracy() {
        return this.baseInaccuracy;
    }

    @Override
    public float getMinInaccuracy() {
        return this.minInaccuracy;
    }

    @Override
    public int getDurability() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDurability'");
    }

    @Override
    public float getAttackDamage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAttackDamage'");
    }

    @Override
    public float getBaseVelocity() {
        return baseVelocity;
    }
    
    public ProjectileEntity createProjectile(World world, double x, double y, double z) {
        ProjectileEntity projectile = projectileEntityType.create(world);
        if (projectile != null) {
            projectile.refreshPositionAndAngles(x, y, z, 0.0F, 0.0F);
        }
        return projectile;

    }

}
