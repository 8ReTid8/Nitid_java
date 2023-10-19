import java.util.Scanner;
public class NumHW11_1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = 9;
        int m = input.nextInt()+1;
        double xfind = input.nextDouble();
        double x[] = {10,15,20,30,40,50,60,70,80};
        double fx[] = {5,9,15,18,22,30,35,38,43};
        double[] sumx = new double[m+(m-1)];
        double[] sumxy = new double[m];
        double[][] mat = new double[m][m];
        double[] a = new double[m];
        addsum(sumx,sumxy,fx,x,m,n,mat);
        for(int i=0;i<sumx.length;i++){
           System.out.println(sumxy[i]); 
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        gauss_jordan(mat, m, a, sumxy);
        addx(a,xfind,m);
        for(int i=0;i<m;i++){
            System.out.println(a[i]);
        }
    }
    public static void addx(double[] a,double x,int m){
        double sum=0;
        for(int i=0;i<m;i++){
            sum += a[i]*Math.pow(x, i);
        }
        System.out.println(sum);
    }
    public static void addsum(double sx[],double sy[],double[] fx,double[] x,int m,int n,double[][] mat){
        // sx[0] = n;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){           
                sy[i] += fx[j]*Math.pow(x[j],i);   
            }
        }
        for(int i=0;i<sx.length;i++){
            for(int j=0;j<n;j++){
                sx[i] += Math.pow(x[j],i);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                // System.out.println(j+i);
                mat[i][j] = sx[j+i];
            }
        }
    }
    public static void gauss_jordan(double[][] mat,int m,double[] a,double[] sumxy){
        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < m; ++j) {
                // double ratio = copy[j][i] / copy[i][i];
                double keep = mat[j][i];
                for (int k = 0; k < m; ++k) {
                    // copy[j][k] -= ratio*copy[i][k];
                    mat[j][k] -= (mat[i][k]/mat[i][i])*keep;
                }
                // b[j] -= ratio * b[i];
                sumxy[j] -= (sumxy[i]/mat[i][i])*keep;
            }
        }
     
        for (int i = m-1; i >= 0; --i) {
            for (int j = i-1; j >= 0; --j) {
                // double ratio = copy[j][i] / copy[i][i];
                double keep = mat[j][i];
                for (int k = m-1; k >= 0; --k) {
                    mat[j][k] -= (mat[i][k]/mat[i][i])*keep;
                    // copy[j][k] -= copy[i][k]*ratio;
                }
                // b[j] -= ratio*b[i];
                sumxy[j] -= (sumxy[i]/mat[i][i])*keep;
            }
        }

        for(int i=m-1;i>=0;i--){   
            a[i] = sumxy[i]/mat[i][i];
        }  
    }
}
