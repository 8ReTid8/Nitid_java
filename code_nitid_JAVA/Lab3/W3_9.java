import java.util.Scanner;

public class W3_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        checkPosition position = new checkPosition();
        position.setp0();
        position.setp1();
        position.setp2();
        System.out.println(position.check());
        position.show();
    }
}

class checkPosition{
    Scanner input = new Scanner(System.in);
    public double[] p0 = new double[2];
    public double[] p1 = new double[2];
    public double[] p2 = new double[2];
    
    void setp0(){
        for(int i=0;i<2;i++){
            p0[i] = input.nextDouble();
        }
    }
    void setp1(){
        for(int i=0;i<2;i++){
            p1[i] = input.nextDouble();
        }
    } 
    void setp2(){
        for(int i=0;i<2;i++){
            p2[i] = input.nextDouble();
        }
    } 
    void show(){
        double value = (p1[0] - p0[0]) * (p2[1] - p0[1]) - (p2[0] - p0[0]) * (p1[1] - p0[1]);
        System.out.println(value);
    }

    int check() {
        double value = (p1[0] - p0[0]) * (p2[1] - p0[1]) - (p2[0] - p0[0]) * (p1[1] - p0[1]);
        if (value == 0) {
            return 0; // Point p2 is on the line
        } else if (value > 0) {
            return 1; // Point p2 is on the right of the line
        } else {
            return 2; // Point p2 is on the left of the line
        }
    }

}
