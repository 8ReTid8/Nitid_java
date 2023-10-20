import jdk.jshell.JShell;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class W9_5 extends JFrame {
    JPanel botBoxPanel = new JPanel();
    JPanel topBoxPanel = new JPanel(new BorderLayout());

    JPanel MainTopPanel = new JPanel(new GridLayout(4,1));
    JPanel MainRightPanel = new JPanel(new GridLayout(4,1));
    JPanel MainBotPanel = new JPanel(new GridLayout(4,3));

    JPanel insidebotBox = new JPanel();
    JPanel trueMain = new JPanel(new BorderLayout());
    JLabel topText = new JLabel(" ",SwingConstants.RIGHT);

    public static void main(String args[]){
        W9_5 a = new W9_5();
        a.setSize(250,200);
        a.setLocationRelativeTo(null);
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);
        a.setVisible(true);
    }
    W9_5(){
        int start=7;
        for (int i = 0;i<3;i++){
            for (int j=start;j<=start+2;j++){
                JButton temp = new JButton(String.valueOf(j));
                int num = j;
                temp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!topText.getText().equals(" ")) {
                            topText.setText(topText.getText() + String.valueOf(num));
                        } else {
                            topText.setText(String.valueOf(num));
                        }
                    }
                });
                MainBotPanel.add(temp);
            }
            start-=3;
        }
        JButton number = new JButton("0");
        number.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (topText.getText() != "") {
                    topText.setText(topText.getText() + String.valueOf(0));
                } else {
                    topText.setText(String.valueOf(0));
                }
            }
        });
        MainBotPanel.add(number);

        JButton point = new JButton(".");
        point.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topText.setText(topText.getText() + ".");
            }
        });
        MainBotPanel.add(point);

        JButton equal = new JButton("=");
        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(JShell js = JShell.create();) {

                    js.onSnippetEvent(snip -> {
                        if (snip.status() == jdk.jshell.Snippet.Status.VALID) {
                            topText.setText(String.valueOf(snip.value()));
                        }
                    });
                    js.eval(js.sourceCodeAnalysis().analyzeCompletion(topText.getText()).source());
                }
            }
        });
        MainBotPanel.add(equal);

        JButton plus = new JButton("+");
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topText.setText(topText.getText() + " + ");
            }
        });
        MainRightPanel.add(plus);

        JButton minus = new JButton("-");
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topText.setText(topText.getText() + " - ");
            }
        });
        MainRightPanel.add(minus);

        JButton multi = new JButton("*");
        multi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topText.setText(topText.getText() + " * ");
            }
        });
        MainRightPanel.add(multi);

        JButton divide = new JButton("/");
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topText.setText(topText.getText() + " / ");
            }
        });
        MainRightPanel.add(divide);

        JButton clear = new JButton("C");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topText.setText(" ");
            }
        });
        MainTopPanel.add(clear);

        JButton abs = new JButton("| |");
        abs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double temp = Double.parseDouble(topText.getText());
                topText.setText(String.valueOf(Math.abs(temp)));
            }
        });
        MainTopPanel.add(abs);

        JButton sqrtbutton = new JButton("^1/2");
        sqrtbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double temp = Double.parseDouble(topText.getText());
                topText.setText(String.valueOf(Math.sqrt(temp)));
            }
        });
        MainTopPanel.add(sqrtbutton);

        JButton power = new JButton("^2");
        power.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double temp = Double.parseDouble(topText.getText());
                topText.setText(String.valueOf(Math.pow(temp,2)));
            }
        });
        MainTopPanel.add(power);

        topBoxPanel.add(topText,BorderLayout.CENTER);
        insidebotBox.add(MainBotPanel);
        insidebotBox.add(MainRightPanel);
        insidebotBox.add(MainTopPanel);
        botBoxPanel.add(insidebotBox);

        trueMain.add(topBoxPanel,BorderLayout.NORTH);
        trueMain.add(botBoxPanel,BorderLayout.CENTER);

        add(trueMain);
    }
}