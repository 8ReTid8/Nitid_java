import java.util.Scanner;
public class W4_8 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int colum = input.nextInt();
        int[][] mat = new int[row][colum];
        for(int i=0;i<row;i++){
            for(int j=0;j<colum;j++){
                mat[i][j] = input.nextInt();
            }
        }
        pokemon(mat);
    }
    public static void pokemon(int[][] x){
        int sum=0;
        int total=0;
        int r=0,c=0;
        for(int i=0;i<x.length-1;i++){
            for(int j=0;j<x[0].length;j++){
                sum = x[i][j]+x[i+1][j];
                if(Math.abs(x[i][j]-x[i+1][j])<=10&&sum>total){
                    total = sum;
                    r=i+1;
                    c=j+1;
                }
            }
        }
        System.out.println(r+" "+c);
    }
}
