package main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	// This function is called whenever the plugin is enabled
	@Override
	public void onEnable() {
		// Sends some debug info to the console.
		Bukkit.getLogger().info("Loading Project Akudur...");
	}
	
	// Same as onEnable but for when it's disabled
	@Override
	public void onDisable() {
		// Sends some debug info to the console.
		Bukkit.getLogger().info("Unloading Project Akudur...");
	}
}
