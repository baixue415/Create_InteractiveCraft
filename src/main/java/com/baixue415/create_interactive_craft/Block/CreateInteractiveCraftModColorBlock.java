package com.baixue415.create_interactive_craft.Block;

import com.baixue415.create_interactive_craft.Block.BlockEntity.ColorRedstoneLampBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class CreateInteractiveCraftModColorBlock {
    public static void register(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            // 注册方块颜色
            BlockColors blockColors = Minecraft.getInstance().getBlockColors();
            blockColors.register((state, world, pos, tintIndex) -> {
                if (tintIndex != 0) return -1;
                if (pos == null || world == null) return -1;
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (!(blockEntity instanceof ColorRedstoneLampBlockEntity colorRedstoneLampBlockEntity)) return -1;
                return colorRedstoneLampBlockEntity.color;
            }, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create_interactive_craft:color_redstone_lamp")));
        });
    }
}