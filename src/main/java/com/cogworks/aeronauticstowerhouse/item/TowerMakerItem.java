package com.cogworks.aeronauticstowerhouse.item;

import com.cogworks.aeronauticstowerhouse.registry.THDataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TowerMakerItem extends Item {

    public TowerMakerItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();

        if (player == null) {
            return InteractionResult.PASS;
        }

        if (context.getLevel().isClientSide) {
            return InteractionResult.SUCCESS;
        }

        ItemStack stack = context.getItemInHand();
        BlockPos clickedPos = context.getClickedPos();

        TowerMakerData data = stack.get(THDataComponents.TOWER_MAKER_DATA.get());

        if (data == null) {
            stack.set(
                    THDataComponents.TOWER_MAKER_DATA.get(),
                    new TowerMakerData(clickedPos)
            );

            player.sendSystemMessage(
                    Component.literal(
                            "Selected block at " +
                                    clickedPos.getX() + ", " +
                                    clickedPos.getY() + ", " +
                                    clickedPos.getZ()
                    )
            );

            return InteractionResult.SUCCESS;
        }

        BlockPos firstPos = data.firstPos();
        BlockPos secondPos = clickedPos;

        ItemStack offhand = player.getOffhandItem();

        BlockState fillState;

        if (offhand.isEmpty()) {
            fillState = net.minecraft.world.level.block.Blocks.AIR.defaultBlockState();
        } else if (offhand.getItem() instanceof BlockItem blockItem) {
            fillState = blockItem.getBlock().defaultBlockState();
        } else {
            player.sendSystemMessage(
                    Component.literal("You need a block in your offhand.")
            );

            stack.remove(THDataComponents.TOWER_MAKER_DATA.get());

            return InteractionResult.SUCCESS;
        }

        int minX = Math.min(firstPos.getX(), secondPos.getX());
        int minY = Math.min(firstPos.getY(), secondPos.getY());
        int minZ = Math.min(firstPos.getZ(), secondPos.getZ());

        int maxX = Math.max(firstPos.getX(), secondPos.getX());
        int maxY = Math.max(firstPos.getY(), secondPos.getY());
        int maxZ = Math.max(firstPos.getZ(), secondPos.getZ());

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    context.getLevel().setBlock(
                            new BlockPos(x, y, z),
                            fillState,
                            3
                    );
                }
            }
        }

        player.sendSystemMessage(
                Component.literal(
                        "Filled from " +
                                firstPos.getX() + ", " +
                                firstPos.getY() + ", " +
                                firstPos.getZ() +
                                " to " +
                                secondPos.getX() + ", " +
                                secondPos.getY() + ", " +
                                secondPos.getZ()
                )
        );

        stack.remove(THDataComponents.TOWER_MAKER_DATA.get());

        return InteractionResult.SUCCESS;
    }
}