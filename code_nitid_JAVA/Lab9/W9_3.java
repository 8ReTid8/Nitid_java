import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class W9_3 extends JFrame {
    private JTextField jtfAnnualInterestRate = new JTextField();
    private JTextField jtfNumberOfYears = new JTextField();
    private JTextField jtfLoanAmount = new JTextField();
    private JTextField jtfMonthlyPayment = new JTextField();
    private JTextField jtfTotalPayment = new JTextField();

    private JButton jbtComputeLoan = new JButton("Compute Payment");

    public W9_3() {
        JPanel p1 = new JPanel(new GridLayout(5, 2));
        p1.add(new JLabel("Annual Interest Rate"));
        p1.add(jtfAnnualInterestRate);
        p1.add(new JLabel("Number of Years"));
        p1.add(jtfNumberOfYears);
        p1.add(new JLabel("Loan Amount"));
        p1.add(jtfLoanAmount);
        p1.add(new JLabel("Monthly Payment"));
        p1.add(jtfMonthlyPayment);
        p1.add(new JLabel("Total Payment"));
        p1.add(jtfTotalPayment);
        p1.setBorder(new TitledBorder("Enter loan amount, interest rate, and years"));

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p2.add(jbtComputeLoan);

        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        jbtComputeLoan.addActionListener(new ButtonListener());
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double interest = Double.parseDouble(jtfAnnualInterestRate.getText());
            int year = Integer.parseInt(jtfNumberOfYears.getText());
            double loanAmount = Double.parseDouble(jtfLoanAmount.getText());

            Loan loan = new Loan(interest, year, loanAmount);

            jtfMonthlyPayment.setText(String.format("%.2f", loan.getMonthlyPayment()));
            jtfTotalPayment.setText(String.format("%.2f", loan.getTotalPayment()));
        }
    }

    public static void main(String[] args) {
        W9_3 frame = new W9_3();
        frame.pack();
        frame.setTitle("LoanCalculator");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    public Loan() {
        this(2.5, 1, 1000);
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }
}

// บรรทัดที่ 7-13 สร้าง textfield รับค่าตัวแปร และปุ่มกด
// บรรทัดที่ 15-36 สร้าง JFrame มา add textfield
//                 ใน p1 และ jframe p2 add button และจัด layout ทั้งคู่
//                 และ add ใน constuctor และรับคำสั่งการทำงานของ buttom
// บรรทัดที่ 38-50 สร้าง class รับคำสั่งการทำงาน ของ button ในการคำนวน loan
// บรรทัดที่ 52-59 เรียกใช้ obj ที่ทำไว้มาแสดงผล  jframe JButton
// บรรทัดที่ 62-66 สร้าง class กับกำหนดตัวแปร private
// บรรทัดที่ 68-77 สร้าง constuctor เก็บตัวแปร annualInterestRate numberOfYears loanAmount loanDate
// บรรทัดที่ 79-93 สร้าง method รับ ค่าตัวแปร และ เรียกใช้ ตัวแปร ของ annualInterestRat and numberOfYears