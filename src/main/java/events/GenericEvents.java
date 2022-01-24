package events;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import hashmaps.HashMaps;
import items.ItemDatabase;

public class GenericEvents implements Listener {

	/*
	 * This class contains all of the generic events, like
	 *  a join and quit event.
	 */
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		// Change the join message.
		e.setJoinMessage("§a§lJOIN! §a" + e.getPlayer().getName() + "§7 has joined!");
		
		World world = e.getPlayer().getWorld();
		if(world == Bukkit.getWorld("world")) {
			ItemDatabase dab = new ItemDatabase();
			dab.init();
			
			e.getPlayer().getInventory().addItem(dab.items.get("WOODEN_PICKAXE_1"));
			e.getPlayer().teleport(new Location(Bukkit.getWorld("build"), 20, 85, -65));
		}
		if(HashMaps.level.get(e.getPlayer().getUniqueId().toString()) == null) {
			HashMaps.level.put(e.getPlayer().getUniqueId().toString(), 1);
			HashMaps.xp.put(e.getPlayer().getUniqueId().toString(), 0);
		}
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		// Change the quit message.
		e.setQuitMessage("§c§lQUIT! §c" + e.getPlayer().getName() + "§7 has left.");
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		// Change the quit message.
		e.setFormat("§7" + e.getPlayer().getName() + "§7: " + e.getMessage());
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			e.setCancelled(true);
		}
		
	}
}
