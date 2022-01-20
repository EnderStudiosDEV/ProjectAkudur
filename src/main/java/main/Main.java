package main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		Bukkit.getLogger().info("Loading Project Akudur...");
	}
	
	@Override
	public void onDisable() {
		Bukkit.getLogger().info("Unloading Project Akudur...");
	}
}
