package me.dio.arena;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class Arena extends JavaPlugin {

    public static Arena plugin;

    public static Arena getPlugin() {
        return plugin;
    }

    ArrayList<Player> kitted = new ArrayList<Player>();

    public ArrayList<Player> getKitted() {
        return this.kitted;
    }

    //public static HM hashmap;

    @Override
    public void onEnable() {
        this.getCommand("archer").setExecutor(new Archer());
        plugin = this;
        getServer().getPluginManager().registerEvents((Listener)new PlayerCommandEvent(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new PlayerDeathEvent(), (Plugin)this);
       // hashmap = new HM();
    }
    @Override
    public void onDisable() {
    }
}