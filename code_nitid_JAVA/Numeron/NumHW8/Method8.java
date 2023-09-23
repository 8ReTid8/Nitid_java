
import java.util.Scanner;
public class Method8 {
    Scanner input = new Scanner(System.in);
    double[] xmain,fxmain,x,fx,c,temp;
    double y;
    int sizemain,size,j=1;
    public Method8(){
        sizemain = input.nextInt();
        xmain = new double[sizemain];
        fxmain = new double[sizemain];
        c = new double[sizemain];
    }
    void add(){
        for(int i=0;i<sizemain;i++){
            xmain[i] = input.nextDouble();
            fxmain[i] = input.nextDouble();
        }
    }
    void choosemanyX(){
        size = input.nextInt();
        x = new double[size];
        fx = new double[size];
        c = new double[size];
    }
    void addchoosex(){
        int n;
        for(int i=0;i<size;i++){
            n = input.nextInt();
            x[i] = xmain[n];
            fx[i] = fxmain[n];
        }
        c[0] = fx[0];
    }
    double c(double[] fx,double[] x,int start,int end){
       if(start==end){
        return fx[start];
       }
       double temp1 = c(fx,x,start+1,end);
       double temp0 = c(fx,x,start,end-1);
       return (temp1-temp0)/(x[end]-x[start]);
    }
    void c(){
        for(int i=1;i<size;i++){
            for(int j=0;j<i+1;j++){
                double divide = 1;
                for(int k=0;k<i+1;k++){
                    if(j==k){
                        continue;
                    }
                    divide*=x[j]-x[k];
                }
                c[i]+=(fx[j]/divide);
            }
        }
    }
    double findy(double xfind){
        for(int i=0;i<size;i++){
            double sum = c[i];
            for(int j=0;j<i;j++){
                sum*=(xfind-x[j]);
            }
            y += sum;
        }
        return y; 
    }
}
