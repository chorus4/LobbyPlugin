package me.egorich.lobbyplugin.Commands.ServerCommands;

import me.egorich.lobbyplugin.Commands.AbstractCommand;
import me.egorich.lobbyplugin.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ShutdownCommand extends AbstractCommand {
    public ShutdownCommand() {
        super("shutdown");
    }


    @Override
    public boolean execute(CommandSender sender, Command command, String[] args) {
        Main.getPlugin().getServer().shutdown();
        return true;
    }
}
