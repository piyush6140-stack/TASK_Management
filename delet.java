import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class delet {
    public static void docdel(String name)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("piyush", "project1",
                "12345".toCharArray());
        System.out.println("Connected to the database successfully");

        // Accessing the database
        MongoDatabase database = mongo.getDatabase("project1");
        MongoCollection<Document> collection =       database.getCollection("Task");
        System.out.println(collection.deleteOne(Filters.eq("TASK_TITLE", name)));

    }
    public static void dele()
    {
        JFrame frame = new JFrame("API");

        JButton back;
        back=new JButton("Back");
        back.setBounds(10,10,100,50);
        frame.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Menu x=new Menu();
                x.me();
            }
        });

        JLabel ntask,dat;
        ntask=new JLabel("Enter Task");
        ntask.setBounds(50,100,150,50);
        frame.add(ntask);

        JTextField t1;
        t1=new JTextField("");
        t1.setBounds(150,100,150,50);
        frame.add(t1);

        JButton delet=new JButton ("Delete");
        delet.setBounds(100,170,150,50);
        frame.add(delet);
        delet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                docdel(t1.getText());
                JOptionPane.showMessageDialog(frame,"Successfully Deleted.","Alert",JOptionPane.WARNING_MESSAGE);
            }
        });

        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String [] args)
    {
        dele();
        //docdel("Task9");
    }

}
