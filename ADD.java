import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
//import org.jdesktop.swingx.JXDatePicker;
/**
 *
 * @author ASUS
 */
public class ADD {
    public static void add()
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

        dat=new JLabel("Select Date");
        dat.setBounds(50,170,150,50);
        frame.add(dat);

        JXDatePicker picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats("yyyy-MM-dd");
        picker.setBounds(150,170,150,50);
        frame.add(picker);

        JButton ad=new JButton("ADD Task");
        ad.setBounds(100,240,150,50);
        frame.add(ad);
        ad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String da=picker.getDate().toString();
                String tas=t1.getText();
                MONGO x1=new MONGO();
                x1.db(tas,da);
                JOptionPane.showMessageDialog(frame,"Successfully Added.","Alert",JOptionPane.WARNING_MESSAGE);
            }
        });
        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        add();
    }

}

