package elctricity.biling.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class customerDetails extends JFrame implements ActionListener {

    Choice searchMeterCho, searchNameCho;
    JButton search, print, close;
    JTable table;

    customerDetails(){

        super("Customer Details");
        getContentPane().setBackground(new Color(192, 186, 245));

        JLabel searchMeter = new JLabel("Search By Meter Number");
        searchMeter.setBounds(20, 20, 150, 20);
        add(searchMeter);

        searchMeterCho = new Choice();
        searchMeterCho.setBounds(180, 20, 120, 20);
        add(searchMeterCho);

        try {
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_Customer");
            while (resultSet.next()){
                searchMeterCho.add(resultSet.getString("meter_no"));
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel searchName = new JLabel("Search By Name");
        searchName.setBounds(400, 20, 100, 20);
        add(searchName);

        searchNameCho = new Choice();
        searchNameCho.setBounds(520, 20, 120, 20);
        add(searchNameCho);
        try {
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_Customer");
            while (resultSet.next()){
                searchNameCho.add(resultSet.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try {
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_Customer");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 700, 500);
        scrollPane.setBackground(Color.white);
        add(scrollPane);

        search = new JButton("Search");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.setBounds(130, 70, 80, 20);
        print.addActionListener(this);
        add(print);


        close = new JButton("Close");
        close.setBackground(Color.BLACK);
        close.setForeground(Color.WHITE);
        close.setBounds(240, 70, 80, 20);
        close.addActionListener(this);
        add(close);


        setSize(700, 500);
        setLocation(400, 200);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==search){

                String query_search = "select * from new_Customer where meter_no = '"+searchMeterCho.getSelectedItem()+"' and name = '"+searchNameCho.getSelectedItem()+"'";
                try {
                    database c = new database();
                    ResultSet resultSet = c.statement.executeQuery(query_search);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception ex){
                    ex.printStackTrace();

                }

        } else if (e.getSource() == print) {

            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new customerDetails();
    }
}
