package net.pythonbear.tead.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;


@Environment(value= EnvType.CLIENT)
public class SmelterScreen extends AbstractFurnaceScreen<SmelterScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(Tead.MOD_ID, "textures/gui/smelter.png");

    public SmelterScreen(SmelterScreenHandler container, PlayerInventory inventory, Text title) {
        super(container, new SmelterRecipeBookScreen(), inventory, title, TEXTURE);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int k;
        int i = this.x;
        int j = this.y;
        context.drawTexture(TEXTURE, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        if ((this.handler).isBurning()) {
            k = (this.handler).getFuelProgress();
            context.drawTexture(TEXTURE, i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }
        k = (this.handler).getCookProgress();
        context.drawTexture(TEXTURE, i + 79, j + 34, 176, 14, k + 1, 16);
    }
}
