package me.pesekjan.multiworld.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WorldTypeGui {

    public static final String SELECTION_GUI = ChatColor.RED + (ChatColor.BOLD + "World Type Selection");


    public static Inventory gui1() {

        int inventorySize = 27;
        Inventory inventory = Bukkit.createInventory(null, inventorySize, SELECTION_GUI);

        ItemStack glassPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta im = glassPane.getItemMeta();
        if (im != null) im.setDisplayName("");
        glassPane.setItemMeta(im);

        for (int i = 0; i < inventorySize; i++) {
            inventory.setItem(i, glassPane);
        }

        int[] itemLocations = {11, 13, 15, 17};

        ItemStack p = new ItemStack(Material.POPPY);
        ItemMeta im1 = p.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.RED + (ChatColor.BOLD + "Normalni svet"));
        p.setItemMeta(im);
        inventory.setItem(itemLocations[0], p);

        ItemStack r = new ItemStack(Material.ROSE_BUSH);
        ItemMeta im2 = r.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.RED + (ChatColor.BOLD + "Zesileny svet"));
        r.setItemMeta(im);
        inventory.setItem(itemLocations[1], r);

        ItemStack g = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta im3 = g.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.RED + (ChatColor.BOLD + "Rovinny svet"));
        g.setItemMeta(im);
        inventory.setItem(itemLocations[2], g);

        ItemStack b = new ItemStack(Material.BEDROCK);
        ItemMeta im4 = b.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.RED + (ChatColor.BOLD + "Prazdny svet"));
        b.setItemMeta(im);
        inventory.setItem(itemLocations[3], b);
        return inventory;
    }




}
