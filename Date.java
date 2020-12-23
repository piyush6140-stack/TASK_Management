import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Date extends JPanel {
    public static int re=1;

    public static int DATE(String name) {
        JFrame frame = new JFrame("JXPicker Example");
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 400, 250, 100);

        JXDatePicker picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats("yyyy-MM-dd");

        JButton select=new JButton("Select");
        select.setBounds(40,50,100,50);
        frame.add(select);


        panel.add(picker);
        frame.getContentPane().add(panel);

        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String da=picker.getDate().toString();
                MongoClient mongo = new MongoClient( "localhost" , 27017 );
                // Creating Credentials
                MongoCredential credential;
                credential = MongoCredential.createCredential("piyush", "project1",
                        "12345".toCharArray());
                System.out.println("Connected to the database successfully");

                // Accessing the database
                MongoDatabase database = mongo.getDatabase("project1");
                MongoCollection<Document> collection =       database.getCollection("Task");
                System.out.println(da);
                collection.updateOne(Filters.eq("TASK_TITLE", name), Updates.set("Due Date", da));
                re=0;
                frame.setVisible(false);
                //return da;
            }
        });
        frame.setSize(170,150);
        frame.setResizable(false);
        frame.setVisible(true);
        return re;
    }

    public static void main(String[] args)
    {
        int x;
        x=DATE("x");
    }
}