import java.util.Scanner;
import java.lang.Math;
public class W3_8{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        estimate a = new estimate(n);
        System.out.println(a.mi());
    }
}

class estimate{
    private double x;
    public estimate(double x){
        this.x = x;
    }

    double mi(){
        double ans=0;
        for(int i=1;i<=x;i++){
            ans += Math.pow(-1,i+1)/((2*i)-1);
        }
        return ans*4;
    }
}