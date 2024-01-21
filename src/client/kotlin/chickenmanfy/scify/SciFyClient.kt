package chickenmanfy.scify

import io.github.prospector.modmenu.api.ConfigScreenFactory
import io.github.prospector.modmenu.api.ModMenuApi
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import net.minecraft.text.Text
import org.lwjgl.glfw.GLFW
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.client.util.math.MatrixStack


object SciFyClient : ClientModInitializer {
	override fun onInitializeClient() {
		
		val menu = KeyBindingHelper.registerKeyBinding(
			KeyBinding(
				"Menu",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_RIGHT_SHIFT,
				"SciFy"
			)
		)
		ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick { client: MinecraftClient ->
			while (menu.wasPressed()) {
				// Debug
				client.player!!.sendMessage(Text.literal("Button input received."), true)

			}
		})
	}
}

@Environment(EnvType.CLIENT)
class ScifyModMenu : ModMenuApi {
	override fun getModConfigScreenFactory(): ConfigScreenFactory<*> {
		return ConfigScreenFactory<*> { parent -> menu(parent) }
	}
}


@Environment(EnvType.CLIENT)
class menu(private val parent: Screen) : Screen(Text.literal("Your Mod Config")) {
	override fun init() {
		// Add a button to open Mod Menu
		val modMenuButton = ButtonWidget.builder(
			Text.literal("Mod Menu")
		) { button: ButtonWidget? ->
			// Open Mod Menu
			ModMenu.getInstance().openConfigScreen()
		}
			.dimensions(width / 2 - 100, height / 2, 200, 20)
			.build()

		addDrawableChild(modMenuButton)
	}

	override fun render(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float) {
		renderBackground(matrices)
		super.render(matrices, mouseX, mouseY, delta)
	}

	fun onClose() {
		client!!.setScreen(parent)
	}
}