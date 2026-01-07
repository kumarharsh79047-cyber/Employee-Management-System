package employe.management.system;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newRegistration extends JFrame implements ActionListener {

    JTextField ename,eaddress,ephone,eaadhar,eemail,eid,epassword;

    JDateChooser edob;

    JComboBox egender;

    JButton add, back;

    newRegistration(){

        JLabel heading =new JLabel("NEW ADMIN REGISTRATION");
        heading.setBounds(300,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("NAME");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        ename = new JTextField();
        ename.setBounds(200,150,150,30);
        ename.setBackground(new Color(204,255,153));
        add(ename);

        JLabel dob = new JLabel("DATE OF BIRTH");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        edob = new JDateChooser();
        edob.setBounds(200,200,150,30);
        edob.setBackground(new Color(204,255,153));
        add(edob);

        JLabel address = new JLabel("ADDRESS");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        eaddress = new JTextField();
        eaddress.setBounds(200,250,550,30);
        eaddress.setBackground(new Color(204,255,153));
        add(eaddress);

        JLabel phone = new JLabel("MOBILE");
        phone.setBounds(50,300,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        ephone = new JTextField();
        ephone.setBounds(200,300,150,30);
        ephone.setBackground(new Color(204,255,153));
        add(ephone);


        JLabel email = new JLabel("E-MAIL ADD.");
        email.setBounds(400,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        eemail = new JTextField();
        eemail.setBounds(600,300,150,30);
        eemail.setBackground(new Color(204,255,153));
        add(eemail);

        JLabel aadhar = new JLabel("AADHAR NO.");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(50,350,150,30);
        gender.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(gender);

        String courses[] = {"MALE","FEMALE","TRANSGENDER"};
        egender = new JComboBox<>(courses);
        egender.setBackground(new Color(204,255,153));
        egender.setBounds(200,350,150,30);
        add(egender);

        eaadhar = new JTextField();
        eaadhar.setBounds(600,350,150,30);
        eaadhar.setBackground(new Color(204,255,153));
        add(eaadhar);

        JLabel username = new JLabel("USERNAME");
        username.setBounds(50,400,150,30);
        username.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(username);

        eid = new JTextField();
        eid.setBounds(200,400,150,30);
        eid.setBackground(new Color(204,255,153));
        add(eid);

        JLabel password = new JLabel("PASSWORD");
        password.setBounds(400,400,150,30);
        password.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(password);

        epassword = new JTextField();
        epassword.setBounds(600,400,150,30);
        epassword.setBackground(new Color(204,255,153));
        add(epassword);

        add = new JButton("ADD");
        add.setBounds(250,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.LIGHT_GRAY);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.LIGHT_GRAY);
        back.addActionListener(this);
        add(back);

        //Background inmage

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addbg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900, 700);
        add(img);

        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String name = ename.getText();
            String dob = ((JTextField) edob.getDateEditor().getUiComponent()).getText();
            String address = eaddress.getText();
            String gender = (String) egender.getSelectedItem();
            String phone = ephone.getText();
            String email = eemail.getText();
            String aadhar = eaadhar.getText();
            String username = eid.getText();
            String password = epassword.getText();

            try{
                dbconn c = new dbconn();
                String query = "insert into newRegis values('"+name+"', '"+dob+"', '"+address+"', '"+gender+"' , '"+phone+"', '"+email+"', '"+aadhar+"')";
                c.statement.executeUpdate(query);
                String qquery = "update login set username = ('"+username+"'), password = ('"+password+"') where s_no = 1;";
                c.statement.executeUpdate(qquery);
                JOptionPane.showMessageDialog(null, "Details Added Sucessfully");
                setVisible(false);
                new main_view();

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new login();
        }
    }
    public static void main(String[] args) {
    new newRegistration();}

}
