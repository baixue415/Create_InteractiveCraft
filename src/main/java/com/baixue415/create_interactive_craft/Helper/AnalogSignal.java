package com.baixue415.create_interactive_craft.Helper;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class AnalogSignal {
    public String WorldId;
    public BlockPos blockPos;
    public String Channel;
    public Integer power;

    public AnalogSignal(Level world, BlockPos blockPos) {
        this.WorldId = world.dimension().location().toString();
        this.blockPos = blockPos;
        this.Channel = "";
        this.power = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AnalogSignal that)) return false;
        return Objects.equals(WorldId, that.WorldId) && Objects.equals(blockPos, that.blockPos);
    }
    @Override
    public int hashCode() {
        return Objects.hash(WorldId, blockPos);
    }
}
