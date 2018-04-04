
```
package semaine09;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoException;

public class MongoDBConnect {
    public static void main(String[] args) {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( "127.0.0.1" , 27017 ); /* localhost a la place de 127.0.0.1 port par defaut de mongoDB*/
 
            System.out.println("Connected to MongoDB!");
            
            System.out.println("List of databases:");


            for (String databaseName : mongoClient.listDatabaseNames()) {

                System.out.println("databaseName :" databaseName);

            }
            
        } catch (MongoException e) {
            e.printStackTrace();
        } finally {
            if(mongoClient!=null)
                mongoClient.close();
        }
    }
 
}

http://www.mkyong.com/mongodb/java-mongodb-hello-world-example/

http://www.codejava.net/java-se/jdbc/java-connecting-to-mongodb-database-examples
