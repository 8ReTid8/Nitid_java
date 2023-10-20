import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class W9_7 {
    public static void main(String[] args) {
        Account frame = new Account();
        frame.pack();
        frame.setSize(600, 600);
        frame.setTitle("Account Information");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Account extends JFrame {
     String id;
     String money;
     String interestRate;
     String openDay;
     String openMonth;
     String openYear;
     String firstName;
     String lastName;
     String birthDay;
     String birthMonth;
     String birthYear;
     String age;
    
    Account() {
        JPanel mainPanel = new JPanel(new GridLayout(9, 1, 0, 5));

        JLabel title = new JLabel("ACCOUNT MONEY");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(title);

        JPanel Row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel Row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel Row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel Row4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel Row5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel Row6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel Row7 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel jlbID = new JLabel("ID:");
        JTextField jtfID = new JTextField(10);

        JLabel jlbMONEY = new JLabel("MONEY:");
        JTextField jtfMONEY = new JTextField(10);
        JLabel jlbBAHT = new JLabel("BAHT");

        JLabel jlbRate = new JLabel("ANNUAL INTEREST RATE:");
        JTextField jtfRate = new JTextField(10);

        JLabel jlbOpenDay = new JLabel("DAY OPEN ACCOUNT:");
        Vector<String> days = new Vector<>();
        for (int i = 1; i <= 31; i++) {
            days.add(String.valueOf(i));
        }
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Vector<String> years = new Vector<>();
        for (int i = 1900; i <= 2023; i++) {
            years.add(String.valueOf(i));
        }
        JComboBox<String> jcbOpenDay = new JComboBox<>(days);
        JComboBox<String> jcbOpenMonth = new JComboBox<>(months);
        JComboBox<String> jcbOpenYear = new JComboBox<>(years);

        JLabel jlbFname = new JLabel("FIRST NAME:");
        JTextField jtfFname = new JTextField(10);
        JLabel jlbLname = new JLabel("LAST NAME:");
        JTextField jtfLname = new JTextField(10);

        JLabel jlbBirthDay = new JLabel("BIRTHDAY:");
        JComboBox<String> jcbBirthDay = new JComboBox<>(days);
        JComboBox<String> jcbBirthMonth = new JComboBox<>(months);
        JComboBox<String> jcbBirthYear = new JComboBox<>(years);

        JLabel jlbAge = new JLabel("AGE:");
        JTextField jtfAge = new JTextField(5);
        JLabel jlbAgeYear = new JLabel("YEAR");

        Row1.add(jlbID);
        Row1.add(jtfID);
        Row1.add(jlbMONEY);
        Row1.add(jtfMONEY);
        Row1.add(jlbBAHT);
        Row2.add(jlbRate);
        Row2.add(jtfRate);
        Row3.add(jlbOpenDay);
        Row3.add(jcbOpenDay);
        Row3.add(jcbOpenMonth);
        Row3.add(jcbOpenYear);
        Row4.add(jlbFname);
        Row4.add(jtfFname);
        Row5.add(jlbLname);
        Row5.add(jtfLname);
        Row6.add(jlbBirthDay);
        Row6.add(jcbBirthDay);
        Row6.add(jcbBirthMonth);
        Row6.add(jcbBirthYear);
        Row7.add(jlbAge);
        Row7.add(jtfAge);
        Row7.add(jlbAgeYear);

        mainPanel.add(Row1);
        mainPanel.add(Row2);
        mainPanel.add(Row3);
        mainPanel.add(Row4);
        mainPanel.add(Row5);
        mainPanel.add(Row6);
        mainPanel.add(Row7);

        JButton saveButton = new JButton("SAVE");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id = jtfID.getText();
                money = jtfMONEY.getText();
                interestRate = jtfRate.getText();
                openDay = (String) jcbOpenDay.getSelectedItem();
                openMonth = (String) jcbOpenMonth.getSelectedItem();
                openYear = (String) jcbOpenYear.getSelectedItem();
                firstName = jtfFname.getText();
                lastName = jtfLname.getText();
                birthDay = (String) jcbBirthDay.getSelectedItem();
                birthMonth = (String) jcbBirthMonth.getSelectedItem();
                birthYear = (String) jcbBirthYear.getSelectedItem();
                age = jtfAge.getText();
            }
        });

        JButton showButton = new JButton("SHOW");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainPanel, "ID: " + id + "\nMoney: " + money + "\nInterest Rate: " + interestRate
                        + "\nOpen Day: " + openDay + "\nOpen Month: " + openMonth + "\nOpen Year: " + openYear
                        + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nBirth Day: " + birthDay
                        + "\nBirth Month: " + birthMonth + "\nBirth Year: " + birthYear + "\nAge: " + age);
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(saveButton);
        buttonPanel.add(showButton);

        mainPanel.add(buttonPanel);

        add(mainPanel);
    }
}