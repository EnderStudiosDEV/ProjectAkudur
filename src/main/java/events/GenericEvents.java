package events;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

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
		/*
		 * public static HashMap<String, Long> coins = new HashMap<String, Long>();
	public static HashMap<String, Long> efficiency = new HashMap<String, Long>();
	public static HashMap<String, Long> fortune = new HashMap<String, Long>();
	public static HashMap<String, Long> xpBonus = new HashMap<String, Long>();
	public static HashMap<String, Long> efficiency2 = new HashMap<String, Long>();
		 */
		e.setJoinMessage("§a§lJOIN! §a" + e.getPlayer().getName() + "§7 has joined!");
		String uuid = e.getPlayer().getUniqueId().toString();
		World world = e.getPlayer().getWorld();
		if(world == Bukkit.getWorld("world")) {
			ItemDatabase dab = new ItemDatabase();
			dab.init();
			e.getPlayer().teleport(new Location(Bukkit.getWorld("build"), 20, 85, -65));
		}
		if(HashMaps.level.get(e.getPlayer().getUniqueId().toString()) == null) {
			HashMaps.level.put(e.getPlayer().getUniqueId().toString(), 1L);
			HashMaps.xp.put(e.getPlayer().getUniqueId().toString(), 0L);
		}
		if(HashMaps.efficiency.get(uuid) == null) {
			HashMaps.efficiency.put(uuid, 1L);
			HashMaps.fortune.put(uuid, 1L);
			HashMaps.xpBonus.put(uuid, 1L);
			HashMaps.efficiency2.put(uuid, 1L);
			HashMaps.coins.put(uuid, 1L);
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
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getWhoClicked().getGameMode() != GameMode.SURVIVAL) return;
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onSwap(PlayerSwapHandItemsEvent e) {
		if(e.getPlayer().getGameMode() != GameMode.SURVIVAL) return;
		e.setCancelled(true);
	}
}
