import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;

public class W11_2 extends JFrame {
    private StillClock clock = new StillClock();

    public W11_2() {
        add(clock);

        // Create a timer with a delay of 1000 ms
        // Timer timer = new Timer(1000, new TimerListener());
        Thread timer = new Thread(new Runnable() {
            public void run(){
                while(true){
                    try{
                        clock.setCurrentTime();
                        clock.repaint();
                        Thread.sleep(10);
                    }catch(Exception e){}
                }
            }
        });
        timer.start();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Set new time and repaint the clock to display the current time
            clock.setCurrentTime();
            clock.repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new W11_2();
        frame.setTitle("ClockAnimation");
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null); // Center the frame
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

    public StillClock(int hour,int minute,int second) {
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

        int clockRadius = (int)(Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        // Draw the clock elements
        g.setColor(Color.BLACK);
        g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
        g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
        g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
        g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
        g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

        // Draw the clock hands
        int sLength = (int)(clockRadius * 0.8);
        int xSecond = (int)(xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
        int ySecond = (int)(yCenter - sLength * Math.cos(second * (2 * Math.PI / 60)));
        g.setColor(Color.RED);
        g.drawLine(xCenter, yCenter, xSecond, ySecond);

        int mLength = (int)(clockRadius * 0.65);
        int xMinute = (int)(xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60)));
        int yMinute = (int)(yCenter - mLength * Math.cos(minute * (2 * Math.PI / 60)));
        g.setColor(Color.BLUE);
        g.drawLine(xCenter, yCenter, xMinute, yMinute);

        int hLength = (int)(clockRadius * 0.5);
        int xHour = (int)(xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int)(yCenter - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        g.setColor(Color.GREEN);
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
