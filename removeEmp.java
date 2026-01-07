package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class removeEmp extends JFrame implements ActionListener {
    Choice choiceEmp;
    JButton delete, back;
    removeEmp(){
        JLabel label = new JLabel("Employee ID");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(label);

        choiceEmp = new Choice();
        choiceEmp.setBounds(200,50,150,30);
        add(choiceEmp);

        try{
            dbconn c = new dbconn();
            ResultSet resultset = c.statement.executeQuery("Select * from employee");
            while(resultset.next()){
                choiceEmp.add(resultset.getString("empId"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("NAME");
        labelName.setBounds(50,100,100,30);
        labelName.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelName);

        JLabel textName =new JLabel();
        textName.setBounds(200,100,100,30);
        add(textName);

        JLabel labelPhone = new JLabel("PHONE");
        labelPhone.setBounds(50,150,100,30);
        labelPhone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelPhone);

        JLabel textPhone =new JLabel();
        textPhone.setBounds(200,150,100,30);
        add(textPhone);

        JLabel labelEmail = new JLabel("EMAIL");
        labelEmail.setBounds(50,200,100,30);
        labelEmail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelEmail);

        JLabel textEmail =new JLabel();
        textEmail.setBounds(200,200,100,30);
        add(textEmail);

        try {
            dbconn o = new dbconn();
            ResultSet resultSet = o.statement.executeQuery("Select * from employee where empId = '"+choiceEmp.getSelectedItem()+"'");
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        choiceEmp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                try {
                    dbconn c = new dbconn();
                    ResultSet resultSet = c.statement.executeQuery("Select * from employee where empId = '"+choiceEmp.getSelectedItem()+"'");
                    while (resultSet.next()){
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        delete = new JButton("DELETE");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.RED);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("BACK");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.RED);
        back.addActionListener(this);
        add(back);

        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete){
            try {
                dbconn c = new dbconn();
                String query = "delete from employee where empId = '"+choiceEmp.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Deleted");
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

    public static void main(String[] args) {
        new removeEmp();
    }
}
