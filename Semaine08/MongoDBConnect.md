``` package semaine09;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoException;

/*** La classe  MongoDBConnect permet de connecter Java a MongoDB tout en gerant les exceptions
     et afficher toutes les bases de donnees se trouvant dans le server de mongo ***/

public class MongoDBConnect {
    public static void main(String[] args) {
        MongoClient mongoClient = null;
        try {
            /*** Connect to a server ***/ 
            mongoClient = new MongoClient( "127.0.0.1" , 27017 ); /* on peut aussi remplacer 127.0.0.1 par localhost port par defaut de mongoDB*/
 
            System.out.println("Connected to MongoDB!");
            
            /*** Print Database names ***/
            
            for (String databaseName : mongoClient.listDatabaseNames()) {
                System.out.println("List of databases:");
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
```
