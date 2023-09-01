import java.util.Scanner;
import java.lang.Math;
public class NumHW2_2and3{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double xnew=0,xold;
        int i=1;
        double x = input.nextDouble();
        // x = (x+1)/44;
        x = (7+x)/(x+1);
        xold = x;
        System.out.println("x"+i+" "+x);
        i++;
        while(Math.abs(xnew-xold)>0.000001){
            xold = x;
            // xnew = (x+1)/44;
            xnew = (7+x)/(x+1);
            x = xnew;
            double a = Math.abs(xnew-xold);
            System.out.println("err = "+a);
            System.out.println("x"+i+" "+xnew);
            i++;
        }
        System.out.println(xnew);
    }
}
