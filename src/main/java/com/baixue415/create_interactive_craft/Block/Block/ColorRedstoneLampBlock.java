package com.baixue415.create_interactive_craft.Block.Block;

import com.baixue415.create_interactive_craft.Block.BlockEntity.ColorRedstoneLampBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
public class ColorRedstoneLampBlock extends Block implements EntityBlock {
    //这个必须有
    public ColorRedstoneLampBlock() {
        super(Properties.of()
                .strength(5f, 75f) // 硬度（挖掘时间）、爆炸抗性
                .sound(SoundType.STONE) // 音效类型
                .requiresCorrectToolForDrops() // 需要正确工具采集
                .lightLevel(state -> 8)
                .noOcclusion()
        );
    }
    //方块实体
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) { return new ColorRedstoneLampBlockEntity(pos, state); }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        if (!(world instanceof ServerLevel)) return;
        world.scheduleTick(pos, this, 1); //触发刻事件
    }
    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!(level instanceof ServerLevel)) return;
        super.onRemove(state, level, pos, newState, isMoving);
    }
    //刻事件
    @Override
    public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        super.tick(blockstate, world, pos, random);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (!(blockEntity instanceof ColorRedstoneLampBlockEntity colorRedstoneLampBlockEntity)) return;
        colorRedstoneLampBlockEntity.setChanged();
        world.sendBlockUpdated(pos, blockstate, blockstate, 3);
        world.scheduleTick(pos, this, 1);
    }
}