package chickenmanfy.scify.mixin.client;


import chickenmanfy.scify.BridgeMixins;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.text.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mixin(InGameHud.class)
public class ActionBarMixin {
    @Unique
    public int finale;

    @Inject(at = @At("HEAD"), method = "setOverlayMessage(Lnet/minecraft/text/Text;Z)V")
	public void sendMessage(Text message, boolean tinted, CallbackInfo info) {
        String actionBar = message.getString();

        int num0 = 0;
        int num1 = 0;

        // Fancy Regex
        Pattern pattern = Pattern.compile("\\[(\\d+)/(\\d+)]");
        Matcher matcher = pattern.matcher(actionBar);

        int count = 0;
        while (matcher.find() && count < 2) {
            int firstNumber = Integer.parseInt(matcher.group(1));
            int secondNumber = Integer.parseInt(matcher.group(2));

            float divided = (float) secondNumber / 20;

            finale = Math.round((float) firstNumber/divided);

            if (count == 0) {
                num0 = finale;
            } else {
                num1 = finale;
            }

            BridgeMixins.INSTANCE.setNum0(num0);
            BridgeMixins.INSTANCE.setNum1(num1);


            count++;
        }
    }
}