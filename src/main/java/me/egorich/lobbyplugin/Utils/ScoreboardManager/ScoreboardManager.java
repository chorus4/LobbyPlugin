package me.egorich.lobbyplugin.Utils.ScoreboardManager;

import me.egorich.lobbyplugin.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

import javax.annotation.Nullable;

public class ScoreboardManager {
//    private Scoreboard scoreboard;
    private final Player player;
    private final Scoreboard scoreboard;
    private final Objective objective ;

    public ScoreboardManager(Player player) {
        Scoreboard scoreboard = new Scoreboard();

        scoreboard.createObj("Server", DisplaySlot.SIDEBAR);

        this.player = player;
        this.scoreboard = scoreboard;
        this.objective = scoreboard.getScoreboard().getObjective(DisplaySlot.SIDEBAR);

        Objective healthobj = scoreboard.createObj("Health", DisplaySlot.BELOW_NAME);

        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getPlugin(), () -> {
            for (Player playerF : Bukkit.getOnlinePlayers()) {
                healthobj.getScoreFor(((Entity) playerF)).setScore((int) playerF.getHealth());
            }
        }, 0, 10);
    }

    public ScoreboardManager createScore(String name, Integer num, Objective objective) {
        Score score = objective.getScore(name);
        score.setScore(num);

        return this;
    }
    public ScoreboardManager updateScore(String name, Integer num, Objective objective) {
        Score score = objective.getScore(name);
        score.setScore(num);

        return this;
    }

    public ScoreboardManager setStats() {
        createScore(" ", 1, objective);
        createScore(ChatColor.YELLOW + "Ваш ник: " + player.getName(), 1, objective);
        createScore(ChatColor.YELLOW + "Ваш опыт: " + player.getExp(), 1, objective);

        return this;
    }

    public void show() {
        player.setScoreboard(scoreboard.getScoreboard());
    }
}
