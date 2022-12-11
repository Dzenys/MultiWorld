package me.pesekjan.multiworld;

import me.pesekjan.multiworld.guis.WorldTypeGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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

            if (!args[1].matches("[a-zA-Z0-9]*")) {
                player.sendMessage(ChatColor.RED + "Pouzivas nepovolene znaky");
                return true;
            }
            player.openInventory(WorldTypeGui.gui1());
            return true;
        }

        return true;
    }
}
