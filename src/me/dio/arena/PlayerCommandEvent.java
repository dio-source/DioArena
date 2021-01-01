package me.dio.arena;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandEvent implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        String message = e.getMessage();
        try {
            if (message.toLowerCase().equals("/archer")) {

            if (Arena.getPlugin().getKitted().contains(e.getPlayer())) {
                e.getPlayer().sendMessage("no");
                e.setCancelled(true);
            } else {
                Arena.getPlugin().getKitted().add(e.getPlayer());
            }
        }
    } catch (Exception exception) {}
}

}
