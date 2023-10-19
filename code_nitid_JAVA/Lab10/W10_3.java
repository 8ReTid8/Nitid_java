import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class W10_3 extends JFrame {
    public W10_3() {
        add(new RaceCar());
    }

    public static void main(String[] args) {
        W10_3 frame = new W10_3();
        frame.setTitle("Exercise");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class RaceCar extends JPanel {
    private int xBase = 0;
    private Timer timer = new Timer(10, new Listener());

    public RaceCar() {
        timer.start();
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == 61) {
                    if (timer.getDelay() > 5)
                        timer.setDelay(timer.getDelay() - 5);
                } else if (e.isControlDown() && e.getKeyCode() == 45)
                    timer.setDelay(timer.getDelay() + 1);
            }
        });
    }

    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yBase = getHeight();
        if (xBase > getWidth())
            xBase = -20;
        else
            xBase += 1;

        g.setColor(Color.BLACK);
        g.fillOval(xBase + 10, yBase - 10, 10, 10);
        g.fillOval(xBase + 30, yBase - 10, 10, 10);

        g.setColor(Color.GREEN);
        g.fillRect(xBase, yBase - 20, 50, 10);

        g.setColor(Color.RED);
        Polygon polygon = new Polygon();
        polygon.addPoint(xBase + 10, yBase - 20);
        polygon.addPoint(xBase + 20, yBase - 30);
        polygon.addPoint(xBase + 30, yBase - 30);
        polygon.addPoint(xBase + 40, yBase - 20);
        g.fillPolygon(polygon);
    }
}
