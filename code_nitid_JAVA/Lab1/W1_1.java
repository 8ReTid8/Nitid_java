import javax.swing.JOptionPane;
public class W1_1{
    public static void main(String[] args){
        String input = JOptionPane.showInputDialog(null, "input", "Temperature as Fahrenheit", JOptionPane.QUESTION_MESSAGE);
        double FH = Double.parseDouble(input);
        String CS = String.valueOf((5.0/9.0)*(FH-32));
        JOptionPane.showMessageDialog(null, "answer "+CS+" \u00B0C", "Temperature as Celsius", JOptionPane.PLAIN_MESSAGE);
    } 
}