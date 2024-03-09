package net.pythonbear.tead.mixin;

import net.pythonbear.tead.Tead;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {
    @Shadow
    protected abstract void addModel(ModelIdentifier modelId);

    @Inject(method = "<init>", at = @At(value = "INVOKE", target =
            "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V",
            ordinal = 3, shift = At.Shift.AFTER))
    public void add3dModel(BlockColors blockColors, Profiler profiler, Map<Identifier,
            JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates,
                           CallbackInfo ci) {
        this.addModel(new ModelIdentifier(Tead.MOD_ID, "stone_hammer_3d", "inventory"));
        this.addModel(new ModelIdentifier(Tead.MOD_ID, "lead_hammer_3d", "inventory"));
        this.addModel(new ModelIdentifier(Tead.MOD_ID, "iron_hammer_3d", "inventory"));
        this.addModel(new ModelIdentifier(Tead.MOD_ID, "gold_hammer_3d", "inventory"));
        this.addModel(new ModelIdentifier(Tead.MOD_ID, "diamond_hammer_3d", "inventory"));
        this.addModel(new ModelIdentifier(Tead.MOD_ID, "netherite_hammer_3d", "inventory"));
        this.addModel(new ModelIdentifier(Tead.MOD_ID, "wood_hammer_3d", "inventory"));
        this.addModel(new ModelIdentifier(Tead.MOD_ID, "gold_mace_3d", "inventory"));
    }
}