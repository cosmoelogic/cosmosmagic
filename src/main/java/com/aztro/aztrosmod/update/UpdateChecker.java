package com.aztro.aztrosmod.update;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class UpdateChecker {
    private final static String current = "0.9.1";
    public static void checkForUpdates() {
        try {
            String sURL = "https://raw.githubusercontent.com/aztro-is-not-available/aztrosmod-info/main/updater-info.json"; //just a string

            // Connect to the URL using java's native library
            URL url = new URL(sURL);
            URLConnection request = url.openConnection();
            request.connect();

            // Convert to a JSON object to print data
            JsonParser jp = new JsonParser(); //from gson
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
            String versions = rootobj.get("versions").getAsString();
            if (versions.contains("1.17")) {
                String latest = rootobj.get("latest").getAsString();
                System.out.println("Latest version: " + latest);
                if (!current.equals(latest)) {
                    System.out.println("\033[0;31m" + "You are using outdated version: " + current);
                    //MinecraftClient.getInstance().openScreen(new UpdateScreen(new UpdateGui()));
                } else {
                    System.out.println("You're all up to date!");
                }
            } else {
                System.out.println("This version of Minecraft is no longer receiving updates from this mod.");
            }
        } catch(Exception e) {
            System.out.println("Unable to grab user and latest versions, error is as follows: ");
            System.out.println("\033[0;31m" + e.getMessage());
        }
    }
}
