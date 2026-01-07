package employe.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewEmp extends JFrame implements ActionListener {
    Choice choiceEMP;
    JTable table;
    JButton find, print, update, back;
    viewEmp(){
        getContentPane().setBackground(new Color(102,255,178));

        JLabel search = new JLabel("Search by Employee Id");
        search.setBounds(20,20,150,20);
        add(search);
        choiceEMP = new Choice();
        choiceEMP.setBounds(180,20,150,20);
        add(choiceEMP);

        try{
            dbconn c = new dbconn();
            ResultSet resultset = c.statement.executeQuery("select * from employee");
            while(resultset.next()){
                choiceEMP.add(resultset.getString("empID"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }


        table = new JTable();
        try{
            dbconn c = new dbconn();
            ResultSet resultset = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultset));

        }catch(Exception E){
            E.printStackTrace();
        }
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0,100,900,600);
        add(scroll);

        find = new JButton("SEARCH");
        find.setBounds(20,70,80,20);
        find.addActionListener(this);
        add(find);

        print = new JButton("PRINT");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("UPDATE");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);


            setSize(900,700);
            setLayout(null);
            setLocation(300,50);
            setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == find){
            String query = "select * from employee where empId = '"+choiceEMP.getSelectedItem()+"'";
            try{
                dbconn c = new dbconn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch(Exception u){
                u.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();

            }catch (Exception u){
                u.printStackTrace();
            }
        } else if (e.getSource() == update) {
            setVisible(false);
            new updateEmp(choiceEMP.getSelectedItem());


        }else {
            setVisible(false);
            new main_view();
        }
    }
    public static void main(String[] args) {
        new viewEmp();
    }

}
