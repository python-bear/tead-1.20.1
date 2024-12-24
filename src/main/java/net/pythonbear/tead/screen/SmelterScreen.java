package net.pythonbear.tead.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.CyclingSlotIcon;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.Tead;

import java.util.List;

public class SmelterScreen extends HandledScreen<SmelterScreenHandler> {
    private static final Identifier RECIPE_BUTTON_TEXTURE = new Identifier(Tead.MINECRAFT_ID, "textures/gui/recipe_button.png");
//    public final TeadRecipeBookWidget recipeBook = new TeadRecipeBookWidget();
    private boolean narrow;
    private static final Identifier EMPTY_SLOT_INGOT_TEXTURE = new Identifier(Tead.MINECRAFT_ID, "item/empty_slot_ingot");
    private static final Identifier EMPTY_SLOT_NUGGET_TEXTURE = new Identifier(Tead.MOD_ID, "item/empty_slot_nugget");
    private static final Identifier EMPTY_SLOT_PIG_IRON_INGOT_TEXTURE = new Identifier(Tead.MOD_ID, "item/empty_slot_pig_iron_ingot");
    private static final Identifier EMPTY_SLOT_COAL_TEXTURE = new Identifier(Tead.MOD_ID, "item/empty_slot_coal");
    private static final List<Identifier> EMPTY_SLOT_ONE_TEXTURES = List.of(EMPTY_SLOT_INGOT_TEXTURE, EMPTY_SLOT_NUGGET_TEXTURE, EMPTY_SLOT_PIG_IRON_INGOT_TEXTURE);
    private static final List<Identifier> EMPTY_SLOT_TWO_TEXTURES = List.of(EMPTY_SLOT_INGOT_TEXTURE, EMPTY_SLOT_NUGGET_TEXTURE, EMPTY_SLOT_COAL_TEXTURE);
    private final CyclingSlotIcon inputSlotOneIcon = new CyclingSlotIcon(0);
    private final CyclingSlotIcon inputSlotTwoIcon = new CyclingSlotIcon(1);
    private final Identifier BACKGROUND = new Identifier(Tead.MOD_ID, "textures/gui/smelter.png");

    public SmelterScreen(SmelterScreenHandler smelterScreenHandler, PlayerInventory playerInventory, Text title) {
        super(smelterScreenHandler, playerInventory, title);
    }

    @Override
    public void init() {
        super.init();
        this.narrow = this.width < 379;
//        this.recipeBook.initialize(this.width, this.height, this.client, this.narrow, this.handler);
//        this.x = this.recipeBook.findLeftEdge(this.width, this.backgroundWidth);
//        this.addDrawableChild(new TexturedButtonWidget(this.x + 10, this.height / 2 - 49, 20, 18, 0, 0, 19, RECIPE_BUTTON_TEXTURE, button -> {
//            this.recipeBook.toggleOpen();
//            this.x = this.recipeBook.findLeftEdge(this.width, this.backgroundWidth);
//            button.setPosition(this.x + 10, this.height / 2 - 49);
//        }));
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
    }

    @Override
    public void handledScreenTick() {
        super.handledScreenTick();
        this.inputSlotOneIcon.updateTexture(EMPTY_SLOT_ONE_TEXTURES);
        this.inputSlotTwoIcon.updateTexture(EMPTY_SLOT_TWO_TEXTURES);
//        this.recipeBook.update();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);

//        if (this.recipeBook.isOpen() && this.narrow) {
//            this.drawBackground(context, delta, mouseX, mouseY);
//            this.recipeBook.render(context, mouseX, mouseY, delta);
//        } else {
//            this.recipeBook.render(context, mouseX, mouseY, delta);
//            super.render(context, mouseX, mouseY, delta);
//            this.recipeBook.drawGhostSlots(context, this.x, this.y, true, delta);
//        }
        super.render(context, mouseX, mouseY, delta); // remove this

        this.inputSlotOneIcon.render(this.handler, context, delta, this.x, this.y);
        this.inputSlotTwoIcon.render(this.handler, context, delta, this.x, this.y);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
//        this.recipeBook.drawTooltip(context, this.x, this.y, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int k;
        int i = this.x;
        int j = this.y;
        context.drawTexture(this.BACKGROUND, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        if (this.handler.isBurning()) {
            k = this.handler.getFuelProgress();
            context.drawTexture(this.BACKGROUND, i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }
        k = this.handler.getCookProgress();
        context.drawTexture(this.BACKGROUND, i + 80, j + 34, 176, 14, k + 1, 16);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
//        if (this.recipeBook.mouseClicked(mouseX, mouseY, button)) {
//            return true;
//        }
//        if (this.narrow && this.recipeBook.isOpen()) {
//            return true;
//        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    protected void onMouseClick(Slot slot, int slotId, int button, SlotActionType actionType) {
        super.onMouseClick(slot, slotId, button, actionType);
//        this.recipeBook.slotClicked(slot);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
//        if (this.recipeBook.keyPressed(keyCode, scanCode, modifiers)) {
//            return false;
//        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

//    @Override
//    protected boolean isClickOutsideBounds(double mouseX, double mouseY, int left, int top, int button) {
//        boolean bl = mouseX < (double)left || mouseY < (double)top || mouseX >= (double)(left + this.backgroundWidth)
//                || mouseY >= (double)(top + this.backgroundHeight);
//        return this.recipeBook.isClickOutsideBounds(mouseX, mouseY, this.x, this.y, this.backgroundWidth, this.backgroundHeight, button) && bl;
//    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
//        if (this.recipeBook.charTyped(chr, modifiers)) {
//            return true;
//        }
        return super.charTyped(chr, modifiers);
    }

//    @Override
//    public void refreshRecipeBook() {
//        this.recipeBook.refresh();
//    }
//
//    @Override
//    public RecipeBookWidget getRecipeBookWidget() {
//        return this.recipeBook;
//        return null;
//    }
}