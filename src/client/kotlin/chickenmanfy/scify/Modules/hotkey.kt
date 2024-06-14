package chickenmanfy.scify.Modules

import io.netty.buffer.ByteBuf
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import net.minecraft.network.PacketByteBuf
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket
import net.minecraft.text.Text
import org.lwjgl.glfw.GLFW


class hotkey {
    fun hotkeys() {

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
        ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick { client: MinecraftClient ->
            while (warp.wasPressed()) {
                MinecraftClient.getInstance().networkHandler!!.sendChatCommand("warp")
            }
            while (enderchest.wasPressed()) {
                MinecraftClient.getInstance().networkHandler!!.sendChatCommand("ec")
            }
            while (guide.wasPressed()) {
                MinecraftClient.getInstance().networkHandler!!.sendChatCommand("guide")
            }

        })

    }
}