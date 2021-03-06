package semaine09;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.Iterator;
import com.mongodb.client.FindIterable;

/*** Cette classe permet d'inserer des documents dans la collection myCollection 
    de la Database semaine07 ***/

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
            
            // Creating a new document
            Document document = new Document("title", "MongoDB")
                    .append("id", 1)
                    .append("description", "database")
                    .append("likes", 100)
                    .append("url", "http://www.mywebsite.com/mongodb/")
                    .append("by", "College Boreal");
            
            //Inserting a new document into myCollection
            collection.insertOne(document);
            System.out.println("Document inserted successfully");
            
            // Getting the iterable object
            FindIterable<Document> iterDoc = collection.find();
            
            // Getting the iterator
            Iterator iterateur = iterDoc.iterator();
             
            // Printing all documents
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


