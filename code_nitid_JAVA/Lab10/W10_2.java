import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;

public class W10_2 extends JFrame {

    private StillClock clock = new StillClock();
    public StillClock other = new StillClock();
    JPanel p1 = new JPanel(new GridLayout(1, 2, 5, 5));
    JPanel text = new JPanel();
    JPanel top = new JPanel();
    JLabel inputtxt = new JLabel("input country");
    JTextField input = new JTextField(10);
    JButton jbtok = new JButton("ok");
    JLabel thai = new JLabel("thai ");
    JLabel country = new JLabel("japan");
    int hour = 2;
    String gettext;

    public W10_2() {
        //top
        top.add(thai);
        top.add(country);
        //text
        text.add(inputtxt);
        text.add(input);
        text.add(jbtok);
        //clock
        p1.add(clock);
        p1.add(other);
        add(p1);
        add(text, BorderLayout.SOUTH);
        add(top, BorderLayout.NORTH);
        TimerListener spy = new TimerListener();
        jbtok.addActionListener(spy);
        // Create a timer with delay 1000 ms
        Timer timer = new Timer(1000, new TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clock.setCurrentTime();
            clock.repaint();
            other.setCurrentTime();
            other.setHour(clock.getHour() + hour);
            other.repaint();
            gettext = input.getText();
            if(e.getActionCommand() == "ok"){
                if(gettext.trim().equals("us")){
                    country.setText("us");
                    hour = -11;
                }
                if(gettext.trim().equals("japan")){
                    country.setText("japan");
                    hour = 2;
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new W10_2();
        frame.setTitle("ClockAnimation");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class StillClock extends JPanel {

    private int hour;
    private int minute;
    private int second;

    public StillClock() {
        setCurrentTime();
    }

    public StillClock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        repaint();
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        repaint();
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int clockRadius = (int) (Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        g.setColor(Color.black);
        g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
        g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
        g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
        g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
        g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

        int sLength = (int) (clockRadius * 0.8);
        int xSecond = (int) (xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
        int ySecond = (int) (yCenter - sLength * Math.cos(second * (2 * Math.PI / 60)));
        g.setColor(Color.red);
        g.drawLine(xCenter, yCenter, xSecond, ySecond);

        int mLength = (int) (clockRadius * 0.65);
        int xMinute = (int) (xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60)));
        int yMinute = (int) (yCenter - mLength * Math.cos(minute * (2 * Math.PI / 60)));
        g.setColor(Color.blue);
        g.drawLine(xCenter, yCenter, xMinute, yMinute);

        int hLength = (int) (clockRadius * 0.5);
        int xHour = (int) (xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int) (yCenter - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        g.setColor(Color.green);
        g.drawLine(xCenter, yCenter, xHour, yHour);
    }

    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}