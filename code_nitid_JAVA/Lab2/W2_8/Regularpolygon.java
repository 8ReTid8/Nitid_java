// package Lab2.W2_9;

import java.lang.Math;

public class Regularpolygon{

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