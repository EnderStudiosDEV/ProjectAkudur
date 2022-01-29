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
        inv.setItem(10, createGuiItem(Material.ENCHANTED_BOOK, 
        		"§bEfficiency " + HashMaps.efficiency.get(uuid), 
        		"§7Gain §625 Mining Speed §7 per level.",
        		"",
        		"§7This tier: §6+" + (25 * HashMaps.efficiency.get(uuid)) + " §6Mining Speed",
        		"§7Next tier: §6+" + (25 * HashMaps.efficiency.get(uuid) + 25) + " §6Mining Speed",
        		"",
        		"§7Cost: §a" + uu.eff1Cost(HashMaps.efficiency.get(uuid).intValue()),
        		"§eClick to upgrade!"));
        inv.setItem(11, createGuiItem(Material.ENCHANTED_BOOK, 
        		"§bEfficiency% " + HashMaps.efficiency2.get(uuid), 
        		"§7Gain §65% Mining Speed §7 per level.",
        		"",
        		"§7This tier: §6+" + (5 * HashMaps.efficiency.get(uuid)) + "§6% Mining Speed",
        		"§7Next tier: §6+" + (5 * HashMaps.efficiency.get(uuid) + 5) + "§6% Mining Speed",
        		"",
        		"§7Cost: §a" + uu.eff2Cost(HashMaps.efficiency2.get(uuid).intValue()),
        		"§eClick to upgrade!"));
        
        
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
            UpgradeUtils uu = new UpgradeUtils();
            String uuid = ((Player) e.getWhoClicked()).getUniqueId().toString();
            if(e.getSlot() == 10) {
            	if(HashMaps.coins.get(uuid) > uu.eff1Cost(HashMaps.efficiency.get(uuid).intValue())) {
            		HashMaps.coins.put(uuid, 
            				HashMaps.coins.get(uuid) - uu.eff1Cost(HashMaps.efficiency.get(uuid).intValue()));
            		HashMaps.efficiency.put(uuid, HashMaps.efficiency.get(uuid) + 1);
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
}
