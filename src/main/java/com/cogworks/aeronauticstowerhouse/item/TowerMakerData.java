package com.cogworks.aeronauticstowerhouse.item;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;

public record TowerMakerData(BlockPos firstPos) {

    public static final Codec<TowerMakerData> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    BlockPos.CODEC.fieldOf("first_pos").forGetter(TowerMakerData::firstPos)
            ).apply(instance, TowerMakerData::new)
    );
}
