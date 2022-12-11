package me.pesekjan.multiworld;
import org.bukkit.plugin.java.JavaPlugin;


public class MultiWorld extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("cw").setExecutor(new InventoryListener());

        getServer().getPluginManager().registerEvents(new ClickEvents(), this);
    }

    public void onDisable() {

    }
}

