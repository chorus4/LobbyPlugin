package me.egorich.lobbyplugin.Utils.ColorUtils;

import org.bukkit.ChatColor;

public class ColorUtils {
    static public String convert(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    static public String convert(String str, ChatColor color) {
        return color + str;
    }
}
