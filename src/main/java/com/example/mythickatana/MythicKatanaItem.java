package com.example.mythickatana;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MythicKatanaItem extends Item {
    public MythicKatanaItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        NbtCompound nbt = stack.getOrCreateNbt();
        int kills = nbt.getInt("kills");

        if (kills >= 4) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600, 2));
            nbt.putInt("kills", 0);
            stack.setNbt(nbt);
        }

        return TypedActionResult.success(stack);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity) {
            NbtCompound nbt = stack.getOrCreateNbt();
            int kills = nbt.getInt("kills");
            nbt.putInt("kills", kills + 1);
            stack.setNbt(nbt);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, LivingEntity entity, int slot, boolean selected) {
        if (selected && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2, 1, true, false));
        }
    }
}