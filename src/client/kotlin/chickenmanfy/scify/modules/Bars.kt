package chickenmanfy.scify.modules

import chickenmanfy.scify.BridgeMixins
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
        val width = 98f
        val height = 18f
        val xHealth = 5f
        val yHealth = 5f
        val xReality = 5f
        val yReality = 10f + height
        HudRenderCallback.EVENT.register(HudRenderCallback { drawContext: DrawContext?, tickDelta: Float ->
            val tessellator: Tessellator = Tessellator.getInstance()
            val buffer: BufferBuilder = tessellator.buffer
            val positionMatrix = drawContext?.matrices?.peek()?.positionMatrix
            if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599") {
                if (barsToggle) {
                    buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR_TEXTURE)
                    buffer.vertex(positionMatrix, xReality, yReality, 0f).color(1f, 1f, 1f, 1f).texture(0f, 0f).next()
                    buffer.vertex(positionMatrix, xReality, yReality+height, 0f).color(1f, 1f, 1f, 1f).texture(0f, 1f).next()
                    buffer.vertex(positionMatrix, xReality+width, yReality+height, 0f).color(1f, 1f, 1f, 1f).texture(1f, 1f).next()
                    buffer.vertex(positionMatrix, xReality+width, yReality, 0f).color(1f, 1f, 1f, 1f).texture(1f, 0f).next()

                    RenderSystem.setShader { GameRenderer.getPositionColorTexProgram() }
                    RenderSystem.setShaderTexture(0, Identifier("scify", "healthmana/mana/mana_${BridgeMixins.getStrNum1()}.png"))
                    RenderSystem.setShaderColor(1f, 1f, 1f, 1f)

                    tessellator.draw()

                    buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR_TEXTURE)
                    /*buffer.vertex(positionMatrix, MinecraftClient.getInstance().window.scaledWidth.toFloat()/2-180, MinecraftClient.getInstance().window.scaledHeight.toFloat() - 40, 0F).color(1f, 1f, 1f, 1f).texture(0f, 0f).next()
                    buffer.vertex(positionMatrix, MinecraftClient.getInstance().window.scaledWidth.toFloat()/2-180, MinecraftClient.getInstance().window.scaledHeight.toFloat(), 0F).color(1f, 1f, 1f, 1f).texture(0f, 1f).next()
                    buffer.vertex(positionMatrix, MinecraftClient.getInstance().window.scaledWidth.toFloat()/2-140, MinecraftClient.getInstance().window.scaledHeight.toFloat(), 0F).color(1f, 1f, 1f, 1f).texture(1f, 1f).next()
                    buffer.vertex(positionMatrix, MinecraftClient.getInstance().window.scaledWidth.toFloat()/2-140, MinecraftClient.getInstance().window.scaledHeight.toFloat() - 40, 0F).color(1f, 1f, 1f, 1f).texture(1f, 0f).next()*/
                    buffer.vertex(positionMatrix, xHealth, yHealth, 0f).color(1f, 1f, 1f, 1f).texture(0f, 0f).next()
                    buffer.vertex(positionMatrix, xHealth, yHealth+height, 0f).color(1f, 1f, 1f, 1f).texture(0f, 1f).next()
                    buffer.vertex(positionMatrix, xHealth+width, yHealth+height, 0f).color(1f, 1f, 1f, 1f).texture(1f, 1f).next()
                    buffer.vertex(positionMatrix, xHealth+width, yHealth, 0f).color(1f, 1f, 1f, 1f).texture(1f, 0f).next()


                    RenderSystem.setShader { GameRenderer.getPositionColorTexProgram() }
                    RenderSystem.setShaderTexture(0, Identifier("scify", "healthmana/health/health_${BridgeMixins.getStrNum0()}.png"))
                    RenderSystem.setShaderColor(1f, 1f, 1f, 1f)

                    tessellator.draw()
                }
            }
        })
    }
}