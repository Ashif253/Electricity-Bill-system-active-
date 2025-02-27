package elctricity.biling.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class newCustomer extends JFrame implements ActionListener {

    JLabel heading, meterNumText, customerName, meterNum, address, state, city, email, phoneNo;
    TextField nameText, addressText, cityText, stateText, emailtext, phonenoText;
    JButton Next, Cancel;

    newCustomer(){

        super ("New Customer Details");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252, 186, 3));
        add(panel);

        heading = new JLabel("New Customer");
        heading.setBounds(180, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(heading);

        customerName = new JLabel("Customer Name");
        customerName.setBounds(50, 80, 100, 20);
        panel.add(customerName);

        nameText = new TextField();
        nameText.setBounds(180, 80, 150, 20);
        panel.add(nameText);

        meterNum = new JLabel("Meter Number");
        meterNum.setBounds(50, 120, 100, 20);
        panel.add(meterNum);

        meterNumText = new JLabel("");
        meterNumText.setBounds(180, 120, 150, 20);
        panel.add(meterNumText);

        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        meterNumText.setText("" + Math.abs(number));

        address = new JLabel("Address");
        address.setBounds(50, 160, 100, 20);
        panel.add(address);
        addressText = new TextField();
        addressText.setBounds(180, 160, 150, 20);
        panel.add(addressText);

        state = new JLabel("State Name");
        state.setBounds(50, 240, 100, 20);
        panel.add(state);
        stateText = new TextField();
        stateText.setBounds(180, 240, 150, 20);
        panel.add(stateText);


        city = new JLabel("City Name");
        city.setBounds(50, 200, 100, 20);
        panel.add(city);
        cityText = new TextField();
        cityText.setBounds(180, 200, 150, 20);
        panel.add(cityText);


        email = new JLabel("Enter Email");
        email.setBounds(50, 280, 100, 20);
        panel.add(email);
        emailtext = new TextField();
        emailtext.setBounds(180, 280, 150, 20);
        panel.add(emailtext);


        phoneNo = new JLabel("Enter phone number");
        phoneNo.setBounds(50,320, 100, 20);
        panel.add(phoneNo);
        phonenoText = new TextField();
        phonenoText.setBounds(180, 320, 150, 20);
        panel.add(phonenoText);


        Next = new JButton("Next");
        Next.setBounds(70, 380, 100,20);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.addActionListener(this);
        panel.add(Next);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(200, 380, 100, 20);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.white);
        Cancel.addActionListener(this);
        panel.add(Cancel);






        setLayout(new BorderLayout());
        add(panel, "Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image i2 = i1.getImage().getScaledInstance(230, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel ing = new JLabel(i3);
        add(ing, "West");

        setSize(700, 500);
        setLocation(500,200);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Next){
            String sname = nameText.getText();
            String smeter = meterNumText.getText();
            String saddress = addressText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String semail = emailtext.getText();
            String sphone = phonenoText.getText();

            String query_Customer = "insert into new_Customer values('"+sname+"', '"+smeter+"','"+saddress+"', '"+scity+"', '"+sstate+"', '"+semail+"', '"+sphone+"')";
            String query_signup = "insert into Signup values ('"+smeter+"', '', '"+sname+"', '', '')";

            try {
                database c = new database();

                c.statement.executeUpdate(query_Customer);
                c.statement.executeUpdate(query_signup);

                JOptionPane.showMessageDialog(null, "Customer details added successfully");
                setVisible(false);
                new meterInfo(smeter);
            }catch (Exception E){
                E.printStackTrace();
            }


        }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new newCustomer();
    }
}
