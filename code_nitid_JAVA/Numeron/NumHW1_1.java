import java.util.Scanner;
public class NumHW1_1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        Double y = 5-x;
        while(y!=0){
            x++;
            double ynew = 5-x;
            if(y*ynew>0){
                y = ynew;
            }
            if(y*ynew<0){
                x = x-1;
                double z = x;
                while(y<0.000001){
                    x+=0.000001;
                    y=(43*x)-180;
                }
                break;
            }
        }
        System.out.print(String.format("%.6f",x));
    }
}