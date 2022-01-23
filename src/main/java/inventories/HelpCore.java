package inventories;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HelpCore implements Listener {
	public static Inventory inv;
	public ItemStack blockStrength;
    public ItemStack commands;
    public ItemStack levelling;
    
    public HelpCore() {
    	inv = Bukkit.createInventory((InventoryHolder)null, 54, "Help");
    	blockStrength = createGuiItem(Material.STONE, 
    			"Block Strength",
    			"",
    			"§7Each block has a different amount", 
    			"§7of hardness. You can mine harder blocks",
    			"§7with higher Mining Speed and Breaking Power.",
    			"", 
    			"§eClick to view!");
    	
    	commands = createGuiItem(Material.COMMAND_BLOCK, 
    			"Commands",
    			"",
    			"§7There is a variety of commands you can use,", 
    			"§7such as /help, /redeem, etc.",
    			"", 
    			"§eClick to view!");
    	
    	levelling = createGuiItem(Material.EXPERIENCE_BOTTLE, 
    			"Levelling",
    			"",
    			"§7You can level up by mining, completing Comissions", 
    			"§7and exploring new islands.");
        initializeItems();
    }
    
    public void initializeItems() {
        for (int i = 0; i < 36; ++i) {
            inv.setItem(i, createGuiItem(Material.BLACK_STAINED_GLASS_PANE, "§b", new String[0]));
        }

        
    }
    
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore((List<String>)Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
    
    public static void openInventory(final HumanEntity ent) {
    	ent.openInventory(HelpCore.inv);
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getWhoClicked().getOpenInventory().getTitle().equals("Help")) {
            e.setCancelled(true);
            
        }
    }
    
    @EventHandler
    public void onInventoryDrag(final InventoryDragEvent e) {
        if (e.getWhoClicked().getOpenInventory().getTitle().equals("Etherwarp Menu")) {
            e.setCancelled(true);
        }
    }
}
