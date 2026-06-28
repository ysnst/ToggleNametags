package sh.ndy.mixin.client;

import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sh.ndy.features.listeners.NametagsToggleListener;

@Mixin(PlayerEntityRenderer.class)
public class MixinRenderPlayerNameTag {
  private static final NametagsToggleListener listener = new NametagsToggleListener();

  @Inject(at = @At("HEAD"), method = "renderLabelIfPresent(Lnet/minecraft/client/render/entity/state/PlayerEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/render/state/CameraRenderState;)V", cancellable = true)
  private void doNotRenderPlayerNameTag(PlayerEntityRenderState state, MatrixStack matrices,
										OrderedRenderCommandQueue queue, CameraRenderState cameraRenderState,
										CallbackInfo ci) {
	listener.handlePlayerMixin(state, ci);
  }
}
