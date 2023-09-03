import java.util.Scanner;
import java.lang.Math;
public class W4_6 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[][] point = new double[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                point[i][j] = input.nextDouble();
            }
        }
        cal(point);
    }
    public static void cal(double[][] x){
        double total;
        double ans=10000000;
        for(int i=0;i<x.length;i++){
            for(int j=i+1;j<x.length;j++){
                total = Math.sqrt(Math.pow(x[i][0]-x[j][0],2)+Math.pow(x[i][1]-x[j][1],2));
                if(total<ans){
                    ans = total;
                }
            }
        }
        System.out.printf("%.2f \n",ans);
    }
}
