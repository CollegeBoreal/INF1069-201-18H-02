package semaine09;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.Iterator;
import com.mongodb.client.FindIterable;
public class MongoDBInsertDocument {
    public static void main(String[] args) {
        MongoClient mongoClient=null;
        try {

            // Creating a Mongo client
            mongoClient = new MongoClient( "localhost" , 27017 );


            System.out.println("Connected to the database successfully");

            // Accessing the database
            MongoDatabase database = mongoClient.getDatabase("semaine07");

            // Retrieving a collection
            MongoCollection<Document> collection = database.getCollection("myCollection");
            System.out.println("Collection myCollection selected successfully");

            Document document = new Document("title", "MongoDB")
                    .append("id", 1)
                    .append("description", "database")
                    .append("likes", 100)
                    .append("url", "http://www.mywebsite.com/mongodb/")
                    .append("by", "College Boreal");
            collection.insertOne(document);
            System.out.println("Document inserted successfully");
            
            // Getting the iterable object
            FindIterable<Document> iterDoc = collection.find();
            // Getting the iterator
            Iterator iterateur = iterDoc.iterator();
             
            // Displaying all documents
            while (iterateur.hasNext()) {
                System.out.println(iterateur.next());
            }
        } catch (MongoException e) {
            e.printStackTrace();
        } finally {
            if(mongoClient!=null)
                mongoClient.close();
        }
    }

}


