// package Lab2.W2_8;
import java.lang.Math;
import java.util.Scanner;
public class W2_8{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Regularpolygon poly1 = new Regularpolygon();
        Regularpolygon poly2 = new Regularpolygon(6,4);
        Regularpolygon poly3 = new Regularpolygon(10,4,5.6,7.8);
        System.out.println(poly1.getPerimeter());
        System.out.println(poly2.getPerimeter());
        System.out.println(poly3.getPerimeter());
        System.out.println(poly1.getArea());
        System.out.println(poly2.getArea());
        System.out.println(poly3.getArea());
    }
}

class Regularpolygon{

    private int n;
    private double side,x,y;

    public Regularpolygon(){
        this.n=3;
        this.side=1;
        this.x=0;
        this.y=0;
    }
    public Regularpolygon(int n,double side){
        this.n = n;
        this.side = side;
        this.x=0;
        this.y=0;
    }
     public Regularpolygon(int n,double side,double x,double y){
        this.n = n;
        this.side = side;
        this.x=x;
        this.y=y;
    }
    public double getPerimeter(){
        return n*side;
    }
    public double getArea(){
        return ((n*Math.pow(side,2))/(4*(Math.tan(Math.PI/n))));
    }
}