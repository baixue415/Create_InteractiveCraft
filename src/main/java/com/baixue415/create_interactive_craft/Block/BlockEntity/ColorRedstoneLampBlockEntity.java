package com.baixue415.create_interactive_craft.Block.BlockEntity;

import com.baixue415.create_interactive_craft.Block.CreateInteractiveCraftModBlockEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ColorRedstoneLampBlockEntity extends BlockEntity {
    public ColorRedstoneLampBlockEntity(BlockPos pos, BlockState state) { super(CreateInteractiveCraftModBlockEntities.color_redstone_lamp_entity.get(), pos, state); }

    public int color = 0x000000;

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("color", this.color); // 保存到NBT
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.color = tag.getInt("color"); // 从NBT读取
    }

    //下面的全是模板 要改的可以去问ai
    @Override public ClientboundBlockEntityDataPacket getUpdatePacket() { return ClientboundBlockEntityDataPacket.create(this); }

    @Override public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        this.load(pkt.getTag());
        Minecraft.getInstance().levelRenderer.setBlocksDirty(
                this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ(),
                this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ()
        );
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag); // 保存需要同步的数据
        return tag;
    }
}