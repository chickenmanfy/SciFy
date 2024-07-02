package chickenmanfy.scify.modules

import com.mojang.blaze3d.systems.RenderSystem
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
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
        })
    }
}