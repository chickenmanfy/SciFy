package chickenmanfy.scify

import chickenmanfy.scify.Modules.Menu
import chickenmanfy.scify.Modules.Hotkey
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import org.lwjgl.glfw.GLFW



object SciFyClient : ClientModInitializer {
    override fun onInitializeClient() {
        Hotkey().hotkeys()
        // Open Menu Hotkey
        val menu = KeyBindingHelper.registerKeyBinding(
            KeyBinding(
                "Menu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "SciFy"
            )
        )


        ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick {
            while (menu.wasPressed()) {
                MinecraftClient.getInstance().setScreen(Menu())
            }
        })
    }
}
