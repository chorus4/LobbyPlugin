package me.egorich.lobbyplugin;

import me.egorich.lobbyplugin.Commands.InitCommands;
import me.egorich.lobbyplugin.Events.EventRegister;
import me.egorich.lobbyplugin.Utils.MenuManager.MenuManager;
import me.egorich.lobbyplugin.Utils.ScoreboardManager.Scoreboard;
import me.egorich.lobbyplugin.Utils.ScoreboardManager.ScoreboardManager;
import me.egorich.lobbyplugin.Utils.TabManager.TabAnimation;
import me.egorich.lobbyplugin.Utils.TabManager.TabManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;

import java.util.HashMap;
import java.util.Map;

public final class Main extends JavaPlugin {

    private static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        new InitCommands();
        new EventRegister();

        TabManager tabManager = new TabManager();

        tabManager.addHeaderLine("      &aПриятной игры!      ");
        tabManager.addHeaderLine(" ");
        tabManager.addHeaderLine("      &eВаш пинг: %player_ping%      ");
        tabManager.addHeaderLine(" ");

        new TabAnimation().start(tabManager);
        new MenuManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getPlugin() {
        return plugin;
    }
}
