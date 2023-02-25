package me.egorich.lobbyplugin.Utils.MenuManager;

import me.egorich.lobbyplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MenuManager {

    private static final Map<UUID, Inventory> menus = new HashMap<>();
    private static final Map<UUID, OnCLick> onClickCall = new HashMap<>();
    private static final Map<UUID, OnOpen> onOpenCall = new HashMap<>();
    private static final Map<UUID, OnClose> onCloseCall = new HashMap<>();

    public MenuManager() {
        Main plugin = Main.getPlugin();

        Bukkit.getPluginManager().registerEvents(new EventListener(), plugin);
    }

    public static UUID createMenu(String name, Integer size, Map<ItemStack, Integer> slots, ItemStack emptySlot) {
        UUID uuid = UUID.randomUUID();

        Inventory menu = Bukkit.createInventory(null, size, name);

        if (emptySlot != null) {
            for (int i = 0; i < size; i++) {
                menu.setItem(i, emptySlot);
            }
        }

        for (ItemStack slot: slots.keySet()) {
            menu.setItem(slots.get(slot), slot);
        }

        menus.put(uuid, menu);

        return uuid;
    }

    public static void addListeners(UUID uuid, OnCLick onClick, OnOpen onOpen, OnClose onClose) {
        if (onClick != null) onClickCall.put(uuid, onClick);
        if (onOpen != null) onOpenCall.put(uuid, onOpen);
        if (onClose != null) onCloseCall.put(uuid, onClose);
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

        if (callback == null) return;

        callback.onClick(player);
    }
    public static void onEvent(InventoryOpenEvent e) {
        Inventory menu = e.getInventory();
        Player player = (Player) e.getPlayer();
        UUID uuid = null;

        for (UUID uuids: menus.keySet()) {
            if (menus.get(uuids) == menu) {
                uuid = uuids;
            }
        }

        if (uuid == null) return;

        OnOpen callback = onOpenCall.get(uuid);

        if (callback == null) return;

        callback.onOpen(player);
    }
    public static void onEvent(InventoryCloseEvent e) {
        Inventory menu = e.getInventory();
        Player player = (Player) e.getPlayer();
        UUID uuid = null;

        for (UUID uuids: menus.keySet()) {
            if (menus.get(uuids) == menu) {
                uuid = uuids;
            }
        }

        if (uuid == null) return;

        OnClose callback = onCloseCall.get(uuid);

        if (callback == null) return;

        callback.onClose(player);
    }

    public static Inventory getMenu(UUID uuid) {
        return menus.get(uuid);
    }

    public static void updateMenu(UUID uuid, Map<ItemStack, Integer> slots) {
        Inventory menu = getMenu(uuid);

        for (ItemStack slot: slots.keySet()) {
            menu.setItem(slots.get(slot), slot);
        }
    }

    public static Map<UUID, Inventory> getMenus() {
        return menus;
    }
    public interface OnCLick { public void onClick(Player player); }
    public interface OnOpen { public void onOpen(Player player); }
    public interface OnClose { public void onClose(Player player); }
}
