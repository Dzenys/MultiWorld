package me.pesekjan.multiworld;

import me.pesekjan.multiworld.guis.DifficultyGui;
import me.pesekjan.multiworld.guis.WorldTypeGui;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent ce) {
        Player player = (Player) ce.getWhoClicked();

        WorldOptionList optionList = WorldOptionList.WORLD_OPTION_LIST_MAP.get(player);
        if (optionList == null)
            return;
        if (ce.getView().getTitle().equals(WorldTypeGui.SELECTION_GUI)) {
            ce.setCancelled(true);
            if (ce.getCurrentItem() == null) return;


            switch (ce.getCurrentItem().getType()) {
                case POPPY -> {
                    player.openInventory(DifficultyGui.gui2());
                    optionList.worldtype = WorldType.NORMAL;
;
                }
                case ROSE_BUSH -> {
                    player.openInventory(DifficultyGui.gui2());
                    optionList.worldtype = WorldType.AMPLIFIED;

                }
                case GRASS_BLOCK -> {
                    player.openInventory(DifficultyGui.gui2());
                    optionList.worldtype = WorldType.FLAT;

                }
                case BEDROCK -> {
                    player.openInventory(DifficultyGui.gui2());
                    optionList.worldtype = WorldType.FLAT;
                    optionList.genSettings =
                            "{\"layers\": [{\"block\": \"air\", \"height\": 1}], \"biome\":\"plains\"}";


                }


                default -> {
                }
            }
        } else if (ce.getView().getTitle().equals(DifficultyGui.SELECTION_GUI2)) {
            ce.setCancelled(true);
            if (ce.getCurrentItem() == null) return;
            switch (ce.getCurrentItem().getType()) {
                case LIME_CONCRETE -> {
                    optionList.difficulty = Difficulty.PEACEFUL;
                }
                case YELLOW_CONCRETE -> {
                    optionList.difficulty = Difficulty.EASY;
                }
                case ORANGE_CONCRETE -> {
                    optionList.difficulty = Difficulty.NORMAL;
                }
                case RED_CONCRETE -> {
                    optionList.difficulty = Difficulty.HARD;
                }
                default -> {
                }


            }
        }
    }


    public World createWorld(WorldOptionList optionList) {

        if (optionList.owner == null || optionList.name == null || optionList.worldtype == null || optionList.difficulty == null)
            return null;
        WorldCreator wc = new WorldCreator(optionList.name);
        wc.environment(World.Environment.NORMAL);
        wc.type(optionList.worldtype);
        World world = wc.createWorld();
        if(world == null)
            return null;
        MultiWorld.WORLD_LIST.add(optionList.name);

        world.setDifficulty(optionList.difficulty);
        return world;
    }
}
