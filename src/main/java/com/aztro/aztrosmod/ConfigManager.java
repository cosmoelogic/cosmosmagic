package com.aztro.aztrosmod;

public class ConfigManager {
    public static void Manage() {
        if ("Windows".equals(System.getProperty("os.name"))) {
            System.out.println(System.getenv("APPDATA"));
        } else {
            System.out.println(System.getProperty("user.home"));
        }
    }
}
