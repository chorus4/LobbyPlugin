package me.egorich.lobbyplugin.Utils.ScoreboardManager;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;

import javax.annotation.Nullable;

public class ScoreboardManager {
//    private Scoreboard scoreboard;
    private final Player player;
    private final Scoreboard scoreboard;

    public ScoreboardManager(Player player) {
        Scoreboard scoreboard = new Scoreboard("Server", DisplaySlot.SIDEBAR);

        this.player = player;
        this.scoreboard = scoreboard;
    }

    public ScoreboardManager createScore(String name, Integer num) {
        Score score = scoreboard.getObjective().getScore(name);
        score.setScore(num);

        return this;
    }
    public ScoreboardManager updateScore(String name, Integer num) {
        Score score = scoreboard.getObjective().getScore(name);
        score.setScore(num);

        return this;
    }

    public ScoreboardManager setStats() {
        createScore(" ", 1);
        createScore(ChatColor.YELLOW + "Ваш ник: " + player.getName(), 1);
        createScore(ChatColor.YELLOW + "Ваш опыт: " + player.getExp(), 1);

        return this;
    }

    public void show() {
        player.setScoreboard(scoreboard.getScoreboard());
    }
}
