import java.lang.Math;
import java.util.Scanner;

public class NumHW1_3{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double xl,xr,xm=0,fxl,fxr,fxm=1;
        xl = input.nextDouble();
        xr = input.nextDouble();
        while(fxm!=0){
            xm = (xl+xr)/2;
            fxm = 1-(43*xm);
            fxr = 1-(43*xr);
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
    }
}