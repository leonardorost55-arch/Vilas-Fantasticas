package br.com.vilasfantasticas;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VilasFantasticas implements ModInitializer {
    public static final String MOD_ID = "vilasfantasticas";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (hand != Hand.MAIN_HAND || !(entity instanceof VillagerEntity)) {
                return ActionResult.PASS;
            }

            // O menu substitui temporariamente a interação vanilla com aldeões.
            // A negociação será ligada a uma opção própria numa etapa posterior.
            return world.isClient ? ActionResult.PASS : ActionResult.SUCCESS;
        });

        LOGGER.info("Vilas Fantásticas iniciado! Sistema de diálogo preparado.");
    }
}
