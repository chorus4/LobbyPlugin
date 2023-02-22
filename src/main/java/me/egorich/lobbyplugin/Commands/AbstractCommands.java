package me.egorich.lobbyplugin.Commands;

import me.egorich.lobbyplugin.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractCommands implements CommandExecutor {

    public AbstractCommands(String name) {
        PluginCommand command = Main.getPlugin().getCommand(name);
        command.setExecutor(this);
    }

    public abstract void execute(CommandSender sender, Command command, String[] args);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        execute(sender, command, args);
        return true;
    }
}
