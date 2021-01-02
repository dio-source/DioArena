package me.dio.arena;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Vanilla implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

                ItemStack ihelmet = new ItemStack(Material.IRON_HELMET);
                ItemStack ichest = new ItemStack(Material.IRON_CHESTPLATE);
                ItemStack ilegg = new ItemStack(Material.IRON_LEGGINGS);
                ItemStack iboot = new ItemStack(Material.IRON_BOOTS);
                ItemStack steak = new ItemStack(Material.COOKED_BEEF, 8);
                ItemStack abow = new ItemStack(Material.BOW);
                ItemStack aarrow = new ItemStack(Material.ARROW, 16);
                ItemStack ssword = new ItemStack(Material.STONE_SWORD);

                p.getInventory().addItem(ihelmet, ichest, ilegg, iboot, ssword, abow, aarrow, steak);

            }
        return true;
    }

}
