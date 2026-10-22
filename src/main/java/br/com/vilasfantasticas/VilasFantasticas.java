package br.com.vilasfantasticas;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
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
            if (world.isClient || hand != Hand.MAIN_HAND || !(entity instanceof VillagerEntity villager)) {
                return ActionResult.PASS;
            }

            String professionId = Registries.VILLAGER_PROFESSION
                    .getId(villager.getVillagerData().getProfession().value())
                    .getPath();
            String professionName = getProfessionName(professionId);

            player.sendMessage(
                    Text.literal("§eVilas Fantásticas §8» §fEste aldeão é: §a" + professionName + "§f."),
                    false
            );

            // PASS mantém a interação vanilla, incluindo as trocas do aldeão.
            return ActionResult.PASS;
        });

        LOGGER.info("Vilas Fantásticas iniciado! Diálogos básicos com aldeões ativados.");
    }

    private static String getProfessionName(String id) {
        return switch (id) {
            case "armorer" -> "Armeiro";
            case "butcher" -> "Açougueiro";
            case "cartographer" -> "Cartógrafo";
            case "cleric" -> "Clérigo";
            case "farmer" -> "Fazendeiro";
            case "fisherman" -> "Pescador";
            case "fletcher" -> "Flecheiro";
            case "leatherworker" -> "Curtidor";
            case "librarian" -> "Bibliotecário";
            case "mason" -> "Pedreiro";
            case "shepherd" -> "Pastor";
            case "toolsmith" -> "Ferramenteiro";
            case "weaponsmith" -> "Ferreiro de armas";
            case "nitwit" -> "Simplório";
            case "none" -> "Desempregado";
            default -> "Aldeão";
        };
    }
}
