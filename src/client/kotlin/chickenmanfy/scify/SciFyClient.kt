package chickenmanfy.scify

import chickenmanfy.scify.modules.Hotkey
import net.fabricmc.api.ClientModInitializer


object SciFyClient : ClientModInitializer {
    override fun onInitializeClient() {
        // Runs the Hotkey().hotkeys() function which contains all keybindings.
        Hotkey().hotkeys()
    }
}
