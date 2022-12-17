package me.pesekjan.multiworld.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DifficultyGui {

    public static final String SELECTION_GUI2 = ChatColor.RED + (ChatColor.BOLD + "Difficulty Selection");

    public static Inventory gui2() {
        int inventorySize = 27;
        Inventory inventory = Bukkit.createInventory(null, inventorySize, SELECTION_GUI2);

        ItemStack glassPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta im = glassPane.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.WHITE + "");
        glassPane.setItemMeta(im);

        for (int i = 0; i < inventorySize; i++) {
            inventory.setItem(i, glassPane);
        }

        int[] itemLocations = {10, 12, 14, 16};

        ItemStack p = new ItemStack(Material.LIME_CONCRETE);
        ItemMeta im1 = p.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.RED + (ChatColor.BOLD + "Mirumilovna obtiznost"));
        p.setItemMeta(im);
        inventory.setItem(itemLocations[0], p);

        ItemStack r = new ItemStack(Material.YELLOW_CONCRETE);
        ItemMeta im2 = r.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.RED + (ChatColor.BOLD + "Lehka obtiznost"));
        r.setItemMeta(im);
        inventory.setItem(itemLocations[1], r);

        ItemStack g = new ItemStack(Material.ORANGE_CONCRETE);
        ItemMeta im3 = g.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.RED + (ChatColor.BOLD + "Stredni obtiznost"));
        g.setItemMeta(im);
        inventory.setItem(itemLocations[2], g);

        ItemStack b = new ItemStack(Material.RED_CONCRETE);
        ItemMeta im4 = b.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.RED + (ChatColor.BOLD + "Tezka obtiznost"));
        b.setItemMeta(im);
        inventory.setItem(itemLocations[3], b);

        return inventory;
    }


}
