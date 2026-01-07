package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_view extends JFrame {
    main_view(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/mainbg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1100, 630);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,200,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(heading);

        JButton add = new JButton("ADD_EMPLOYEE");
        add.setBounds(235,300,150,40);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new addEmp();
                setVisible(false);

            }
        });
        image.add(add);

        JButton view = new JButton("VIEW_EMPLOYEE");
        view.setBounds(665,300,150,40);
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new viewEmp();
                setVisible(false);

            }
        });
        image.add(view);

        JButton remove = new JButton("REMOVE_EMPLOYEE");
        remove.setBounds(450,300,150,40);
        remove.setForeground(Color.white);
        remove.setBackground(Color.black);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new removeEmp();
                setVisible(false);
            }
        });
        image.add(remove);

        setSize(1100,600);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new main_view();

    }
}
