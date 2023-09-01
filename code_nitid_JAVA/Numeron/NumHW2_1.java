import java.util.Scanner;
import java.lang.Math;
public class NumHW2_1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double fxr,fxl,x1,fx1=-1,x1new=1;
        double xl = input.nextDouble();
        double xr = input.nextDouble();
        
        fxl = Math.pow(xl,4)-13;
        fxr = Math.pow(xr,4)-13;
        x1 = ((xl*fxr)-(xr*fxl))/(fxr-fxl);
        fx1 = Math.pow(x1,4)-13;
        System.out.println("xl = "+xl+" fxl = "+fxl+" xr = "+xr+" fxr = "+fxr+" fx1 = "+fx1+" x1 = "+x1+" err = "+Math.abs((x1new-x1)/x1new)*100);
        if(fx1*fxr>0){ 
            xr = x1;
        }
        if(fx1*fxr<0){
            xl = x1;
        }
        x1new = x1;

        while(fx1!=0){
            fxl = Math.pow(xl,4)-13;
            fxr = Math.pow(xr,4)-13;
            x1new = ((xl*fxr)-(xr*fxl))/(fxr-fxl);
            fx1 = Math.pow(x1new,4)-13;
            System.out.println("xl = "+xl+" fxl = "+fxl+" xr = "+xr+" fxr = "+fxr+" fx1 = "+fx1+" x1 = "+x1new);
            if(fx1*fxr>0){ 
                xr = x1new;
            }
            if(fx1*fxr<0){
                xl = x1new;
            }
            if(Math.abs((x1new-x1)/x1new)*100<0.000001){
                break;
            }
            
            x1 = x1new;
            
        }
        System.out.println(x1new);
        System.out.println(fx1);
    }
}