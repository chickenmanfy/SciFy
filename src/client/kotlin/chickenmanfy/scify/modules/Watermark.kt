package chickenmanfy.scify.modules

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.render.*

var watermarkToggle = true
class Watermark() {
    fun toggleWaterMark() {
        watermarkToggle = !watermarkToggle
    }

    fun watermark() {
            HudRenderCallback.EVENT.register(HudRenderCallback { drawContext: DrawContext?, tickDelta: Float ->
                val tessellator: Tessellator = Tessellator.getInstance()

                if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599"
                ) {
                    if (watermarkToggle) {
                        val minecraftClient = MinecraftClient.getInstance()
                        drawContext?.drawTextWithShadow(minecraftClient.textRenderer,"§nSciFy v0.1.0",minecraftClient.window.scaledWidth - minecraftClient.textRenderer.getWidth("SciFy v0.1.0") - 5, minecraftClient.window.scaledHeight - minecraftClient.textRenderer.fontHeight - 5, 0xff00ff)
                    }
                }
            })
    }
}