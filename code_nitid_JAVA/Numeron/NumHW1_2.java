import java.lang.Math;
import java.util.Scanner;

public class NumHW1_2{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double xl,xr,xm=0,fxl,fxr,fxm=1,i=0;
        xl = input.nextDouble();
        xr = input.nextDouble();
        while(fxm!=0){
            xm = (xl+xr)/2;
            fxm = Math.pow(xm,4)-13;
            fxr = Math.pow(xr,4)-13;
            fxl = Math.pow(xl,4)-13;
            if(fxm*fxr>0){
                xr = xm;
            }
            if(fxm*fxr<0){
                xl = xm;
            }
            if(fxm*fxr==0){
                break;
            }
        }
        System.out.println(String.format("%.6f",xm));
        System.out.print(fxm);
    }
}