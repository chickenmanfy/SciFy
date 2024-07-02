package chickenmanfy.scify

import chickenmanfy.scify.modules.* // woo fancy import all modules
import net.fabricmc.api.ClientModInitializer
import net.minecraft.client.MinecraftClient


object SciFyClient : ClientModInitializer {
    val debugUser = "Chickenmanfy"
    override fun onInitializeClient() {
        Hotkey().hotkeys()
        // Run the modules
        if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "dungeonfy.minehut.gg" ||
            MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599" ||
            MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "minehut.com" ||  // if you join minehut.com and type /join dungeonfy
            MinecraftClient.getInstance().player?.name?.string == debugUser) // Test override
        {
            AutoWelcome().autoWelcome()
            FishingNotif().fishingNotif()
            Bars().bars()
            //LivelyMode().livelyMode()
        }
    }
}
