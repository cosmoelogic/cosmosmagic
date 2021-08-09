package com.aztro.aztrosmod;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UpdateChecker {
    public static void checkForUpdates() throws IOException {
        String sURL = "https://raw.githubusercontent.com/aztro-is-not-available/aztrosmod-info/main/updater-info.json"; //just a string

        // Connect to the URL using java's native library
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();

        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
        JsonObject versionobject = rootobj.getAsJsonObject("1.17");
        String latest = versionobject.get("latest").getAsString();
        System.out.println(latest);
    }
}
