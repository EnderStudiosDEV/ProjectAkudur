package main;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

public class DatabaseHandler {
	public DatabaseHandler(int i) {
		ConnectionString connectionString = new ConnectionString("mongodb+srv://endistic:k8gSHXxxFu6cm782@playerdata.wkal0.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
		MongoClientSettings settings = MongoClientSettings.builder()
				      .applyConnectionString(connectionString)
				      .build();
		MongoClient mongoClient = MongoClients.create(settings);
		com.mongodb.client.MongoDatabase database = mongoClient.getDatabase("playerdata");
		MongoCollection<Document> collection = database.getCollection("playerdata");
		
    }
}
