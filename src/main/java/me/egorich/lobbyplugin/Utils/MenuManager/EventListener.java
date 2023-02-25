package me.egorich.lobbyplugin.Utils.MenuManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EventListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        MenuManager.onEvent(e);
    }
}
