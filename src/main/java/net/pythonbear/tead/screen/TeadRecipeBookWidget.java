package net.pythonbear.tead.screen;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.screen.recipebook.*;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.ToggleButtonWidget;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.client.resource.language.LanguageDefinition;
import net.minecraft.client.resource.language.LanguageManager;
import net.minecraft.client.search.SearchManager;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.RecipeCategoryOptionsC2SPacket;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.pythonbear.tead.recipe.TeadRecipeBookGroup;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;

import java.util.*;

@Environment(value=EnvType.CLIENT)
public class TeadRecipeBookWidget extends RecipeBookWidget {
    protected static final Identifier TEXTURE = new Identifier("textures/gui/recipe_book.png");
    private static final Text SEARCH_HINT_TEXT = Text.translatable("gui.recipebook.search_hint").formatted(Formatting.ITALIC).formatted(Formatting.GRAY);
    private static final Text TOGGLE_CRAFTABLE_RECIPES_TEXT = Text.translatable("gui.recipebook.toggleRecipes.craftable");
    private static final Text TOGGLE_ALL_RECIPES_TEXT = Text.translatable("gui.recipebook.toggleRecipes.all");
    private int leftOffset;
    private int parentWidth;
    private int parentHeight;
    protected final RecipeBookGhostSlots ghostSlots = new RecipeBookGhostSlots();
    private final List<RecipeGroupButtonWidget> tabButtons = Lists.newArrayList();
    @Nullable
    private RecipeGroupButtonWidget currentTab;
    protected ToggleButtonWidget toggleCraftableButton;
    protected TeadAbstractRecipeScreenHandler<?> craftingScreenHandler;
    protected MinecraftClient client;
    @Nullable
    private TextFieldWidget searchField;
    private String searchText = "";
    private ClientRecipeBook recipeBook;
    private final TeadRecipeBookResults recipesArea = new TeadRecipeBookResults();
    private final RecipeMatcher recipeFinder = new RecipeMatcher();
    private int cachedInvChangeCount;
    private boolean searching;
    private boolean open;
    private boolean narrow;

    public void initialize(int parentWidth, int parentHeight, MinecraftClient client, boolean narrow, TeadAbstractRecipeScreenHandler<?> craftingScreenHandler) {
        this.client = client;
        this.parentWidth = parentWidth;
        this.parentHeight = parentHeight;
        this.craftingScreenHandler = craftingScreenHandler;
        this.narrow = narrow;
        client.player.currentScreenHandler = craftingScreenHandler;
        this.recipeBook = client.player.getRecipeBook();
        this.cachedInvChangeCount = client.player.getInventory().getChangeCount();
        this.open = this.isGuiOpen();
        if (this.open) {
            this.reset();
        }
    }

    public void reset() {
        this.leftOffset = this.narrow ? 0 : 86;
        int i = (this.parentWidth - 147) / 2 - this.leftOffset;
        int j = (this.parentHeight - 166) / 2;
        this.recipeFinder.clear();
        this.client.player.getInventory().populateRecipeFinder(this.recipeFinder);
        this.craftingScreenHandler.populateRecipeFinder(this.recipeFinder);
        String string = this.searchField != null ? this.searchField.getText() : "";
        this.searchField = new TextFieldWidget(this.client.textRenderer, i + 26, j + 14, 79, this.client.textRenderer.fontHeight + 3, Text.translatable("itemGroup.search"));
        this.searchField.setMaxLength(50);
        this.searchField.setVisible(true);
        this.searchField.setEditableColor(0xFFFFFF);
        this.searchField.setText(string);
        this.searchField.setPlaceholder(SEARCH_HINT_TEXT);
        this.recipesArea.initialize(this.client, i, j);
        this.recipesArea.setGui(this);
        this.toggleCraftableButton = new ToggleButtonWidget(i + 110, j + 12, 26, 16, this.recipeBook.isFilteringCraftable(this.craftingScreenHandler));
        this.updateTooltip();
        this.setBookButtonTexture();
        this.tabButtons.clear();
        for (TeadRecipeBookGroup recipeBookGroup : TeadRecipeBookGroup.getGroups(this.craftingScreenHandler.getCategory())) {
            this.tabButtons.add(new RecipeGroupButtonWidget(recipeBookGroup));
        }
        if (this.currentTab != null) {
            this.currentTab = this.tabButtons.stream().filter(button -> button.getCategory().equals(this.currentTab.getCategory())).findFirst().orElse(null);
        }
        if (this.currentTab == null) {
            this.currentTab = this.tabButtons.get(0);
        }
        this.currentTab.setToggled(true);
        this.refreshResults(false);
        this.refreshTabButtons();
    }

