package chickenmanfy.scify

import chickenmanfy.scify.modules.* // woo fancy import all modules
import net.fabricmc.api.ClientModInitializer


object SciFyClient : ClientModInitializer {
    override fun onInitializeClient() {
        // Runs the Hotkey().hotkeys() function which contains all keybindings.
        Hotkey().hotkeys()

        // Run the modules
        AutoWelcome().autoWelcome()
        FishingNotif().fishingNotif()
        Bars().bars()
        //LivelyMode().livelyMode()
    }
}
