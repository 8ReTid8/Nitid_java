// package W2_5;
import java.util.Scanner;

public class W2_5{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("enter a b c d e f : ");
        double[] keep = new double[6];
        for(int i=0;i<6;i++){
            keep[i] = input.nextDouble();
        }
        Linearequation ans1 = new Linearequation(keep[0],keep[1],keep[2],keep[3],keep[4],keep[5]);
        if(ans1.isSolvable()){
             System.out.println("x is "+ans1.getx()+" and y is "+ans1.gety());
        }
        else{
            System.out.println("The equation has no solution");
        }
    }
}

class Linearequation {
    private double a,b,c,d,e,f;
    
    Linearequation(double a,double b,double c,double d,double e,double f){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.e=e;
        this.f=f;
    }
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    public double getC(){
        return c;
    }
    public double getD(){
        return d;
    }
    public double getE(){
        return e;
    }
    public double getF(){
        return f;
    }
    
    public boolean isSolvable(){
        if((a*d)-(b*c)==0)
            return false;
        return true; 
    }
    public double getx(){
        return ((e*d)-(b*f))/((a*d)-(b*c));
    }
    public double gety(){
        return ((a*f)-(e*c))/((a*d)-(b*c));
    }
}