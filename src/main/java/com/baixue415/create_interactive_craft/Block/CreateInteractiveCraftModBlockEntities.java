package com.baixue415.create_interactive_craft.Block;

import com.baixue415.create_interactive_craft.Block.BlockEntity.ColorRedstoneLampBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreateInteractiveCraftModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "vs_orbit");
    // 注册方块实体
    public static final RegistryObject<BlockEntityType<ColorRedstoneLampBlockEntity>> color_redstone_lamp_entity = BLOCK_ENTITIES.register("color_redstone_lamp_entity", () -> BlockEntityType.Builder.of(ColorRedstoneLampBlockEntity::new).build(null));
    // 在构造函数中注册到主模组总线
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}