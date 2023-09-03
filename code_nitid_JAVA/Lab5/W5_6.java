import java.util.Scanner;

public class W5_6 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int col = input.nextInt();
        int[][] mat = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                mat[i][j] = input.nextInt();
            }
        }
        if(checkfour(mat)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
    public static boolean checkfour(int[][] x){
        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[0].length;j++){
                int c = x[i][j];
                if(j+3<x[0].length){
                    if(c==x[i][j+1]&&c==x[i][j+2]&&c==x[i][j+3]){
                        return true;
                    }     
                }
                if(i+3<x.length){
                    if(c==x[i+1][j]&&c==x[i+2][j]&&c==x[i+3][j]){
                        return true;
                    }
                }
                if(i+3<x.length&&j+3<x[0].length){
                    if(c==x[i+1][j+1]&&c==x[i+2][j+2]&&c==x[i+3][j+3]){
                        return true;
                    }
                }
                if(i-3>=0&&j+3<x[0].length){
                    if(c==x[i-1][j+1]&&c==x[i-2][j+2]&&c==x[i-3][j+3]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
