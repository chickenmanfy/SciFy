package chickenmanfy.scify.modules

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import org.lwjgl.glfw.GLFW


class Hotkey {
    fun hotkeys() {

        val debugUser = "Chickenmanfy"

        // Register Keys
        val warp = KeyBindingHelper.registerKeyBinding(
            KeyBinding(
                "Open Warp Menu (/warp)",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_V,
                "SciFy"
            )
        )
        val enderchest = KeyBindingHelper.registerKeyBinding(
            KeyBinding(
                "Open Ender Chest (/ec)",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_Z,
                "SciFy"
            )
        )
        val guide = KeyBindingHelper.registerKeyBinding(
            KeyBinding(
                "Open Guide Book (/guide)",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_SEMICOLON,
                "SciFy"
            )
        )
        // Open Menu Hotkey
        val menu = KeyBindingHelper.registerKeyBinding(
            KeyBinding(
                "Menu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "SciFy"
            )
        )

        // Debug
        val debug = KeyBindingHelper.registerKeyBinding(
            KeyBinding(
                "Debug",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_MINUS,
                "SciFy"
            )
        )
        ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick {
            while (warp.wasPressed()) {
                if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "dungeonfy.minehut.gg" ||
                    MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599" ||
                    MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "minehut.com" ||  // if you join minehut.com and type /join dungeonfy
                    MinecraftClient.getInstance().player?.name?.string == debugUser) // Test override
                {
                    MinecraftClient.getInstance().networkHandler!!.sendChatCommand("warp")
                }

            }
            while (enderchest.wasPressed()) {
                if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "dungeonfy.minehut.gg" ||
                    MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599" ||
                    MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "minehut.com" ||  // if you join minehut.com and type /join dungeonfy
                    MinecraftClient.getInstance().player?.name?.string == debugUser) // Test override
                {
                    MinecraftClient.getInstance().networkHandler!!.sendChatCommand("ec")
                }
            }
            while (guide.wasPressed()) {
                if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "dungeonfy.minehut.gg" ||
                    MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599" ||
                    MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "minehut.com" ||  // if you join minehut.com and type /join dungeonfy
                    MinecraftClient.getInstance().player?.name?.string == debugUser) // Test override
                {
                    MinecraftClient.getInstance().networkHandler!!.sendChatCommand("guide")
                }
            }
            while (menu.wasPressed()) {
                if (MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "dungeonfy.minehut.gg" ||
                    MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "51.222.121.148:25599" ||
                    MinecraftClient.getInstance().networkHandler?.serverInfo?.address == "minehut.com" ||  // if you join minehut.com and type /join dungeonfy
                    MinecraftClient.getInstance().player?.name?.string == debugUser) // Test override
                {
                    MinecraftClient.getInstance().setScreen(Menu())
                }
            }
            while (debug.wasPressed()) {
                println(MinecraftClient.getInstance().networkHandler?.serverInfo?.address)
                println(MinecraftClient.getInstance().player?.name?.string)
            }

        })

    }
}