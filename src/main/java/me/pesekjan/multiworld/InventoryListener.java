package me.pesekjan.multiworld;

import me.pesekjan.multiworld.guis.WorldTypeGui;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryListener implements org.bukkit.command.CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!(sender instanceof Player))
            return true;

        Player player = ((Player) sender);

        if (args.length == 0)
            return true;


        if (args[0].equals("create")) {
            if (args.length != 2) {
                player.sendMessage(ChatColor.RED + "Nezvolil jsi jmeno pro svuj svet");
                return true;
            }

            for (int i = 0; i < MultiWorld.WORLD_LIST.size(); i++) {
                if (MultiWorld.WORLD_LIST.get(i).equals(args[1])){
                    player.sendMessage(ChatColor.RED + "Tento svet uz existuje");
                    return true;
                }
            }

            if (!args[1].matches("[a-zA-Z0-9]*")) {
                player.sendMessage(ChatColor.RED + "Pouzivas nepovolene znaky");
                return true;
            }
            WorldOptionList.WORLD_OPTION_LIST_MAP.put(player, new WorldOptionList());
            WorldOptionList.WORLD_OPTION_LIST_MAP.get(player).owner = player.getName();
            WorldOptionList.WORLD_OPTION_LIST_MAP.get(player).name = args[1];
            player.openInventory(WorldTypeGui.gui1());
            return true;
        }
        else if (args[0].equals("tp")) {
            if (args.length != 2) {
                player.sendMessage(ChatColor.RED + "Nenapsal jsi jmeno sveta, kam se chces teleportovat");
                return true;
            }
            for (int i = 0; i < MultiWorld.WORLD_LIST.size(); i++) {
                World world = player.getServer().getWorld(args[1]);
                if (!MultiWorld.WORLD_LIST.get(i).equals(args[1]) || world == null){
                    player.sendMessage(ChatColor.RED + "Tento svet nexistuje");
                    return true;

                }
                Location loc = new Location(player.getServer().getWorld(args[1]), world.getSpawnLocation().getX(), world.getSpawnLocation().getY(), world.getSpawnLocation().getZ());
                player.teleport(loc);
        return true;
    }
}
        else if (args[0].equals("list")) {
            if (args.length != 1)
                return true;
            player.sendMessage(ChatColor.DARK_GRAY + "Existujici svety");
            for (int i = 0; i < MultiWorld.WORLD_LIST.size(); i++) {
                player.sendMessage(ChatColor.RED + MultiWorld.WORLD_LIST.get(i));
            }

            }
    return true;
    }
}


