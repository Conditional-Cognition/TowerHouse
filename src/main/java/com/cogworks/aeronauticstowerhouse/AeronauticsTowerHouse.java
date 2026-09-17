package com.cogworks.aeronauticstowerhouse;

import com.cogworks.aeronauticstowerhouse.registry.*;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(AeronauticsTowerHouse.MODID)
public class AeronauticsTowerHouse {
    public static final String MODID = "aeronauticstowerhouse";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AeronauticsTowerHouse(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // modEventBus.addListener(THBlocks::register);
        modEventBus.addListener(THItems::register);
        modEventBus.addListener(THTabs::register);

        THDataComponents.COMPONENTS.register(modEventBus);
        //THFeatures.FEATURES.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Tower House - common setup");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Tower House - server starting");
    }
}
