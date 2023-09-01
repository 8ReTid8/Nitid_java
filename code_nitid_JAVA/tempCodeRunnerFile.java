import java.util.Scanner;
import java.lang.Math;
public class test{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double fxl,fxr,xr=2,xl=1,xm,fxm;
        do{
            xm = (xr+xl)/2;
            fxr = Math.pow(xr,2)-7;
            fxm = Math.pow(xm,2)-7;
            if(fxm*fxr<0){
                xl = xm;
            }
            if(fxm*fxr>0){
                xr = xm;
            }
        }while(fxm!=0);
        System.out.print(fxm+" "+xm);      
    }
}