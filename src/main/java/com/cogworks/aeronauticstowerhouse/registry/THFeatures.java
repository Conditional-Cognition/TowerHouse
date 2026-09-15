package com.cogworks.aeronauticstowerhouse.registry;

import com.cogworks.aeronauticstowerhouse.AeronauticsTowerHouse;
import com.cogworks.aeronauticstowerhouse.worldgen.feature.AutumnwoodTreeFeature;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class THFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(
                    BuiltInRegistries.FEATURE,
                    AeronauticsTowerHouse.MODID
            );

    public static final DeferredHolder<Feature<?>, AutumnwoodTreeFeature> AUTUMNWOOD_TREE =
            FEATURES.register(
                    "autumnwood_tree",
                    () -> new AutumnwoodTreeFeature(
                            Codec.unit(NoneFeatureConfiguration::new)
                    )
            );
}