package com.baixue415.create_interactive_craft.Helper;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class AnalogSignalPool {
    private static List<AnalogSignal> AnalogSignalPool = new ArrayList<>();

    public static List<AnalogSignal> getAnalogSignalPool() { return new ArrayList<>(AnalogSignalPool); }
    @Nullable public static AnalogSignal getAnalogSignalFormPos(Level world, BlockPos blockPos) { for (AnalogSignal analogSignal : AnalogSignalPool) if (analogSignal.WorldId.equals(world.dimension().location().toString()) && analogSignal.blockPos.equals(blockPos)) return analogSignal; return null; }
}
