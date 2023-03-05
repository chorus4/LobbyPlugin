package me.egorich.lobbyplugin.Menus;

import me.clip.placeholderapi.PlaceholderAPI;
import me.egorich.lobbyplugin.Utils.MenuManager.MenuManager;
import me.egorich.lobbyplugin.Utils.Pinger.Pinger;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.*;

public class ServerChoiseMenu {

    private UUID menu;
    public ServerChoiseMenu() {
        menu = MenuManager.createMenu("Выбор сервера", 54, "serverchoise", getItems(), new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        Inventory inventory = MenuManager.getMenu(menu);

        MenuManager.OnCLick onClick = new MenuManager.OnCLick() {
            @Override
            public void onClick(InventoryClickEvent event) {
                event.setCancelled(true);
            }
        };

        MenuManager.addListeners(menu, onClick, null, null);
    }

    private Map<ItemStack, Integer> getItems() {
        Map<ItemStack, Integer> items = new HashMap<>();

        ItemStack standart = new ItemStack(Material.DEEPSLATE_DIAMOND_ORE);
        ItemMeta standartMeta = standart.getItemMeta();

        standartMeta.displayName(Component.text(""));
        List<Component> standartLore = new ArrayList<>();

        standartLore.add(Component.text(ChatColor.AQUA + "          Стандартное выживание"));
        standartLore.add(Component.text(""));

        standartLore.add(Component.text(ChatColor.BLUE + "  Стандартное выживание с приватами  "));
        standartLore.add(Component.text(ChatColor.BLUE + "        и рандомной телепортацией!        "));

        standartLore.add(Component.text(""));
        standartLore.add(Component.text(ChatColor.GREEN +  "               Заходи тут весело!"));

        standartLore.add(Component.text(""));

        String ping_responce = PlaceholderAPI.setPlaceholders((Player) Bukkit.getOnlinePlayers().toArray()[0], "%pinger_online_localhost:25568%");

        boolean isOnline = ping_responce.contains("Online");

        standartLore.add(Component.text( ChatColor.YELLOW + "       Статус: " + (isOnline ? ChatColor.GREEN + "Онлайн" : ChatColor.RED + "Оффлайн")));

        standartLore.add(Component.text(""));

        standartMeta.lore(standartLore);
        standart.setItemMeta(standartMeta);

        items.put(standart, 11);

        return items;
    }

    public UUID getMenu() {
        return menu;
    }
}
