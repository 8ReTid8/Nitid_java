import java.util.Scanner;

public class W4_10{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int m = input.nextInt(); // จำนวนเลน col
        int n = input.nextInt(); // เลนเริ่มต้น row
        int t = input.nextInt(); // ระยะเวลา
        int[] keep = new int[t];
        int[][] road = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                road[i][j] = input.nextInt();
            }
        }
        int goalrow=0,goalcol=0;
        for(int i=0;i<m;i++){
            if(road[n-1][i]==0){
                goalrow = n-1;
                goalcol = i;
            }
        }
        keep = findrightway(road,t-1,goalrow,goalcol,keep);
        for(int i=0;i<t;i++){
            System.out.print(keep[i]+" ");
        }
    }
    public static int[] findrightway(int[][] road,int t,int row,int col,int ans[]){
        if(row==0){
            if(col<t){
                ans[row]=2;
            }
            if(col==t){
                ans[row]=3;
            }
            if(col>t){
                ans[row]=1;
            }
        }
        else if(0==road[row-1][col-1]&&col<t){
            ans[row] = 2;
            return findrightway(road,t,row-1,col-1,ans);
        }
        else if(0==road[row-1][col]&&col==t){
            ans[row] = 3;
            return findrightway(road,t,row-1,col,ans);
        }
        else if(0==road[row-1][col+1]&&col>t){
            ans[row] = 1;
            return findrightway(road,t,row-1,col+1,ans);
        }
        return ans;
    } 
}
