
package loops;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import hashmaps.HashMaps;
import items.CustomItem;
import items.Rarity;
public class AutoPickaxe {

	/*
	 * public static HashMap<String, Long> coins = new HashMap<String, Long>();
	public static HashMap<String, Long> efficiency = new HashMap<String, Long>();
	public static HashMap<String, Long> fortune = new HashMap<String, Long>();
	public static HashMap<String, Long> xpBonus = new HashMap<String, Long>();
	public static HashMap<String, Long> efficiency2 = new HashMap<String, Long>();
	 */
	public static void call() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			String uuid = p.getUniqueId().toString();
			
			int lvl = HashMaps.level.get(uuid).intValue();
			int efficiency = HashMaps.efficiency.get(uuid).intValue();
			int fortune = HashMaps.fortune.get(uuid).intValue();
			int xpBonus = HashMaps.xpBonus.get(uuid).intValue();
			int efficiency2 = HashMaps.efficiency2.get(uuid).intValue();
			
			CustomItem ci = new CustomItem();
			ci.rarity = Rarity.COMMON;
			ci.mat = Material.WOODEN_PICKAXE;
			ci.baseBreakingPower = 1 + lvl;
			ci.miningSpeed = 25 + ((lvl - 1) * 150) + ((efficiency - 1) * 50);
			ci.miningFortune = ((lvl - 1) * 50) + ((fortune - 1) * 10);
			ci.miningSpeedPercent = ((efficiency2 - 1) * 20);
			ci.miningXPBonus = ((xpBonus - 1) * 10);
			ci.name = "Pickaxe";
			
			p.getInventory().setItem(0, ci.getBukkitItem());
		}
	}

}
