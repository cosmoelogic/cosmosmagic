package com.aztro.aztrosmod.update;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;


import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConfigManager {
    private static String configfolder;
    public static void Manage() throws IOException {
        if (!CheckExistace()) {
            CreateConfig();
        }
    }
    public static boolean CheckExistace() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            configfolder = System.getProperty("user.home") + "\\Appdata\\Roaming\\.minecraft\\config\\";
        } else {
            configfolder = System.getProperty("user.home") + "\\.minecraft\\config\\";
        }
        File f = new File(configfolder + "aztros.json");
        return f.isFile();
    }
    public static void CreateConfig() throws IOException {
        File f = new File(configfolder + "aztros.json");
        f.createNewFile();
        FileWriter fWriter = new FileWriter(f);
        fWriter.write("{'AnnoyMe':true}");
    }
    public static boolean GetConfig() throws IOException {
        Manage();
        File f = new File(configfolder + "aztros.json");
        InputStream is = new FileInputStream(f);
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader(is)); //Convert the input stream to a json element
        JsonObject config = root.getAsJsonObject(); //May be an array, may be an object.
        return config.get("AnnoyMe").getAsBoolean();
    }
}
