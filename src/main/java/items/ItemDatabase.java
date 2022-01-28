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
		
		ci.rarity = Rarity.UNCOMMON;
		
		ci.shiny = true;
		ci.mat = Material.STONE;
		ci.name = "Compressed Stone";
		items.put("COMPRESSED_STONE", ci.getBukkitItem());
		
		ci.name = "Compressed Copper";
		ci.mat = Material.COPPER_INGOT;
		items.put("COMPRESSED_COPPER", ci.getBukkitItem());
		
		ci.shiny = false;
		ci.name = "Iron Ingot";
		ci.mat = Material.IRON_INGOT;
		items.put("IRON", ci.getBukkitItem());
		
		ci.name = "Gold Ingot";
		ci.mat = Material.GOLD_INGOT;
		items.put("GOLD", ci.getBukkitItem());
		
		ci.rarity = Rarity.RARE;
		ci.shiny = true;
		ci.name = "Compressed Iron Ingot";
		ci.mat = Material.IRON_INGOT;
		items.put("COMPRESSED_IRON", ci.getBukkitItem());
		
		ci.name = "Compressed Gold Ingot";
		ci.mat = Material.GOLD_INGOT;
		items.put("COMPRESSED_GOLD", ci.getBukkitItem());
		
		ci.shiny = false;
		
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
	public void initSpecialPickaxes() {
		// Setup
		CustomItem ci = new CustomItem();
		ci.rarity = Rarity.COMMON;
		ci.mat = Material.WOODEN_PICKAXE;
		ci.baseBreakingPower = 1;
		
		/*
		 * Stone Tier
		 */
		ci.mat = Material.STONE_PICKAXE;
		ci.baseBreakingPower = 3;
		
		ci.name = "Unique Stone Pickaxe";
		ci.rarity = Rarity.RARE;
		ci.miningSpeed = 150;
		items.put("STONE_PICKAXE_V", ci.getBukkitItem());
		/*
		 * Iron Tier
		 */
		ci.mat = Material.IRON_PICKAXE;
		ci.baseBreakingPower = 5;
		ci.rarity = Rarity.EPIC;
		
		ci.name = "Hard Drive";
		ci.miningSpeed = 1;
		ci.miningSpeedPercent = 39000;
		ci.miningFortune = 10;
		items.put("HARD_DRIVE", ci.getBukkitItem());
		
		ci.name = "Fragment";
		ci.miningSpeed = 250;
		ci.miningSpeedPercent = 155;
		ci.miningFortune = 20;
		items.put("FRAGMENT", ci.getBukkitItem());
		
		ci.name = "Prevalence";
		ci.miningSpeed = 250;
		ci.miningSpeedPercent = 75;
		ci.miningFortune = 100;
		items.put("PREVALENCE", ci.getBukkitItem());
		
		ci.name = "Assembly";
		ci.miningSpeed = 250;
		ci.miningFortune = 300;
		items.put("ASSEMBLY", ci.getBukkitItem());
		/*
		 * Gold Tier
		 */
		ci.mat = Material.GOLDEN_PICKAXE;
		ci.baseBreakingPower = 6;
		ci.rarity = Rarity.LEGENDARY;
		
		ci.name = "Conservation";
		ci.miningSpeed = 250;
		ci.miningSpeedPercent = 75;
		ci.miningFortune = 100;
		items.put("CONSERVATION", ci.getBukkitItem());
		
		ci.name = "Surround";
		ci.miningSpeed = 450;
		ci.miningSpeedPercent = 200;
		ci.miningFortune = 75;
		items.put("SURROUND", ci.getBukkitItem());
		
		ci.name = "Extension";
		ci.miningSpeed = 450;
		ci.miningSpeedPercent = 15;
		ci.miningFortune = 350;
		items.put("EXTENSION", ci.getBukkitItem());
		
		ci.name = "Statue's Demise";
		ci.miningSpeed = 350;
		ci.miningSpeedPercent = 300;
		ci.miningFortune = 0;
		ci.miningXPBonus = 0;
		items.put("STATUES_DEMISE", ci.getBukkitItem());
		
		ci.name = "Absolvent";
		ci.miningSpeed = 250;
		ci.miningSpeedPercent = 100;
		ci.miningFortune = 0;
		ci.miningXPBonus = 400;
		items.put("ABSOLVENT", ci.getBukkitItem());
		/*
		 * Diamond Tier Pickaxes
		 */
		ci.mat = Material.DIAMOND_PICKAXE;
		ci.baseBreakingPower = 9;
		ci.miningFortune = 0;
		
		ci.name = "Major";
		ci.rarity = Rarity.FABLED;
		ci.miningSpeed = 1;
		ci.miningSpeedPercent = 210000;
		
		items.put("MAJOR", ci.getBukkitItem());
		
		ci.name = "Oblivion";
		ci.miningSpeed = 420;
		ci.miningSpeedPercent = 600;
		ci.miningXPBonus = 200;
		ci.miningFortune = 0;
		
		items.put("OBLIVION", ci.getBukkitItem());
		
		ci.name = "Fantasy";
		ci.miningSpeed = 300;
		ci.miningSpeedPercent = 300;
		ci.miningXPBonus = 300;
		ci.miningFortune = 300;
		
		items.put("FANTASY", ci.getBukkitItem());
		
		ci.name = "Ambivalence";
		ci.miningSpeed = 500;
		ci.miningSpeedPercent = 500;
		ci.miningXPBonus = 400;
		ci.miningFortune = 400;
		
		items.put("AMBIVALENCE", ci.getBukkitItem());
		
		ci.name = "Mithraic";
		ci.miningSpeed = 400;
		ci.miningSpeedPercent = 400;
		ci.miningFortune = 0;
		ci.miningXPBonus = 900;
		
		items.put("MITHRAIC", ci.getBukkitItem());
		
		ci.name = "Catalonia";
		ci.miningSpeed = 100;
		ci.miningSpeedPercent = 400;
		ci.miningFortune = -100;
		ci.miningXPBonus = 12000;
		
		items.put("CATALONIA", ci.getBukkitItem());
		
		ci.name = "Akudur";
		ci.miningSpeed = 900;
		ci.miningSpeedPercent = 600;
		ci.miningFortune = 25;
		ci.miningXPBonus = 0;
		
		items.put("AKUDUR", ci.getBukkitItem());
		
		ci.name = "Outlook";
		ci.miningSpeed = 1;
		ci.miningSpeedPercent = 390000;
		ci.miningXPBonus = 35;
		
		items.put("OUTLOOK", ci.getBukkitItem());
	}	
	public void init() {
		initStandardPickaxes();
		initDrops();
		initTokens();
		initSpecialPickaxes();
	}
}
