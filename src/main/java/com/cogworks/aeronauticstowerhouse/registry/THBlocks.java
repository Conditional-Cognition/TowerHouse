package com.cogworks.aeronauticstowerhouse.registry;

import com.cogworks.aeronauticstowerhouse.AeronauticsTowerHouse;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.Optional;

public class THBlocks {

    public static final BlockSetType AUTUMNWOOD_SET = BlockSetType.register(
            new BlockSetType("autumnwood")
    );

    public static final WoodType AUTUMNWOOD = WoodType.register(
            new WoodType("autumnwood", AUTUMNWOOD_SET)
    );

    public static final TreeGrower AUTUMNWOOD_TREE_GROWER = new TreeGrower(
            "autumnwood",
            Optional.empty(),
            Optional.of(ResourceKey.create(
                    net.minecraft.core.registries.Registries.CONFIGURED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(AeronauticsTowerHouse.MODID, "autumnwood_tree")
            )),
            Optional.empty()
    );

    public static Block AUTUMNWOOD_LEAVES;
    public static Block AUTUMNWOOD_SAPLING;
    public static Block AUTUMNWOOD_LOG;
    public static Block AUTUMNWOOD_WOOD;
    public static Block STRIPPED_AUTUMNWOOD_LOG;
    public static Block STRIPPED_AUTUMNWOOD_WOOD;
    public static Block AUTUMNWOOD_PLANKS;
    public static Block AUTUMNWOOD_STAIRS;
    public static Block AUTUMNWOOD_SLAB;
    public static Block AUTUMNWOOD_FENCE;
    public static Block AUTUMNWOOD_FENCE_GATE;
    public static Block AUTUMNWOOD_BUTTON;
    public static Block AUTUMNWOOD_PRESSURE_PLATE;

    public static Block AUTUMNWOOD_DOOR;
    public static Block AUTUMNWOOD_TRAPDOOR;
    public static Block AUTUMNWOOD_SIGN;
    public static Block AUTUMNWOOD_WALL_SIGN;
    public static Block AUTUMNWOOD_HANGING_SIGN;
    public static Block AUTUMNWOOD_WALL_HANGING_SIGN;

    public static void register(RegisterEvent event) {
        event.register(BuiltInRegistries.BLOCK.key(), helper -> {
            AUTUMNWOOD_LEAVES = new LeavesBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)
            );

            AUTUMNWOOD_SAPLING = new SaplingBlock(
                    AUTUMNWOOD_TREE_GROWER,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)
            );

            AUTUMNWOOD_LOG = new RotatedPillarBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)
            );

            AUTUMNWOOD_WOOD = new RotatedPillarBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
            );

            STRIPPED_AUTUMNWOOD_LOG = new RotatedPillarBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)
            );

            STRIPPED_AUTUMNWOOD_WOOD = new RotatedPillarBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)
            );

            AUTUMNWOOD_PLANKS = new Block(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            );

            AUTUMNWOOD_STAIRS = new StairBlock(
                    AUTUMNWOOD_PLANKS.defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)
            );

            AUTUMNWOOD_SLAB = new SlabBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)
            );

            AUTUMNWOOD_FENCE = new FenceBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)
            );

            AUTUMNWOOD_FENCE_GATE = new FenceGateBlock(
                    AUTUMNWOOD,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)
            );

            AUTUMNWOOD_BUTTON = new ButtonBlock(
                    AUTUMNWOOD_SET,
                    30,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)
            );

            AUTUMNWOOD_PRESSURE_PLATE = new PressurePlateBlock(
                    AUTUMNWOOD_SET,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)
            );

            helper.register(id("autumnwood_leaves"), AUTUMNWOOD_LEAVES);
            helper.register(id("autumnwood_sapling"), AUTUMNWOOD_SAPLING);
            helper.register(id("autumnwood_log"), AUTUMNWOOD_LOG);
            helper.register(id("autumnwood_wood"), AUTUMNWOOD_WOOD);
            helper.register(id("stripped_autumnwood_log"), STRIPPED_AUTUMNWOOD_LOG);
            helper.register(id("stripped_autumnwood_wood"), STRIPPED_AUTUMNWOOD_WOOD);
            helper.register(id("autumnwood_planks"), AUTUMNWOOD_PLANKS);
            helper.register(id("autumnwood_stairs"), AUTUMNWOOD_STAIRS);
            helper.register(id("autumnwood_slab"), AUTUMNWOOD_SLAB);
            helper.register(id("autumnwood_fence"), AUTUMNWOOD_FENCE);
            helper.register(id("autumnwood_fence_gate"), AUTUMNWOOD_FENCE_GATE);
            helper.register(id("autumnwood_button"), AUTUMNWOOD_BUTTON);
            helper.register(id("autumnwood_pressure_plate"), AUTUMNWOOD_PRESSURE_PLATE);

            AUTUMNWOOD_DOOR = new DoorBlock(
                    AUTUMNWOOD_SET,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)
            );

            AUTUMNWOOD_TRAPDOOR = new TrapDoorBlock(
                    AUTUMNWOOD_SET,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)
            );

            AUTUMNWOOD_SIGN = new StandingSignBlock(
                    AUTUMNWOOD,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)
            );

            AUTUMNWOOD_WALL_SIGN = new WallSignBlock(
                    AUTUMNWOOD,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)
            );

            AUTUMNWOOD_HANGING_SIGN = new CeilingHangingSignBlock(
                    AUTUMNWOOD,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)
            );

            AUTUMNWOOD_WALL_HANGING_SIGN = new WallHangingSignBlock(
                    AUTUMNWOOD,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)
            );

            helper.register(id("autumnwood_door"), AUTUMNWOOD_DOOR);
            helper.register(id("autumnwood_trapdoor"), AUTUMNWOOD_TRAPDOOR);
            helper.register(id("autumnwood_sign"), AUTUMNWOOD_SIGN);
            helper.register(id("autumnwood_wall_sign"), AUTUMNWOOD_WALL_SIGN);
            helper.register(id("autumnwood_hanging_sign"), AUTUMNWOOD_HANGING_SIGN);
            helper.register(id("autumnwood_wall_hanging_sign"), AUTUMNWOOD_WALL_HANGING_SIGN);
        });
    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(
                AeronauticsTowerHouse.MODID,
                name
        );
    }
}