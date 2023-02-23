package me.egorich.lobbyplugin.Utils.ScoreboardManager;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

import java.util.UUID;

public class Scoreboard {
    private org.bukkit.scoreboard.Scoreboard scoreboard;

    public Scoreboard() {
        org.bukkit.scoreboard.ScoreboardManager manager = Bukkit.getScoreboardManager();

        this.scoreboard = manager.getNewScoreboard();
    }

    public Objective createObj(String name, DisplaySlot location) {
        Objective objective = scoreboard.registerNewObjective(UUID.randomUUID().toString(), "dummy", name);
        objective.setDisplaySlot(location);

        return objective;
    }

    public org.bukkit.scoreboard.Scoreboard getScoreboard() {
        return scoreboard;
    }

}
