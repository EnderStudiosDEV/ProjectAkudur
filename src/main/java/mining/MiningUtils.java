package mining;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;

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
    	if(m.equals(Material.COAL_ORE)) {
    		if(bp >= 3) {
    			return true;
    		}
    	}
    	if(m.equals(Material.IRON_ORE)) {
    		if(bp >= 4) {
    			return true;
    		}
    	}
    	if(m.equals(Material.DIAMOND_ORE)) {
    		if(bp >= 5) {
    			return true;
    		}
    	}
    	if(m.equals(Material.EMERALD_ORE)) {
    		if(bp >= 6) {
    			return true;
    		}
    	}
    	
    	
		return false;
    	
    }
    
    public Integer hardness(Material m) {
    	if(m.equals(Material.STONE) ||
    			m.equals(Material.ANDESITE)) {
    		return 15;
    	}
    	if(m.equals(Material.COAL_ORE)) {
    	    return 30;
    	}
    	if(m.equals(Material.COPPER_ORE)) {
    	    return 50;
    	}
    	if(m.equals(Material.IRON_ORE)) {
    	    return 90;
    	}
    	if(m.equals(Material.DIAMOND_ORE)) {
    	    return 130;
    	}
    	if(m.equals(Material.EMERALD_ORE)) {
    	    return 190;
    	}
		return 1000000;
	
    }
    
    public ItemStack getDrop(Material m) {
    	if(m.equals(Material.STONE) ||
    			m.equals(Material.ANDESITE)) {
    	}
    	if(m.equals(Material.COAL_ORE)) {
    	}
    	if(m.equals(Material.COPPER_ORE)) {
    	}
    	if(m.equals(Material.IRON_ORE)) {
    	}
    	if(m.equals(Material.DIAMOND_ORE)) {
    	}
    	if(m.equals(Material.EMERALD_ORE)) {
    	}
    	
    	
		return null;
    }
    
}
