import java.util.Scanner;
import java.lang.Math;
public class W1_7{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int x,n,i,a=0;
        System.out.print("Please input x, n: ");
        x = input.nextInt();
        n = input.nextInt();
        for(i=0;i<=n;i++){
            a += Math.pow(x,i);
        }
        System.out.print("Output is: "+a);
    }
}