import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class update {
    public static void searh(String name)
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
        collection.updateOne(Filters.eq("TASK_TITLE", name), Updates.set("Status", 1));
        System.out.println("Document update successfully...");

    }
    public static void updat()
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
        
        JButton up=new JButton ("UPDATE");
        up.setBounds(100,380,150,50);
        frame.add(up);

        JLabel ntask,dat;
        ntask=new JLabel("Enter Task");
        ntask.setBounds(50,100,150,50);
        frame.add(ntask);



        JTextField t1;
        t1=new JTextField("");
        t1.setBounds(150,100,150,50);
        frame.add(t1);

        JRadioButton c,uc,da;

        c=new JRadioButton("Task Completed");
        c.setBounds(50,170,150,50);
        frame.add(c);

        uc=new JRadioButton("Task Not Completed");
        uc.setBounds(50,240,150,50);
        frame.add(uc);

        da=new JRadioButton("Change Due Date");
        da.setBounds(50,310,150,50);
        frame.add(da);

        ButtonGroup bg=new ButtonGroup();
        bg.add(c);
        bg.add(uc);

        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=t1.getText();
                MongoClient mongo = new MongoClient( "localhost" , 27017 );
                // Creating Credentials
                MongoCredential credential;
                credential = MongoCredential.createCredential("piyush", "project1",
                        "12345".toCharArray());
                System.out.println("Connected to the database successfully");

                // Accessing the database
                MongoDatabase database = mongo.getDatabase("project1");
                MongoCollection<Document> collection =       database.getCollection("Task");

                if(c.isSelected())
                {
                    collection.updateOne(Filters.eq("TASK_TITLE", name), Updates.set("Status", 1));

                }
                if(uc.isSelected())
                {
                    collection.updateOne(Filters.eq("TASK_TITLE", name), Updates.set("Status", 0));
                    System.out.println("uncom");
                }
                int daa=0;
                if (da.isSelected())
                {
                    Date x=new Date();
                    daa=x.DATE(name);

                }



            }
        });


        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String [] arg)
    {
        updat();
        //searh("Task 2");
    }

}

