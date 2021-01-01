package me.dio.arena;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerDeathEvent implements Listener {

    @EventHandler
    public static void onPlayerDeath(org.bukkit.event.entity.PlayerDeathEvent e) {

        if (e.getEntity() != null) {
            Player player = e.getEntity();
            if (Arena.getPlugin().getKitted().contains(player))
                Arena.getPlugin().getKitted().remove(player);

            e.getEntity().getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + e.getEntity().getName() + " DIED!" + "\",color:" + ChatColor.DARK_RED.name().toLowerCase() + "}");
        PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
        PacketPlayOutTitle length = new PacketPlayOutTitle(15, 80, 15);
        for (Player player : Bukkit.getOnlinePlayers()) {
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(length);
        }

    }
}
