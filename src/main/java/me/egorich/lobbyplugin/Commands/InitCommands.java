package me.egorich.lobbyplugin.Commands;

import me.egorich.lobbyplugin.Commands.PlayerCommands.Essentials.SetBuilderCommand;
import me.egorich.lobbyplugin.Commands.PlayerCommands.Essentials.VanishCommand;
import me.egorich.lobbyplugin.Commands.PlayerCommands.ManagePermissionsCommand;
import me.egorich.lobbyplugin.Commands.ServerCommands.ShutdownCommand;

public class InitCommands {
    public InitCommands() {
        new ShutdownCommand();
        new ManagePermissionsCommand();
        new VanishCommand();
        new SetBuilderCommand();
    }
}
