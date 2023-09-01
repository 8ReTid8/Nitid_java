// package Lab2.W2_8;

import java.util.Scanner;
public class Main{
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