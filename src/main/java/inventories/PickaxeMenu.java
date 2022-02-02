package inventories;

import java.util.Arrays;
import java.util.List;

import hashmaps.HashMaps;
import upgrades.UpgradeUtils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PickaxeMenu implements Listener {
    
	public Inventory inv;
    public PickaxeMenu(Player p) {
    	if(p == null) {
    		return;
    	}
    	Inventory localInv = Bukkit.createInventory((InventoryHolder)null, 36, "Pickaxe Menu");

    	localInv = initializeItems(localInv, p);
    	inv = localInv;
    }
    
    public Inventory initializeItems(Inventory inv, Player p) {
        for (int i = 0; i < 36; ++i) {
            inv.setItem(i, createGuiItem(Material.BLACK_STAINED_GLASS_PANE, "§b", ""));
        }
        UpgradeUtils uu = new UpgradeUtils();
       
        String uuid = p.getUniqueId().toString();
        long lvl = HashMaps.level.get(uuid);
        inv.setItem(10, createGuiItem(Material.ENCHANTED_BOOK, 
        		"§bEfficiency " + HashMaps.efficiency.get(uuid), 
        		"§7Gain §625 Mining Speed §7 per level.",
        		"",
        		"§7This tier: §6+" + (25 * (HashMaps.efficiency.get(uuid) - 1)) + " §6Mining Speed",
        		"§7Next tier: §6+" + (25 * (HashMaps.efficiency.get(uuid))) + " §6Mining Speed",
        		"",
        		"§7Cost: §a" + retMaxed(uu.eff1Cost(HashMaps.efficiency.get(uuid).intValue())),
        		"§eClick to upgrade!"));
        
        inv.setItem(12, createGuiItem(Material.BARRIER,
        		"§cNot unlocked!",
        		"§7This upgrade is unlocked at §bLevel 3."));
        inv.setItem(13, createGuiItem(Material.BARRIER,
        		"§cNot unlocked!",
        		"§7This upgrade is unlocked at §bLevel 4."));
        inv.setItem(14, createGuiItem(Material.BARRIER,
        		"§cNot unlocked!",
        		"§7This upgrade is unlocked at §bLevel 6."));
        inv.setItem(15, createGuiItem(Material.BARRIER,
        		"§cNot unlocked!",
        		"§7This upgrade is unlocked at §bLevel 7."));
        inv.setItem(16, createGuiItem(Material.BARRIER,
        		"§cNot unlocked!",
        		"§7This upgrade is unlocked at §bLevel 7."));
        
        if(lvl >= 1) {
        	inv.setItem(11, createGuiItem(Material.ENCHANTED_BOOK, 
            		"§bFortune " + HashMaps.fortune.get(uuid), 
            		"§7Gain §610 Mining Fortune§7 per level.",
            		"",
            		"§7This tier: §6+" + (10 * (HashMaps.fortune.get(uuid) - 1)) + "§6 Mining Fortune",
            		"§7Next tier: §6+" + (10 * HashMaps.fortune.get(uuid)) + "§6 Mining Fortune",
            		"",
            		"§7Cost: §a" + retMaxed(uu.fortune1Cost(HashMaps.fortune.get(uuid).intValue())),
            		"§eClick to upgrade!"));
        }
        if(lvl >= 2) {
        	inv.setItem(12, createGuiItem(Material.ENCHANTED_BOOK, 
            		"§bEfficienct Miner " + HashMaps.efficientMiner.get(uuid), 
            		"§7Gain a §61% chance§7 to instantly break a", 
            		"§7block per level.",
            		"",
            		"§7This tier: §6+" + (10 * (HashMaps.efficientMiner.get(uuid) - 1)) + "§6% chance",
            		"§7Next tier: §6+" + (1 * HashMaps.efficientMiner.get(uuid)) + "§6% chance",
            		"",
            		"§7Cost: §a" + retMaxed(uu.fortune1Cost(HashMaps.efficientMiner.get(uuid).intValue())),
            		"§eClick to upgrade!"));
        }
        if(lvl >= 3) {
        	inv.setItem(13, createGuiItem(Material.ENCHANTED_BOOK, 
            		"§bEfficiency% " + HashMaps.efficiency2.get(uuid), 
            		"§7Gain §65% Mining Speed §7 per level.",
            		"",
            		"§7This tier: §6+" + (10 * (HashMaps.efficiency2.get(uuid) - 1)) + "§6% Mining Speed",
            		"§7Next tier: §6+" + (10 * HashMaps.efficiency2.get(uuid)) + "§6% Mining Speed",
            		"",
            		"§7Cost: §a" + retMaxed(uu.eff2Cost(HashMaps.efficiency2.get(uuid).intValue())),
            		"§eClick to upgrade!"));
        }
        if(lvl >= 4) {
        	inv.setItem(14, createGuiItem(Material.ENCHANTED_BOOK, 
            		"§bXP Boost " + HashMaps.xpBonus.get(uuid), 
            		"§7Gain §610% XP Bonus §7per level.",
            		"",
            		"§7This tier: §6+" + (15 * (HashMaps.xpBonus.get(uuid) - 1)) + "§6% XP Bonus",
            		"§7Next tier: §6+" + (15 * HashMaps.xpBonus.get(uuid)) + "§6% XP Bonus",
            		"",
            		"§7Cost: §a" + retMaxed(uu.xpBoostCost(HashMaps.xpBonus.get(uuid).intValue())),
            		"§eClick to upgrade!"));
        }
        if(lvl >= 6) {
        	 inv.setItem(15, createGuiItem(Material.ENCHANTED_BOOK, 
             		"§bHaste " + HashMaps.haste.get(uuid), 
             		"§7Gain §6+1 Haste Tier §7per level.",
             		"",
             		"§7This tier: §6+" + (HashMaps.haste.get(uuid) - 1) + "§6Haste Tier",
             		"§7Next tier: §6+" + (HashMaps.haste.get(uuid)) + "§6Haste Tier",
             		"",
             		"§7Cost: §a" + retMaxed(uu.hasteCost(HashMaps.haste.get(uuid).intValue())),
             		"§eClick to upgrade!"));
        }
        if(lvl >= 7) {
        	inv.setItem(16, createGuiItem(Material.ENCHANTED_BOOK, 
             		"§bDebris Summoner " + HashMaps.debrisSummoner.get(uuid), 
             		"§7Have an increase chance of spawning Ancient Debris.",
             		"",
             		"§7This tier: §6+" + (HashMaps.debrisSummoner.get(uuid) - 1) * 5 + "§6% Chance",
             		"§7Next tier: §6+" + (HashMaps.debrisSummoner.get(uuid)) * 5 + "§6% Chance",
             		"",
             		"§7Cost: §a" + retMaxed(uu.debrisBoostCost(HashMaps.debrisSummoner.get(uuid).intValue())),
             		"§eClick to upgrade!"));
        	inv.setItem(17, createGuiItem(Material.ENCHANTED_BOOK, 
             		"§bEnder Summoner " + HashMaps.haste.get(uuid), 
             		"§7Have an increase chance of spawning Ufili and more.",
             		"",
             		"§7This tier: §6+" + (HashMaps.debrisSummoner.get(uuid) - 1) * 5 + "§6% Chance",
             		"§7Next tier: §6+" + (HashMaps.debrisSummoner.get(uuid)) * 5 + "§6% Chance",
             		"",
             		"§7Cost: §a" + retMaxed(uu.enderBoostCost(HashMaps.debrisSummoner.get(uuid).intValue())),
             		"§eClick to upgrade!"));
        }
        
       
        
        
        return inv;
    }
    
    
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore((List<String>)Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
    
    public void openInventory(final HumanEntity ent) {
    	PickaxeMenu menu = new PickaxeMenu((Player) ent);
    	ent.openInventory(menu.inv);
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getWhoClicked().getOpenInventory().getTitle().equals("Pickaxe Menu")) {
            e.setCancelled(true);
            if(e.getCurrentItem().getType() != Material.ENCHANTED_BOOK) return;
            UpgradeUtils uu = new UpgradeUtils();
            String uuid = ((Player) e.getWhoClicked()).getUniqueId().toString();
            if(e.getSlot() == 10) {
            	if(HashMaps.coins.get(uuid) >= uu.eff1Cost(HashMaps.efficiency.get(uuid).intValue())) {
            		HashMaps.coins.put(uuid, 
            				HashMaps.coins.get(uuid) - uu.eff1Cost(HashMaps.efficiency.get(uuid).intValue()));
            		HashMaps.efficiency.put(uuid, HashMaps.efficiency.get(uuid) + 1);
            	}
            }
            if(e.getSlot() == 11) {
            	if(HashMaps.coins.get(uuid) >= uu.efficientMinerCost(HashMaps.efficientMiner.get(uuid).intValue())) {
            		HashMaps.coins.put(uuid, 
            				HashMaps.coins.get(uuid) - uu.efficientMinerCost(HashMaps.efficientMiner.get(uuid).intValue()));
            		HashMaps.efficientMiner.put(uuid, HashMaps.efficientMiner.get(uuid) + 1);
            	}
            }
            if(e.getSlot() == 12) {
            	if(HashMaps.coins.get(uuid) >= uu.fortune1Cost(HashMaps.fortune.get(uuid).intValue())) {
            		HashMaps.coins.put(uuid, 
            				HashMaps.coins.get(uuid) - uu.fortune1Cost(HashMaps.fortune.get(uuid).intValue()));
            		HashMaps.fortune.put(uuid, HashMaps.fortune.get(uuid) + 1);
            	}
            }
            if(e.getSlot() == 13) {
            	if(HashMaps.coins.get(uuid) >= uu.eff2Cost(HashMaps.efficiency2.get(uuid).intValue())) {
            		HashMaps.coins.put(uuid, 
            				HashMaps.coins.get(uuid) - uu.eff2Cost(HashMaps.efficiency2.get(uuid).intValue()));
            		HashMaps.efficiency2.put(uuid, HashMaps.efficiency2.get(uuid) + 1);
            	}
            }
            
            if(e.getSlot() == 14) {
            	if(HashMaps.coins.get(uuid) >= uu.xpBoostCost(HashMaps.xpBonus.get(uuid).intValue())) {
            		HashMaps.coins.put(uuid, 
            				HashMaps.coins.get(uuid) - uu.xpBoostCost(HashMaps.xpBonus.get(uuid).intValue()));
            		HashMaps.xpBonus.put(uuid, HashMaps.xpBonus.get(uuid) + 1);
            	}
            }
            if(e.getSlot() == 15) {
            	if(HashMaps.coins.get(uuid) >= uu.hasteCost(HashMaps.haste.get(uuid).intValue())) {
            		HashMaps.coins.put(uuid, 
            				HashMaps.coins.get(uuid) - uu.hasteCost(HashMaps.haste.get(uuid).intValue()));
            		HashMaps.haste.put(uuid, HashMaps.haste.get(uuid) + 1);
            	}
            }
            if(e.getSlot() == 16) {
            	if(HashMaps.coins.get(uuid) >= uu.debrisBoostCost(HashMaps.debrisSummoner.get(uuid).intValue())) {
            		HashMaps.coins.put(uuid, 
            				HashMaps.coins.get(uuid) - uu.debrisBoostCost(HashMaps.debrisSummoner.get(uuid).intValue()));
            		HashMaps.debrisSummoner.put(uuid, HashMaps.debrisSummoner.get(uuid) + 1);
            	}
            }
            if(e.getSlot() == 17) {
            	if(HashMaps.coins.get(uuid) >= uu.enderBoostCost(HashMaps.haste.get(uuid).intValue())) {
            		HashMaps.coins.put(uuid, 
            				HashMaps.coins.get(uuid) - uu.enderBoostCost(HashMaps.enderSummoner.get(uuid).intValue()));
            		HashMaps.enderSummoner.put(uuid, HashMaps.enderSummoner.get(uuid) + 1);
            	}
            }
            
            PickaxeMenu menu = new PickaxeMenu((Player) e.getWhoClicked());
            menu.openInventory((Player) e.getWhoClicked());
        }
    }
    
    @EventHandler
    public void onInventoryDrag(final InventoryDragEvent e) {
        if (e.getWhoClicked().getOpenInventory().getTitle().equals("Pickaxe Menu")) {
            e.setCancelled(true);
        }
    }
    
    public String retMaxed(Long a) {
    	if(a == Long.MAX_VALUE) {
    		return "§b§lMAXED!";
    	} else {
    		return a.toString();
    	}
    	
    }
}
