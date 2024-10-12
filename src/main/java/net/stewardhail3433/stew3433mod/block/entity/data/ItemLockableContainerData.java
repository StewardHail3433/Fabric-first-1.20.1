package net.stewardhail3433.stew3433mod.block.entity.data;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record ItemLockableContainerData(BlockPos pos) {
    public static final PacketCodec<RegistryByteBuf, ItemLockableContainerData> PACKET_CODEC = PacketCodec.tuple(BlockPos.PACKET_CODEC, ItemLockableContainerData::pos, ItemLockableContainerData::new);
}

