import java.util.Scanner;
import java.lang.Math;
public class NumHW3_3{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        double xold=0,i=1;
        do{
            xold = x;
            x = xold - (Math.pow(xold,2)-7)/(2*xold);
            System.out.println("x"+i+" "+x);
            i++;
        }while(Math.abs((x-xold)/x)*100>=0.000001);
        System.out.println(x);
    }
} 