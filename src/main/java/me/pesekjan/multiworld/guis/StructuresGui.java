package me.pesekjan.multiworld.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StructuresGui {
    public static final String SELECTION_GUI3 = ChatColor.RED + (ChatColor.BOLD + "Structures Selection");

    public static Inventory gui3() {
        int inventorySize = 27;
        Inventory inventory = Bukkit.createInventory(null, inventorySize, SELECTION_GUI3);

        ItemStack glassPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta im = glassPane.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.WHITE + "");
        glassPane.setItemMeta(im);

        for (int i = 0; i < inventorySize; i++) {
            inventory.setItem(i, glassPane);
        }

        int[] itemLocations = {11, 15};

        ItemStack p = new ItemStack(Material.LIME_CONCRETE_POWDER);
        ItemMeta im1 = p.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.GREEN + (ChatColor.BOLD + "ANO"));
        p.setItemMeta(im);
        inventory.setItem(itemLocations[0], p);

        ItemStack r = new ItemStack(Material.RED_CONCRETE_POWDER);
        ItemMeta im2 = r.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.RED + (ChatColor.BOLD + "NE"));
        r.setItemMeta(im);
        inventory.setItem(itemLocations[1], r);


        return inventory;
    }


}
