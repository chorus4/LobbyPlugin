package me.egorich.lobbyplugin.Commands.ServerCommands;

import me.egorich.lobbyplugin.Commands.AbstractCommands;
import me.egorich.lobbyplugin.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ShutdownCommand extends AbstractCommands {
    public ShutdownCommand() {
        super("shutdown");
    }


    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        Main.getPlugin().getServer().shutdown();
    }
}
