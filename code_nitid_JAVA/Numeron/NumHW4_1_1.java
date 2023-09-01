import java.util.Scanner;
import java.lang.Math;

public class NumHW4_1_1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double x0 = input.nextDouble();
        double x1 = x0-(Math.pow(x0,2)-7)/(2*x0);
        double x;
        int i=2;
        while(Math.abs((x1-x0)/x1)*100>=0.000001){
            x = x1;
            x1 = x1 - (f(x1)*(x1-x0))/(f(x1)-f(x0));
            System.out.println("iter "+i+" = "+ x1);
            i++;
            x0 = x;
        }
        System.out.println(x1);
    }
    public static double f(double x){
        return Math.pow(x,2)-7;
    }
}