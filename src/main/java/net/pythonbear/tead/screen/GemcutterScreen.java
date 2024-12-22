package net.pythonbear.tead.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;


public class GemcutterScreen extends HandledScreen<GemcutterScreenHandler> {
    private static final Identifier BACKGROUND = new Identifier(Tead.MOD_ID, "textures/gui/gemcutter.png");

    public GemcutterScreen(GemcutterScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int k;
        int i = this.x;
        int j = this.y;
        context.drawTexture(BACKGROUND, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        if (this.handler.isCrafting()) {
            k = this.handler.getScaledProgress();
            context.drawTexture(BACKGROUND, i + 79, j + 34, 176, 14, k + 1, 16);

        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
