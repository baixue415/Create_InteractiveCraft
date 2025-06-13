package com.baixue415.create_interactive_craft.Block.Block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
public class ColorRedstoneLampBlock extends Block{
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

    //附近充能
    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean isMoving) {
        if (!(world instanceof ServerLevel)) return;// 确保只在服务端执行
    }
}