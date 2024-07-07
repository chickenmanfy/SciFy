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
        HudRenderCallback.EVENT.register(HudRenderCallback { drawContext: DrawContext?, tickDelta: Float ->
            val tessellator: Tessellator = Tessellator.getInstance()
            val buffer: BufferBuilder = tessellator.buffer
            val positionMatrix = drawContext?.matrices?.peek()?.positionMatrix
            if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599") {
                if (barsToggle) {
                    buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR_TEXTURE)
                    buffer.vertex(positionMatrix, MinecraftClient.getInstance().window.scaledWidth.toFloat()/2-160, MinecraftClient.getInstance().window.scaledHeight.toFloat() - 40, 0F).color(1f, 1f, 1f, 1f).texture(0f, 0f).next()
                    buffer.vertex(positionMatrix, MinecraftClient.getInstance().window.scaledWidth.toFloat()/2-160, MinecraftClient.getInstance().window.scaledHeight.toFloat(), 0F).color(1f, 1f, 1f, 1f).texture(0f, 1f).next()
                    buffer.vertex(positionMatrix, MinecraftClient.getInstance().window.scaledWidth.toFloat()/2-120, MinecraftClient.getInstance().window.scaledHeight.toFloat(), 0F).color(1f, 1f, 1f, 1f).texture(1f, 1f).next()
                    buffer.vertex(positionMatrix, MinecraftClient.getInstance().window.scaledWidth.toFloat()/2-120, MinecraftClient.getInstance().window.scaledHeight.toFloat() - 40, 0F).color(1f, 1f, 1f, 1f).texture(1f, 0f).next()

                    RenderSystem.setShader { GameRenderer.getPositionColorTexProgram() }

                    RenderSystem.setShaderTexture(0, Identifier("scify", "healthmana/mana/vials_00${BridgeMixins.getStrNum1()}.png"))
                    RenderSystem.setShaderColor(1f, 1f, 1f, 1f)

                    tessellator.draw()

                    buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR_TEXTURE)
                    buffer.vertex(positionMatrix, MinecraftClient.getInstance().window.scaledWidth.toFloat()/2-180, MinecraftClient.getInstance().window.scaledHeight.toFloat() - 40, 0F).color(1f, 1f, 1f, 1f).texture(0f, 0f).next()
                    buffer.vertex(positionMatrix, MinecraftClient.getInstance().window.scaledWidth.toFloat()/2-180, MinecraftClient.getInstance().window.scaledHeight.toFloat(), 0F).color(1f, 1f, 1f, 1f).texture(0f, 1f).next()
                    buffer.vertex(positionMatrix, MinecraftClient.getInstance().window.scaledWidth.toFloat()/2-140, MinecraftClient.getInstance().window.scaledHeight.toFloat(), 0F).color(1f, 1f, 1f, 1f).texture(1f, 1f).next()
                    buffer.vertex(positionMatrix, MinecraftClient.getInstance().window.scaledWidth.toFloat()/2-140, MinecraftClient.getInstance().window.scaledHeight.toFloat() - 40, 0F).color(1f, 1f, 1f, 1f).texture(1f, 0f).next()

                    RenderSystem.setShader { GameRenderer.getPositionColorTexProgram() }
                    if (BridgeMixins.getNum0() < 10) {
                        RenderSystem.setShaderTexture(0, Identifier("scify", "healthmana/health/vials_000${BridgeMixins.getStrNum0()}.png"))
                    } else {
                        RenderSystem.setShaderTexture(0, Identifier("scify", "healthmana/health/vials_00${BridgeMixins.getStrNum0()}.png"))
                    }
                    RenderSystem.setShaderColor(1f, 1f, 1f, 1f)

                    tessellator.draw()
                }
            }
        })
    }
}