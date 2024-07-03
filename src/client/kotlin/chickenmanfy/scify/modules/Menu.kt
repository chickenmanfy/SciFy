package chickenmanfy.scify.modules

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.tooltip.Tooltip
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.text.Text
import net.minecraft.util.Identifier


@Environment(EnvType.CLIENT)
class Menu : Screen(Text.literal("SciFy Menu")) {
    private var dynamicBars: ButtonWidget? = null
    private var fishingNotif: ButtonWidget? = null
    private var warpHotkeys: ButtonWidget? = null
    private var autoWelcome: ButtonWidget? = null
    private var livelyMode: ButtonWidget? = null
    private var resourcePack: ButtonWidget? = null

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
        }
            .dimensions(width / 2 - 205, 84, 200, 20)
            .tooltip(Tooltip.of(Text.literal("Custom Health and Mana bars.")))
            .build()
        fishingNotif = ButtonWidget.builder(Text.literal("Fishing Notifications")) {
            FishingNotif().toggleFishingNotif() // Call the function toggleFishingNotif() from the FishingNotif.kt module
        }
            .dimensions(width / 2 + 5, 84, 200, 20)
            .tooltip(Tooltip.of(Text.literal("Fishing Notifications")))
            .build()
        warpHotkeys = ButtonWidget.builder(Text.literal("Toggle hotkeys")) {
            // I don't think we actually need this module at all. TODO: replace with something else
        }
            .dimensions(width / 2 - 205, 164, 200, 20)
            .tooltip(Tooltip.of(Text.literal("Enable/Disable hotkeys.")))
            .build()
        autoWelcome = ButtonWidget.builder(Text.literal("Auto-Welcome")) {
            AutoWelcome().toggleAutoWelcome() // Call the function toggleAutoWelcome() from the AutoWelcome.kt module
        }
            .dimensions(width / 2 - 205, 124, 200, 20)
            .tooltip(Tooltip.of(Text.literal("Automatically welcomes new players.")))
            .build()
        livelyMode = ButtonWidget.builder(Text.literal("City NPCs (Lively Mode)")) {
            LivelyMode().toggleLivelyMode() // Call the function toggleLivelyMode() from the LivelyMode.kt module
        }
            .dimensions(width / 2 - 205, 164, 200, 20)
            .tooltip(Tooltip.of(Text.literal("Replaces Villagers with player NPCs")))
            .build()
        resourcePack = ButtonWidget.builder(Text.literal("Toggle Resource Pack")) {
            // TODO: Implement Resource pack
        }
            .dimensions(width / 2 + 5, 124, 200, 20)
            .tooltip(Tooltip.of(Text.literal("Toggles the community resource pack.")))
            .build()

        addDrawableChild(dynamicBars)
        addDrawableChild(fishingNotif)
        //addDrawableChild(warpHotkeys)
        addDrawableChild(autoWelcome)
        //addDrawableChild(livelyMode)
        addDrawableChild(resourcePack)
    }
}