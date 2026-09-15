package com.cogworks.aeronauticstowerhouse.registry;

import com.cogworks.aeronauticstowerhouse.AeronauticsTowerHouse;
import com.cogworks.aeronauticstowerhouse.item.TowerMakerItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.neoforged.neoforge.registries.RegisterEvent;

public class THItems {
    public static BlockItem AUTUMNWOOD_LEAVES;
    public static BlockItem AUTUMNWOOD_LOG;
    public static BlockItem AUTUMNWOOD_WOOD;
    public static BlockItem STRIPPED_AUTUMNWOOD_LOG;
    public static BlockItem STRIPPED_AUTUMNWOOD_WOOD;
    public static BlockItem AUTUMNWOOD_PLANKS;
    public static BlockItem AUTUMNWOOD_STAIRS;
    public static BlockItem AUTUMNWOOD_SLAB;
    public static BlockItem AUTUMNWOOD_FENCE;
    public static BlockItem AUTUMNWOOD_FENCE_GATE;
    public static BlockItem AUTUMNWOOD_BUTTON;
    public static BlockItem AUTUMNWOOD_PRESSURE_PLATE;
    public static BlockItem AUTUMNWOOD_SAPLING;

    public static BlockItem AUTUMNWOOD_DOOR;
    public static BlockItem AUTUMNWOOD_TRAPDOOR;
    public static Item AUTUMNWOOD_SIGN;
    public static Item AUTUMNWOOD_HANGING_SIGN;

    public static Item TOWERMAKER;

    public static void register(RegisterEvent event) {
        event.register(BuiltInRegistries.ITEM.key(), helper -> {
            TOWERMAKER = new TowerMakerItem(new Item.Properties());
            helper.register(id("towermaker"), TOWERMAKER);

            AUTUMNWOOD_LEAVES = new BlockItem(THBlocks.AUTUMNWOOD_LEAVES, new Item.Properties());
            helper.register(id("autumnwood_leaves"), AUTUMNWOOD_LEAVES);

            AUTUMNWOOD_LOG = new BlockItem(THBlocks.AUTUMNWOOD_LOG, new Item.Properties());
            helper.register(id("autumnwood_log"), AUTUMNWOOD_LOG);

            AUTUMNWOOD_WOOD = new BlockItem(THBlocks.AUTUMNWOOD_WOOD, new Item.Properties());
            helper.register(id("autumnwood_wood"), AUTUMNWOOD_WOOD);

            STRIPPED_AUTUMNWOOD_LOG = new BlockItem(THBlocks.STRIPPED_AUTUMNWOOD_LOG, new Item.Properties());
            helper.register(id("stripped_autumnwood_log"), STRIPPED_AUTUMNWOOD_LOG);

            STRIPPED_AUTUMNWOOD_WOOD = new BlockItem(THBlocks.STRIPPED_AUTUMNWOOD_WOOD, new Item.Properties());
            helper.register(id("stripped_autumnwood_wood"), STRIPPED_AUTUMNWOOD_WOOD);

            AUTUMNWOOD_PLANKS = new BlockItem(THBlocks.AUTUMNWOOD_PLANKS, new Item.Properties());
            helper.register(id("autumnwood_planks"), AUTUMNWOOD_PLANKS);

            AUTUMNWOOD_STAIRS = new BlockItem(THBlocks.AUTUMNWOOD_STAIRS, new Item.Properties());
            helper.register(id("autumnwood_stairs"), AUTUMNWOOD_STAIRS);

            AUTUMNWOOD_SLAB = new BlockItem(THBlocks.AUTUMNWOOD_SLAB, new Item.Properties());
            helper.register(id("autumnwood_slab"), AUTUMNWOOD_SLAB);

            AUTUMNWOOD_FENCE = new BlockItem(THBlocks.AUTUMNWOOD_FENCE, new Item.Properties());
            helper.register(id("autumnwood_fence"), AUTUMNWOOD_FENCE);

            AUTUMNWOOD_FENCE_GATE = new BlockItem(THBlocks.AUTUMNWOOD_FENCE_GATE, new Item.Properties());
            helper.register(id("autumnwood_fence_gate"), AUTUMNWOOD_FENCE_GATE);

            AUTUMNWOOD_BUTTON = new BlockItem(THBlocks.AUTUMNWOOD_BUTTON, new Item.Properties());
            helper.register(id("autumnwood_button"), AUTUMNWOOD_BUTTON);

            AUTUMNWOOD_PRESSURE_PLATE = new BlockItem(THBlocks.AUTUMNWOOD_PRESSURE_PLATE, new Item.Properties());
            helper.register(id("autumnwood_pressure_plate"), AUTUMNWOOD_PRESSURE_PLATE);

            AUTUMNWOOD_SAPLING = new BlockItem(THBlocks.AUTUMNWOOD_SAPLING, new Item.Properties());
            helper.register(id("autumnwood_sapling"), AUTUMNWOOD_SAPLING);

            AUTUMNWOOD_DOOR = new BlockItem(THBlocks.AUTUMNWOOD_DOOR, new Item.Properties());
            helper.register(id("autumnwood_door"), AUTUMNWOOD_DOOR);

            AUTUMNWOOD_TRAPDOOR = new BlockItem(THBlocks.AUTUMNWOOD_TRAPDOOR, new Item.Properties());
            helper.register(id("autumnwood_trapdoor"), AUTUMNWOOD_TRAPDOOR);

            AUTUMNWOOD_SIGN = new SignItem(new Item.Properties().stacksTo(16), THBlocks.AUTUMNWOOD_SIGN, THBlocks.AUTUMNWOOD_WALL_SIGN);
            helper.register(id("autumnwood_sign"), AUTUMNWOOD_SIGN);

            AUTUMNWOOD_HANGING_SIGN = new HangingSignItem(THBlocks.AUTUMNWOOD_HANGING_SIGN, THBlocks.AUTUMNWOOD_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16));
            helper.register(id("autumnwood_hanging_sign"), AUTUMNWOOD_HANGING_SIGN);
        });
    }

    private static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(
                AeronauticsTowerHouse.MODID,
                name
        );
    }
}