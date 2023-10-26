import java.util.Scanner;
public class NumHW12_1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double x0 = input.nextDouble();
        double xn = input.nextDouble();
        double n = input.nextDouble();
        double h = (xn-x0)/n;
        double sum = f(x0)+f(xn);
        double xtemp = x0;
        int i=1;
        while(i<n){
            double x = x0+h*i;
            // if(x0==xn){
            //     break;
            // }
            sum += 2*f(x);
            i++;
        }
        sum*=(h/2);
        System.out.println(sum);
        double e = err(xn)-err(xtemp);
        System.out.println(((e-sum)/e)*100);
    }
    public static double err(double x){
        return ((4*Math.pow(x,6))/6)-((3*Math.pow(x,5))/5)+((Math.pow(x,4))/4)-((6*(x*x))/2)+2*x;
    }
    public static double f(double x){
        return (4*Math.pow(x,5))-(3*Math.pow(x,4))+Math.pow(x,3)-(6*x)+2;
    }
}