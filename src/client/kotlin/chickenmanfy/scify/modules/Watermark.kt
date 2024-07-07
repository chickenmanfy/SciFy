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
            HudRenderCallback.EVENT.register(HudRenderCallback { drawContext: DrawContext?, tickDelta: Float ->

                if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "dungeonfy.minehut.gg" ||
                    MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599" ||
                    MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "minehut.com" ||
                    MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "54.39.244.190:25608") {
                    if (watermarkToggle) {
                        val minecraftClient = MinecraftClient.getInstance()
                        drawContext?.drawTextWithShadow(minecraftClient.textRenderer,"§nSciFy v0.1.4",minecraftClient.window.scaledWidth - minecraftClient.textRenderer.getWidth("SciFy v0.1.4") - 5, minecraftClient.window.scaledHeight - minecraftClient.textRenderer.fontHeight - 5, 0xff00ff)
                    }
                }
            })
    }
}