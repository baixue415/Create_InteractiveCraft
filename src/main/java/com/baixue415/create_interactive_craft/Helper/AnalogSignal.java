package com.baixue415.create_interactive_craft.Helper;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class AnalogSignal {
    public String channel;
    public Integer power;

    public AnalogSignal() {
        this.channel = "";
        this.power = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AnalogSignal that)) return false;
        return Objects.equals(channel, that.channel);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(channel);
    }
}
