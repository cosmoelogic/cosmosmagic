package net.cosmo.cosmosmagic;

import net.cosmo.cosmosmagic.fluid.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.option.KeyBinding;


public class cosmosmagicclient implements ClientModInitializer {
	private static KeyBinding keyBinding;
	// The KeyBinding declaration and registration are commonly executed here statically

	@Override
	public void onInitializeClient() {
		ModFluids.renderFluids();
		//this is for reference, don't delete it.

//        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
//                "key.examplemod.spook", // The translation key of the keybinding's name
//                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
//                GLFW.GLFW_KEY_R, // The keycode of the key
//                "category.examplemod.test" // The translation key of the keybinding's category.
//        ));
//
//        ClientTickEvents.END_CLIENT_TICK.register(client -> {
//            while (keyBinding.wasPressed()) {
//                try {
//                    client.player.sendMessage(new LiteralText("Key 1 was pressed!"), false);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
	}
}