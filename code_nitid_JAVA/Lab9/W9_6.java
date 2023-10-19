
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class W9_6 extends JFrame{
	
	W9_6() {
		add(new Canvas());
	}

	class Canvas extends JPanel {
		Timer timer = new Timer(50, new Listener());
		boolean swingForward = true;
		int offset = 0;
		
		Canvas() {
			timer.start();
		}
		
		private void updatePosition() {
			if (offset > 20) {
				swingForward = false;
			} else if (offset <= -20) {
				swingForward = true;
			}
			
			if (swingForward) {
				offset++;
			} else {
				offset--;
			}
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			updatePosition();
			
			g.drawArc(20, 220, 80, 40, 0, 180);
			g.drawLine(20 + 40, 220, 20 + 40, 20);
			g.drawLine(20 + 40, 20, 20 + 40 + 100, 20);
			
			g.drawLine(160, 20, 160 + offset, 40);
			
			int radius = 20;
			g.drawOval(20 + 40 + 100 - radius + offset, 40, 2 * radius, 2 * radius);
			
			g.drawLine(20 + 40 + 100 - (int)(radius *
			Math.cos(Math.toRadians(45))) + offset,
			40 + radius + (int)(radius * Math.sin(Math.toRadians(45))),
			20 + 40 + 100 - 60, 40 + radius + 60);
			
			g.drawLine(20 + 40 + 100 + (int)(radius *
			Math.cos(Math.toRadians(45))) + offset,
			40 + radius + (int)(radius * Math.sin(Math.toRadians(45))),
			20 + 40 + 100 + 60 , 40 + radius + 60);
			
			g.drawLine(20 + 40 + 100 + offset, 40 + 2 * radius,
			20 + 40 + 100 + offset, 40 + radius + 80);
			
			g.drawLine(20 + 40 + 100 + offset, 40 + radius + 80, 20 + 40 + 100 - 40 + offset,
			40 + radius + 80 + 40);
			
			g.drawLine(20 + 40 + 100 + offset, 40 + radius + 80, 20 + 40 + 100 + 40 + offset,
			40 + radius + 80 + 40);
			
			g.dispose();
		}
		
		class Listener implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
			
		}
	}

	public static void main(String[] args) {
		W9_6 frame = new W9_6();
		frame.setSize(500, 500);
		frame.setTitle("the one piece is real");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
}