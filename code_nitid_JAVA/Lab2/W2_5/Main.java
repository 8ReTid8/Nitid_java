// package W2_5;
import java.util.Scanner;

public class Main {
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
