package br.com.vilasfantasticas;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class VilasFantasticasClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!world.isClient || hand != Hand.MAIN_HAND || !(entity instanceof VillagerEntity villager)) {
                return ActionResult.PASS;
            }

            MinecraftClient.getInstance().setScreen(new VillagerDialogueScreen(villager));
            return ActionResult.SUCCESS;
        });
    }
}
