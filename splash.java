package employe.management.system;

import javax.swing.*;
import java.awt.*;

public class splash extends JFrame {
    //constructor
    splash(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splashscreen.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1170, 650);
        add(image);


        // layouts
        setSize(1170, 650);
        setLocation(200,100);
        setLayout(null);
        setVisible(true);


        try {
            Thread.sleep(4000);
            setVisible(false);
            new login();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new splash();
    }
}
