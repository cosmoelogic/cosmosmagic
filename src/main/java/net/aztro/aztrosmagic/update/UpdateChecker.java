package net.aztro.aztrosmagic.update;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.aztro.aztrosmagic.aztrosmagic;
import net.minecraft.MinecraftVersion;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UpdateChecker {
	private static final String MOD_VERSION = aztrosmagic.MOD_VERSION;
	public static void checkForUpdates() {
		try {
			String sURL = "https://raw.githubusercontent.com/aztro-is-not-available/aztrosmod-info/main/updater-info.json"; //just a string

			// Connect to the URL using java's native library
			URL url = new URL(sURL);
			URLConnection request = url.openConnection();
			request.connect();

			JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
			JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
			String versions = rootobj.get("versions").getAsString();
			if (versions.contains(MinecraftVersion.CURRENT.getName())) {
				String latest = rootobj.get("latest").getAsString();
				System.out.printf("Latest version: %s%n", latest);
				if (!MOD_VERSION.equals(latest)) {
					System.out.printf("\033[0;31m" + "You are using outdated version: %s%n", MOD_VERSION);
				} else {
					System.out.println("You're all up to date!");
				}
			} else {
				System.out.println("This version of Minecraft is no longer receiving updates from this mod.");
				System.out.printf("You're using: %s%n", MinecraftVersion.CURRENT.getName());
				System.out.printf("Supported Versions: %s%n", versions);
			}
		} catch(Exception e) {
			System.out.printf("Unable to grab user and latest versions, error is as follows:%n\033[0;31m%s%n", e.getMessage());
		}
	}
}
