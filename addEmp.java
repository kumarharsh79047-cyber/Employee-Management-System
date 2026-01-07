package employe.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class addEmp extends JFrame implements ActionListener {
    Random ran =new Random();
    int number = ran.nextInt(999999);
    JTextField tname,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JLabel tempId;
    JDateChooser tdob;
    JComboBox beducation;
    JButton add, back;
    addEmp(){
        //getContentPane().setBackground(new Color(102,255,178));

        JLabel heading =new JLabel("ADD EMPLOYEE DETAILS");
        heading.setBounds(300,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("NAME");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(204,255,153));
        add(tname);


        JLabel fname = new JLabel("FATHER'S NAME");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(204,255,153));
        add(tfname);


        JLabel dob = new JLabel("DATE OF BIRTH");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(204,255,153));
        add(tdob);


        JLabel salary = new JLabel("SALARY");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(204,255,153));
        add(tsalary);


        JLabel address = new JLabel("ADDRESS");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,550,30);
        taddress.setBackground(new Color(204,255,153));
        add(taddress);


        JLabel phone = new JLabel("MOBILE");
        phone.setBounds(50,300,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(200,300,150,30);
        tphone.setBackground(new Color(204,255,153));
        add(tphone);


        JLabel email = new JLabel("E-MAIL ADD.");
        email.setBounds(400,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail = new JTextField();
        temail.setBounds(600,300,150,30);
        temail.setBackground(new Color(204,255,153));
        add(temail);


        JLabel education = new JLabel("EDUCATION");
        education.setBounds(50,350,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        String courses[] = {"BBA","BCA","B-TECH","BSE-IT","B-COM","MBA","MCA","M-TECH","MSC-IT","PHD"};
        beducation = new JComboBox<>(courses);
        beducation.setBackground(new Color(204,255,153));
        beducation.setBounds(200,350,150,30);
        add(beducation);

        JLabel aadhar = new JLabel("AADHAR NO.");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600,350,150,30);
        taadhar.setBackground(new Color(204,255,153));
        add(taadhar);

        JLabel empId = new JLabel("EMPLOY ID");
        empId.setBounds(50,400,150,30);
        empId.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empId);

        tempId = new JLabel(""+number);
        tempId.setBounds(200,400,150,30);
        tempId.setBackground(new Color(204,255,153));
        tempId.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        tempId.setForeground(Color.RED);
        add(tempId);

        JLabel designation = new JLabel("DESIGNATION");
        designation.setBounds(400,400,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(600,400,150,30);
        tdesignation.setBackground(new Color(204,255,153));
        add(tdesignation);

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

        //Background image
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
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) beducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empId = tempId.getText();
            String aadhar = taadhar.getText();

            try{
                dbconn c = new dbconn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Added Sucessfully");
                setVisible(false);
                new main_view();

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new main_view();
        }
    }

    public static void main(String[] args){
        new addEmp();
    }
}
