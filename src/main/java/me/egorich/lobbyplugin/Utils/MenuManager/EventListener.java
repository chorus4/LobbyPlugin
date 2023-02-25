package me.egorich.lobbyplugin.Utils.MenuManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class EventListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        MenuManager.onEvent(e);
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) { MenuManager.onEvent(e); }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) { MenuManager.onEvent(e); }
}
