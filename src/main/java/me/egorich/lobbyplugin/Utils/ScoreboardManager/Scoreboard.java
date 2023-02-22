package me.egorich.lobbyplugin.Utils.ScoreboardManager;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

public class Scoreboard {
    private org.bukkit.scoreboard.Scoreboard scoreboard;
    private Objective objective;
    private DisplaySlot slot;

    public Scoreboard(String name, DisplaySlot location) {
        org.bukkit.scoreboard.ScoreboardManager manager = Bukkit.getScoreboardManager();
        org.bukkit.scoreboard.Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("Stats", "dummy");
        objective.displayName(Component.text(name));
        objective.setDisplaySlot(location);

        this.scoreboard = scoreboard;
        this.objective = objective;
        this.slot = location;
    }

    public org.bukkit.scoreboard.Scoreboard getScoreboard() {
        return scoreboard;
    }

    public Objective getObjective() {
        return objective;
    }

    public DisplaySlot getSlot() {
        return slot;
    }
}
