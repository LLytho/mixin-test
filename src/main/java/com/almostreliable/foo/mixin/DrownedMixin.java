package com.almostreliable.foo.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Drowned.class)
public class DrownedMixin {

    @Inject(method = "finalizeSpawn", at = @At("RETURN"))
    private void appendItemTest(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, SpawnGroupData spawnGroupData, CompoundTag compoundTag, CallbackInfoReturnable<SpawnGroupData> cir) {
        if (mobSpawnType == MobSpawnType.NATURAL) {
            var drowned = (Drowned) (Object) this;
            drowned.setItemInHand(drowned.getUsedItemHand(), new ItemStack(Items.APPLE));
        }
    }
}
