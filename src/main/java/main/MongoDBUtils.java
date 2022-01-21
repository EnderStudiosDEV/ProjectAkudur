package main;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

import hashmaps.PlayerData;
public class MongoDBUtils {

	public void storePlayerData(String uuid, PlayerData dat) {
		// Mongo Database Code
        
		ConnectionString connectionString = new ConnectionString("mongodb+srv://endistic:k8gSHXxxFu6cm782@playerdata.wkal0.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
		MongoClientSettings settings = MongoClientSettings.builder()
				      .applyConnectionString(connectionString)
				      .build();
		MongoClient mongoClient = MongoClients.create(settings);
		com.mongodb.client.MongoDatabase database = mongoClient.getDatabase("playerdata");
				
		MongoCollection<PlayerData> collection = database.getCollection("playerdata", PlayerData.class);
		collection.insertOne(dat);
	}
	
	public void updatePlayerData(String uuid, PlayerData dat) {
		// Mongo Database Code
        
		ConnectionString connectionString = new ConnectionString("mongodb+srv://endistic:k8gSHXxxFu6cm782@playerdata.wkal0.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
		MongoClientSettings settings = MongoClientSettings.builder()
				      .applyConnectionString(connectionString)
				      .build();
		MongoClient mongoClient = MongoClients.create(settings);
		com.mongodb.client.MongoDatabase database = mongoClient.getDatabase("playerdata");
				
		// MongoCollection<PlayerData> collection = database.getCollection("playerdata", PlayerData.class);
	
	}
}
