package chickenmanfy.scify.modules

import chickenmanfy.scify.SciFyClient.debugUser
import com.mojang.blaze3d.systems.RenderSystem
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.render.*
import net.minecraft.util.Identifier

var barsToggle: Boolean = true
class Bars {
    fun toggleBars() {
        barsToggle = !barsToggle
    }

    fun bars() {
        HudRenderCallback.EVENT.register(HudRenderCallback { drawContext: DrawContext?, tickDelta: Float ->
            val tessellator: Tessellator = Tessellator.getInstance()
            val buffer: BufferBuilder = tessellator.buffer
            val positionMatrix = drawContext?.matrices?.peek()?.positionMatrix
            if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "dungeonfy.minehut.gg" ||
                MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599" ||
                MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "minehut.com" ||  // if you join minehut.com and type /join dungeonfy
                MinecraftClient.getInstance().player?.name?.string == debugUser) {
                if (barsToggle) {
                    buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR_TEXTURE)
                    buffer.vertex(positionMatrix, 20F, 20F, 0F).color(1f, 1f, 1f, 1f).texture(0f, 0f).next()
                    buffer.vertex(positionMatrix, 20F, 60F, 0F).color(1f, 1f, 1f, 1f).texture(0f, 1f).next()
                    buffer.vertex(positionMatrix, 60F, 60F, 0F).color(1f, 1f, 1f, 1f).texture(1f, 1f).next()
                    buffer.vertex(positionMatrix, 60F, 20F, 0F).color(1f, 1f, 1f, 1f).texture(1f, 0f).next()

                    RenderSystem.setShader { GameRenderer.getPositionColorTexProgram() }
                    RenderSystem.setShaderTexture(0, Identifier("scify", "scify.png"))
                    RenderSystem.setShaderColor(1f, 1f, 1f, 1f)

                    tessellator.draw()
                }
            }
        })
    }
}