package br.com.vilasfantasticas;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;

public class VillagerDialogueScreen extends Screen {
    private final VillagerEntity villager;
    private final String professionName;

    public VillagerDialogueScreen(VillagerEntity villager) {
        super(Text.literal("Vilas Fantásticas"));
        this.villager = villager;
        String id = Registries.VILLAGER_PROFESSION
                .getId(villager.getVillagerData().getProfession())
                .getPath();
        this.professionName = getProfessionName(id);
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int top = this.height / 2 - 20;

        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Quem és tu?"),
                button -> showReply("Sou um aldeão desta vila. Prazer em conhecer-te!")
        ).dimensions(centerX - 100, top, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Qual é a tua profissão?"),
                button -> showReply("A minha profissão é: " + professionName + ".")
        ).dimensions(centerX - 100, top + 25, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Falou, tchau!"),
                button -> this.close()
        ).dimensions(centerX - 100, top + 50, 200, 20).build());
    }

    private void showReply(String reply) {
        if (this.client != null && this.client.player != null) {
            this.client.player.sendMessage(
                    Text.literal("§eVilas Fantásticas §8» §f" + reply),
                    false
            );
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        int centerX = this.width / 2;
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, centerX, this.height / 2 - 65, 0xFFFF55);
        context.drawCenteredTextWithShadow(
                this.textRenderer,
                Text.literal("Aldeão: " + professionName),
                centerX,
                this.height / 2 - 45,
                0xFFFFFF
        );
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
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
