package main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import commands.ItemCommand;
import commands.RedeemCommand;
import events.GenericEvents;
import inventories.HelpCore;
import loops.Core;
import mining.MiningHandler;

public class Main extends JavaPlugin {

	public static Main instance;
	
	// This function is called whenever the plugin is enabled
	@Override
	public void onEnable() {
		// Define an instance of main
		instance = this;
		// Sends some debug info to the console.
		Bukkit.getLogger().info("Loading Project Akudur...");
		
		// Initialize commands and events
		createListener(new GenericEvents());
		createListener(new MiningHandler());
		
		createCommand(new RedeemCommand(), "redeem");
		createCommand(new ItemCommand(), "ci");
		
		createListener(new HelpCore());
		
		Core c = new Core();
		c.callLoop();
	}
	
	
	// Same as onEnable but for when it's disabled
	@Override
	public void onDisable() {
		// Sends some debug info to the console.
		Bukkit.getLogger().info("Unloading Project Akudur...");
	}
	
	public void createListener(Listener listener) {
		Bukkit.getPluginManager().registerEvents(listener, Main.instance);
	}
	public void createCommand(CommandExecutor cmd, String t) {
		getCommand(t).setExecutor(cmd);
	}
	
}
