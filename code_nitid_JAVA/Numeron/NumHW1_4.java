import java.lang.Math;
import java.util.Scanner;

public class NumHW1_4{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double xl,xr,xm=0,fxl,fxr,fxm=1,i=0,xrold=0;
        xl = input.nextDouble();
        xr = input.nextDouble();
        while(fxm!=0){
            xm = (xl+xr)/2;
            fxm = Math.pow(xm,2)-7;
            fxr = Math.pow(xr,2)-7;
            fxl = Math.pow(xl,2)-7;
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
        System.out.println(String.format("%.6f",xm));
    }
}