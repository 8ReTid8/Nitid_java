import java.util.Scanner;
import java.lang.Math;

public class NumHW3_1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        double xold = 0;
        int i=1;
        do{
            xold = x;
            x = (xold+1)/3;
            System.out.println("iter "+i+": xnew = "+x+" xold = "+xold);
            i++;
        }while(Math.abs((x-xold)/x)*100>0.000001);
        System.out.println(x);
    }
}