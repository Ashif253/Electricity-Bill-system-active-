package elctricity.biling.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Signup extends JFrame implements ActionListener {
    JTextField employeeidText, meterText, usertext, nameText, passwordtext;
    Choice accountType;
    JButton Create, Back;
    Signup(){

        super("Sign Up Page");
        getContentPane().setBackground(new Color(149, 190, 216));


        JLabel CreateAccount = new JLabel("Create Account");
        CreateAccount.setBounds(0,0,100,20);
        add(CreateAccount);

        JLabel CreateAccountno = new JLabel("Create Account No");
        CreateAccountno.setBounds(20, 50, 120, 20);
        add(CreateAccountno);
        accountType = new Choice();
        accountType.setBounds(160, 50, 120, 20);
        accountType.add("Admin");
        accountType.add("Customer");
        add(accountType);

        JLabel EmployeeID = new JLabel("Employee ID");
        EmployeeID.setBounds(20, 100, 120, 20);
        add(EmployeeID);
        employeeidText =new JTextField();
        employeeidText.setBounds(160, 102, 120, 20);
        add(employeeidText);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(20, 100, 120, 20);
        add(meterNo);
        meterNo.setVisible(false);
        meterText = new JTextField();
        meterText.setBounds(160, 102, 120, 20);
        add(meterText);
        meterText.setVisible(false);

        JLabel Username = new JLabel("UserName");
        Username.setBounds(20, 140, 120, 20);
        add(Username);
        usertext = new JTextField();
        usertext.setBounds(160, 142, 120, 20);
        add(usertext);


        JLabel Name = new JLabel("Name");
        Name.setBounds(20, 180, 120, 20);
        add(Name);
        nameText = new JTextField();
        nameText.setBounds(160, 182, 120, 20);
        add(nameText);


        JLabel Password = new JLabel("Password");
        Password.setBounds(20, 220, 120, 20);
        add(Password);
        passwordtext = new JTextField();
        passwordtext.setBounds(160, 222, 120, 20);
        add(passwordtext);

        Create = new JButton("Create");
        Create.setBounds(30, 280, 100, 20);
        add(Create);
        Create.addActionListener(this);


        Back = new JButton("Back");;
        Back.setBackground(new Color(144, 173, 152));
        Back.setBounds(160, 280, 100, 20);
        add(Back);
        Back.addActionListener(this);

        ImageIcon imageone = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image profileone = imageone.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon profiletwo = new ImageIcon(profileone);
        JLabel boylabel = new JLabel(profiletwo);
        boylabel.setBounds(300, 40, 250, 250);
        add(boylabel);

        accountType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = accountType.getSelectedItem();
                if (user.equals("Customer")){
                    EmployeeID.setVisible(false);
                    employeeidText.setVisible(false);

                    meterNo.setVisible(true);
                    meterText.setVisible(true);
                }
                else {
                    EmployeeID.setVisible(true);
                    employeeidText.setVisible(true);

                    meterNo.setVisible(false);
                    meterText.setVisible(false);
                }
            }
        });


        setSize(600, 400);
        setLocation(500, 200);

        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== Create){
            String sloginas = accountType.getSelectedItem();
            String susername = usertext.getText();
            String sname = nameText.getText();
            String spassword = passwordtext.getText();
            String smeter = meterText.getText();
            try {
                database c = new database();
                String query = null;
                query = "insert into Signup value('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+sloginas+"')";

                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Your account created successfully");
                setVisible(false);
                new Login();

            }catch (Exception c){
                c.printStackTrace();
            }
        } else if (e.getSource() == Back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
