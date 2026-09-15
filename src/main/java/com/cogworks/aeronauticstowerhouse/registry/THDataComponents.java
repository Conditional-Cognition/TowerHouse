package com.cogworks.aeronauticstowerhouse.registry;

import com.cogworks.aeronauticstowerhouse.AeronauticsTowerHouse;
import com.cogworks.aeronauticstowerhouse.item.TowerMakerData;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class THDataComponents {
    @SuppressWarnings("removal")
    public static final DeferredRegister.DataComponents COMPONENTS =
            DeferredRegister.createDataComponents(AeronauticsTowerHouse.MODID);

    public static final Supplier<DataComponentType<TowerMakerData>> TOWER_MAKER_DATA =
            COMPONENTS.registerComponentType(
                    "tower_maker_data",
                    builder -> builder
                            .persistent(TowerMakerData.CODEC)
            );
}
