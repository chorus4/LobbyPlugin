package me.egorich.lobbyplugin.Utils.PermissionManager;

import me.egorich.lobbyplugin.Main;
import org.bukkit.entity.Player;

public class Permissions {
    public static void add(Player player, String permission) {
        player.addAttachment(Main.getPlugin(), permission, true);
    }

    public static void remove(Player player, String permission) {
        player.addAttachment(Main.getPlugin(), permission, false);
    }
}
