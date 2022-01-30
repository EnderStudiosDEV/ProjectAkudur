
package loops;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.tr7zw.nbtapi.NBTItem;
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
			ci.baseBreakingPower = lvl;
			ci.miningSpeed = 25 + ((lvl - 1) * 150) + ((efficiency - 1) * 50);
			ci.miningFortune = ((lvl - 1) * 50) + ((fortune - 1) * 10);
			ci.miningSpeedPercent = ((efficiency2 - 1) * 10);
			ci.miningXPBonus = ((xpBonus - 1) * 15);
			ci.name = "Pickaxe";
			
			int pickaxeWeight = 0;
			pickaxeWeight = ci.miningSpeed * (100 + (ci.miningSpeedPercent / 100));
			pickaxeWeight *= (100 + (ci.miningXPBonus / 100));
			if(pickaxeWeight >= 150) {
				ci.mat = Material.STONE_PICKAXE;
			}
			if(pickaxeWeight >= 450) {
				ci.mat = Material.GOLDEN_PICKAXE;
			}
			if(pickaxeWeight >= 900) {
				ci.mat = Material.IRON_PICKAXE;
			}
			if(pickaxeWeight >= 1500) {
				ci.mat = Material.DIAMOND_PICKAXE;
			}
			if(pickaxeWeight >= 2500) {
				ci.mat = Material.NETHERITE_PICKAXE;
			}
			if(pickaxeWeight >= 500) {
				ci.mat = Material.PRISMARINE_SHARD;
				ci.name = "Drill";
			}
			try {
				if(HashMaps.haste.get(uuid) == 2) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1000000, 1));
					ci.miningSpeed += 300;
				}
				if(HashMaps.haste.get(uuid) == 3) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1000000, 2));
					ci.miningSpeed += 600;
				}
			} catch(Exception e) {
				HashMaps.haste.put(uuid, 1L);
			}
			
			
			ItemStack i = ci.getBukkitItem();
			NBTItem nbti = new NBTItem(i);
			if(p.getInventory().getItem(0) != null) {
				NBTItem nbti2 = new NBTItem(p.getInventory().getItem(0));
				if(nbti.getInteger("c") != nbti2.getInteger("c")) {
					nbti.setInteger("c", nbti2.getInteger("c"));
				}
			}
			i = nbti.getItem();
			
			p.getInventory().setItem(0, i);
			
			p.setWalkSpeed(0.25f);
			// 100 + 1 - 1 * 10
			
		}
	}

}
