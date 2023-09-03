import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class W5_3{
    static Scanner input = new Scanner(System.in);
    /**
     * @param args
     */
    public static void main(String[] args){
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        addarray(list1);
        addarray(list2);
        ans = intersect(list1,list2);
        Collections.sort(ans);  
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
    public static ArrayList<Integer> intersect(ArrayList<Integer> x,ArrayList<Integer> y){
        ArrayList<Integer> contain = new ArrayList<Integer>();
        for(int i=0;i<x.size();i++){
            for(int j=0;j<y.size();j++){
                if(x.get(i)==y.get(j)&&x.get(i)!=0){
                    contain.add(x.get(i));
                }
            }
        }
        return contain;
    }
    public static void addarray(ArrayList<Integer> x){
        int n;
        do{
            n = input.nextInt();
            x.add(n);
        }while(n!=0);
    }
}