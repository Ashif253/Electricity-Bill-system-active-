package elctricity.biling.system;

import javax.swing.*;
import java.awt.*;

public class main_class extends JFrame {
    main_class(){




        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon profileone = new ImageIcon(ClassLoader.getSystemResource("icon/ebs.png"));
        Image profiletwo = profileone.getImage().getScaledInstance(2000, 1000, Image.SCALE_DEFAULT);
        ImageIcon profilet = new ImageIcon(profiletwo);
        JLabel imageLabel = new JLabel(profilet);
        add(imageLabel);


        //MENU_BAR
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(new Color(149, 190, 216));

        //MENU
        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif", Font.PLAIN, 15));
        menu.setBackground(new Color(110, 141, 166));
        menuBar.add(menu);

        JMenuItem newCustomer = new JMenuItem("New Customer");
        newCustomer.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon customerIcon = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image cIconone = customerIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newCustomer.setIcon(new ImageIcon(cIconone));
        newCustomer.setBackground(Color.lightGray);
        menu.add(newCustomer);

        JMenuItem customerDetails= new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon customerdetail = new ImageIcon(ClassLoader.getSystemResource("icon/customerDetails.png"));
        Image cIcontwo = customerdetail.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(cIcontwo));
        customerDetails.setBackground(new Color(166, 210, 251));
        menu.add(customerDetails);

        JMenuItem depositDetails = new JMenuItem("Deposit Details");
        depositDetails.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon depositdetail = new ImageIcon(ClassLoader.getSystemResource("icon/depositDetails.png"));
        Image depositdetails_icon = depositdetail.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositDetails.setIcon(new ImageIcon(depositdetails_icon));
        depositDetails.setBackground(Color.lightGray);
        menu.add(depositDetails);

        JMenuItem calculateBill = new JMenuItem("Calculate BIll");
        calculateBill.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon cBills = new ImageIcon(ClassLoader.getSystemResource("icon/calculatorbills.png"));
        Image calculateBill_icon = cBills.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(calculateBill_icon));
        calculateBill.setBackground(new Color(166, 210, 251));
        menu.add(calculateBill);

        //INFORMATION

        JMenu Information = new JMenu("Information");;
        menu.setFont(new Font("serif", Font.PLAIN, 15));
        menuBar.add(Information);

        JMenuItem upInfo = new JMenuItem("Update Information");
        upInfo.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon upInfos = new ImageIcon(ClassLoader.getSystemResource("icon/refresh.png"));
        Image upInfo_icon = upInfos.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        upInfo.setIcon(new ImageIcon(upInfo_icon));
        upInfo.setBackground(new Color(166, 210, 251));
        Information.add(upInfo);

        JMenuItem viewInfo = new JMenuItem("View Informatoin");
        viewInfo.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon viewInfos = new ImageIcon(ClassLoader.getSystemResource("icon/Information.png"));
        Image viewInfo_icon = viewInfos.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewInfo.setIcon(new ImageIcon(viewInfo_icon));
        viewInfo.setBackground(new Color(93, 146, 197));
        Information.add(viewInfo);

        //USER
        JMenu User = new JMenu("User");
        User.setFont(new Font("serif", Font.PLAIN, 15));
        menuBar.add(User);

        JMenuItem payBill = new JMenuItem("Pay Bill");
        payBill.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon payBills = new ImageIcon(ClassLoader.getSystemResource("Icon/pay.png"));
        Image payBill_icon = payBills.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        payBill.setIcon(new ImageIcon(payBill_icon));
        User.add(payBill);

        JMenuItem billDetails = new JMenuItem("Bill Details");
        billDetails.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon billDetailss = new ImageIcon(ClassLoader.getSystemResource("Icon/detail.png"));
        Image billdetails_icon = billDetailss.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billDetails.setIcon(new ImageIcon(billdetails_icon));
        User.add(billDetails);

        //BILL
        JMenu Bill = new JMenu("Bill");
        Bill.setFont(new Font("serif", Font.PLAIN, 15));
        menuBar.add(Bill);

        JMenuItem genBill = new JMenuItem("Generate Bill");
        genBill.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon genBills = new ImageIcon(ClassLoader.getSystemResource("Icon/bill.png"));
        Image genBills_icon = genBills.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        genBill.setIcon(new ImageIcon(genBills_icon));
        Bill.add(genBill);

        JMenu Util = new JMenu("Utility");
        Util.setFont(new Font("serif", Font.PLAIN, 15));
        menuBar.add(Util);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon notepads = new ImageIcon(ClassLoader.getSystemResource("Icon/Notepad.png"));
        Image notepad_icon = notepads.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepad_icon));

        Util.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon calculators = new ImageIcon(ClassLoader.getSystemResource("Icon/calculator.png"));
        Image calculator_icon = calculators.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculator_icon));
        calculator.setBackground(new Color(175, 192, 207));
        Util.add(calculator);

        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("serif", Font.PLAIN, 15));
        menuBar.add(exit);

        JMenuItem eexit = new JMenuItem("EXIT");
        eexit.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon exits = new ImageIcon(ClassLoader.getSystemResource("Icon/exit.png"));
        Image exit_icon = exits.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        eexit.setIcon(new ImageIcon(exit_icon));
        exit.add(eexit);


        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new main_class();
    }
}
