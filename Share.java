import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Share {
    public static void shar()
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

        JLabel ntask,em;
        JTextField ta,email;

        ntask=new JLabel("Enter Task:");
        ntask.setBounds(50,100,150,50);
        frame.add(ntask);

        ta=new JTextField("");
        ta.setBounds(50,140,150,50);
        frame.add(ta);


        em=new JLabel("Enter email to which you want to share:");
        em.setBounds(50,190,250,50);
        frame.add(em);

        email=new JTextField("");
        email.setBounds(50,230,250,40);
        frame.add(email);

        JButton share=new JButton("Share");
        share.setBounds(100,300,150,50);
        frame.add(share);
        share.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
// Creating a Mongo client
                MongoClient mongo = new MongoClient( "localhost" , 27017 );
                // Creating Credentials
                MongoCredential credential;
                credential = MongoCredential.createCredential("piyush", "project1",
                        "12345".toCharArray());
                System.out.println("Connected to the database successfully");

                // Accessing the database
                MongoDatabase database = mongo.getDatabase("project1");
                MongoCollection<Document> collection =       database.getCollection("Share");
                System.out.println("Credentials ::"+ credential);
                Document x1=new Document();
                x1.append("Email",email.getText());
                x1.append("Task",ta.getText());
                database.getCollection("Share").insertOne(x1);
                JOptionPane.showMessageDialog(frame,"Successfully Shared.","Alert",JOptionPane.WARNING_MESSAGE);
            }
        });

        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String [] args)
    {
        shar();
    }
}
