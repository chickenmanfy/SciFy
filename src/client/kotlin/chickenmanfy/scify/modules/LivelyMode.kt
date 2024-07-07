package chickenmanfy.scify.modules

import net.minecraft.client.MinecraftClient

var livelyModeToggle: Boolean = false
class LivelyMode {
    fun toggleLivelyMode() {
        livelyModeToggle = !livelyModeToggle
    }

    fun livelyMode() {
        if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "dungeonfy.minehut.gg" ||
            MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599" ||
            MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "minehut.com" ||
            MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "54.39.244.190:25608") {
            if (livelyModeToggle) {
                return
            }
        }
    }
}