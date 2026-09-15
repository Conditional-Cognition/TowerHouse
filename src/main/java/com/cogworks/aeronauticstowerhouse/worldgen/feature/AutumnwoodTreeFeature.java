package com.cogworks.aeronauticstowerhouse.worldgen.feature;

import com.cogworks.aeronauticstowerhouse.registry.THBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class AutumnwoodTreeFeature extends Feature<NoneFeatureConfiguration> {

    private static final int MIN_TRUNK_HEIGHT = 7;
    private static final int MAX_TRUNK_HEIGHT = 10;

    private static final int BRANCH_COUNT = 4;
    private static final int LEAF_RADIUS = 2;

    private final BlockState LOG =
            THBlocks.AUTUMNWOOD_LOG.defaultBlockState();

    private final BlockState LEAVES =
            THBlocks.AUTUMNWOOD_LEAVES.defaultBlockState();

    public AutumnwoodTreeFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        int trunkHeight = Mth.nextInt(
                random,
                MIN_TRUNK_HEIGHT,
                MAX_TRUNK_HEIGHT
        );

        if (!canPlace(level, origin, trunkHeight)) {
            return false;
        }

        placeTrunk(level, origin, trunkHeight);

        generateBranches(
                level,
                origin,
                trunkHeight,
                random
        );

        makeTopLeaves(
                level,
                origin,
                trunkHeight
        );

        return true;
    }

    private boolean canPlace(
            WorldGenLevel level,
            BlockPos origin,
            int height
    ) {
        if (!level.getBlockState(origin.below()).isSolid()) {
            return false;
        }

        for (int y = 0; y <= height + 3; y++) {
            if (!isReplaceable(
                    level.getBlockState(origin.above(y))
            )) {
                return false;
            }
        }

        return true;
    }

    private void placeTrunk(
            WorldGenLevel level,
            BlockPos origin,
            int height
    ) {
        for (int y = 0; y < height; y++) {
            set(
                    level,
                    origin.above(y),
                    LOG
            );
        }
    }

    private void generateBranches(
            WorldGenLevel level,
            BlockPos origin,
            int trunkHeight,
            RandomSource random
    ) {
        // Dynamically space out the 4 branches in the upper half of the trunk
        int base = trunkHeight / 2;
        int[] branchHeights = {
                base,
                base + 1,
                base + 2,
                Math.min(trunkHeight - 1, base + 3)
        };

        for (int i = 0; i < BRANCH_COUNT; i++) {
            BlockPos start = origin.above(branchHeights[i]);
            int type = i % 3;

            placeBranch(
                    level,
                    start,
                    i,
                    type
            );
        }
    }

    private void placeBranch(
            WorldGenLevel level,
            BlockPos start,
            int direction,
            int type
    ) {
        BlockPos[] offsets;

        if (type == 0) {
            offsets = new BlockPos[]{
                    new BlockPos(1, 0, 0),
                    new BlockPos(2, 0, 0),
                    new BlockPos(2, 1, 0)
            };
        } else if (type == 1) {
            offsets = new BlockPos[]{
                    new BlockPos(1, 0, 0),
                    new BlockPos(2, 0, 0),
                    new BlockPos(2, 1, 1)
            };
        } else {
            offsets = new BlockPos[]{
                    new BlockPos(1, 0, 0),
                    new BlockPos(2, 1, 0)
            };
        }

        for (BlockPos offset : offsets) {
            int x = offset.getX();
            int y = offset.getY();
            int z = offset.getZ();

            int rotatedX;
            int rotatedZ;

            switch (direction) {
                case 0 -> {
                    rotatedX = x;
                    rotatedZ = z;
                }
                case 1 -> {
                    rotatedX = -z;
                    rotatedZ = x;
                }
                case 2 -> {
                    rotatedX = -x;
                    rotatedZ = -z;
                }
                default -> {
                    rotatedX = z;
                    rotatedZ = -x;
                }
            }

            BlockPos branchPos = start.offset(
                    rotatedX,
                    y,
                    rotatedZ
            );

            set(level, branchPos, LOG);
            makeLeaves(level, branchPos);
        }
    }

    private void makeTopLeaves(
            WorldGenLevel level,
            BlockPos origin,
            int trunkHeight
    ) {
        BlockPos top = origin.above(trunkHeight);

        makeLeaves(level, top);
        makeLeaves(level, top.north());
        makeLeaves(level, top.south());
        makeLeaves(level, top.east());
        makeLeaves(level, top.west());
    }

    private void makeLeaves(
            WorldGenLevel level,
            BlockPos center
    ) {
        for (int x = -LEAF_RADIUS; x <= LEAF_RADIUS; x++) {
            for (int y = -LEAF_RADIUS; y <= LEAF_RADIUS; y++) {
                for (int z = -LEAF_RADIUS; z <= LEAF_RADIUS; z++) {

                    if (x * x + y * y + z * z
                            > LEAF_RADIUS * LEAF_RADIUS) {
                        continue;
                    }

                    BlockPos pos = center.offset(x, y, z);

                    if (isReplaceable(
                            level.getBlockState(pos)
                    )) {
                        set(
                                level,
                                pos,
                                LEAVES
                        );
                    }
                }
            }
        }
    }

    private boolean isReplaceable(BlockState state) {
        return state.isAir()
                || state.is(Blocks.SHORT_GRASS)
                || state.is(Blocks.TALL_GRASS)
                || state.is(Blocks.FERN)
                || state.is(Blocks.LARGE_FERN)
                || state.is(LEAVES.getBlock());
    }

    private void set(
            WorldGenLevel level,
            BlockPos pos,
            BlockState state
    ) {
        if (isReplaceable(
                level.getBlockState(pos)
        )) {
            level.setBlock(
                    pos,
                    state,
                    19
            );
        }
    }
}