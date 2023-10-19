import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author student
 */
public class W8_3 extends JFrame {
    public W8_3(){
        getContentPane().setLayout(new GridLayout(2, 2, 5, 5));
        getContentPane().add(new ex1());
        getContentPane().add(new ex2());
        getContentPane().add(new ex3());
        getContentPane().add(new ex4());
        getContentPane().add(new ex5());
        getContentPane().add(new ex6());
        getContentPane().add(new ex7());
    }
    public static void main(String[] args) {
        W8_3 frame = new W8_3();
        frame.setSize(400, 400);
        frame.setTitle("Exercise 10.10");
        frame.setVisible(true);
    }
    
}

abstract class AbstractDrawFunction extends JPanel{
    /**Polygon to hold the points*/
    private Polygon p = new Polygon();
    /**Default constructor*/
    protected AbstractDrawFunction (){
        drawFunction();
        setBackground(Color.white);
    }
    /**Draw the function*/
    public abstract double f(double x);
    /**Obtain points for x coordinates 100, 101, ..., 300*/
    public void drawFunction(){
        for (int x = -100; x <= 100; x++){
            p.addPoint(x+200, 200-(int)f(x));
        }
    }
    /**Paint the function diagram*/ 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // Draw x axis
        g.drawLine(10, 200, 390, 200);
        // Draw y axis
        g.drawLine(200,30, 200, 390);
        // Draw arrows on x axis
        g.drawLine(390, 200, 370, 190);
        g.drawLine(390, 200, 370, 210);
        // Draw arrows on y axis
        g.drawLine(200, 30, 190, 50);
        g.drawLine(200, 30, 210, 50);
        // Draw x, y
        g.drawString("X", 370, 170);
        g.drawString("Y", 220, 40);
        // Draw a polygon line by connecting the points in the polygon
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }
}
class ex1 extends AbstractDrawFunction{

    @Override
    public double f(double x){
        return x*x;
    }
    protected ex1(){
        drawFunction();
        setBackground(Color.CYAN);
    }
}
class ex2 extends AbstractDrawFunction{
    
    @Override
    public double f(double x){
        return Math.sin(x)*100;
    }
    protected ex2(){
        drawFunction();
    }
}
class ex3 extends AbstractDrawFunction{
    
    @Override
    public double f(double x){
        return Math.cos(x)*100;
    }
    protected ex3(){
        drawFunction();
    }
}
class ex4 extends AbstractDrawFunction{
    
    @Override
    public double f(double x){
        return Math.tan(x)*100;
    }
    protected ex4(){
        drawFunction();
    }
}
class ex5 extends AbstractDrawFunction{
    
    @Override
    public double f(double x){
        return Math.cos(x)+(5*Math.sin(x));
    }
    protected ex5(){
        drawFunction();
    }
}
class ex6 extends AbstractDrawFunction{
    
    @Override
    public double f(double x){
        return (5*Math.cos(x))+Math.sin(x);
    }
    protected ex6(){
        drawFunction();
    }
}
class ex7 extends AbstractDrawFunction{
    
    @Override
    public double f(double x){
        return Math.log(x)+(x*x);
    }
    protected ex7(){
        drawFunction();
    }
}
