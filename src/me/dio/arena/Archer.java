package me.dio.arena;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
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
                ItemStack steak = new ItemStack(Material.COOKED_BEEF, 8);

                p.getInventory().addItem(lhelmet, lchest, llegg, lboot, bow, arrow, steak);

            }
        return true;
    }
}