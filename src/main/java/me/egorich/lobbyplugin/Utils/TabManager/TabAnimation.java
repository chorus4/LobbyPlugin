package me.egorich.lobbyplugin.Utils.TabManager;

import me.egorich.lobbyplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TabAnimation {
    public void start(TabManager manager) {
        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getPlugin(),  () -> {
            for (Player player: Bukkit.getOnlinePlayers()) {
                manager.update(player);
            }
        }, 0, 1);
    }

    public void start(TabManager manager, TabManager admManager) {
        for (Player player: Bukkit.getOnlinePlayers()) {
            manager.update(player);
            if (player.isOp()) {
                admManager.update(player);
            }
        }
    }
}
