package me.dio.arena;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandEvent implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        String message = e.getMessage();
        try {
            if (message.equalsIgnoreCase("/archer") | message.equalsIgnoreCase("/vanilla")) {

            if (Arena.getPlugin().getKitted().contains(e.getPlayer())) {
                e.getPlayer().sendMessage(ChatColor.RED.toString() + "Only allowed one kit per life!");
                e.setCancelled(true);
            } else {
                Arena.getPlugin().getKitted().add(e.getPlayer());
            }
        }
    } catch (Exception exception) {}
}

}
