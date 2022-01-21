package main;

import java.util.logging.Logger;
import java.util.logging.Level;

import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

import commands.RedeemCommand;
import events.GenericEvents;
import loops.Core;

public class Main extends JavaPlugin {

	public static Main instance;
	
	// This function is called whenever the plugin is enabled
	@Override
	public void onEnable() {
		// Properties of MongoDB
		System.setProperty("DEBUG.GO", "true");
		System.setProperty("DB.TRACE", "true");
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.WARNING);
		connect();
		
		
		// Define an instance of main
		instance = this;
		// Sends some debug info to the console.
		Bukkit.getLogger().info("Loading Project Akudur...");
		
		// Initialize commands and events
		createListener(new GenericEvents());
		
		createCommand(new RedeemCommand());
		
		
		Core c = new Core();
		c.callLoop();
	}
	
	public void connect() {
		ConnectionString connectionString = new ConnectionString("mongodb+srv://endistic:k8gSHXxxFu6cm782@playerdata.wkal0.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
		MongoClientSettings settings = MongoClientSettings.builder()
				      .applyConnectionString(connectionString)
				      .build();
		MongoClient mongoClient = MongoClients.create(settings);
		com.mongodb.client.MongoDatabase database = mongoClient.getDatabase("playerdata");
		MongoCollection<Document> collection = database.getCollection("playerdata");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Connected to MongoDB!");
		
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
	public void createCommand(CommandExecutor cmd) {
		getCommand("redeem").setExecutor(cmd);
	}
	
}
