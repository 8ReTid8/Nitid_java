import java.util.Scanner;
import java.util.ArrayList;
public class W5_1 {
   public static void main(String[] args){
       Scanner input = new Scanner(System.in);
       ArrayList<Integer> n = new ArrayList<Integer>();
       for(int i=0;i<50;i++){
           n.add(input.nextInt());
       }
       mean(n);
       maxmin(n);
       no2(n);
   }
   public static void mean(ArrayList<Integer> n){
       double sum=0;
       for(int i=0;i<n.size();i++){
           sum +=  n.get(i);
       }
       System.out.println(sum/n.size());
   }
   public static void maxmin (ArrayList<Integer> n){
       int max = n.get(0);
       int min = n.get(0);
       for(int i=0;i<n.size();i++){
           if(max<n.get(i)){
               max = n.get(i);
           }
           if(min>n.get(i)){
               min = n.get(i);
           }
       }
       System.out.println(max);
       System.out.println(min);
   }
   public static void no2 (ArrayList<Integer> n){
       for(int i=0;i<n.size();i++){
           if(n.get(i)%2==0){
               n.remove(i);
               i--;
           }
           System.out.print(n.get(i)+" ");
       }
   }
}
