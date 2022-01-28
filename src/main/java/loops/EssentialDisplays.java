
package loops;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.tr7zw.nbtapi.NBTItem;
import fastboard.FastBoard;
import hashmaps.HashMaps;
import main.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
public class EssentialDisplays {

	public static void call() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			Utils utils = new Utils();
			String uuid = p.getUniqueId().toString();
			
			// Potion Effect
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 1000000, -1));
			
			// Display on Action Bar
			int x = (int) Math.round(p.getLocation().getX());
			int z = (int) Math.round(p.getLocation().getZ());
			String dir = utils.getCardinalDirection(p);
			String msg1 = "";
			String msg2 = "";
			try {
				ItemStack i = p.getInventory().getItemInMainHand();
				NBTItem nbti = new NBTItem(i);
				Integer miningSpeed = nbti.getInteger("miningSpeed");
				Integer miningFortune = nbti.getInteger("miningFortune");
				msg1 = "§6" + miningSpeed + "§6⛏ ";
				msg2 = " §6" + miningFortune + "§6☘";
			} catch(Exception e) {
			}
			
			String message = msg1 + " §7" + x + " §a" + dir + " §7" + z + msg2;
	        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
	        
	        // Tablist
	        p.setPlayerListHeaderFooter(System.lineSeparator() + 
	        		"§5§lPROJECT: AKUDUR" + System.lineSeparator() + System.lineSeparator()
	        		+ "§7Players Online: §b" + Bukkit.getOnlinePlayers().size() + "§7/10",
	        		"§e/join akudur §8| §bakudur.minehut.gg");
	        
	        
	        // Scoreboard
	        FastBoard board = new FastBoard(p);
	        board.updateTitle("§5§lPROJECT AKUDUR");
	        List<String> lines = new ArrayList<String>();
	        
	        lines.add("§7Running 0.7.2.30");
	        lines.add("");
	        lines.add("§aCoins: §2$§a0");
	        lines.add("");
	        lines.add("§eakudur.minehut.gg");
	        board.updateLines(lines);
	        
	        // Teleport

			World world = p.getWorld();
			if(world == Bukkit.getWorld("world")) {
				p.teleport(new Location(Bukkit.getWorld("build"), 20, 85, -65));
			}
			
			// Armor
			ItemStack[] armor = utils.armor(HashMaps.level.get(uuid));
			for(int i = 0; i < 5; i++) {
				try {
					ItemStack item = armor[i];
					if(i == 1) {
						p.getInventory().setHelmet(item);
					}
					if(i == 2) {
						p.getInventory().setChestplate(item);
					}
					if(i == 3) {
						p.getInventory().setLeggings(item);
					}
					if(i == 4) {
						p.getInventory().setBoots(item);
					}
				} catch(Exception e) {
					
				}
				
			}
		}
	}

}
