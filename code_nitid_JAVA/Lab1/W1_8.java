import java.util.Scanner;
import java.lang.Math;
public class W1_8{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n,a0,a1,i;
        System.out.print("Please input n, a0 and a1: ");
        n = input.nextInt();
        int[] a = new int[n+1];
        a[0] = input.nextInt();
        a[1] = input.nextInt();
        for(i=2;i<=n;i++){
            a[i] = (i*i)*a[i-1]-a[i-2]+((int)Math.pow(3,i));
        }
        System.out.print("Out put is : ");
        for(i=0;i<=n;i++){
            System.out.print(a[i]+" ");
        }
    }
}