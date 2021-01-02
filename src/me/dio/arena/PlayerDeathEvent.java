package me.dio.arena;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PlayerDeathEvent implements Listener {

    @EventHandler
    public static void onPlayerDeath(org.bukkit.event.entity.PlayerDeathEvent e) {

        if (e.getEntity() != null) {
            Player player = e.getEntity();
            if (Arena.getPlugin().getKitted().contains(player))
                Arena.getPlugin().getKitted().remove(player);

            List<ItemStack> drops = e.getDrops();

            ListIterator<ItemStack> litr = drops.listIterator();

            while( litr.hasNext() )
            {
                ItemStack stack = litr.next();
                litr.remove();
                //if( stack.getType().equals( Material.WOOD_AXE ) || stack.getType().equals( Material.WOOD_PICKAXE ) || stack.getType().equals( Material.WOOD_SWORD ) || stack.getType().equals( Material.LEATHER_HELMET ) || stack.getType().equals( Material.LEATHER_CHESTPLATE ) || stack.getType().equals( Material.LEATHER_LEGGINGS )|| stack.getType().equals( Material.LEATHER_BOOTS ) )
                {
                }
            }

            //e.getEntity().getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        // Eventually make this say who won
        IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + e.getEntity().getName() + " DIED!" + "\",color:" + ChatColor.DARK_RED.name().toLowerCase() + "}");
        PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
        PacketPlayOutTitle length = new PacketPlayOutTitle(15, 80, 15);
        for (Player player : Bukkit.getOnlinePlayers()) {
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(length);
         }
    }
}
