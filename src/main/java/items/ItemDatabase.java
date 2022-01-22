package items;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemDatabase {

	public HashMap<String, ItemStack> items = new HashMap<String, ItemStack>();
	
	public void initStandardPickaxes() {
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
	public void initDrops() {
		CustomItem ci = new CustomItem();
		ci.rarity = Rarity.COMMON;
		ci.mat = Material.STONE;
		ci.name = "Stone";
		ci.type = ItemType.DROP;
		items.put("STONE", ci.getBukkitItem());
	
		ci.name = "Copper Ingot";
		ci.mat = Material.COPPER_INGOT;
		items.put("COPPER", ci.getBukkitItem());
		
		ci.name = "Coal";
		ci.mat = Material.COAL;
		items.put("COAL", ci.getBukkitItem());
		
		ci.rarity = Rarity.UNCOMMON;
		ci.name = "Iron Ingot";
		ci.mat = Material.IRON_INGOT;
		items.put("IRON", ci.getBukkitItem());
		
		ci.name = "Diamond";
		ci.mat = Material.DIAMOND;
		items.put("DIAMOND", ci.getBukkitItem());
	}
	
	public void initTokens() {
		CustomItem ci = new CustomItem();
		ci.rarity = Rarity.COMMON;
		ci.mat = Material.STONE;
		ci.name = "Stone Voucher";
		ci.type = ItemType.DROP;
		items.put("STONE_VOUCHER", ci.getBukkitItem());
		
		ci.rarity = Rarity.UNCOMMON;
		ci.name = "Iron Voucher";
		ci.mat = Material.IRON_INGOT;
		items.put("IRON_VOUCHER", ci.getBukkitItem());
		
		ci.rarity = Rarity.RARE;
		ci.name = "Gold Voucher";
		ci.mat = Material.GOLD_INGOT;
		items.put("GOLD_VOUCHER", ci.getBukkitItem());
		
		ci.rarity = Rarity.LEGENDARY;
		ci.name = "Diamond Voucher";
		ci.mat = Material.DIAMOND;
		items.put("DIAMOND_VOUCHER", ci.getBukkitItem());
		
		
	}
}
