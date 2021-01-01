package me.dio.arena;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Archer implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

                ItemStack lhelmet = new ItemStack(Material.LEATHER_HELMET);
                ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack llegg = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack lboot = new ItemStack(Material.LEATHER_BOOTS);
                ItemStack arrow = new ItemStack(Material.ARROW, 1);
                ItemStack bow = new ItemStack(Material.BOW);
                bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);

                p.getInventory().addItem(lhelmet, lchest, llegg, lboot, bow, arrow);

            }
        return true;
    }
}