package chickenmanfy.scify.modules

import net.minecraft.client.MinecraftClient

var fishingToggle: Boolean = false
class FishingNotif {
    // Fishing Notification Toggle
    fun toggleFishingNotif() {
        fishingToggle = !fishingToggle
    }


    // Code in Menu.kt:
    // toggleFishingNotif()

    fun fishingNotif() {
        if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "dungeonfy.minehut.gg" ||
            MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599" ||
            MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "minehut.com" ||
            modDisableOverride) {
            if (fishingToggle) {
                return
            }
        }
    }
}