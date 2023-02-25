package me.egorich.lobbyplugin.Events.PlayerEvents;

import me.egorich.lobbyplugin.Main;
import me.egorich.lobbyplugin.Utils.MenuManager.MenuManager;
import me.egorich.lobbyplugin.Utils.ScoreboardManager.Scoreboard;
import me.egorich.lobbyplugin.Utils.ScoreboardManager.ScoreboardManager;
import me.egorich.lobbyplugin.Utils.TabManager.TabAnimation;
import me.egorich.lobbyplugin.Utils.TabManager.TabManager;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class ConnectEvent implements Listener {
    @EventHandler
    public void onConnect(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        e.joinMessage(Component.text(""));

        player.sendTitle(ChatColor.GREEN + "Добро пожаловать на наш сервер",  ChatColor.GRAY + "Ваш ник: " + player.getName());

        new ScoreboardManager(player)
                .setStats()
                .show();

        // Test

        Map<ItemStack, Integer> items = new HashMap<>();

        items.put(
                new ItemStack(Material.ACACIA_BOAT),
                4
        );

        UUID uuid = MenuManager.createMenu(
                "Menushka",
                54,
                items,
                new ItemStack(Material.RED_STAINED_GLASS_PANE)
        );

        player.openInventory(MenuManager.getMenu(uuid));

        MenuManager.addListeners(uuid,
                new MenuManager.OnCLick() {
                    @Override
                    public void onClick(Player player) {
                        player.sendMessage("Clickered");
                        player.closeInventory();
                    }
                }, new MenuManager.OnOpen() {
                    @Override
                    public void onOpen(Player player) {
                        player.sendMessage("Opened");
                    }
                }, new MenuManager.OnClose() {
                    @Override
                    public void onClose(Player player) {
                        player.sendMessage("Closed");
                    }
                });

        new BukkitRunnable() {
            @Override
            public void run() {
                //methods
                Inventory menu = MenuManager.getMenu(uuid);

                menu.setItem(4, new ItemStack(Material.ACACIA_LOG));
            }
        }.runTaskTimer(Main.getPlugin(), 60, 0);
    }

}
