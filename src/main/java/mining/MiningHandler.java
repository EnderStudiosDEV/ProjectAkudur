// 
// Decompiled by Procyon v0.5.36
// 

package mining;

import java.util.HashMap;

import org.bukkit.GameMode;

import de.tr7zw.nbtapi.NBTItem;

import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

import main.Main;
import main.Utils;

import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class MiningHandler implements Listener
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
        MiningUtils mu = new MiningUtils();
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
            
            final Material bl = e.getClickedBlock().getType();
            final World world = e.getClickedBlock().getLocation().getWorld();
            final Location loc = e.getClickedBlock().getLocation();
            
            if (ms > 0) {
            	// Update the item in hand
            	e.getPlayer().getInventory().setItemInMainHand(nbti.getItem());
            	
                // Manage Packets for break progress
                final int r = Utils.random(1, 999999);
                
                mu.blockBreakEffect(e.getPlayer(), loc.toVector(), -1, r);
        		
        		Integer op = mu.hardness(bl) / 10;
        		Integer pp = 10;
        		
        		for(int nm=0; nm<10; nm++) {
        			if(progress.get(loc) > (op * nm)) {
        				pp--;
        			}
        		}
        		
        		// Send the effect
                mu.blockBreakEffect(e.getPlayer(), loc.toVector(), pp, r);
                
        		if(progress.get(loc) < 1) {
        			progress.put(loc, 0);
        			loc.getBlock().setType(Material.BEDROCK);
        			if(mf <= 1) {
        				e.getPlayer().getInventory().addItem(mu.getDrop(bl));
        			} else {
        				if(mf % 100 == 0) {
        					for(int ic = 0; ic < (mf / 100); ic++) {
        						e.getPlayer().getInventory().addItem(mu.getDrop(bl));
        					}
        				} else {
        					int mf2 = (int) Math.round(mf / 100);
        					for(int ic = 0; ic < (mf2); ic++) {
        						e.getPlayer().getInventory().addItem(mu.getDrop(bl));
        					}
        					
        				}
        			}
        			
        			
        			mu.blockBreakEffect(e.getPlayer(), loc.toVector(), -1, r);
        			Main.instance.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
        				  public void run() {
        					  loc.getBlock().setType(bl);
        					  progress.put(loc, mu.hardness(bl));
        				  }
        				}, 400L);
        		}
        	} else {
        		progress.put(loc, mu.hardness(bl));
        	}
        	
        }
        
    }
                
}

