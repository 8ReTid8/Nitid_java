import java.util.Scanner;

public class NumHW11_3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = 7;
        int m = input.nextInt()+1;
        double xfind = input.nextDouble();
        double x[][] = {{1,0,2,3,4,2,1},{0,1,4,2,1,3,6},{1,3,1,2,5,3,4}};
        double fx[] = {4,-5,-6,0,-1,-7,-20};
        double[][] sumx = new double[m][m];
        double[] sumxy = new double[m];
        double[][] mat = new double[m][m];
        double[] a = new double[m];
        addsum(sumx,sumxy,fx,x,m,n,mat);
        for(int i=0;i<sumx.length;i++){
           System.out.println(sumx[i]); 
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        gauss_jordan(mat, m, a, sumxy);
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
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
    public static void addsum(double sx[][],double sy[],double[] fx,double[][] x,int m,int n,double[][] mat){
        // sx[0] = n;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    sy[i] += fx[j];
                }
                else{           
                    sy[i] += fx[j]*x[i-1][j];
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    if(i==0){
                        if(j==0){
                            sx[i][j] = n;
                            break;
                        }
                        sx[i][j] += x[j-1][k];
                    }
                    else{
                        if(j==0){
                            sx[i][j] = sx[0][i];
                            break;
                        }
                        else{
                            sx[i][j] += x[i-1][k]*x[j-1][k];
                        }
                    }
                }   
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                // System.out.println(j+i);
                mat[i][j] = sx[i][j];
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
