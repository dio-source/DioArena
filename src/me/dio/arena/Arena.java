package me.dio.arena;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;

public class Arena extends JavaPlugin {

    public static Arena plugin;

        public static Arena getPlugin() {
            return plugin;
        }

    ArrayList<Player> kitted = new ArrayList<Player>();

    public ArrayList<Player> getKitted() {
        return this.kitted;
    }

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents((Listener)new PlayerCommandEvent(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new PlayerDeathEvent(), (Plugin)this);
        this.getCommand("archer").setExecutor(new Archer());{ }
        this.getCommand("vanilla").setExecutor(new Vanilla());
    }

    @Override
    public void onDisable() {
    }
}