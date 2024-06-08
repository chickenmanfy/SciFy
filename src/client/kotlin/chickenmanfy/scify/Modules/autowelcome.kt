package chickenmanfy.scify.Modules

import net.minecraft.client.MinecraftClient
import net.minecraft.text.Text

fun autowelcome() {
    val minecraftClient = MinecraftClient.getInstance()
    val message: Text = Text.literal("Hi!")
    if (minecraftClient?.player != null) {
        minecraftClient.player!!.sendMessage(message, false)
    } else {
        println("MinecraftClient or player is null!")
    }
}