package me.pesekjan.multiworld;

import me.pesekjan.multiworld.guis.DifficultyGui;
import me.pesekjan.multiworld.guis.WorldTypeGui;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent ce){

        Player player = (Player) ce.getWhoClicked();

        if (ce.getView().getTitle().equals(WorldTypeGui.SELECTION_GUI))
            ce.setCancelled(true);

        if(ce.getCurrentItem() == null) return;

        switch(ce.getCurrentItem().getType()){
            case POPPY: player.openInventory(DifficultyGui.gui2());
                break;
            case ROSE_BUSH: player.openInventory(DifficultyGui.gui2());
                break;
            case GRASS_BLOCK: player.openInventory(DifficultyGui.gui2());
                break;
            case BEDROCK: player.openInventory(DifficultyGui.gui2());
                break;
            default:
                break;
        }



    }


}
