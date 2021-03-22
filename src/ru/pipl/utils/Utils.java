package ru.pipl.utils;

import org.bukkit.ChatColor;

public class Utils {
    public static String parseColor(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}