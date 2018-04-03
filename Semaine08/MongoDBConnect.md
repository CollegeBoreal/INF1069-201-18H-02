```
package semaine09;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnect {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
     
        try {
          
            // Connect to MongoDB server
           MongoClient mongoClient = new MongoClient("localhost", 27017);

            // Connect to your database
            MongoDatabase mongoDatabase = mongoClient.getDatabase("semaine04");

            // Print message
            System.out.println("Connect to database successfully.");

            /*** Print list of databases from the server. */
            System.out.println("List of databases:");

            for (String databaseName : mongoClient.listDatabaseNames()) {
                System.out.println(databaseName);
            }

            // close the connection
            mongoClient.close();
        } catch(Exception e) {
            // Print errors
            System.err.println(e.toString());
        }
    }
}
```

http://www.mkyong.com/mongodb/java-mongodb-hello-world-example/
