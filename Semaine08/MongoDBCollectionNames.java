package semaine09;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoException;


public class MongoDBCollectionNames {
    public static void main(String[] args) {
        MongoClient mongoClient = null;
        MongoDatabase mongoDatabase = null;
        String database = null;

        try {

            // Database name
            database = "semaine04";

            // Connect to MongoDB server
            mongoClient = new MongoClient("localhost", 27017);

            // Connect to your database
            mongoDatabase = mongoClient.getDatabase(database);

            // Print message
            System.out.println("Connect to database successfully ");

            /*** Print collection names */
            System.out.println("List of collections:");

            for (String collectionName : mongoDatabase.listCollectionNames()) {
                System.out.println(collectionName);
            }

        } catch (MongoException e) {
            e.printStackTrace();
        } finally {
            if(mongoClient!=null)
                mongoClient.close();
        }
    }
 
}
