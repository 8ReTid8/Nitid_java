import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class W9_8 extends JFrame {
    private JPanel gamePanel;
    private JTextField birdYPositionField;
    private JTextField birdSpeedField;
    private JTextField birdAngleField;
    private JButton okButton;
    private int birdXPosition;
    private int birdYPosition;
    private int birdSpeed;
    private int birdAngle;
    private int pigXPosition;
    private int pigYPosition;
    private int score;

    public W9_8() {
        // Initialize the game panel
        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Draw the bird as a circle
                g.setColor(Color.RED);
                g.fillOval(birdXPosition, birdYPosition, 30, 30);

                // Draw the pig as a triangle
                int[] xPoints = {pigXPosition, pigXPosition + 20, pigXPosition + 10};
                int[] yPoints = {pigYPosition, pigYPosition, pigYPosition - 30};
                g.setColor(Color.GREEN);
                g.fillPolygon(xPoints, yPoints, 3);

                // Display the score
                g.setColor(Color.BLACK);
                g.drawString("Score: " + score, 10, 20);
            }
        };

        birdYPositionField = new JTextField(5);
        birdSpeedField = new JTextField(5);
        birdAngleField = new JTextField(5);
        okButton = new JButton("Ok");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the user-input bird parameters
                birdYPosition = Integer.parseInt(birdYPositionField.getText());
                birdSpeed = Integer.parseInt(birdSpeedField.getText());
                birdAngle = Integer.parseInt(birdAngleField.getText());

                // Calculate the bird's final position (birdXPosition) based on the given parameters
                double t = (2.0 * birdSpeed * Math.sin(Math.toRadians(birdAngle))) / 10.0;
                birdXPosition = (int) (t * birdSpeed * Math.cos(Math.toRadians(birdAngle)));

                // Check if the bird's final position is close to the pig's position
                if (Math.abs(birdXPosition - pigXPosition) <= 20) {
                    // Bird hits the pig, increase the score
                    score += 100;
                }

                // Repaint the game panel to update the bird and pig positions
                gamePanel.repaint();
            }
        });

        // Set up the layout of the game frame
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Bird Y Position:"));
        inputPanel.add(birdYPositionField);
        inputPanel.add(new JLabel("Bird Speed:"));
        inputPanel.add(birdSpeedField);
        inputPanel.add(new JLabel("Bird Angle:"));
        inputPanel.add(birdAngleField);
        inputPanel.add(okButton);

        add(inputPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);

        // Initialize pig and bird positions
        Random random = new Random();
        pigXPosition = random.nextInt(400); // Random position for the pig
        pigYPosition = 300; // Fixed Y-position for the pig

        birdXPosition = 0; // Initial X-position for the bird
        birdYPosition = 300; // Initial Y-position for the bird

        // Initialize the score
        score = 0;

        // Set frame properties
        setTitle("Angry Birds Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            W9_8 game = new W9_8();
            game.setVisible(true);
        });
    }
}
