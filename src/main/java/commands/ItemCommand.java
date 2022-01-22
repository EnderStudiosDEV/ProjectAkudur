package commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import items.ItemDatabase;

public class ItemCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("ci")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(!p.isOp()) return true;
				
				ItemDatabase dab = new ItemDatabase();
				dab.initStandardPickaxes();
				dab.initDrops();
				dab.initTokens();
				HashMap<String, ItemStack> db = dab.items;
				
				if(args[0] != null) {
					p.getInventory().addItem(db.get(args[0]));
				} else {
					p.sendMessage("Please specify an ID!");
				}
				
			}
			return true;
		}
		return false;
	}

}
