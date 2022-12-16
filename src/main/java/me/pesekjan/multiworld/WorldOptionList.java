package me.pesekjan.multiworld;

import org.bukkit.Difficulty;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class WorldOptionList {

    public static final Map<Player, WorldOptionList> WORLD_OPTION_LIST_MAP = new HashMap<>();

    public  Difficulty difficulty = null;
    public  String owner = null;
    public  WorldType worldtype = null;
    public  String name = null;
    public String genSettings = null;

}
