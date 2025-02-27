package elctricity.biling.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField usertext,passwordtext;
    Choice loginaschoice;
    JButton loginbutton, cancelbutton, signupbutton;
    Login(){


        super("Login");  //super hamesha first statement hona chahiye constructor ke andar
        getContentPane().setBackground(Color.LIGHT_GRAY);



        JLabel username = new JLabel("UserName");
        username.setBounds(300,60,100,20);
        add(username);

        usertext = new JTextField();
        usertext.setBounds(400, 60, 100, 20);
        add(usertext);

        JLabel Password = new JLabel("Password");
        Password.setBounds(300,100,100,20);
        add(Password);

        passwordtext = new JTextField();
        passwordtext.setBounds(400, 100, 100, 20);
        add(passwordtext);

        JLabel login = new JLabel("Login in As");
        login.setBounds(300, 140, 100, 20);
        add(login);
        loginaschoice = new Choice();
        loginaschoice.add("Admin");
        loginaschoice.add("Customer");
        loginaschoice.setBounds(400,140,100,20);
        add(loginaschoice);

        loginbutton = new JButton("Login");
        loginbutton.setBounds(330,180,100,20);
        add(loginbutton);
        loginbutton.addActionListener(this);

        cancelbutton = new JButton("Cancel");
        cancelbutton.setBounds(450,180,100,20);
        add(cancelbutton);
        cancelbutton.addActionListener(this);

        signupbutton = new JButton("Signup");
        signupbutton.setBounds(390,210,100,20);
        add(signupbutton);
        signupbutton.addActionListener(this);


        ImageIcon profileOne = new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profiletwo = profileOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon fprofileone = new ImageIcon(profiletwo);
        JLabel profilelabel = new JLabel(fprofileone);
        profilelabel.setBounds(5, 5, 250, 250);
        add(profilelabel);



        setSize(640, 300);
        setLocation(400,200);
        setLayout(null);
        setVisible(true); //visible hamesha last hoga

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == loginbutton){
            String susername = usertext.getText();
            String spassword = passwordtext.getText();
            String suser = loginaschoice.getSelectedItem();

            try {
                database d = new database();
                String query = "select * from Signup where username = '"+susername+"'and password = '"+spassword+"'and usertype = '"+suser+"'";

                ResultSet resultSet = d.statement.executeQuery(query);

                if (resultSet.next()){
                    setVisible(false);
                    new main_class();
                }else {
                    JOptionPane.showMessageDialog(null, "invalid login");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource() == cancelbutton) {
            setVisible(false);
        } else if (e.getSource() == signupbutton) {
            setVisible(false);
            new Signup();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
