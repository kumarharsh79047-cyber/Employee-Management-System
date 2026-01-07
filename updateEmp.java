package employe.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateEmp extends JFrame  implements ActionListener {
    JTextField teducation,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JLabel tempId;
    JButton add, back;
    String empid;

    updateEmp(String empid){
        this.empid = empid;
        getContentPane().setBackground(new Color(102,255,178));

        JLabel heading =new JLabel("UPDATE EMPLOYEE DETAILS");
        heading.setBounds(300,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("NAME");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        JLabel tname = new JLabel();
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

        JLabel tdob = new JLabel();
        tdob.setBounds(200,200,150,30);
        tdob.setFont(new Font("Tahoma", Font.BOLD,20));
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

        JLabel taddress = new JLabel();
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

        teducation = new JTextField();
        teducation.setBounds(200,350,150,30);
        teducation.setBackground(new Color(204,255,153));
        add(teducation);

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

        tempId = new JLabel();
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

        try{
            dbconn c = new dbconn();
            String query = "Select * from employee where empId = '"+empid+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fanme"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                taadhar.setText(resultSet.getString("aadhar"));
                tempId.setText(resultSet.getString("empId"));
                tdesignation.setText(resultSet.getString("designation"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        add = new JButton("UPDATE");
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

        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == add) {
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();
            try{
                dbconn c = new dbconn();
                String query = "update employee set fanme = '"+fname+"',salary = '"+salary+"',phone = '"+phone+"',email = '"+email+"',education = '"+education+"',designation = '"+designation+"'where empId = '"+empid+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated sucessfully");
                setVisible(false);
                new main_view();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
            new main_view();
        }
    }

    public static void main(String[] args) {
        new updateEmp("");

    }
}
