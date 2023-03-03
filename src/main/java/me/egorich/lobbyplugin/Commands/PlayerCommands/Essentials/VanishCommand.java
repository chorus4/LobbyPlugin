package me.egorich.lobbyplugin.Commands.PlayerCommands.Essentials;

import me.egorich.lobbyplugin.Commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class VanishCommand extends AbstractCommand {

    public static List<Player> vanishPlayers = new ArrayList<>();

    public VanishCommand() {
        super("vanish");
    }

    @Override
    public boolean execute(CommandSender sender, Command command, String[] args) {
        Player player = (Player) sender;

        if (!player.hasPermission("essentials.vanish")) {
            player.sendMessage("У вас нет прав на использование этой команды!");
            return true;
        }

        if (vanishPlayers.contains(player)) {
            for (Player people: Bukkit.getOnlinePlayers()) {
                people.showPlayer(player);
                player.sendMessage(ChatColor.YELLOW + "Вас теперь видят!");
            }
        } else {
            for (Player people: Bukkit.getOnlinePlayers()) {
               people.hidePlayer(player);
               player.sendMessage("Вы теперь невидимы!");
            }
        }

        return true;
    }
}
