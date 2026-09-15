package com.cogworks.aeronauticstowerhouse.registry;

import com.cogworks.aeronauticstowerhouse.AeronauticsTowerHouse;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

@SuppressWarnings("removal")
@EventBusSubscriber(modid = AeronauticsTowerHouse.MODID, bus = EventBusSubscriber.Bus.MOD)
public class THEventBusSubscriber {

    @SubscribeEvent
    public static void onAddBlocksToBlockEntityType(BlockEntityTypeAddBlocksEvent event) {
        // Register standard signs and wall signs
        event.modify(
            BlockEntityType.SIGN, 
            THBlocks.AUTUMNWOOD_SIGN, 
            THBlocks.AUTUMNWOOD_WALL_SIGN
        );

        // Register hanging signs and wall hanging signs
        event.modify(
            BlockEntityType.HANGING_SIGN, 
            THBlocks.AUTUMNWOOD_HANGING_SIGN, 
            THBlocks.AUTUMNWOOD_WALL_HANGING_SIGN
        );
    }
}