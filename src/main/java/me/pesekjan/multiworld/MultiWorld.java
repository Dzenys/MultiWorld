package me.pesekjan.multiworld;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;


public class MultiWorld extends JavaPlugin {

    private static MultiWorld plugin;

    public static MultiWorld getPlugin() {
        return plugin;
    }

    public static final List<String> WORLD_LIST = new ArrayList<>();

    @Override
    public void onEnable() {
        plugin = this;
        getCommand("cw").setExecutor(new Command());
        getServer().getPluginManager().registerEvents(new ClickEvents(), this);
        saveDefaultConfig();
        Config.load();
    }

    public void onDisable() {
        Config.save();

    }
}

