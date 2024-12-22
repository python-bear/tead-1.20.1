package net.pythonbear.tead.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.CyclingSlotIcon;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;

import java.util.List;


public class TransmutationTableScreen extends HandledScreen<TransmutationTableScreenHandler> {
    private static final Identifier BACKGROUND = new Identifier(Tead.MOD_ID, "textures/gui/transmutation_table.png");
    private static final Identifier EMPTY_SLOT_INGOT_TEXTURE = new Identifier(Tead.MINECRAFT_ID, "item/empty_slot_ingot");
    private static final Identifier EMPTY_SLOT_RUBY_TEXTURE = new Identifier(Tead.MOD_ID, "item/empty_slot_ruby");
    private static final Identifier EMPTY_SLOT_RUBY_ARROW_TEXTURE = new Identifier(Tead.MOD_ID, "item/empty_slot_ruby_arrow");
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = new Identifier(Tead.MINECRAFT_ID, "item/empty_slot_pickaxe");
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE = new Identifier(Tead.MINECRAFT_ID, "item/empty_slot_axe");
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = new Identifier(Tead.MINECRAFT_ID, "item/empty_slot_sword");
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE = new Identifier(Tead.MINECRAFT_ID, "item/empty_slot_hoe");
    private static final List<Identifier> EMPTY_SLOT_ONE_TEXTURES = List.of(EMPTY_SLOT_RUBY_TEXTURE, EMPTY_SLOT_INGOT_TEXTURE, EMPTY_SLOT_RUBY_ARROW_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE);
    private static final List<Identifier> EMPTY_SLOT_TWO_TEXTURES = List.of(EMPTY_SLOT_RUBY_TEXTURE, EMPTY_SLOT_INGOT_TEXTURE, EMPTY_SLOT_RUBY_ARROW_TEXTURE, EMPTY_SLOT_AXE_TEXTURE);
    private static final List<Identifier> EMPTY_SLOT_THREE_TEXTURES = List.of(EMPTY_SLOT_RUBY_TEXTURE, EMPTY_SLOT_INGOT_TEXTURE, EMPTY_SLOT_RUBY_ARROW_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE);
    private static final List<Identifier> EMPTY_SLOT_FOUR_TEXTURES = List.of(EMPTY_SLOT_RUBY_TEXTURE, EMPTY_SLOT_INGOT_TEXTURE, EMPTY_SLOT_RUBY_ARROW_TEXTURE, EMPTY_SLOT_HOE_TEXTURE);
    private final CyclingSlotIcon inputSlotOneIcon = new CyclingSlotIcon(2);
    private final CyclingSlotIcon inputSlotTwoIcon = new CyclingSlotIcon(3);
    private final CyclingSlotIcon inputSlotThreeIcon = new CyclingSlotIcon(4);
    private final CyclingSlotIcon inputSlotFourIcon = new CyclingSlotIcon(5);

    public TransmutationTableScreen(TransmutationTableScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
    }

    @Override
    public void handledScreenTick() {
        super.handledScreenTick();
        this.inputSlotOneIcon.updateTexture(EMPTY_SLOT_ONE_TEXTURES);
        this.inputSlotTwoIcon.updateTexture(EMPTY_SLOT_TWO_TEXTURES);
        this.inputSlotThreeIcon.updateTexture(EMPTY_SLOT_THREE_TEXTURES);
        this.inputSlotFourIcon.updateTexture(EMPTY_SLOT_FOUR_TEXTURES);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int k;
        int i = this.x;
        int j = this.y;
        context.drawTexture(BACKGROUND, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        if (this.handler.isCrafting()) {
            k = this.handler.getScaledProgress();
            context.drawTexture(BACKGROUND, i + 92, j + 34, 176, 14, k + 1, 16);

        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        this.inputSlotOneIcon.render(this.handler, context, delta, this.x, this.y);
        this.inputSlotTwoIcon.render(this.handler, context, delta, this.x, this.y);
        this.inputSlotThreeIcon.render(this.handler, context, delta, this.x, this.y);
        this.inputSlotFourIcon.render(this.handler, context, delta, this.x, this.y);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
