package mining;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;

import main.Utils;

public class MiningUtils {

	public void blockBreakEffect(final Player player, final Vector vector, final int step, final int randId) {
    	// Block breaking effect, done via ProtocolLib packets.
        final PacketContainer container = new PacketContainer(PacketType.Play.Server.BLOCK_BREAK_ANIMATION);
        container.getBlockPositionModifier().write(0, (BlockPosition)new BlockPosition(vector));
        container.getIntegers().write(0, (Integer)randId).write(1, (Integer)step);
        this.execute(player, container);
    }
    
    void execute(final Player receiver, final PacketContainer container) {
    	// Sends out packets
        try {
            for (final Player p : Bukkit.getOnlinePlayers()) {
                ProtocolLibrary.getProtocolManager().sendServerPacket(p, container);
            }
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    
    public boolean canMine(Material m, int bp) {
    	if(m.equals(Material.STONE) ||
    			m.equals(Material.ANDESITE)) {
    		return true;
    	}
    	if(m.equals(Material.COPPER_ORE)) {
    		if(bp >= 2) {
    			return true;
    		}
    	}
    	if(m.equals(Material.IRON_ORE)) {
    		if(bp >= 3) {
    			return true;
    		}
    	}
    	if(m.equals(Material.GOLD_ORE)) {
    		if(bp >= 4) {
    			return true;
    		}
    	}
    	if(m.equals(Material.DIAMOND_ORE)) {
    		if(bp >= 5) {
    			return true;
    		}
    	}
    	
    	if(m.equals(Material.OBSIDIAN)) {
    		if(bp >= 6) {
    			return true;
    		}
    	}
    	if(m.equals(Material.ANCIENT_DEBRIS)) {
    		if(bp >= 7) {
    			return true;
    		}
    	}
    	if(m.equals(Material.END_STONE)) {
    		if(bp >= 8) {
    			return true;
    		}
    	}
    	if(m.equals(Material.PURPLE_TERRACOTTA)) {
    		if(bp >= 9) {
    			return true;
    		}
    	}
    	
    	
		return false;
    	
    }
    
    public Integer hardness(Material m) {
    	if(Utils.random(1,10) == 10) {
    		
    	}
    	if(m.equals(Material.STONE) ||
    			m.equals(Material.ANDESITE)) {
    		return 50;
    	}
    	if(m.equals(Material.COPPER_ORE)) {
    	    return 115;
    	}
    	if(m.equals(Material.IRON_ORE)) {
    	    return 215;
    	}
    	if(m.equals(Material.GOLD_ORE)) {
    	    return 340;
    	}
    	if(m.equals(Material.DIAMOND_ORE)) {
    	    return 550;
    	}
    	if(m.equals(Material.OBSIDIAN)) {
    	    return 730;
    	}
    	if(m.equals(Material.ANCIENT_DEBRIS)) {
    	    return 1010;
    	}
    	if(m.equals(Material.END_STONE)) {
    	    return 1380;
    	}
    	if(m.equals(Material.PURPLE_TERRACOTTA)) {
    	    return 2180;
    	}
		return 1000000;
	
    }
    
    public long getDrop(Material m) {
    	if(m.equals(Material.STONE) ||
    			m.equals(Material.ANDESITE)) {
    		return 1;
    	}
    	if(m.equals(Material.COPPER_ORE)) {
    		return 5;
    	}
    	if(m.equals(Material.IRON_ORE)) {
    		return 12;
    	}
    	if(m.equals(Material.GOLD_ORE)) {
    		return 24;
    	}
    	if(m.equals(Material.DIAMOND_ORE)) {
    		return 48;
    	}
    	
    	
		return 0;
    }
    public Integer xp(Material m, int miningXPBonus) {
    	int dol = 0;
    	if(m.equals(Material.STONE) ||
    			m.equals(Material.ANDESITE)) {
    		dol = 5;
    	}
    	if(m.equals(Material.COPPER_ORE)) {
    		dol = 15;
    	}
    	if(m.equals(Material.IRON_ORE)) {
    		dol = 30;
    	}
    	if(m.equals(Material.GOLD_ORE)) {
    		dol = 70;
    	}
    	if(m.equals(Material.DIAMOND_ORE)) {
    		dol = 120;
    	}
    	if(m.equals(Material.EMERALD_ORE)) {
    		dol = 180;
    	}
    	if(m.equals(Material.NETHER_QUARTZ_ORE)) {
    		dol = 360;
    	}
    	if(m.equals(Material.OBSIDIAN)) {
    		dol = 480;
    	}
    	if(m.equals(Material.ANCIENT_DEBRIS)) {
    		dol = 720;
    	}
    	if(m.equals(Material.END_STONE)) {
    		dol = 1400;
    	}
    	if(m.equals(Material.PURPLE_TERRACOTTA)) {
    		dol = 2350;
    	}
    	if(m.equals(Material.YELLOW_TERRACOTTA)) {
    		dol = 4900;
    	}
    	if(m.equals(Material.RED_TERRACOTTA)) {
    		dol = 8500;
    	}
		return dol * ((miningXPBonus + 100) / 100);
	
    }
    public Material replenish(Location loc) {
    	Material mat = stoneRng();
    	if(loc.distanceSquared(new Location(Bukkit.getWorld("build"), 19, 85, 36)) < 625) {
    		if(Utils.random(1,2) == 1) {
    			mat = Material.COPPER_ORE;
    		}
    	}
    	if(loc.distanceSquared(new Location(Bukkit.getWorld("build"), -9, 85, 72)) < 625) {
    		if(Utils.random(1,2) == 1) {
    			mat = Material.IRON_ORE;
    		}
    	}
    	if(loc.distanceSquared(new Location(Bukkit.getWorld("build"), 57, 85, 74)) < 625) {
    		if(Utils.random(1,2) == 1) {
    			mat = Material.DIAMOND_ORE;
    		}
    	}
    	if(loc.distanceSquared(new Location(Bukkit.getWorld("build"), -16, 85, 6)) < 600) {
    		if(Utils.random(1,2) == 1) {
    			mat = Material.GOLD_ORE;
    		}
    	}
    	if(loc.distanceSquared(new Location(Bukkit.getWorld("build"), -31, 85, -25)) < 600) {
    		if(Utils.random(1,2) == 1) {
    			mat = Material.GOLD_ORE;
    		}
    	}
    	return mat;
    }
    public Material stoneRng() {
    	if(Utils.random(1,2) == 1) {
    		return Material.STONE;
    	} else {
    		return Material.ANDESITE;
    	}
    }
}
