import java.util.Scanner;
public class W8_5 {
    public static void main(String[] args){
        octagon temp1 = new octagon(1);
        octagon temp2 = new octagon(5);
        System.out.println(temp1.getPerimeter());
        System.out.println(temp1.compareTo(temp2));
    }
}

abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    protected GeometricObject() {
    }
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}

class circle extends GeometricObject implements Comparable<Object>{
    double r;
    public circle(double r){
        this.r = r;
    }
    @Override
    public double getArea(){
        return 3.14*(r*r);
    }
    @Override
    public double getPerimeter(){
        return 2*3.14*r;
    }
    public boolean equals(Object x){
        if(((circle)x)==this){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public int compareTo(Object x) {
        if(((circle)x).getPerimeter()==this.getPerimeter()){
            return 1;
        }
        else{
            return 0;
        }
    }
}

class rectangle extends GeometricObject implements Comparable<Object>{
    double width,height;
    public rectangle(double w,double h){
        this.width = w;
        this.height = h;
    }
    @Override
    public double getArea() {
        return width*height; 
    }
    @Override
    public double getPerimeter() {
        return 2*(width+height);
    }
    public boolean equals(Object x) {
        if(((rectangle)x)==this){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public int compareTo(Object x) {
        if(((rectangle)x).getArea()==this.getArea()){
            return 1;
        }
        else{
            return 0;
        }
    }
}

class octagon extends GeometricObject implements Comparable<Object>{
    double side;
    public octagon(double side){
        this.side = side;
    }
    @Override
    public double getArea() {
        return (2+4/Math.sqrt(2))*side*side;
    }
    @Override
    public double getPerimeter() {
        return side*8;
    }
    public boolean equals(Object x) {
        if(((octagon)x)==this){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public int compareTo(Object x) {
        if(((octagon)x).getArea()==this.getArea()){
            return 1;
        }
        else{
            return 0;
        }
    }
    
}