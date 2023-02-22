package me.egorich.lobbyplugin.Utils.TabManager;

import me.egorich.lobbyplugin.Utils.ColorUtils.ColorUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabManager {

    private List<String> header = new ArrayList<>();
    private List<String> footer = new ArrayList<>();

    public void update(Player player) {
        player.sendPlayerListHeader(
                Component.text(
                        ColorUtils.convert(
                                convert(header)
                        )
                )
        );

        player.sendPlayerListFooter(
                Component.text(
                        ColorUtils.convert(
                                convert(footer)
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
