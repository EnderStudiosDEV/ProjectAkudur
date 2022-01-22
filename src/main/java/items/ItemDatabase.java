package items;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemDatabase {

	public HashMap<String, ItemStack> items = new HashMap<String, ItemStack>();
	
	public void initPickaxes() {
		// Setup
		CustomItem ci = new CustomItem();
		ci.rarity = Rarity.COMMON;
		ci.mat = Material.WOODEN_PICKAXE;
		ci.baseBreakingPower = 1;
	/*
		* Wooden Pickaxes
		*/
		ci.name = "Wooden Pickaxe [Tier 1]";
		ci.miningSpeed = 25;
		items.put("WOODEN_PICKAXE_1", ci.getBukkitItem());
		
		ci.name = "Wooden Pickaxe [Tier 2]";
		ci.miningSpeed = 50;
		items.put("WOODEN_PICKAXE_2", ci.getBukkitItem());

		ci.name = "Wooden Pickaxe [Tier 3]";
		ci.miningSpeed = 75;
		items.put("WOODEN_PICKAXE_3", ci.getBukkitItem());

		ci.name = "Wooden Pickaxe [Tier 4]";
		ci.miningSpeed = 100;
		items.put("WOODEN_PICKAXE_4", ci.getBukkitItem());

		ci.name = "Wooden Pickaxe [Tier 5]";
		ci.miningSpeed = 125;
		items.put("WOODEN_PICKAXE_5", ci.getBukkitItem());
		
		/*
		 * Copper Pickaxes
		 */
		ci.baseBreakingPower = 2;
		
		ci.name = "Copper Pickaxe [Tier 1]";
		ci.miningSpeed = 100;
		items.put("COPPER_PICKAXE_1", ci.getBukkitItem());
		
		ci.name = "Copper Pickaxe [Tier 2]";
		ci.miningSpeed = 125;
		items.put("COPPER_PICKAXE_2", ci.getBukkitItem());
		
		ci.name = "Copper Pickaxe [Tier 3]";
		ci.miningSpeed = 150;
		ci.miningFortune = 5;
		items.put("COPPER_PICKAXE_3", ci.getBukkitItem());
		
		ci.name = "Copper Pickaxe [Tier 4]";
		ci.miningSpeed = 175;
		ci.miningFortune = 7;
		items.put("COPPER_PICKAXE_4", ci.getBukkitItem());
		
		ci.name = "Copper Pickaxe [Tier 5]";
		ci.miningSpeed = 200;
		ci.miningFortune = 10;
		items.put("COPPER_PICKAXE_5", ci.getBukkitItem());
		
		/*
		 * Stone Pickaxes
		 */
		ci.mat = Material.STONE_PICKAXE;
		ci.baseBreakingPower = 3;
		
		ci.name = "Stone Pickaxe [Tier 1]";
		ci.miningSpeed = 175;
		items.put("STONE_PICKAXE_1", ci.getBukkitItem());
		
		ci.name = "Stone Pickaxe [Tier 2]";
		ci.miningSpeed = 200;
		items.put("STONE_PICKAXE_2", ci.getBukkitItem());
		
		ci.name = "Stone Pickaxe [Tier 3]";
		ci.miningSpeed = 225;
		ci.miningFortune = 7;
		items.put("STONE_PICKAXE_3", ci.getBukkitItem());
		
		
		/*
		 * Special Pickaxes
		 */
		ci.mat = Material.DIAMOND_PICKAXE;
		ci.baseBreakingPower = 9;
		
		ci.name = "Major";
		ci.rarity = Rarity.FABLED;
		ci.miningSpeed = 1;
		ci.miningSpeedPercent = 210000;
		
		items.put("MAJOR", ci.getBukkitItem());
		
		ci.name = "Minor";
		ci.miningSpeed = 8400;
		ci.miningSpeedPercent = -75;
		
		items.put("MINOR", ci.getBukkitItem());
	}
	public void initTokens() {
		
	}
}
