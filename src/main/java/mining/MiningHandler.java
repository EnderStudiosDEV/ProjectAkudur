package mining;

import java.util.HashMap;

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
            int miningTime = (hardness * 30) / miningSpeed;
            int r = utils.random(1,999);
            // If the block does not have a mining time, give it one.
            if(progress == null ||
            progress.get(blockLocation) == null) {
            	progress.put(blockLocation, miningTime);
            }
            progress.put(blockLocation, (progress.get(blockLocation) - 1));
            // Get the block fracture visibility
    		int visibility = (int) Math.floor(((float)(progress.get(blockLocation)) / ((float) miningTime)) * ((float) 10));
    		visibility -= 10;
    		visibility *= -1;
    		int x = (int) Math.floor(blockLocation.getX());
    		int y = (int) Math.floor(blockLocation.getY());
    		int z = (int) Math.floor(blockLocation.getZ());
    		if(z < 0) {
    			z *= -100;
    		}
    		String idPre = x + "" + y + "3" + z;
    		int id = Integer.parseInt(idPre);
    		mu.blockBreakEffect(event.getPlayer(), blockLocation.toVector(), visibility, id);
    		
    		if(progress.get(blockLocation) < 1) {
    			// After it's done breaking, add the drops.
    			progress.put(blockLocation, 0);
    			blockLocation.getBlock().setType(Material.BEDROCK);
    			if(miningFortune <= 99) {
    				if(miningFortune > 0) {
    					int rng = Utils.random(0, 100);
    					if(rng <= miningFortune) {
    						event.getPlayer().getInventory().addItem(mu.getDrop(block));
    					}
    				}
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
    					if((miningFortune - mf2) <= 99) {
    						int rng = Utils.random(0, 100);
        					if(rng <= miningFortune) {
        						event.getPlayer().getInventory().addItem(mu.getDrop(block));
        					}
    					}
    					
    				}
    			}
    			
    			
    			mu.blockBreakEffect(event.getPlayer(), blockLocation.toVector(), -1, id);
    			Main.instance.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
    				  public void run() {
    					  blockLocation.getBlock().setType(block);
    					  progress.put(blockLocation, null);
    					  mu.blockBreakEffect(event.getPlayer(), blockLocation.toVector(), -1, id);
    				  }
    				}, 20L);
    		}
            // Get the mining time.
            // nbti.setInteger("c", 0);
        }
        
	}
	
	@EventHandler
	public void fixPickaxe(PlayerInteractEvent event) {
		if(event.getAction() != Action.RIGHT_CLICK_AIR) return;
		
		final ItemStack i = event.getPlayer().getInventory().getItemInMainHand();
		final NBTItem nbti = new NBTItem(i);
        nbti.removeKey("c");
        event.getPlayer().getInventory().setItemInMainHand(nbti.getItem());
        event.getPlayer().sendMessage("Fixed your pickaxe!");
	}
}
