package main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import commands.ItemCommand;
import commands.RedeemCommand;
import events.GenericEvents;
import hashmaps.HashMaps;
import inventories.HelpCore;
import loops.Core;
import mining.MiningHandler;

public class Main extends JavaPlugin {

	public static Main instance;
	public static File file;
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
		
		HashMaps.level = loadHashMap("level");
		HashMaps.xp = loadHashMap("xp");
	}
	
	
	// Same as onEnable but for when it's disabled
	@Override
	public void onDisable() {
		// Sends some debug info to the console.
		Bukkit.getLogger().info("Unloading Project Akudur...");
		saveHashMap(HashMaps.level, "level");
		saveHashMap(HashMaps.xp, "xp");
	}
	
	public void createListener(Listener listener) {
		Bukkit.getPluginManager().registerEvents(listener, Main.instance);
	}
	public void createCommand(CommandExecutor cmd, String t) {
		getCommand(t).setExecutor(cmd);
	}
	
	// Save a HashMap to it's file.
		public static void saveHashMap(HashMap<String, Integer> hm, String hashName) {
			file = new File(Main.instance.getDataFolder(), hashName + ".yml");
			System.out.println(Main.instance.getDataFolder().toString());
			
			if (!file.exists()){
				try {
					file.createNewFile();
					System.out.println("3");
			    } catch (IOException e) {
			    	e.printStackTrace();
			    	System.out.println("4");
			    }
			}
			
			
			YamlConfiguration customFile = YamlConfiguration.loadConfiguration(file);
			// For every KEY the HashMap has...
	    	for (Object key : hm.keySet()) {
	    		// Use the YamlConfiguration to be able to read the new file as a .yml
	    		// and set it as needed, so that each player has their own file.
	    		// Each "player" file will have all of their stats such as XP
	    		// MaxHP, their level, coins, etc.
	    		customFile.set(hashName + "."+key, hm.get(key));
	    		
	    	}
	    	try {
				customFile.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	     
		public static void saveHashMapString(HashMap<String, String> hm, String hashName) {
			file = new File(Main.instance.getDataFolder(), hashName + ".yml");
			System.out.println(Main.instance.getDataFolder().toString());
			
			if (!file.exists()){
				try {
					file.createNewFile();
					System.out.println("3");
			    } catch (IOException e) {
			    	e.printStackTrace();
			    	System.out.println("4");
			    }
			}
			
			
			YamlConfiguration customFile = YamlConfiguration.loadConfiguration(file);
			// For every KEY the HashMap has...
	    	for (Object key : hm.keySet()) {
	    		// Use the YamlConfiguration to be able to read the new file as a .yml
	    		// and set it as needed, so that each player has their own file.
	    		// Each "player" file will have all of their stats such as XP
	    		// MaxHP, their level, coins, etc.
	    		customFile.set(hashName + "."+key, hm.get(key));
	    		
	    	}
	    	try {
				customFile.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
		
	    public static HashMap<String, Integer> loadHashMap(String hashName) {
	    	HashMap<String, Integer> hm = new HashMap<String, Integer>();
	    	
	    	file = new File(Main.instance.getDataFolder(), hashName + ".yml");
	    	
	    	if (!file.exists()){
				try {
					file.createNewFile();
					System.out.println("3");
			    } catch (IOException e) {
			    	e.printStackTrace();
			    	System.out.println("4");
			    }
			}
	    	
	    	YamlConfiguration customFile = YamlConfiguration.loadConfiguration(file);
	    	for (String key : customFile.getConfigurationSection(hashName).getKeys(true)) {
	    		// Load the config from the file, and apply it to the hashmaps needed.
	    		hm.put(key, (Integer) customFile.get(hashName + "."+key));
	    	}
	    	return hm;
	    }
	    
	    public static HashMap<String, String> loadHashMapString(String hashName) {
	    	HashMap<String, String> hm = new HashMap<String, String>();
	    	
	    	file = new File(Main.instance.getDataFolder(), hashName + ".yml");
	    	
	    	if (!file.exists()){
				try {
					file.createNewFile();
					System.out.println("3");
			    } catch (IOException e) {
			    	e.printStackTrace();
			    	System.out.println("4");
			    }
			}
	    	
	    	YamlConfiguration customFile = YamlConfiguration.loadConfiguration(file);
	    	for (String key : customFile.getConfigurationSection(hashName).getKeys(true)) {
	    		// Load the config from the file, and apply it to the hashmaps needed.
	    		hm.put(key, (String) customFile.get(hashName + "."+key));
	    	}
	    	return hm;
	    }
	    
}
