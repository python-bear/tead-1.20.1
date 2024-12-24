package net.pythonbear.tead.item.ruby;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.pythonbear.tead.Tead;

import java.util.ArrayList;
import java.util.List;

public class RubyToolTransmuting {
    private static final String TRANSMUTATION_ITEMS_KEY = "TransmutationItems";

    public static ItemStack rotateTransmutation(ItemStack mainRubyTool) {
        NbtCompound nbtCompound = mainRubyTool.getNbt();

        if (nbtCompound == null || !nbtCompound.contains(TRANSMUTATION_ITEMS_KEY, NbtElement.LIST_TYPE)) {
            return mainRubyTool;
        }

        NbtList nbtList = nbtCompound.getList(TRANSMUTATION_ITEMS_KEY, NbtElement.COMPOUND_TYPE);

        if (nbtList == null || nbtList.isEmpty()) {
            return mainRubyTool;
        }

        List<ItemStack> itemStacks = new ArrayList<>();
        for (int i = 0; i < nbtList.size(); i++) {
            itemStacks.add(ItemStack.fromNbt((NbtCompound) nbtList.get(i)));
        }

        for (ItemStack stack : itemStacks) {
            cleanNbt(stack);
        }

        ItemStack cleanedMainRubyTool = mainRubyTool.copy();
        cleanNbt(cleanedMainRubyTool);

        if (!itemStacks.isEmpty()) {
            ItemStack resultRubyTool = itemStacks.remove(0).copy();
            itemStacks.add(cleanedMainRubyTool);

            addToRubyTool(resultRubyTool, itemStacks);

            return resultRubyTool;
        }

        return mainRubyTool;
    }

    public static void cleanNbt(ItemStack stack) {
        if (stack.hasNbt()) {
            NbtCompound stackNbt = stack.getNbt();
            if (stackNbt != null && stackNbt.contains(TRANSMUTATION_ITEMS_KEY)) {
                stackNbt.remove(TRANSMUTATION_ITEMS_KEY);
            }
        }
    }

    public static boolean hasTransmorphing(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();
        if (nbt == null) return false;

        NbtList enchantments = stack.getNbt().getList("Enchantments", NbtElement.COMPOUND_TYPE);
        if (enchantments == null) return false;

        for (NbtElement enchantment : enchantments) {
            if (enchantment instanceof NbtCompound compound) {
                String id = compound.getString("id");
                int level = compound.getInt("lvl");

                if ("tead:transmorphing".equals(id) && level > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void addToRubyTool(ItemStack mainRubyTool, List<ItemStack> additionalTools) {
        NbtCompound nbtCompound = mainRubyTool.getOrCreateNbt();
        if (!nbtCompound.contains(TRANSMUTATION_ITEMS_KEY)) {
            nbtCompound.put(TRANSMUTATION_ITEMS_KEY, new NbtList());
        }

        NbtList nbtList = nbtCompound.getList(TRANSMUTATION_ITEMS_KEY, NbtElement.COMPOUND_TYPE);

        for (ItemStack tool : additionalTools) {
            nbtList.add(tool.writeNbt(new NbtCompound()));
        }
    }
}
