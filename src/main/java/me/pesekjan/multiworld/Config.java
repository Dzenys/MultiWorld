package me.pesekjan.multiworld;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    public static void load() {
        FileConfiguration config = MultiWorld.getPlugin().getConfig();

        ConfigurationSection section = config.getConfigurationSection("multiworld");
        if(section == null) return;

        for (String name : section.getKeys(false)) {
            String worldName = config.getString("multiworld." + name);
            if(worldName == null) continue;
            MultiWorld.WORLD_LIST.add(worldName);
            new WorldCreator(worldName).createWorld();
        }
    }

    public static void save() {
        FileConfiguration config = MultiWorld.getPlugin().getConfig();

        for (int i = 0; i < MultiWorld.WORLD_LIST.size(); i++) {
            config.set("multiworld." + MultiWorld.WORLD_LIST.get(i), MultiWorld.WORLD_LIST.get(i));
        }
        MultiWorld.getPlugin().saveConfig();
    }
}
