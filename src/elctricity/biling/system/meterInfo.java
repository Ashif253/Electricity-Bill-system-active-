package elctricity.biling.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.ImageGraphicAttribute;

public class meterInfo extends JFrame implements ActionListener {

    Choice meterLocChoice, meterTypeChoice, phaseCodeChoice, billTypeChoice;
    JButton Submit;
    String meterNumber;

    meterInfo(String meterNumber){

        this.meterNumber = meterNumber;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252, 186, 3));
        add(panel);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(heading);

        JLabel meternumber = new JLabel("Meter Number");
        meternumber.setBounds(50, 80, 100, 20);
        panel.add(meternumber);

        JLabel meterNumbertext = new JLabel(meterNumber);
        meterNumbertext.setBounds(180, 80, 150, 20);
        panel.add(meterNumbertext);


        JLabel meterLocation = new JLabel("Meter Location");
        meterLocation.setBounds(50, 120, 100, 20);
        panel.add(meterLocation);

        meterLocChoice = new Choice();
        meterLocChoice.setBounds(180, 120, 150, 20);
        meterLocChoice.add("Outside");
        meterLocChoice.add("Inside");
        panel.add(meterLocChoice);

        JLabel meterType = new JLabel("Meter type");
        meterType.setBounds(50,160,100,20);
        panel.add(meterType);

        meterTypeChoice = new Choice();
        meterTypeChoice.add("Electric Meter");
        meterTypeChoice.add("Solar Meter");
        meterTypeChoice.add("Solar Meter");
        meterTypeChoice.setBounds(180,160,150,20);
        panel.add(meterTypeChoice);

        phaseCodeChoice = new Choice();
        phaseCodeChoice.add("011");
        phaseCodeChoice.add("022");
        phaseCodeChoice.add("033");
        phaseCodeChoice.add("044");
        phaseCodeChoice.add("055");
        phaseCodeChoice.add("066");
        phaseCodeChoice.add("077");
        phaseCodeChoice.add("088");
        phaseCodeChoice.add("099");
        phaseCodeChoice.setBounds(180, 200, 150, 20);
        panel.add(phaseCodeChoice);

        JLabel billType = new JLabel("Bill TYpe");
        billType.setBounds(50, 240, 100, 20);
        panel.add(billType);

        billTypeChoice = new Choice();
        billTypeChoice.add("Normal");
        billTypeChoice.add("Industrial");
        billTypeChoice.setBounds(180, 240, 150, 20);
        panel.add(billTypeChoice);

        JLabel day  = new JLabel("30 Days Billing Time ....");
        day.setBounds(50, 280, 150, 20);
        panel.add(day);

        JLabel note = new JLabel("Note :- ");
        note.setBounds(50, 320, 100, 20);
        panel.add(note);

        JLabel note1 = new JLabel("By Default bill is calculated for 30 days only");
        note1.setBounds(50, 340, 300, 20);
        panel.add(note1);

        JLabel phaseCode = new JLabel("Phase Code");
        phaseCode.setBounds(50, 200, 100, 20);
        panel.add(phaseCode);

        Submit = new JButton("Submit");
        Submit.setBounds(220, 390, 100, 25);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        panel.add(Submit);

        setLayout(new BorderLayout());
        add(panel, "Center");

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/details.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(230, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel imagelabel = new JLabel(i2);
        add(imagelabel, "East");




        setSize(700,500);
        setLocation(500,200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Submit){
            String smeterNum = meterNumber;
            String smeterLoc = meterLocChoice.getSelectedItem();
            String smeterType = meterTypeChoice.getSelectedItem();
            String sphasecode = phaseCodeChoice.getSelectedItem();
            String sbillType = billTypeChoice.getSelectedItem();
            String sDay = "30";

            String query_meterInfo = "insert into meter_info values('"+smeterNum+"', '"+smeterLoc+"', '"+smeterType+"', '"+sphasecode+"', '"+sbillType+"', '"+sDay+"')";
            try {
                database c = new database();
                c.statement.executeUpdate(query_meterInfo);

                JOptionPane.showMessageDialog(null, "Meter Information Submitted Successfully");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new meterInfo("");
    }
}