    private void updateTooltip() {
        this.toggleCraftableButton.setTooltip(this.toggleCraftableButton.isToggled() ? Tooltip.of(this.getToggleCraftableButtonText()) : Tooltip.of(TOGGLE_ALL_RECIPES_TEXT));
    }

    protected void setBookButtonTexture() {
        this.toggleCraftableButton.setTextureUV(152, 41, 28, 18, TEXTURE);
    }

    public int findLeftEdge(int width, int backgroundWidth) {
        return this.isOpen() && !this.narrow ? 177 + (width - backgroundWidth - 200) / 2 : (width - backgroundWidth) / 2;
    }

    public void toggleOpen() {
        this.setOpen(!this.isOpen());
    }

    public boolean isOpen() {
        return this.open;
    }

    private boolean isGuiOpen() {
        return this.recipeBook.isGuiOpen(this.craftingScreenHandler.getCategory());
    }

    protected void setOpen(boolean opened) {
        if (opened) {
            this.reset();
        }
        this.open = opened;
        this.recipeBook.setGuiOpen(this.craftingScreenHandler.getCategory(), opened);
        if (!opened) {
            this.recipesArea.hideAlternates();
        }
        this.sendBookDataPacket();
    }

    public void slotClicked(@Nullable Slot slot) {
        if (slot != null && slot.id < this.craftingScreenHandler.getCraftingSlotCount()) {
            this.ghostSlots.reset();
            if (this.isOpen()) {
                this.refreshInputs();
            }
        }
    }

    private void refreshResults(boolean resetCurrentPage) {
        List<RecipeResultCollection> list = this.recipeBook.getResultsForGroup(this.currentTab.getCategory());
        list.forEach(resultCollection -> resultCollection.computeCraftables(this.recipeFinder, this.craftingScreenHandler.getCraftingWidth(), this.craftingScreenHandler.getCraftingHeight(), this.recipeBook));
        ArrayList<RecipeResultCollection> list2 = Lists.newArrayList(list);
        list2.removeIf(resultCollection -> !resultCollection.isInitialized());
        list2.removeIf(resultCollection -> !resultCollection.hasFittingRecipes());
        String string = this.searchField.getText();
        if (!string.isEmpty()) {
            ObjectLinkedOpenHashSet<RecipeResultCollection> objectSet = new ObjectLinkedOpenHashSet<RecipeResultCollection>(this.client.getSearchProvider(SearchManager.RECIPE_OUTPUT).findAll(string.toLowerCase(Locale.ROOT)));
            list2.removeIf(recipeResultCollection -> !objectSet.contains(recipeResultCollection));
        }
        if (this.recipeBook.isFilteringCraftable(this.craftingScreenHandler)) {
            list2.removeIf(resultCollection -> !resultCollection.hasCraftableRecipes());
        }
        this.recipesArea.setResults(list2, resetCurrentPage);
    }

    private void refreshTabButtons() {
        int i = (this.parentWidth - 147) / 2 - this.leftOffset - 30;
        int j = (this.parentHeight - 166) / 2 + 3;
        int l = 0;
        for (RecipeGroupButtonWidget recipeGroupButtonWidget : this.tabButtons) {
            TeadRecipeBookGroup recipeBookGroup = recipeGroupButtonWidget.getCategory();
            if (recipeBookGroup == TeadRecipeBookGroup.ALLOY_SMELTING_SEARCH || recipeBookGroup == TeadRecipeBookGroup.GEM_CUTTING_SEARCH || recipeBookGroup == TeadRecipeBookGroup.TRANSMORPHING_SEARCH) {
                recipeGroupButtonWidget.visible = true;
                recipeGroupButtonWidget.setPosition(i, j + 27 * l++);
                continue;
            }
            if (!recipeGroupButtonWidget.hasKnownRecipes(this.recipeBook)) continue;
            recipeGroupButtonWidget.setPosition(i, j + 27 * l++);
            recipeGroupButtonWidget.checkForNewRecipes(this.client);
        }
    }

    public void update() {
        boolean bl = this.isGuiOpen();
        if (this.isOpen() != bl) {
            this.setOpen(bl);
        }
        if (!this.isOpen()) {
            return;
        }
        if (this.cachedInvChangeCount != this.client.player.getInventory().getChangeCount()) {
            this.refreshInputs();
            this.cachedInvChangeCount = this.client.player.getInventory().getChangeCount();
        }
        this.searchField.tick();
    }

