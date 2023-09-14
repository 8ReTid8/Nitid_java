// package NumHW7_1_2_3;
import java.util.Scanner;
import java.lang.Math;
public class Method7 {
    Scanner input = new Scanner(System.in);
    double[][] mat;
    int size;
    double[] x,xold,y,r,d;
    public Method7(){
        size = input.nextInt();
        mat = new double[size][size];
        x = new double[size];
        y = new double[size];
        xold = new double[size];
        r = new double[size];
        d = new double[size];
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
    //JACOBI AND SEIDAL
    void cal(){
        for(int i=0;i<size;i++){
            xold[i] = x[i];
        }
        for(int i=0;i<size;i++){
            double temp = 0;
            for(int j=0;j<size;j++){
                if(i==j){
                    continue;
                }
                temp += mat[i][j]*xold[j];
            }
            x[i] = (y[i]-temp)/mat[i][i];
        }
    }
    void seidel(){
        for(int i=0;i<size;i++){
            xold[i] = x[i];
        }
        for(int i=0;i<size;i++){
            double temp = 0;
            for(int j=0;j<size;j++){
                if(i==j){
                    continue;
                }
                temp += mat[i][j]*x[j];
            }
            x[i] = (y[i]-temp)/mat[i][i];
        }
    }
   
    boolean checkErr(){
        boolean logic=true;
        for(int i=0;i<size;i++){
            if(Math.abs((x[i]-xold[i])/x[i])*100>0.001){
                logic = true;
            }
            else{
                logic = false;
                break;
            }
        }
        return logic;
    }


    //CONJUGATE
    void R(){
        for(int i=0;i<size;i++){
            double sum=0;
            for(int j=0;j<size;j++){
                sum += mat[i][j]*x[j];
            }
            r[i] = sum - y[i];
        }
    }

    void D0(){
        for(int i=0;i<size;i++){
            d[i] = r[i]*-1;
        }
    }

    double A(){
        double sumtop = 0;
        double sumbutt = 0;
        double[] temp = new double[size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                temp[i] += mat[i][j]*d[j];
            }
            sumbutt += temp[i]*d[i];
            sumtop += temp[i]*r[i];
        }
        return sumtop/sumbutt;
    }

    void D(){
        double temp = A();
        for(int i=0;i<size;i++){
            d[i] = (temp*d[i])-r[i];
        }
    }

    double ramda(){
        double sumtop = 0;
        double sumbutt = 0;
        double[] temp = new double[size];
        for(int i=0;i<size;i++){
            sumtop += d[i]*r[i];
            for(int j=0;j<size;j++){
                temp[i] += mat[i][j]*d[j];
            }
            sumbutt += temp[i]*d[i]; 
        }
        return (sumtop/sumbutt)*-1;
    }

    void X(){
        double temp = ramda();
        for(int i=0;i<size;i++){
            x[i] = x[i]+temp*d[i];
        }
    }
    boolean conjuCheck(){
        double sum=0;
        for(int i=0;i<size;i++){
            sum += r[i]*r[i];
        }
        if(Math.sqrt(sum)<0.01){
            return false;
        }
        else{
            return true;
        }
    }
}
