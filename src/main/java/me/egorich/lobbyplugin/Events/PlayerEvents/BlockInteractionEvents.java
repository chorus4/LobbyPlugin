package me.egorich.lobbyplugin.Events.PlayerEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockInteractionEvents implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();

        if (!player.hasPermission("server.builder")) {
            player.sendMessage("Ты не можешь ломать блоки здесь! \uD83D\uDE25");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();

        if (!player.hasPermission("server.builder")) {
            player.sendMessage("Ты не можешь ставить блоки здесь! \uD83D\uDE25");
            e.setCancelled(true);
        }
    }
}
