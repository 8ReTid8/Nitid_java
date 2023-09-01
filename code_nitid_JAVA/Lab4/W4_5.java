import java.util.Scanner;
public class W4_5{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] a = new int[2];
        int[] b = new int[2];
        a = RowColum(a);
        int[][] matrixA = new int[a[0]][a[1]]; 
        matrixA = inputmatrix(a,matrixA);
        b = RowColum(b);
        int[][] matrixB = new int[b[0]][b[1]];
        matrixB = inputmatrix(b,matrixB);
        if(a[1]==b[0]){
            int[][] matrixC = new int[a[0]][b[1]];
            matrixC = multiply(matrixA,matrixB,matrixC);
            for(int i=0;i<matrixC.length;i++){
                for(int j=0;j<matrixC[0].length;j++){
                    System.out.print(matrixC[i][j]+" ");
                }
                System.out.println("");
            }
        }
        else{
            System.out.println("logic false");
        }
    }

    public static int[] RowColum(int[] x){
        Scanner input = new Scanner(System.in);
        x[0] = input.nextInt();
        x[1] = input.nextInt();
        return x;
    }

    public static int[][] inputmatrix(int[] x,int[][] mat){
        Scanner input = new Scanner(System.in);
        for(int i=0;i<x[0];i++){
            for(int j=0;j<x[1];j++){
                mat[i][j] = input.nextInt();
            }
        }
        return mat;
    }
    
    public static int[][] multiply(int[][] a,int[][] b,int[][] c){
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[0].length;j++){
                for(int k=0;k<b.length;k++){
                    c[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }
}