    private void refreshInputs() {
        this.recipeFinder.clear();
        this.client.player.getInventory().populateRecipeFinder(this.recipeFinder);
        this.craftingScreenHandler.populateRecipeFinder(this.recipeFinder);
        this.refreshResults(false);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        if (!this.isOpen()) {
            return;
        }
        context.getMatrices().push();
        context.getMatrices().translate(0.0f, 0.0f, 100.0f);
        int i = (this.parentWidth - 147) / 2 - this.leftOffset;
        int j = (this.parentHeight - 166) / 2;
        context.drawTexture(TEXTURE, i, j, 1, 1, 147, 166);
        this.searchField.render(context, mouseX, mouseY, delta);
        for (RecipeGroupButtonWidget recipeGroupButtonWidget : this.tabButtons) {
            recipeGroupButtonWidget.render(context, mouseX, mouseY, delta);
        }
        this.toggleCraftableButton.render(context, mouseX, mouseY, delta);
        this.recipesArea.draw(context, i, j, mouseX, mouseY, delta);
        context.getMatrices().pop();
    }

    public void drawTooltip(DrawContext context, int x, int y, int mouseX, int mouseY) {
        if (!this.isOpen()) {
            return;
        }
        this.recipesArea.drawTooltip(context, mouseX, mouseY);
        this.drawGhostSlotTooltip(context, x, y, mouseX, mouseY);
    }

    protected Text getToggleCraftableButtonText() {
        return TOGGLE_CRAFTABLE_RECIPES_TEXT;
    }

    private void drawGhostSlotTooltip(DrawContext context, int x, int y, int mouseX, int mouseY) {
        ItemStack itemStack = null;
        for (int i = 0; i < this.ghostSlots.getSlotCount(); ++i) {
            RecipeBookGhostSlots.GhostInputSlot ghostInputSlot = this.ghostSlots.getSlot(i);
            int j = ghostInputSlot.getX() + x;
            int k = ghostInputSlot.getY() + y;
            if (mouseX < j || mouseY < k || mouseX >= j + 16 || mouseY >= k + 16) continue;
            itemStack = ghostInputSlot.getCurrentItemStack();
        }
        if (itemStack != null && this.client.currentScreen != null) {
            context.drawTooltip(this.client.textRenderer, Screen.getTooltipFromItem(this.client, itemStack), mouseX, mouseY);
        }
    }

    public void drawGhostSlots(DrawContext context, int x, int y, boolean notInventory, float delta) {
        this.ghostSlots.draw(context, this.client, x, y, notInventory, delta);
    }

    private boolean isWide() {
        return this.leftOffset == 86;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (!this.isOpen() || this.client.player.isSpectator()) {
            return false;
        }
        if (this.recipesArea.mouseClicked(mouseX, mouseY, button, (this.parentWidth - 147) / 2 - this.leftOffset, (this.parentHeight - 166) / 2, 147, 166)) {
            Recipe<?> recipe = this.recipesArea.getLastClickedRecipe();
            RecipeResultCollection recipeResultCollection = this.recipesArea.getLastClickedResults();
            if (recipe != null && recipeResultCollection != null) {
                if (!recipeResultCollection.isCraftable(recipe) && this.ghostSlots.getRecipe() == recipe) {
                    return false;
                }
                this.ghostSlots.reset();
                this.client.interactionManager.clickRecipe(this.client.player.currentScreenHandler.syncId, recipe, Screen.hasShiftDown());
                if (!this.isWide()) {
                    this.setOpen(false);
                }
            }
            return true;
        }
        if (this.searchField.mouseClicked(mouseX, mouseY, button)) {
            this.searchField.setFocused(true);
            return true;
        }
        this.searchField.setFocused(false);
        if (this.toggleCraftableButton.mouseClicked(mouseX, mouseY, button)) {
            boolean bl = this.toggleFilteringCraftable();
            this.toggleCraftableButton.setToggled(bl);
            this.updateTooltip();
            this.sendBookDataPacket();
            this.refreshResults(false);
            return true;
        }
        for (RecipeGroupButtonWidget recipeGroupButtonWidget : this.tabButtons) {
            if (!recipeGroupButtonWidget.mouseClicked(mouseX, mouseY, button)) continue;
            if (this.currentTab != recipeGroupButtonWidget) {
                if (this.currentTab != null) {
                    this.currentTab.setToggled(false);
                }
                this.currentTab = recipeGroupButtonWidget;
                this.currentTab.setToggled(true);
                this.refreshResults(true);
            }
            return true;
        }
        return false;
    }

    private boolean toggleFilteringCraftable() {
        RecipeBookCategory recipeBookCategory = this.craftingScreenHandler.getCategory();
        boolean bl = !this.recipeBook.isFilteringCraftable(recipeBookCategory);
        this.recipeBook.setFilteringCraftable(recipeBookCategory, bl);
        return bl;
    }

