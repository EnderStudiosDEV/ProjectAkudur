package mining;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import de.tr7zw.nbtapi.NBTItem;
import main.Main;
import main.Utils;

public class MiningHandler implements Listener {

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
	
	@SuppressWarnings({ "unused", "static-access" })
	@EventHandler
	public void miningManager(PlayerInteractEvent event) {
		// This event will manage custom mining.
		final ItemStack i = event.getPlayer().getInventory().getItemInMainHand();
        MiningUtils mu = new MiningUtils();
        Utils utils = new Utils();
        if (event.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }
        
        if (i.getType() != Material.AIR) {
        	// If the player is not trying to hold air, do the following
            final NBTItem nbti = new NBTItem(i);
            // This wil give the pickaxe a random, invisible stat, that will allow the user
            // to use the custom mining system.
            nbti.setInteger("c", Integer.valueOf(nbti.getInteger("c") + 1));
            event.getPlayer().getInventory().setItemInMainHand(nbti.getItem());
            
            // Define some generic values
            final Material block = event.getClickedBlock().getType();
            final World world = event.getClickedBlock().getLocation().getWorld();
            final Location blockLocation = event.getClickedBlock().getLocation();
            
            Integer miningSpeed = nbti.getInteger("miningSpeed");
            Integer miningFortune = nbti.getInteger("miningFortune");
            Integer miningXPBonus = nbti.getInteger("miningXPBonus");
            Integer breakingPower = nbti.getInteger("breakingPower");
            
            if(!mu.canMine(block, breakingPower)) return;
            
            // Stats of the block.
            int hardness = mu.hardness(block);
            int maxHardness = mu.hardness(block);
            int fracture = 10;
            int miningTime = (hardness * 30) / miningSpeed;
            Bukkit.broadcastMessage("time: " + miningTime + " fracture: " + fracture + " hardness: " + hardness);
            int r = utils.random(1,999);
            // If the block does not have a mining time, give it one.
            if(progress == null ||
            progress.get(blockLocation) == null) {
            	progress.put(blockLocation, miningTime);
            }
            progress.put(blockLocation, (progress.get(blockLocation) - 1));
            // Get the block fracture visibility
    		int visibility = (int) Math.floor((hardness / maxHardness) * 10);
    		mu.blockBreakEffect(event.getPlayer(), blockLocation.toVector(), visibility, r);
    		
    		if(progress.get(blockLocation) < 1) {
    			// After it's done breaking, add the drops.
    			progress.put(blockLocation, 0);
    			blockLocation.getBlock().setType(Material.BEDROCK);
    			if(miningFortune <= 1) {
    				event.getPlayer().getInventory().addItem(mu.getDrop(block));
    			} else {
    				if(miningFortune % 100 == 0) {
    					for(int ic = 0; ic < (miningFortune / 100); ic++) {
    						event.getPlayer().getInventory().addItem(mu.getDrop(block));
    					}
    				} else {
    					int mf2 = (int) Math.round(miningFortune / 100);
    					for(int ic = 0; ic < (mf2); ic++) {
    						event.getPlayer().getInventory().addItem(mu.getDrop(block));
    					}
    					
    				}
    			}
    			
    			
    			mu.blockBreakEffect(event.getPlayer(), blockLocation.toVector(), -1, r);
    			Main.instance.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
    				  public void run() {
    					  blockLocation.getBlock().setType(block);
    					  progress.put(blockLocation, null);
    				  }
    				}, 20L);
    		}
            // Get the mining time.
            // nbti.setInteger("c", 0);
        }
        
	}
}
