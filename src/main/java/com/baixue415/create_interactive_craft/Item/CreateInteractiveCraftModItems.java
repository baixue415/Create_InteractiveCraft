package com.baixue415.create_interactive_craft.Item;

import com.baixue415.create_interactive_craft.Block.CreateInteractiveCraftModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreateInteractiveCraftModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "create_interactive_craft");
    // 注册方块对应的物品
    public static final RegistryObject<Item> color_redstone_lamp = ITEMS.register("color_redstone_lamp", () -> new BlockItem(CreateInteractiveCraftModBlocks.color_redstone_lamp.get(), new Item.Properties()));
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}