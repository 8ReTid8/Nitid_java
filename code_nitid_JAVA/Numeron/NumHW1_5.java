import java.lang.Math;
import java.util.Scanner;

public class NumHW1_5{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double xl=0,xr=1000000,xm=0,fxl,fxr,fxm=1,i=0,x,n,xrold=0;
        x = input.nextDouble();
        n = input.nextDouble();

        while(fxm!=0){
            xm = (xl+xr)/2;
            fxm = Math.pow(xm,n)-x;
            fxr = Math.pow(xr,n)-x;
            fxl = Math.pow(xl,n)-x;
            if(fxm*fxr>0){
                xrold = xr;
                xr = xm;
            }
            if(fxm*fxr<0){
                xl = xm;
            }
            if(fxm*fxr==0){
                break;
            }
            if(Math.abs(((xr-xrold)/xr)*100) < 0.000001){             
                break;
            }
        }
        System.out.println(String.format("%.4f",xm));
    }
}