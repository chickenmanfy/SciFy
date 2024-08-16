package chickenmanfy.scify.modules

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.tooltip.Tooltip
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.text.Text
import net.minecraft.util.Identifier

var modDisableOverride = false
@Environment(EnvType.CLIENT)
class Menu : Screen(Text.literal("SciFy Menu")) {
    private var dynamicBars: ButtonWidget? = null
    private var fishingNotif: ButtonWidget? = null
    private var watermark: ButtonWidget? = null
    private var autoWelcome: ButtonWidget? = null
    private var livelyMode: ButtonWidget? = null
    private var resourcePack: ButtonWidget? = null
    private var forceMod: ButtonWidget? = null

    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float) {
        super.render(context, mouseX, mouseY, delta)
        context.drawCenteredTextWithShadow(
            textRenderer,
            Text.literal("SciFy Menu"),
            width / 2,
            5,
            0xff00ff
        )

        val texture = Identifier("scify", "scify.png")
        context.drawTexture(texture, width / 2 - 32, 20, 0F, 0F, 64, 64, 64, 64)
    }
    public override fun init() {

        dynamicBars = ButtonWidget.builder(Text.literal("Custom Health/Mana")) {
            Bars().toggleBars() // Call the function toggleBars() from the bars.kt module
            MinecraftClient.getInstance().setScreen(Menu())
        }
            .dimensions(width / 2 - 205, 84, 200, 20)
            .tooltip(Tooltip.of(Text.literal("Custom Health and Mana bars. (${if (barsToggle) "Enabled" else "Disabled"})")))
            .build()
        fishingNotif = ButtonWidget.builder(Text.literal("Fishing Notifications")) {
            FishingNotif().toggleFishingNotif() // Call the function toggleFishingNotif() from the FishingNotif.kt module
            MinecraftClient.getInstance().setScreen(Menu())
        }
            .dimensions(width / 2 + 5, 84, 200, 20)
            .tooltip(Tooltip.of(Text.literal("Fishing Notifications (${if (fishingToggle) "Enabled" else "Disabled"})")))
            .build()
        watermark = ButtonWidget.builder(Text.literal("Show Watermark")) {
            Watermark().toggleWaterMark() // Call the function toggleWaterMark() from the Watermark.kt module
            MinecraftClient.getInstance().setScreen(Menu())
        }
            .dimensions(width / 2 - 205, 164, 200, 20)
            .tooltip(Tooltip.of(Text.literal("Enable/Disable the small text in the bottom right displaying the mod name. (${if (watermarkToggle) "Enabled" else "Disabled"})")))
            .build()
        autoWelcome = ButtonWidget.builder(Text.literal("Auto Welcome Back")) {
            AutoWelcome().toggleAutoWelcome() // Call the function toggleAutoWelcome() from the AutoWelcome.kt module
            MinecraftClient.getInstance().setScreen(Menu())
        }
            .dimensions(width / 2 - 205, 124, 200, 20)
            .tooltip(Tooltip.of(Text.literal("Automatically sends \"wb\" when a player joins. (${if (autoWelcomeToggle) "Enabled" else "Disabled"})")))
            .build()
        livelyMode = ButtonWidget.builder(Text.literal("City NPCs (Lively Mode)")) {
            LivelyMode().toggleLivelyMode() // Call the function toggleLivelyMode() from the LivelyMode.kt module
            MinecraftClient.getInstance().setScreen(Menu())
        }
            .dimensions(width / 2 - 205, 164, 200, 20)
            .tooltip(Tooltip.of(Text.literal("Replaces Villagers with player NPCs (${if (livelyModeToggle) "Enabled" else "Disabled"})")))
            .build()
        resourcePack = ButtonWidget.builder(Text.literal("Toggle Resource Pack")) {
            // TODO: Implement Resource pack
            MinecraftClient.getInstance().setScreen(Menu())
        }
            .dimensions(width / 2 + 5, 124, 200, 20)
            .tooltip(Tooltip.of(Text.literal("Toggles the community resource pack. (${if (fishingToggle) "Enabled" else "Disabled"})")))
            .build()

        forceMod = ButtonWidget.builder(Text.literal("ADVANCED: Force enable mod features")) {
            modDisableOverride = !modDisableOverride
            println(modDisableOverride)
            MinecraftClient.getInstance().setScreen(Menu())
        }
            .dimensions(width / 2 - 100, height - 40, 200, 20)
            .tooltip(Tooltip.of(Text.literal("Disables the requirement to be on Dungeonfy. This means the features work on every server. This is not recommended. (${if (modDisableOverride) "Enabled" else "Disabled"})")))
            .build()
        addDrawableChild(dynamicBars)
        addDrawableChild(fishingNotif)
        addDrawableChild(watermark)
        addDrawableChild(autoWelcome)
        //addDrawableChild(livelyMode)
        addDrawableChild(resourcePack)
        addDrawableChild(forceMod)
    }
}