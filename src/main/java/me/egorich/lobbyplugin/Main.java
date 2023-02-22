package me.egorich.lobbyplugin;

import me.egorich.lobbyplugin.Commands.InitCommands;
import me.egorich.lobbyplugin.Events.EventRegister;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;


        new InitCommands();
        new EventRegister();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getPlugin() {
        return plugin;
    }
}
