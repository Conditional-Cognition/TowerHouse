package com.cogworks.aeronauticstowerhouse.registry;

import com.cogworks.aeronauticstowerhouse.AeronauticsTowerHouse;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.RegisterEvent;

public class THTabs {
    public static CreativeModeTab ATH_TAB;

    public static void register(RegisterEvent event) {
        event.register(BuiltInRegistries.CREATIVE_MODE_TAB.key(), helper -> {
            ATH_TAB = CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.aeronauticstowerhouse"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> THItems.TOWERMAKER.getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(THItems.TOWERMAKER);/*
                        output.accept(THItems.AUTUMNWOOD_LEAVES);
                        output.accept(THItems.AUTUMNWOOD_LOG);
                        output.accept(THItems.AUTUMNWOOD_WOOD);
                        output.accept(THItems.STRIPPED_AUTUMNWOOD_LOG);
                        output.accept(THItems.STRIPPED_AUTUMNWOOD_WOOD);
                        output.accept(THItems.AUTUMNWOOD_PLANKS);
                        output.accept(THItems.AUTUMNWOOD_STAIRS);
                        output.accept(THItems.AUTUMNWOOD_SLAB);
                        output.accept(THItems.AUTUMNWOOD_FENCE);
                        output.accept(THItems.AUTUMNWOOD_FENCE_GATE);
                        output.accept(THItems.AUTUMNWOOD_BUTTON);
                        output.accept(THItems.AUTUMNWOOD_PRESSURE_PLATE);
                        output.accept(THItems.AUTUMNWOOD_SAPLING);

                        output.accept(THItems.AUTUMNWOOD_DOOR);
                        output.accept(THItems.AUTUMNWOOD_TRAPDOOR);
                        output.accept(THItems.AUTUMNWOOD_SIGN);
                        output.accept(THItems.AUTUMNWOOD_HANGING_SIGN);*/
                    })
                    .build();
            helper.register(
                    ResourceLocation.fromNamespaceAndPath(AeronauticsTowerHouse.MODID, "cogcrasher_tab"),
                    ATH_TAB
            );

        });
    }
}
