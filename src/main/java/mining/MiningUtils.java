package mining;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;

import items.ItemDatabase;
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
    	if(m.equals(Material.DIAMOND_ORE)) {
    		if(bp >= 4) {
    			return true;
    		}
    	}
    	if(m.equals(Material.EMERALD_ORE)) {
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
    	if(m.equals(Material.DIAMOND_ORE)) {
    	    return 350;
    	}
    	if(m.equals(Material.EMERALD_ORE)) {
    	    return 470;
    	}
    	if(m.equals(Material.EMERALD_ORE)) {
    	    return 590;
    	}
    	if(m.equals(Material.OBSIDIAN)) {
    	    return 730;
    	}
    	if(m.equals(Material.ANCIENT_DEBRIS)) {
    	    return 1010;
    	}
    	if(m.equals(Material.END_STONE)) {
    	    return 1200;
    	}
    	if(m.equals(Material.PURPLE_TERRACOTTA)) {
    	    return 2180;
    	}
		return 1000000;
	
    }
    
    public ItemStack getDrop(Material m) {
    	ItemDatabase dat = new ItemDatabase();
    	dat.init();
    	
    	if(Utils.random(1, 20) == 20) {
    		ItemStack vo = new ItemStack(Material.STONE);
    		vo = dat.items.get("STONE_VOUCHER");
    		if(Utils.random(1, 3) == 3) {
    			vo = dat.items.get("IRON_VOUCHER");
    		}
    		return vo;
    	}
    	if(m.equals(Material.STONE) ||
    			m.equals(Material.ANDESITE)) {
    		return dat.items.get("STONE");
    	}
    	if(m.equals(Material.COPPER_ORE)) {
    		return dat.items.get("COPPER");
    	}
    	if(m.equals(Material.IRON_ORE)) {
    		return dat.items.get("IRON");
    	}
    	if(m.equals(Material.GOLD_ORE)) {
    		return dat.items.get("GOLD");
    	}
    	if(m.equals(Material.DIAMOND_ORE)) {
    		return dat.items.get("DIAMOND");
    	}
    	
    	
		return null;
    }
    public Integer xp(Material m, int miningXPBonus) {
    	int dol = 0;
    	if(m.equals(Material.STONE) ||
    			m.equals(Material.ANDESITE)) {
    		dol = 5;
    	}
    	if(m.equals(Material.COPPER_ORE)) {
    		dol = 11;
    	}
    	if(m.equals(Material.IRON_ORE)) {
    		dol = 21;
    	}
    	if(m.equals(Material.DIAMOND_ORE)) {
    		dol = 35;
    	}
    	if(m.equals(Material.EMERALD_ORE)) {
    		dol =dol = 47;
    	}
    	if(m.equals(Material.EMERALD_ORE)) {
    		dol = 59;
    	}
    	if(m.equals(Material.OBSIDIAN)) {
    		dol = 73;
    	}
    	if(m.equals(Material.ANCIENT_DEBRIS)) {
    		dol = 101;
    	}
    	if(m.equals(Material.END_STONE)) {
    		dol = 120;
    	}
    	if(m.equals(Material.PURPLE_TERRACOTTA)) {
    		dol = 218;
    	}
		return dol * ((miningXPBonus + 100) / 100);
	
    }
    public Material replenish(Location loc) {
    	Material mat = stoneRng();
    	if(loc.distance(new Location(Bukkit.getWorld("build"), 19, 85, 36)) < 15) {
    		if(Utils.random(1,2) == 1) {
    			mat = Material.COPPER_ORE;
    		}
    	}
    	if(loc.distance(new Location(Bukkit.getWorld("build"), -9, 85, 72)) < 15) {
    		if(Utils.random(1,2) == 1) {
    			mat = Material.IRON_ORE;
    		}
    	}
    	if(loc.distance(new Location(Bukkit.getWorld("build"), 57, 85, 74)) < 20) {
    		if(Utils.random(1,2) == 1) {
    			mat = Material.DIAMOND_ORE;
    		}
    	}
    	if(loc.distance(new Location(Bukkit.getWorld("build"), -16, 85, 6)) < 15) {
    		if(Utils.random(1,2) == 1) {
    			mat = Material.GOLD_ORE;
    		}
    	}
    	if(loc.distance(new Location(Bukkit.getWorld("build"), -31, 85, 25)) < 25) {
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
