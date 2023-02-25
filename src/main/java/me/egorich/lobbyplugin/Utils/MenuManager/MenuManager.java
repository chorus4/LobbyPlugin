package me.egorich.lobbyplugin.Utils.MenuManager;

import me.egorich.lobbyplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MenuManager {

    private static final Map<UUID, Inventory> menus = new HashMap<>();
    private static final Map<UUID, OnCLick> onClickCall = new HashMap<>();

    public MenuManager() {
        Main plugin = Main.getPlugin();

        Bukkit.getPluginManager().registerEvents(new EventListener(), plugin);
    }

    public static UUID createMenu(String name, Integer size, Map<ItemStack, Integer> slots, OnCLick onClick, ItemStack emptySlot) {
        UUID uuid = UUID.randomUUID();

        Inventory menu = Bukkit.createInventory(null, size, name);

        if (emptySlot != null) {
            for (int i = 1; i < size; i++) {
                menu.setItem(i, emptySlot);
            }
        }

        for (ItemStack slot: slots.keySet()) {
            menu.setItem(slots.get(slot), emptySlot);
        }

        menus.put(uuid, menu);
        onClickCall.put(uuid, onClick);

        return uuid;
    }

    public static void onEvent(InventoryClickEvent e) {
        Inventory menu = e.getInventory();
        Player player = (Player) e.getWhoClicked();
        UUID uuid = null;

        for (UUID uuids: menus.keySet()) {
            if (menus.get(uuids) == menu) {
                uuid = uuids;
            }
        }

        if (uuid == null) return;

        OnCLick callback = onClickCall.get(uuid);

        callback.onClick(player);
    }

    public static Inventory getMenu(UUID uuid) {
        return menus.get(uuid);
    }
    public static void updateMenu(UUID uuid, Inventory menu) {
        menus.replace(uuid, menu);
    }

    public static Map<UUID, Inventory> getMenus() {
        return menus;
    }
    public interface OnCLick { public void onClick(Player player); }
}
