
package loops;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
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
			Utils utils = new Utils();
			// Potion Effect
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 1000000, -1));
			
			// Display on Action Bar
			int x = (int) Math.round(p.getLocation().getX());
			int z = (int) Math.round(p.getLocation().getZ());
			String dir = utils.getCardinalDirection(p);
			String message = "�7" + x + " �a" + dir + " �7" + z;
	        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
	        
	        // Tablist
	        p.setPlayerListHeaderFooter(System.lineSeparator() + 
	        		"�5�lPROJECT: AKUDUR" + System.lineSeparator() + System.lineSeparator()
	        		+ "�7Players Online: �b" + Bukkit.getOnlinePlayers().size() + "�7/10",
	        		"�e/join akudur �8| �bakudur.minehut.gg");
	        
	        
	        // Scoreboard
	        FastBoard board = new FastBoard(p);
	        board.updateTitle("�5�lPROJECT AKUDUR");
	        List<String> lines = new ArrayList<String>();
	        
	        lines.add("�7Running 0.7.0.30");
	        lines.add("");
	        lines.add("�aCoins: �2$�a0");
	        lines.add("");
	        lines.add("�eakudur.minehut.gg");
	        board.updateLines(lines);
	        
	        // Teleport

			World world = p.getWorld();
			if(world == Bukkit.getWorld("world")) {
				p.teleport(new Location(Bukkit.getWorld("build"), 20, 85, -65));
			}
		}
	}

}
