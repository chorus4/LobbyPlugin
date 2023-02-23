package me.egorich.lobbyplugin.Events.PlayerEvents;

import me.egorich.lobbyplugin.Utils.ScoreboardManager.Scoreboard;
import me.egorich.lobbyplugin.Utils.ScoreboardManager.ScoreboardManager;
import me.egorich.lobbyplugin.Utils.TabManager.TabAnimation;
import me.egorich.lobbyplugin.Utils.TabManager.TabManager;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;

import java.util.Objects;

public class ConnectEvent implements Listener {
    @EventHandler
    public void onConnect(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        e.joinMessage(Component.text(""));

        player.sendTitle(ChatColor.GREEN + "Добро пожаловать на наш сервер",  ChatColor.GRAY + "Ваш ник: " + player.getName());

        new ScoreboardManager(player)
                .setStats()
                .show();
    }
}
