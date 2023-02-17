package me.egorich.lobbyplugin.Events.PlayerEvents;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ConnectEvent implements Listener {
    @EventHandler
    public void onConnect(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        e.joinMessage(Component.text(""));

        player.sendTitle("Добро пожаловать на наш сервер", "Ваш ник: " + player.getName());
    }
}
