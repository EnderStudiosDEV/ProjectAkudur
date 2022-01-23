package items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tr7zw.nbtapi.NBTItem;
import main.Utils;

public class CustomItem {

	// Essential Stats
	public String name;
	public Rarity rarity = Rarity.COMMON;
	public Material mat;
	public ItemType type = ItemType.TOOL;
	public String id;
	
	// Mining Stats
	public int miningSpeed = 0;
	public int miningFortune = 0;
	public int miningXPBonus = 0;
	public int baseBreakingPower = 0;
	
	// Bonus Stats
	public int bonusBreakingPower = 0;
	public int miningSpeedPercent = 0;
	public int miningFortunePercent = 0;
	
	public ItemStack getBukkitItem() {
		ItemStack i = new ItemStack(mat);
		ItemMeta meta = i.getItemMeta();
		meta.setLore(getLore());
		meta.setDisplayName(rarity.code + "" + name);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);
		i.setItemMeta(meta);
		NBTItem nbti = getNBTItem(i);
		i = nbti.getItem();
		
		return i;
		
	}
	
	
	public List<String> getLore() {
		Utils utils = new Utils();
		List<String> lore = new ArrayList<String>();
		if(type == ItemType.TOOL) {
			lore.add("§7" + baseBreakingPower + " Breaking Power");
			lore.add("");
			if(miningSpeed > 0) {
				lore.add("§a+" + utils.format(miningSpeed) + " §7Mining Speed");
			} else if (miningSpeed < 0) {
				lore.add("§c-" + utils.format(miningSpeed) + " §7Mining Speed");
			}
			if(miningFortune > 0) {
				lore.add("§a+" + utils.format(miningFortune) + " §7Mining Fortune");
			} else if (miningFortune < 0) {
				lore.add("§c-" + utils.format(miningFortune) + " §7Mining Fortune");
			}
			if(miningXPBonus > 0) {
				lore.add("§a+" + miningXPBonus + "§a% §7XP Bonus");
			} else if (miningXPBonus < 0) {
				lore.add("§c-" + miningXPBonus + "§c% §7XP Bonus");
			}
			lore.add("");
			if(bonusBreakingPower > 0) {
				lore.add("§a+" + bonusBreakingPower + " §atier §7Breaking Power");
			} else if (bonusBreakingPower < 0) {
				lore.add("§c-" + bonusBreakingPower + " §ctier §7Breaking Power");
			}
			if(miningSpeedPercent > 0) {
				lore.add("§a+" + utils.format(miningSpeedPercent) + "§a% §7Mining Speed");
			} else if (miningSpeedPercent < 0) {
				lore.add("§c-" + utils.format(miningSpeedPercent) + "§c% §7Mining Speed");
			}
			if(miningFortunePercent > 0) {
				lore.add("§a+" + utils.format(miningFortunePercent) + "§a% §7Mining Fortune");
			} else if (miningFortunePercent < 0) {
				lore.add("§c-" + utils.format(miningFortunePercent) + "§c% §7Mining Fortune");
			}
		}
		lore.add(rarity.desc);
		return lore;
	}
	
	public NBTItem getNBTItem(ItemStack i) {
		NBTItem nbti = new NBTItem(i);
		
		nbti.setInteger("miningSpeed", miningSpeed * ((miningSpeedPercent + 100) / 100));
		nbti.setInteger("miningFortune", miningFortune * ((miningFortunePercent + 100) / 100));
		nbti.setInteger("breakingPower", baseBreakingPower + bonusBreakingPower);
		nbti.setInteger("miningXPBonus", miningXPBonus);
		return nbti;
	}
	
	public void reg() {
		if(type == ItemType.TOOL) {
			mat = Material.WOODEN_PICKAXE;
		}
	}
	
}
