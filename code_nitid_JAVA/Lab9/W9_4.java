

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class W9_4 extends JFrame{
	JLabel jlbUSD = new JLabel("Us Dollars");
	JLabel jlbCAD = new JLabel("Canadian Dollars");
	
	JLabel empty = new JLabel("");
	
	JTextField jtfUSD = new JTextField();
	JTextField jtfCAD = new JTextField();
	JLabel jlbResult = new JLabel();
	
	JButton jbtnConvert = new JButton("Convert");
	JPanel p = new JPanel();
	JPanel r = new JPanel();
	JPanel b = new JPanel();
	JPanel big = new JPanel();
	
	
	
	
	W9_4() {
		add(big);
		
		p.setLayout(new GridLayout(2, 1, 0, 0));
		p.add(jlbUSD);
		p.add(jlbCAD);
		
		r.setLayout(new GridLayout(2, 1, 0, 0));
		r.add(jtfUSD);
		r.add(jtfCAD);
		jtfCAD.setHorizontalAlignment(JTextField.RIGHT);
		jtfUSD.setHorizontalAlignment(JTextField.RIGHT);
		jtfCAD.setEditable(false);
		
		b.add(jbtnConvert);
		
		big.setLayout(new GridLayout(2, 2, 0, 0));
		big.add(p);
		big.add(r);
		big.add(b);
		Listener spyButton = new Listener();
		
		jbtnConvert.addActionListener(spyButton);
		
	}
	
	public double usdToCad(double usd) {
		return usd * 1.5;
	}
	
	
	public static void main(String[] args) {
		W9_4 frame = new W9_4();
		frame.setSize(400,150);
		frame.setTitle("ตู้");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	class Panel1 extends JPanel {
		JLabel jlbUSD = new JLabel("Us Dollars");
		JLabel jlbCAD = new JLabel("Canadian Dollars");
		
		Panel1() {
			setLayout(new GridLayout(2, 1, 0, 0));
			add(jlbUSD);
			add(jlbCAD);
		}
	}
	class Listener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Convert") {
				double usd = Double.parseDouble(jtfUSD.getText());
				jtfCAD.setText(String.valueOf(usdToCad(usd)));
			}
			
		}
		
	}
}

