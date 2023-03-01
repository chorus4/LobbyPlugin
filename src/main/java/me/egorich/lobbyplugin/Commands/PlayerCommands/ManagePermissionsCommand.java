package me.egorich.lobbyplugin.Commands.PlayerCommands;

import me.egorich.lobbyplugin.Commands.AbstractCommand;
import me.egorich.lobbyplugin.Utils.PermissionManager.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class ManagePermissionsCommand extends AbstractCommand {

    public ManagePermissionsCommand() {
        super("permission");
    }

    @Override
    public boolean execute(CommandSender sender, Command command, String[] args) {
        Player player = (Player) sender;

        if (args.length < 3) {
            player.sendMessage(ChatColor.RED + "Недостаточно аргументов!");
            return false;
        }

        switch (args[0]) {
            case "add":
                Permissions.add(Objects.requireNonNull(Bukkit.getPlayer(args[1])), args[2]);
                break;
            case "remove":
                Permissions.remove(Objects.requireNonNull(Bukkit.getPlayer(args[1])), args[2]);
                break;

            default:
                player.sendMessage(ChatColor.YELLOW + "Неизвестное действие!");
                return false;
        }

        return true;
    }
}
