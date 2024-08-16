package chickenmanfy.scify.modules

import net.minecraft.client.MinecraftClient

var autoWelcomeToggle: Boolean = false
class AutoWelcome {
    fun toggleAutoWelcome() {
        autoWelcomeToggle = !autoWelcomeToggle
        // Debug
        println("Auto Welcome ${if (autoWelcomeToggle) "enabled" else "disabled"}")
    }

    fun autoWelcome() {
        if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "dungeonfy.minehut.gg" ||
            MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599" ||
            MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "minehut.com") {
            if (autoWelcomeToggle) {
                return
            }
        }
    }
}