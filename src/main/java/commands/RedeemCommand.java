package commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import items.ItemDatabase;

public class RedeemCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("redeem")) {
			sender.sendMessage("yay! you've run the command!");
			if(sender instanceof Player) {
				Player p = (Player) sender;
				
				ItemDatabase dab = new ItemDatabase();
				dab.initStandardPickaxes();
				HashMap<String, ItemStack> db = dab.items;
				
				p.getInventory().addItem(db.get("MINOR"));
			}
			return true;
		}
		return false;
	}

}
