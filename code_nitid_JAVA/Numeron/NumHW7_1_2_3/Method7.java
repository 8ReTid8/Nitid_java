// package NumHW7_1_2_3;
import java.util.Scanner;
public class Method7 {
    Scanner input = new Scanner(System.in);
    double[][] mat;
    int size;
    double[] x,xnew,y;
    public Method7(){
        size = input.nextInt();
        mat = new double[size][size];
        x = new double[size];
        y = new double[size];
        xnew = new double[size];
    }

    void add(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                mat[i][j] = input.nextDouble();
            }
            y[i] = input.nextDouble();
        }
    }

    void addx(){
        double temp = input.nextDouble();
        for(int i=0;i<size;i++){
            x[i] = temp;
        }
    }

}
