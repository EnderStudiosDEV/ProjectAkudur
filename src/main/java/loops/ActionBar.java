
package loops;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fastboard.FastBoard;
import main.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
public class ActionBar {

	public static void call() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			// Potion Effect
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 1000000, -1));
			
			// Display on Action Bar
			int x = (int) Math.round(p.getLocation().getX());
			int z = (int) Math.round(p.getLocation().getZ());
			String dir = Utils.getCardinalDirection(p);
			String message = "§7" + x + " §a" + dir + " §7" + z;
	        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
	        
	        // Tablist
	        p.setPlayerListHeaderFooter(System.lineSeparator() + 
	        		"§5§lPROJECT: AKUDUR" + System.lineSeparator() + System.lineSeparator()
	        		+ "§7Players Online: §b" + Bukkit.getOnlinePlayers().size() + "§7/10",
	        		"§e/join enderae §8| §benderae.minehut.gg");
	        
	        
	        // Scoreboard
	        FastBoard board = new FastBoard(p);
	        board.updateTitle("§5§lHALT MINES");
	        List<String> lines = new ArrayList<String>();
	        
	        lines.add("");
	        lines.add("§aCoins: §2$§a0");
	        lines.add("");
	        lines.add("§ehaltmines.minehut.gg");
	        board.updateLines(lines);
		}
	}

}
