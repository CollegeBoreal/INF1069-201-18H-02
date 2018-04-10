package semaine09;

import java.util.Iterator;
import java.util.Set;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

public class SolutionsSemaine02 {
    static MongoClient mongoClient = null;
    static MongoDatabase mongoDatabase = null;
    static  Set<String> keySet = null;

    public static void main(String[] args) {
        // Connect to MongoDB Server
        connect();

        // Question 1
        //question1();

        // Question 2
        //question2();

        // Question 3
        //question3();

        // Question 4
        //question4();
        
          // Question 5
        //question5();
    }

    /**
     * This method connect to MongoDB server and initialize MongoClient.
     */
    public static void connect() {
        try {

            // To connect to MongDB server
            mongoClient = new MongoClient("localhost", 27017);

            // Now connect to your databases
            mongoDatabase = mongoClient.getDatabase("semaine09");

            // Print message
            System.out.println("Youpi : get connected to MongoDB");

            // close the connection
            //mongoClient.close();
        } catch(Exception e) {
            // Print errors
            System.err.println(e.toString());
        }
    }

    public static void question1() {

        try {
            // Get the collection
           MongoCollection collection = mongoDatabase.getCollection("users");

            // Create the document
           Document document = new Document("username", "Henry");

            // Insert document
            collection.insertOne(document);
            
        } catch(Exception e) {
            // Print errors
            System.err.println(e.toString());
        }
    }

    public static void question2() {
        Document query = null;
        Document document = null;
        MongoCollection collection = null;
        UpdateResult updateResult = null;

        try {
            collection = mongoDatabase.getCollection("users");

            // Create query
            query = new Document("username", "Henry");

            // Create update document
            document = new Document();
            document.append("$set",  new Document("country", "Canada"));

            // Update
            updateResult = collection.updateOne(query, document);

            // Print results
            System.out.println("Update Result: \n" + updateResult.toString());
        } catch(Exception e) {
            // Print errors
            System.err.println(e.toString());
        }
    }

    public static void question3() {
        Document document = null;
        MongoCollection collection = null;

        try {
            // Get the collection
            collection = mongoDatabase.getCollection("users");

            // Create the document
            document = new Document("username", "Marie");
            document.append("country", "Peru");
            document.append("hobbies",
                    new Document("movies", "['Chicago', 'Star Wars', 'X-Men', 'Friday']")
                            .append("sports", "['Baseball', 'Tennis']"));

            // Insert document
            collection.insertOne(document);
          
            FindIterable<Document> iterable = collection.find();
            for (Document document : iterable) {
                 keySet = document.keySet();
                 Iterator<String> iterator = keySet.iterator();

                while (iterator.hasNext()) {
                   String documentKey = iterator.next();
                    System.out.println(
                            documentKey +
                            ":\t" +
                            document.get(documentKey));
                }
            }
            
        } catch(Exception e) {
            // Print errors
            System.err.println(e.toString());
        }
    }

    public static void question4() {
        Document document = null;
        MongoCollection collection = null;

        try {
            // Get the collection
            collection = mongoDatabase.getCollection("users");

            // Create the document
            document = new Document("username", "Paul");
            document.append("city", "Paris");
            document.append("hobbies", new Document("sports", "['Soccer', 'Boxing']"));
            document.append("age", 20);

            // Insert document
            collection.insertOne(document);
        } catch(Exception e) {
            // Print errors
            System.err.println(e.toString());
        }
    }

    public static void question5() {
        Document query = null;
        Document document = null;
        MongoCollection collection = null;
        UpdateResult updateResult = null;

        try {
            collection = mongoDatabase.getCollection("users");

            // Create query
            query = new Document("username", "Paul");

            // Create update document
            document = new Document();
            document.append("$unset",  new Document("age", 1));

            // Update
            updateResult = collection.updateOne(query, document);

            // Print results
            System.out.println("Update Result: \n" + updateResult.toString());
        } catch(Exception e) {
            // Print errors
            System.err.println(e.toString());
        }
    }
}
