
package semaine09;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoException;

/*** La classe  MongoDBConnect permet de connecter Java a MongoDB tout en gerant les exceptions ***/

public class MongoDBConnect {
    public static void main(String[] args) {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( "127.0.0.1" , 27017 ); /* localhost a la place de 127.0.0.1 port par defaut de mongoDB*/
 
            System.out.println("Connected to MongoDB!");
            
            System.out.println("List of databases:");


            for (String databaseName : mongoClient.listDatabaseNames()) {

                System.out.println( databaseName);

            }
            
        } catch (MongoException e) {
            e.printStackTrace();
        } finally {
            if(mongoClient!=null)
                mongoClient.close();
        }
    }
 
}

