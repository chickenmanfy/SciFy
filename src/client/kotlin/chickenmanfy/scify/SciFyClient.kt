package chickenmanfy.scify

import chickenmanfy.scify.modules.* // woo fancy import all modules
import net.fabricmc.api.ClientModInitializer


object SciFyClient : ClientModInitializer {
    val debugUser = "Chickenmanfy"
    override fun onInitializeClient() {

        // Run the Modules
        Hotkey().hotkeys()
        AutoWelcome().autoWelcome()
        FishingNotif().fishingNotif()
        Bars().bars()
        //LivelyMode().livelyMode()
    }
}
