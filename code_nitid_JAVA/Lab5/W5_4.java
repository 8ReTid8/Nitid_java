import java.util.Scanner;
public class W5_4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int colum = input.nextInt();
        int n = input.nextInt();
        int[][] city = new int[row][colum];
        for(int i=0;i<row;i++){
            for(int j=0;j<colum;j++){
                city[i][j] = input.nextInt();
            }
        }
        find(city,n);
    }
    public static void find(int[][] x,int n){
        int total;
        int sum=0;
        for(int i=0;i<=x.length-n;i++){
            for(int j=0;j<=x[0].length-n;j++){
                total = 0;
                for(int k=i;k<i+n;k++){
                    for(int l=j;l<j+n;l++){
                        total += x[k][l];
                    }
                }
                if(sum<total){
                    sum = total;
                }
            }
        }
        System.out.println(sum);
    }
}
