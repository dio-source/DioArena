package me.dio.arena;

import org.bukkit.plugin.java.JavaPlugin;

public class Arena extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Event(), this);
        this.getCommand("archer").setExecutor(new Archer());
        CM.setupCooldown();
    }
    @Override
    public void onDisable() {
    }
}