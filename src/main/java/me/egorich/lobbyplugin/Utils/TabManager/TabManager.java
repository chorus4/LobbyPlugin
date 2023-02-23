package me.egorich.lobbyplugin.Utils.TabManager;

import me.clip.placeholderapi.PlaceholderAPI;
import me.egorich.lobbyplugin.Utils.ColorUtils.ColorUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabManager {

    private final List<String> header = new ArrayList<>();
    private final List<String> footer = new ArrayList<>();

    public void update(Player player) {

        List<String> opFooter = new ArrayList<>();

        if (player.isOp()) {
            opFooter.add(" ");
            opFooter.add("&cВы админ");
        }

        player.sendPlayerListHeader(
                Component.text(
                        ColorUtils.convert(
                                convert(
                                        PlaceholderAPI.setPlaceholders(player, header)

                                )
                        )
                )
        );

        player.sendPlayerListFooter(
                Component.text(
                        ColorUtils.convert(
                                convert(
                                        PlaceholderAPI.setPlaceholders(player, footer)
                                ) + convert(
                                        PlaceholderAPI.setPlaceholders(player, opFooter)
                                )
                        )
                )
        );
    }

    private String convert(List<String> list) {
        return String.join("\n", list);
    }

    public void addHeaderLine(String str) {
        header.add(str);
    }

    public void addFooterLine(String str) {
        footer.add(str);
    }

}
