// 
// Decompiled by Procyon v0.5.36
// 

package mining;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;

import com.comphenix.protocol.wrappers.BlockPosition;

import de.tr7zw.nbtapi.NBTItem;

import org.bukkit.util.Vector;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

import main.Main;
import main.Utils;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.PacketType;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class MiningManager implements Listener
{
	
	public HashMap<Location, Integer> progress = new HashMap<Location,Integer>();
	
	
	// Cancel breaking and placing blocks
	@EventHandler
	public void BlockBreak(BlockBreakEvent e) {
		if(e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void BlockPlace(BlockPlaceEvent e) {
		if(e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
			e.setCancelled(true);
		}
	}
    @SuppressWarnings("unused")
	@EventHandler
    public void onMine(final PlayerInteractEvent e) {
    	// This event will run, to manage custom mining
        final ItemStack i = e.getPlayer().getInventory().getItemInMainHand();
        if (e.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }
        if (i.getType() != Material.AIR) {
        	// If the player is not trying to mine air, do the following
            final NBTItem nbti = new NBTItem(i);
            nbti.setInteger("c", Integer.valueOf(nbti.getInteger("c") + 1));
            Integer ms = nbti.getInteger("miningSpeed");
            Integer mf = nbti.getInteger("miningFortune");
            Integer xb = nbti.getInteger("miningXPBonus");
            if (ms > 0) {
            	// Update the item in hand
            	e.getPlayer().getInventory().setItemInMainHand(nbti.getItem());
            	
            	// Get various variables, for where the block is, 
            	// and what the block being mined is
            	final Material bl = e.getClickedBlock().getType();
                final World world = e.getClickedBlock().getLocation().getWorld();
                final Location loc = e.getClickedBlock().getLocation();
                
                // Manage Packets for break progress
                final int r = Utils.random(1, 999999);
                
                this.blockBreakEffect(e.getPlayer(), loc.toVector(), -1, r);
                if(canMine(world, bl, nbti.getInteger("breakingPower"))) {
                	if(progress.containsKey(loc)) {
                		progress.put(loc, progress.get(loc) - (ms / 50));
                		
                		Integer op = hardness(bl) / 10;
                		Integer pp = 10;
                		
                		for(int nm=0; nm<10; nm++) {
                			if(progress.get(loc) > (op * nm)) {
                				pp--;
                			}
                		}
                		
                		// Send the effect
                        this.blockBreakEffect(e.getPlayer(), loc.toVector(), pp, r);
                        
                		if(progress.get(loc) < 1) {
                			progress.put(loc, 0);
                			loc.getBlock().setType(Material.BEDROCK);
                			if(mf <= 1) {
                				e.getPlayer().getInventory().addItem(getDrop(bl));
                			} else {
                				if(mf % 100 == 0) {
                					for(int ic = 0; ic < (mf / 100); ic++) {
                						e.getPlayer().getInventory().addItem(getDrop(bl));
                					}
                				} else {
                					int mf2 = (int) Math.round(mf / 100);
                					for(int ic = 0; ic < (mf2); ic++) {
                						e.getPlayer().getInventory().addItem(getDrop(bl));
                					}
                					
                				}
                			}
                			
                			
                			this.blockBreakEffect(e.getPlayer(), loc.toVector(), -1, r);
                			Main.instance.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
                				  public void run() {
                					  loc.getBlock().setType(bl);
                					  progress.put(loc, hardness(bl));
                				  }
                				}, 400L);
                		}
                	} else {
                		progress.put(loc, hardness(bl));
                	}
                	
                }
                
            }
            
            
        }
    }
    
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
    
    public boolean canMine(World w, Material m, int bp) {
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
