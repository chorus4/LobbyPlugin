package me.egorich.lobbyplugin.Events;

import me.egorich.lobbyplugin.Events.PlayerEvents.ConnectEvent;
import me.egorich.lobbyplugin.Main;
import org.bukkit.Bukkit;

public class EventRegister {
    public EventRegister() {
        Main plugin = Main.getPlugin();

        Bukkit.getPluginManager().registerEvents(new ConnectEvent(), plugin);
    }
}
