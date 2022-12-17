package me.pesekjan.multiworld;

import me.pesekjan.multiworld.guis.WorldTypeGui;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class Command implements org.bukkit.command.CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String s, String[] args) {

        if (!(sender instanceof Player))
            return true;

        Player player = ((Player) sender);

        if (args.length == 0) {
            player.sendMessage(ChatColor.GRAY + "===== Dostupne prikazy =====");
            player.sendMessage(ChatColor.RED + "/cw create <nazev>" + ChatColor.YELLOW + " - vytvori novy svet");
            player.sendMessage(ChatColor.RED + "/cw tp <nazev>" + ChatColor.YELLOW + " - pripoji te do zvoleneho sveta");
            player.sendMessage(ChatColor.RED + "/cw list" + ChatColor.YELLOW + " - vypise seznam svetu");
            player.sendMessage(ChatColor.RED + "/cw delete <nazev>" + ChatColor.YELLOW + " - smaze svet");
            return true;
        }


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
            World world = player.getServer().getWorld(args[1]);
            if (world == null) {
                player.sendMessage(ChatColor.RED + "Tento svet neexistuje");
                return true;
            }
            Location loc = new Location(world, world.getSpawnLocation().getX(), world.getSpawnLocation().getY(), world.getSpawnLocation().getZ());
            player.teleport(loc);
            return true;
        }
        else if (args[0].equals("list")) {
            if (args.length != 1)
                return true;
            player.sendMessage(ChatColor.DARK_GRAY + "Existujici svety");
            for (int i = 0; i < MultiWorld.WORLD_LIST.size(); i++) {
                player.sendMessage(ChatColor.RED + MultiWorld.WORLD_LIST.get(i));
            }
        }

        else if (args[0].equals("delete")) {
            if (args.length != 2) {
                player.sendMessage(ChatColor.RED + "Nezvolil jsi jmeno svet, ktery chces odstranit");
                return true;
            }

            World world = player.getServer().getWorld(args[1]);
            if (world == null) {
                player.sendMessage(ChatColor.RED + "Tento svet neexistuje");
                return true;
            }
            World defaultWorld = Bukkit.getWorlds().get(0);
            if (Bukkit.getWorlds().size() == 1){
                player.sendMessage(ChatColor.RED + "Nemuzes smazat vsechny svety");
                return true;
            }
            if(defaultWorld == world){
                player.sendMessage(ChatColor.RED + "Nemuzes smazat defaultni svet");
                return true;
            }

            for(Player playerInWorld : world.getPlayers()) {
                playerInWorld.teleport(defaultWorld.getSpawnLocation());
            }
            Bukkit.unloadWorld(world, false);
            deleteDirectory(world.getWorldFolder());
            player.sendMessage(ChatColor.RED + "Svet byl smazan a hraci teleportovani do defaultniho sveta");
            MultiWorld.WORLD_LIST.remove(args[1]);


        }


        return true;
    }
    boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}


