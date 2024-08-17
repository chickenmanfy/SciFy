package chickenmanfy.scify.modules

import com.mojang.blaze3d.systems.RenderSystem
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.render.*
import net.minecraft.util.Identifier
import java.util.regex.Pattern

var barsToggle: Boolean = true
class Bars {
    private var mana = 0
    init {
        ClientReceiveMessageEvents.GAME.register { actionbar, _ ->

            val pattern: Pattern = Pattern.compile("\\[(\\d+)/(\\d+)]")
            val matcher = pattern.matcher(actionbar.string)

            var lastFirstNumber = 0
            var lastSecondNumber = 0

            while (matcher.find()) {
                lastFirstNumber = matcher.group(1).toInt()
                lastSecondNumber = matcher.group(2).toInt()
            }

            // Final mana value
            if (lastSecondNumber != 0) {
                val divided = lastSecondNumber.toFloat() / 20
                val final = Math.round(lastFirstNumber.toFloat() / divided)
                mana = if (final <= 20) final else 20
            }

        }
    }

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
        HudRenderCallback.EVENT.register(HudRenderCallback { drawContext: DrawContext, _: RenderTickCounter ->
            val tessellator: Tessellator = Tessellator.getInstance()
            val buffer: BufferBuilder = tessellator.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR)
            val positionMatrix = drawContext.matrices?.peek()?.positionMatrix
            if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "dungeonfy.minehut.gg" ||
                MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599" ||
                MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "minehut.com" ||
                modDisableOverride) {
                if (barsToggle) {
                    if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599") {
                        buffer.vertex(positionMatrix, xReality, yReality, 0f).color(1f, 1f, 1f, 1f).texture(0f, 0f)
                        buffer.vertex(positionMatrix, xReality, yReality + height, 0f).color(1f, 1f, 1f, 1f).texture(0f, 1f)
                        buffer.vertex(positionMatrix, xReality + width, yReality + height, 0f).color(1f, 1f, 1f, 1f).texture(1f, 1f)
                        buffer.vertex(positionMatrix, xReality + width, yReality, 0f).color(1f, 1f, 1f, 1f).texture(1f, 0f)
                        RenderSystem.setShader { GameRenderer.getPositionTexColorProgram() }
                        RenderSystem.setShaderTexture(0, Identifier.of("scify", "healthmana/mana/mana_${mana}.png"))
                        RenderSystem.setShaderColor(1f, 1f, 1f, 1f)

                        BufferRenderer.drawWithGlobalProgram(buffer.end())
                    }
                    buffer.vertex(positionMatrix, xHealth, yHealth, 0f).color(1f, 1f, 1f, 1f).texture(0f, 0f)
                    buffer.vertex(positionMatrix, xHealth, yHealth+height, 0f).color(1f, 1f, 1f, 1f).texture(0f, 1f)
                    buffer.vertex(positionMatrix, xHealth+width, yHealth+height, 0f).color(1f, 1f, 1f, 1f).texture(1f, 1f)
                    buffer.vertex(positionMatrix, xHealth+width, yHealth, 0f).color(1f, 1f, 1f, 1f).texture(1f, 0f)
                    val maxHealthDivided = MinecraftClient.getInstance().player?.maxHealth?.div(20)?.toInt()
                    val health = if (MinecraftClient.getInstance().player?.health?.toInt()?.div(maxHealthDivided!!)!! <= 20) MinecraftClient.getInstance().player?.health?.toInt()?.div(maxHealthDivided!!) else 20
                    RenderSystem.setShader { GameRenderer.getPositionTexColorProgram() }
                    RenderSystem.setShaderTexture(0, Identifier.of("scify", "healthmana/health/health_${health}.png"))
                    RenderSystem.setShaderColor(1f, 1f, 1f, 1f)

                    BufferRenderer.drawWithGlobalProgram(buffer.end())
                }
            }
        })

        /*HudRenderCallback.EVENT.register(HudRenderCallback { drawContext: DrawContext, _: RenderTickCounter ->
            val color = -0x10000 // Red
            drawContext.fill(0, 0, 100, 100, 0, color)
        })*/
    }
}