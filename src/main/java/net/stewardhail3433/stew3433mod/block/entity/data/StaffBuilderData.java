package net.stewardhail3433.stew3433mod.block.entity.data;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record StaffBuilderData(BlockPos pos) {
    public static final PacketCodec<RegistryByteBuf, StaffBuilderData> PACKET_CODEC = PacketCodec.tuple(BlockPos.PACKET_CODEC, StaffBuilderData::pos, StaffBuilderData::new);
}

