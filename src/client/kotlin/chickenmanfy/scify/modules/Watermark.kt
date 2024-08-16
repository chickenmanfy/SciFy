package chickenmanfy.scify.modules

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawContext

var watermarkToggle = true
class Watermark {
    fun toggleWaterMark() {
        watermarkToggle = !watermarkToggle
    }

    fun watermark() {
            HudRenderCallback.EVENT.register(HudRenderCallback { drawContext: DrawContext?, _: Float ->

                if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "dungeonfy.minehut.gg" ||
                    MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599" ||
                    MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "minehut.com" ||
                    modDisableOverride) {
                    if (watermarkToggle) {
                        val minecraftClient = MinecraftClient.getInstance()
                        val scifyVersion = "0.2.11"
                        drawContext?.drawTextWithShadow(minecraftClient.textRenderer,"§nSciFy v${scifyVersion}",minecraftClient.window.scaledWidth - minecraftClient.textRenderer.getWidth("SciFy v${scifyVersion}") - 5, minecraftClient.window.scaledHeight - minecraftClient.textRenderer.fontHeight - 5, 0xff00ff)
                    }
                }
            })
    }
}