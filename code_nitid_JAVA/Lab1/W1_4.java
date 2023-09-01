import java.util.Scanner;
public class W1_4{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double bal,in,ans;
        System.out.print("Enter balance and interest rate (e.g., 3 for 3%):");
        bal = input.nextDouble();
        in = input.nextDouble();
        ans = bal*(in/1200);
        System.out.print("The interest is "+ans);
    }
}