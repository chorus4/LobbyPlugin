package me.egorich.lobbyplugin.Utils.TabManager;

import me.egorich.lobbyplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TabAnimation {
    private final TabManager manager = new TabManager();

    public void start() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getPlugin(),  () -> {
            for (Player player: Bukkit.getOnlinePlayers()) {
                manager.update(player);
            }
        }, 0, 1);
    }
}
