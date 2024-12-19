/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */
package net.pythonbear.tead.screen;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.screen.narration.NarrationPart;
import net.minecraft.client.gui.screen.recipebook.RecipeBookResults;
import net.minecraft.client.gui.screen.recipebook.RecipeResultCollection;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeBook;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(value=EnvType.CLIENT)
public class TeadAnimatedResultButton extends ClickableWidget {
    private static final Identifier BACKGROUND_TEXTURE = new Identifier("textures/gui/recipe_book.png");
    private static final Text MORE_RECIPES_TEXT = Text.translatable("gui.recipebook.moreRecipes");
    private AbstractRecipeScreenHandler<?> craftingScreenHandler;
    private RecipeBook recipeBook;
    private RecipeResultCollection resultCollection;
    private float time;
    private float bounce;
    private int currentResultIndex;

    public TeadAnimatedResultButton() {
        super(0, 0, 25, 25, ScreenTexts.EMPTY);
    }

    public void showResultCollection(RecipeResultCollection resultCollection, TeadRecipeBookResults results) {
        this.resultCollection = resultCollection;
        this.craftingScreenHandler = (AbstractRecipeScreenHandler)results.getClient().player.currentScreenHandler;
        this.recipeBook = results.getRecipeBook();
        List<Recipe<?>> list = resultCollection.getResults(this.recipeBook.isFilteringCraftable(this.craftingScreenHandler));
        for (Recipe<?> recipe : list) {
            if (!this.recipeBook.shouldDisplay(recipe)) continue;
            results.onRecipesDisplayed(list);
            this.bounce = 15.0f;
            break;
        }
    }

    public RecipeResultCollection getResultCollection() {
        return this.resultCollection;
    }

    @Override
    public void renderButton(DrawContext context, int mouseX, int mouseY, float delta) {
        boolean bl;
        if (!Screen.hasControlDown()) {
            this.time += delta;
        }
        int i = 29;
        if (!this.resultCollection.hasCraftableRecipes()) {
            i += 25;
        }
        int j = 206;
        if (this.resultCollection.getResults(this.recipeBook.isFilteringCraftable(this.craftingScreenHandler)).size() > 1) {
            j += 25;
        }
        boolean bl2 = bl = this.bounce > 0.0f;
        if (bl) {
            float f = 1.0f + 0.1f * (float)Math.sin(this.bounce / 15.0f * (float)Math.PI);
            context.getMatrices().push();
            context.getMatrices().translate(this.getX() + 8, this.getY() + 12, 0.0f);
            context.getMatrices().scale(f, f, 1.0f);
            context.getMatrices().translate(-(this.getX() + 8), -(this.getY() + 12), 0.0f);
            this.bounce -= delta;
        }
        context.drawTexture(BACKGROUND_TEXTURE, this.getX(), this.getY(), i, j, this.width, this.height);
        List<Recipe<?>> list = this.getResults();
        this.currentResultIndex = MathHelper.floor(this.time / 30.0f) % list.size();
        ItemStack itemStack = list.get(this.currentResultIndex).getOutput(this.resultCollection.getRegistryManager());
        int k = 4;
        if (this.resultCollection.hasSingleOutput() && this.getResults().size() > 1) {
            context.drawItem(itemStack, this.getX() + k + 1, this.getY() + k + 1, 0, 10);
            --k;
        }
        context.drawItemWithoutEntity(itemStack, this.getX() + k, this.getY() + k);
        if (bl) {
            context.getMatrices().pop();
        }
    }

    private List<Recipe<?>> getResults() {
        List<Recipe<?>> list = this.resultCollection.getRecipes(true);
        if (!this.recipeBook.isFilteringCraftable(this.craftingScreenHandler)) {
            list.addAll(this.resultCollection.getRecipes(false));
        }
        return list;
    }

    public boolean hasResults() {
        return this.getResults().size() == 1;
    }

    public Recipe<?> currentRecipe() {
        List<Recipe<?>> list = this.getResults();
        return list.get(this.currentResultIndex);
    }

    public List<Text> getTooltipList() {
        ItemStack itemStack = this.getResults().get(this.currentResultIndex).getOutput(this.resultCollection.getRegistryManager());
        ArrayList<Text> list = Lists.newArrayList(Screen.getTooltipFromItem(MinecraftClient.getInstance(), itemStack));
        if (this.resultCollection.getResults(this.recipeBook.isFilteringCraftable(this.craftingScreenHandler)).size() > 1) {
            list.add(MORE_RECIPES_TEXT);
        }
        return list;
    }

    @Override
    public void appendClickableNarrations(NarrationMessageBuilder builder) {
        ItemStack itemStack = this.getResults().get(this.currentResultIndex).getOutput(this.resultCollection.getRegistryManager());
        builder.put(NarrationPart.TITLE, (Text)Text.translatable("narration.recipe", itemStack.getName()));
        if (this.resultCollection.getResults(this.recipeBook.isFilteringCraftable(this.craftingScreenHandler)).size() > 1) {
            builder.put(NarrationPart.USAGE, Text.translatable("narration.button.usage.hovered"), Text.translatable("narration.recipe.usage.more"));
        } else {
            builder.put(NarrationPart.USAGE, (Text)Text.translatable("narration.button.usage.hovered"));
        }
    }

    @Override
    public int getWidth() {
        return 25;
    }

    @Override
    protected boolean isValidClickButton(int button) {
        return button == 0 || button == 1;
    }
}

