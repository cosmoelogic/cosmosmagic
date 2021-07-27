package com.aztro.aztrosmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.TntEntity;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

public class aztrosmodclient implements ClientModInitializer {
    private static KeyBinding keyBinding;
    // The KeyBinding declaration and registration are commonly executed here statically

    @Override
    public void onInitializeClient() {
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.examplemod.spook", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_R, // The keycode of the key
                "category.examplemod.test" // The translation key of the keybinding's category.
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                try {
                    client.player.sendMessage(new LiteralText("Key 1 was pressed!"), false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}