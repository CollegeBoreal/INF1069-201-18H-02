package project03;

import java.util.Iterator;
import java.util.Set;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

public class project {
    static MongoClient mongoClient = null;
    static MongoDatabase mongoDatabase = null;
    static  Set<String> keySet = null;

    public static void main(String[] args) {
        // Connect to MongoDB Server
        connect();

        // Exemple 1
        //exemple1();

        //  Exemple 2
        //exemple2();

        //  Exemple 3
       // exemple3();

    }

    /**
     * This method connect to MongoDB server and initialize MongoClient.
     */
    public static void connect() {
        try {

            // To connect to MongoDB server
            mongoClient = new MongoClient("localhost", 27017);

            // Now connect to your databases
            mongoDatabase = mongoClient.getDatabase("project");

            // Print message
            System.out.println("Message : get successfully connected to MongoDB !");

            // close the connection
            //mongoClient.close();
        } catch(Exception e) {
            // Print errors
            System.err.println(e.toString());
        }
    }

// Ajoute le volleyball a tous les utilisateurs dont le pays est Canada

    public static void exemple1() {

        try {
            // Get the collection
            MongoCollection collection = mongoDatabase.getCollection("mycollection");
            // Create query
            Document query = new Document("Country", "Canada");

            // Create update document
            Document document = new Document();
            document.append("$set", new Document("Hobbies",
                    new Document("sports", "['soccer','basketball','volleyball']")
                            .append("movies","['seven pounds','time out']")));

            //update document
            UpdateResult updateResult = collection.updateOne(query, document);

            // Affiche tous les documents
            FindIterable<Document> iterable = collection.find();
            for (Document doc : iterable) {
                keySet = doc.keySet();
                Iterator<String> iterator = keySet.iterator();

                while (iterator.hasNext()) {
                    String documentKey = iterator.next();
                    System.out.println(documentKey + ":\t" + doc.get(documentKey));
                }

            }
        } catch(Exception e) {
                // Print errors
                System.err.println(e.toString());
            }
        }


        // Supprime tous les sports de pierre

        public static void exemple2() {

            try {
                MongoCollection collection = mongoDatabase.getCollection("mycollection");

                // Create query
                Document query = new Document("Username", "Pierre");

                // Create update document
                Document document = new Document();
                document.append("$unset",  new Document("Hobbies.sports", " "));

                // Update
                UpdateResult updateResult = collection.updateOne(query, document);

                // Print results

                System.out.println("Update Result: \n" + updateResult.toString());

                FindIterable<Document> iterable = collection.find();
                for (Document doc : iterable) {
                    keySet = doc.keySet();
                    Iterator<String> iterator = keySet.iterator();

                    while (iterator.hasNext()) {
                        String documentKey = iterator.next();
                        System.out.println(documentKey + ":\t" + doc.get(documentKey));
                    }

                }
            } catch(Exception e) {
                // Print errors
                System.err.println(e.toString());
            }
        }


// Supprime tous les documents d'une collection


        public static void exemple3() {

            try {
                MongoCollection collection = mongoDatabase.getCollection("mycollection");

                // Delete many documents
                DeleteResult deleteDoc = collection.deleteMany(new Document());

                // Print Number of documents deleted
                System.out.println("Number of documents deleted: "+ deleteDoc.getDeletedCount());

            } catch(Exception e) {
                // Print errors
                System.err.println(e.toString());
            }
        }



    }