    public boolean isClickOutsideBounds(double mouseX, double mouseY, int x, int y, int backgroundWidth, int backgroundHeight, int button) {
        if (!this.isOpen()) {
            return true;
        }
        boolean bl = mouseX < (double) x || mouseY < (double) y || mouseX >= (double) (x + backgroundWidth) || mouseY >= (double) (y + backgroundHeight);
        boolean bl2 = (double) (x - 147) < mouseX && mouseX < (double) x && (double) y < mouseY && mouseY < (double) (y + backgroundHeight);
        return bl && !bl2 && !this.currentTab.isSelected();
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        this.searching = false;
        if (!this.isOpen() || this.client.player.isSpectator()) {
            return false;
        }
        if (keyCode == GLFW.GLFW_KEY_ESCAPE && !this.isWide()) {
            this.setOpen(false);
            return true;
        }
        if (this.searchField.keyPressed(keyCode, scanCode, modifiers)) {
            this.refreshSearchResults();
            return true;
        }
        if (this.searchField.isFocused() && this.searchField.isVisible() && keyCode != GLFW.GLFW_KEY_ESCAPE) {
            return true;
        }
        if (this.client.options.chatKey.matchesKey(keyCode, scanCode) && !this.searchField.isFocused()) {
            this.searching = true;
            this.searchField.setFocused(true);
            return true;
        }
        return false;
    }

    private void refreshSearchResults() {
        String string = this.searchField.getText().toLowerCase(Locale.ROOT);
        this.triggerPirateSpeakEasterEgg(string);
        if (!string.equals(this.searchText)) {
            this.refreshResults(false);
            this.searchText = string;
        }
    }

    private void triggerPirateSpeakEasterEgg(String search) {
        if ("excitedze".equals(search)) {
            LanguageManager languageManager = this.client.getLanguageManager();
            LanguageDefinition languageDefinition = languageManager.getLanguage("en_pt");
            if (languageDefinition == null || languageManager.getLanguage().equals("en_pt")) {
                return;
            }
            languageManager.setLanguage("en_pt");
            this.client.options.language = "en_pt";
            this.client.reloadResources();
            this.client.options.write();
        }
    }

    public void refresh() {
        this.refreshTabButtons();
        if (this.isOpen()) {
            this.refreshResults(false);
        }
    }

    @Override
    public void onRecipesDisplayed(List<Recipe<?>> recipes) {
        for (Recipe<?> recipe : recipes) {
            this.client.player.onRecipeDisplayed(recipe);
        }
    }

    public void showGhostRecipe(Recipe<?> recipe, List<Slot> slots) {
        ItemStack itemStack = recipe.getOutput(this.client.world.getRegistryManager());
        this.ghostSlots.setRecipe(recipe);
        this.ghostSlots.addSlot(Ingredient.ofStacks(itemStack), slots.get(0).x, slots.get(0).y);
        this.alignRecipeToGrid(this.craftingScreenHandler.getCraftingWidth(), this.craftingScreenHandler.getCraftingHeight(), this.craftingScreenHandler.getCraftingResultSlotIndex(), recipe, recipe.getIngredients().iterator(), 0);
    }

    @Override
    public void acceptAlignedInput(Iterator<Ingredient> inputs, int slot, int amount, int gridX, int gridY) {
        Ingredient ingredient = inputs.next();
        if (!ingredient.isEmpty()) {
            Slot slot2 = this.craftingScreenHandler.slots.get(slot);
            this.ghostSlots.addSlot(ingredient, slot2.x, slot2.y);
        }
    }

    protected void sendBookDataPacket() {
        if (this.client.getNetworkHandler() != null) {
            RecipeBookCategory recipeBookCategory = this.craftingScreenHandler.getCategory();
            boolean bl = this.recipeBook.getOptions().isGuiOpen(recipeBookCategory);
            boolean bl2 = this.recipeBook.getOptions().isFilteringCraftable(recipeBookCategory);
            this.client.getNetworkHandler().sendPacket(new RecipeCategoryOptionsC2SPacket(recipeBookCategory, bl, bl2));
        }
    }

    @Override
    public Selectable.SelectionType getType() {
        return this.open ? Selectable.SelectionType.HOVERED : Selectable.SelectionType.NONE;
    }

    @Override
    public void appendNarrations(NarrationMessageBuilder builder) {
        ArrayList<ClickableWidget> list = Lists.newArrayList();
        this.recipesArea.forEachButton(button -> {
            if (button.isNarratable()) {
                list.add(button);
            }
        });
        list.add(this.searchField);
        list.add(this.toggleCraftableButton);
        list.addAll(this.tabButtons);
        Screen.SelectedElementNarrationData selectedElementNarrationData = Screen.findSelectedElementData(list, null);
        if (selectedElementNarrationData != null) {
            selectedElementNarrationData.selectable.appendNarrations(builder.nextMessage());
        }
    }
}
