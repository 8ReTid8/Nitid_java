import java.util.Scanner;
public class W8_5 {
    public static void main(String[] args){

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

class circle extends GeometricObject{
    double r;
    public circle(double r){
        this.r = r;
    }

    public double getArea(){
        return 3.14*(r*r);
    }

    public double getPerimeter(){
        return 2*3.14*r;
    }
}

class rectangle extends GeometricObject{
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
}

class octagon extends GeometricObject{
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
        return 0;
    }
    
}