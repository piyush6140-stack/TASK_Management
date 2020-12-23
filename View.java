import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class View {




    public static void vew()
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

        JButton vw=new JButton ("View");
        vw.setBounds(100,170,150,50);
        frame.add(vw);

        JLabel ntask,dat,stat;
        ntask=new JLabel("Enter Task");
        ntask.setBounds(50,100,150,50);
        frame.add(ntask);



        JTextField t1;
        t1=new JTextField("");
        t1.setBounds(150,100,150,50);
        frame.add(t1);

        vw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MongoClient mongo = new MongoClient( "localhost" , 27017 );
                // Creating Credentials
                MongoCredential credential;
                credential = MongoCredential.createCredential("piyush", "project1",
                        "12345".toCharArray());
                System.out.println("Connected to the database successfully");

                // Accessing the database
                MongoDatabase database = mongo.getDatabase("project1");
                MongoCollection<Document> collection  =       database.getCollection("Task");
                BasicDBObject whereQuery = new BasicDBObject();
                String tname=t1.getText();
                whereQuery.put("TASK_TITLE",tname );
                FindIterable<Document> iterDoc = collection.find(whereQuery).projection(Projections.fields(Projections.include("Due Date"),Projections.excludeId()));
                FindIterable<Document> iterDoc1 = collection.find(whereQuery).projection(Projections.fields(Projections.include("Status"),Projections.excludeId()));

                int i = 1;
                // Getting the iterator
                Iterator it = iterDoc.iterator();
                Iterator it1 = iterDoc1.iterator();
                Object due= it.next();
                Object st= it1.next();
                String du=due.toString();
                String da=st.toString();
                frame.setVisible(false);

                JFrame f1=new JFrame("API");

                JButton back;
                back=new JButton("Back");
                back.setBounds(10,10,100,50);
                f1.add(back);
                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f1.setVisible(false);
                        Menu x=new Menu();
                        x.me();
                    }
                });

                JLabel vw=new JLabel (tname);
                vw.setBounds(100,170,150,50);
                f1.add(vw);

                JLabel ntask,dat,stat;
                ntask=new JLabel("Task Name:");
                ntask.setBounds(50,170,150,50);
                f1.add(ntask);

                dat=new JLabel("Due Date:");
                dat.setBounds(50,240,150,50);
                f1.add(dat);

                stat=new JLabel("Due Status:");
                stat.setBounds(50,310,150,50);
                f1.add(stat);

                JLabel r1,r2;
                r1=new JLabel(du);
                r1.setBounds(150,240,150,50);
                f1.add(r1);

                r2=new JLabel(da);
                r2.setBounds(150,310,150,50);
                f1.add(r2);
                f1.setSize(400, 600);
                f1.setResizable(false);
                f1.setLayout(null);
                f1.setVisible(true);
                //System.out.println(it.next());
            }
        });


        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String [] args)

    {
        vew();
    }
}
