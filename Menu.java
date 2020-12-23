import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class Menu {
    public static void me()
    {
        JFrame frame = new JFrame("API");
        JButton ad,delete,update,view,share,exit;

        exit=new JButton("Exit");
        exit.setBounds(10,10,100,50);
        frame.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        ad=new JButton("Add Task");
        ad.setBounds(50,100,150,50);
        frame.add(ad);
        ad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ADD x=new ADD();
                x.add();
            }
        });

        delete=new JButton("Delete Task");
        delete.setBounds(50,170,150,50);
        frame.add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                delet x=new delet();
                x.dele();
            }
        });

        update=new JButton("Update Task");
        update.setBounds(50,240,150,50);
        frame.add(update);

        view=new JButton("View Task");
        view.setBounds(50,310,150,50);
        frame.add(view);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                View x=new View();
                x.vew();

            }
        });

        share=new JButton("Share Task");
        share.setBounds(50,380,150,50);
        frame.add(share);

        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args )
    {
        me();
    }
}

