package it.axis.mafia.utils.world;

import org.bukkit.Location;
import org.bukkit.World;

public class LocationUtils {
    public static String serialize(Location loc) {
        return loc.getWorld().getName() + ";" + loc.getX() + ";" + loc.getY() + ";" + loc.getZ() + ";" + loc.getYaw()
                + ";" + loc.getPitch();
    }

    public static Location deserialize(String s) {

        return null;
    }

    public static String getChunkKey(Location loc) {
        return loc.getWorld().getName() + ":" + loc.getChunk().getX() + ":" + loc.getChunk().getZ();
    }
}
