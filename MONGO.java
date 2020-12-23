import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MONGO {

    public static void db( String task,String date ) {

        // Creating a Mongo client
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("piyush", "project1",
                "12345".toCharArray());
        System.out.println("Connected to the database successfully");

        // Accessing the database
        MongoDatabase database = mongo.getDatabase("project1");
        MongoCollection<Document> collection =       database.getCollection("Task");
        System.out.println("Credentials ::"+ credential);

        Document x1=new Document();
        x1.append("TASK_TITLE",task);
        x1.append("Due Date",date);
        x1.append("Status",0);
        database.getCollection("Task").insertOne(x1);

    }
    public static void main( String args[] )
    {
        db("Task1","Wed Dec 23 00:00:00 IST 2020");
    }
}