import java.util.Scanner;
public class NumHW12_2{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double x0 = input.nextDouble();
        double xn = input.nextDouble();
        double n = input.nextDouble();
        double h = (xn-x0)/n;
        double sum = f(x0)+f(xn);
        int i=1;
        double xtemp = x0;
        while(x0<xn){
            
            x0+=h;
            if(x0==xn){
                break;
            }
            if(i%2==0){
                sum += 2*f(x0);
            }
            else{
                sum += 4*f(x0);
                System.out.println(4*f(x0));
            }
            i++;
        }
        sum *= h/3;
        System.out.println(sum);
        double e = err(xn)-err(xtemp);
        System.out.println(e);
        System.out.println(((e-sum)/e)*100);
    }
    public static double err(double x){
        return (Math.pow(x,8)/8)+((2*Math.pow(x,4))/4)-x;
    }
    public static double f(double x){
        return Math.pow(x,7)+(2*Math.pow(x,3))-1;
    }
}