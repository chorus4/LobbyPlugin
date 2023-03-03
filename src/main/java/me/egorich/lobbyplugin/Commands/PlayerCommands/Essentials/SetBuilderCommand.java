package me.egorich.lobbyplugin.Commands.PlayerCommands.Essentials;

import me.egorich.lobbyplugin.Commands.AbstractCommand;
import me.egorich.lobbyplugin.Utils.PermissionManager.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetBuilderCommand extends AbstractCommand {
    public SetBuilderCommand() {
        super("setbuilder");
    }

    @Override
    public boolean execute(CommandSender sender, Command command, String[] args) {
        Player player = (Player) sender;

        if (!player.isOp()) {
            player.sendMessage("Вы не можете использовать эту команду!");
            return true;
        }

        if (args.length < 2) {
            player.sendMessage("Неправильные аргументы!");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);


        if (Integer.parseInt(args[1]) == 0) {
            Permissions.remove(target, "server.builder");
        } else {
            Permissions.add(target, "server.builder");
        }

        return true;
    }
}
