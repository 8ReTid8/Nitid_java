import java.util.Scanner;
import java.util.ArrayList;
public class W9_9 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Integer> atom = new ArrayList<>();
        for(int i=0;i<n;i++){
            atom.add(input.nextInt());
            // System.out.println(atom.get(i));
        }
        int sum=0;
        int minia=0;
        int temp;
        int j=0;
        while(atom.size()>1){
            int maxatom=0;
            int cout = 0;
            for(int i=0;i<atom.size()-1;i++){
                temp = Math.abs(atom.get(i)-atom.get(i+1));
                if(maxatom<temp){
                    maxatom = temp;
                    cout = i;
                }
            }
            atom.remove(cout);
            atom.remove(cout);
            for(int i=0;i<atom.size();i++){
                System.out.print(atom.get(i)+" ");
            }
            System.out.println();
            sum += maxatom;

        }
        System.out.println(sum);
    }
}
