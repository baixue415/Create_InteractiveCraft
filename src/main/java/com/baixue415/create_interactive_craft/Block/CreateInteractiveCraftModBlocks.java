package com.baixue415.create_interactive_craft.Block;

import com.baixue415.create_interactive_craft.Block.Block.ColorRedstoneLampBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreateInteractiveCraftModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "create_interactive_craft");
    // 注册方块
    public static final RegistryObject<Block> color_redstone_lamp = BLOCKS.register("color_redstone_lamp", ColorRedstoneLampBlock::new);
    // 在构造函数中注册到主模组总线
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}