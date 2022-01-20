package main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import commands.RedeemCommand;
import events.GenericEvents;

public class Main extends JavaPlugin {

	static Main instance;
	
	// This function is called whenever the plugin is enabled
	@Override
	public void onEnable() {
		// Define an instance of main
		instance = this;
		// Sends some debug info to the console.
		Bukkit.getLogger().info("Loading Project Akudur...");
		
		// Initialize commands and events
		Bukkit.getPluginManager().registerEvents(new GenericEvents(), this);
		
		getCommand("redeem").setExecutor(new RedeemCommand());
	}
	
	// Same as onEnable but for when it's disabled
	@Override
	public void onDisable() {
		// Sends some debug info to the console.
		Bukkit.getLogger().info("Unloading Project Akudur...");
	}
	
}
