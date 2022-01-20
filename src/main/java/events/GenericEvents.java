package events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class GenericEvents implements Listener {

	/*
	 * This class contains all of the generic events, like
	 *  a join and quit event.
	 */
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		// Change the join message.
		e.setJoinMessage("§a§lJOIN! §a" + e.getPlayer().getName() + "§7 has joined!");
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
}
