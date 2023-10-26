import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class W9_8_1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AngryBirds frame = new AngryBirds();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class AngryBirds extends JFrame {
    gamePanel gp = new gamePanel();
    inputPanel ip = new inputPanel();
    scorePanel sp = new scorePanel();
    JButton jbtOK = new JButton("OK");

    JPanel mainPanel = new JPanel(new BorderLayout());
    Thread timer = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true) {
                try {
                    sp.jtfScore.setText(sp.score+"");
                    repaint();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        }
    });
    AngryBirds() {
        setLayout(new BorderLayout());
        mainPanel.add(sp, BorderLayout.NORTH);
        mainPanel.add(gp, BorderLayout.CENTER);
        mainPanel.add(ip, BorderLayout.SOUTH);
        jbtOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int yPos = Integer.parseInt(ip.jtfPosition.getText());
                int speed = Integer.parseInt(ip.jtfSpeed.getText());
                int angle = Integer.parseInt(ip.jtfAngle.getText());
                gp.player.shoot(yPos, speed, angle);
            }
        });
        add(jbtOK, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        timer.start();
    }

    static class gamePanel extends JPanel {
        public int score = 0;
        public Bird player = new Bird();
        public Pig monster = new Pig();
        gamePanel() {
            setPreferredSize(new Dimension(800, 400));
            setBackground(Color.BLACK);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            player.draw(g);
            monster.draw(g);
        }

        public void checkHit(Pig monster, Bird player) {
            if (player.hitbox.intersects(monster.hitbox)) {
                score++;
            }
        }
    }

    static class Bird {
        ImageIcon birdIMG = new ImageIcon(W9_8_1.class.getResource("bird.png"));
        double x = 50;
        Random rand = new Random();
        double y = rand.nextInt(300);
        double size = 40;
        Rectangle hitbox = new Rectangle((int) x, (int) y, (int) size, (int) size);

        public void shoot(int yPos, int speed, int angle) {
            double g = 9.8;
            double angleInRadians = Math.toRadians(angle);

            double v0x = speed * Math.cos(angleInRadians);
            double v0y = speed * Math.sin(angleInRadians);
            double t = (v0y + Math.sqrt(v0y * v0y + 2 * g * yPos)) / g; // time of flight

            x += v0x * t;
            y -= (v0y * t - 0.5 * g * t * t);
            hitbox.setLocation((int) x, (int) y);
        }


        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.drawImage(birdIMG.getImage(), (int) x, (int) y, (int) size, (int) size, null);
        }
    }

    static class Pig {
        ImageIcon pigIMG = new ImageIcon(W9_8_1.class.getResource("pig.png"));
        int x = 650;
        int y = 50;
        int size = 40;
        Rectangle hitbox = new Rectangle((int) x, (int) y, (int) size, (int) size);

        public void resetY() {
            Random r = new Random();
            y = r.nextInt(251) + 50;
            hitbox.setLocation((int) x, (int) y);
        }

        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.drawImage(pigIMG.getImage(), x, y, size, size, null);

        }
    }

    static class inputPanel extends JPanel {
        JLabel jlbPosition = new JLabel("Bird Position in y-axis");
        JLabel jlbSpeed = new JLabel("Shooting speed");
        JLabel jlbAngle = new JLabel("Angle");

        JLabel jlbPositionM = new JLabel("m");
        JLabel jlbSpeedMS = new JLabel("m/s");
        JLabel jlbAngleDeg = new JLabel("degree");

        JTextField jtfPosition = new JTextField(10);
        JTextField jtfSpeed = new JTextField(10);
        JTextField jtfAngle = new JTextField(10);

        inputPanel() {
            setPreferredSize(new Dimension(800, 300));
            setLayout(new GridLayout(4, 3));
            add(jlbPosition);
            add(jtfPosition);
            add(jlbPositionM);

            add(jlbSpeed);
            add(jtfSpeed);
            add(jlbSpeedMS);

            add(jlbAngle);
            add(jtfAngle);
            add(jlbAngleDeg);
        }
    }

    static class scorePanel extends JPanel {
        JLabel jlbScene = new JLabel("SCENE 1: At Tokyo");
        JLabel jlbScore = new JLabel("SCORE");
        JTextField jtfScore = new JTextField(10);

        JPanel score = new JPanel(new GridLayout(1, 2));

        scorePanel() {
            setLayout(new BorderLayout());
            score.add(jlbScore);
            score.add(jtfScore);
            add(jlbScene, BorderLayout.CENTER);
            add(score, BorderLayout.EAST);
        }
    }
}
