package com.baixue415.create_interactive_craft.Helper;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class AnalogSignalPool {
    private static List<AnalogSignal> AnalogSignalPool = new ArrayList<>();

    public static void clear() { AnalogSignalPool.clear(); }
    public static List<AnalogSignal> getAnalogSignalPool() { return new ArrayList<>(AnalogSignalPool); }

    public static Integer getPowerFromChannel(String channel) {
        for (AnalogSignal analogSignal : AnalogSignalPool) {
            if (analogSignal.channel.equals(channel)) {
                return analogSignal.power;
            }
        }
        return 0;
    }
}
