package employe.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener{

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back, newRegistration;

    login(){

        // MD5: 9e91b6b515ddea4495b62ffb7cee1f21

        //Username field
        JLabel username =new JLabel("Username");
        username.setBounds(40,20, 100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 20, 150, 30);
        add(tusername);

        //Password field
        JLabel password =new JLabel("Password");
        password.setBounds(40,70, 100, 30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 150, 30);
        add(tpassword);

        //Submit Button
        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        //Back Button
        back = new JButton("BACK");
        back.setBounds(150, 180, 150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        //New Registration Button
        newRegistration = new JButton("NEW REGISTRATION");
        newRegistration.setBounds(100, 220, 250,30);
        newRegistration.setBackground(Color.BLACK);
        newRegistration.setForeground(Color.WHITE);
        newRegistration.addActionListener(this);
        add(newRegistration);

        //Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600, 300);
        add(img);

        //Desktop Visiblity
        setSize(600, 300);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            try {
                String username = tusername.getText();
                String password = tpassword.getText();

                dbconn dbconn = new dbconn();

                String query = "Select * from login where username = '"+ username +"' and password = '"+password+"'";
                ResultSet resultSet =dbconn.statement.executeQuery(query);
                if (resultSet.next()){
                    setVisible(false);
                    new main_view();

                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username and password");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource() == back) {
            System.exit(14);

        }else if (e.getSource() == newRegistration) {
            setVisible(false);
            new newRegistration();
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
