import java.util.Scanner;
import java.lang.Math;
public class NumHW3_2{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double x0 = input.nextDouble();
        double x = 4;
        double sum=0;
        sum += Math.log(x0);
        System.out.println("n0 = "+sum+" Error = "+Math.abs((sum-Math.log(4))/Math.log(4))*100);
        sum += (x-x0)*(1/x0);
        System.out.println("n1 = "+sum+" Error = "+Math.abs((sum-Math.log(4))/Math.log(4))*100);
        double topdiff = 1,fact = 1;
        for(int i=2;i<4;i++){
            fact *= i;
            topdiff = (topdiff*-1*(i-1));
            sum += (Math.pow(x-x0,i)/fact)*(topdiff/Math.pow(x0,i));
            System.out.println("n"+i+" = "+sum+" Error = "+Math.abs((sum-Math.log(4))/Math.log(4))*100);
        }
        System.out.println(sum);
    }
}