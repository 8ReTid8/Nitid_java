import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class W4_10{
   public static void main (String[] args){
       int row,col;
       Scanner sc = new Scanner(System.in);
       col = sc.nextInt();
       row = sc.nextInt();
       int start = sc.nextInt();
       int [][]ar = new int [row][col];
       for(int i =0;i<row;i++){
           for(int j=0;j<col;j++){
               ar[i][j] = sc.nextInt();
           }
       }
       List<List<Integer>> e = new ArrayList<>();
       int count =0;
       e = drive(row, col, start-1, -1, e, new ArrayList<>(),ar,count);
       for (List<Integer> path : e) {
           System.out.println(path);
       }
   }
   public static List<List<Integer>> drive(int row,int column,int cc,int cr,List<List<Integer>> e,List<Integer> col,int[][]ar,int count){
       count++;
       if(cr == row-1){
           System.out.println("Finish");
           e.add(new ArrayList<>(col));
           return e;
       }else if (cc > 0 && ar[cr + 1][cc - 1] == 0) {
           System.out.println("1");
           col.add(1);
           drive(row,column,cc-1, cr+1, e, col,ar,count);
           col.remove(col.size()-1);
       }else if (ar[cr+1][cc] == 0) {
           System.out.println("3");
           col.add(3);
           drive(row,column,cc, cr+1, e, col,ar,count);
           col.remove(col.size()-1);
       }else if (cc < column-1 && ar[cr+1][cc+1] == 0) {
           System.out.println("2");
           col.add(2);
           drive(row,column,cc+1, cr+1, e, col,ar,count);
           col.remove(col.size()-1);
       }
       return e;
   }
}