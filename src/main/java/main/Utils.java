package main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Utils {

	public void createListener(Listener listener) {
		Bukkit.getPluginManager().registerEvents(listener, Main.instance);
	}
	public void createCommand(CommandExecutor cmd) {
		Main.instance.getCommand("redeem").setExecutor(cmd);
	}
}
