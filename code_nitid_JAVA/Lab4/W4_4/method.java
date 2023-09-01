import java.util.Arrays;
import java.util.Scanner;
public class method {
    Scanner input = new Scanner(System.in);
    public int[] a;
    
    public method(int n){
        a = new int[n];
    }
    
    public void get(){
        for(int i=0;i<a.length;i++){
            a[i] = input.nextInt();
        }
    }
    
    public int[] ascendsort(int[] b){
        int temp = 0;
        // Arrays.sort(b);
        for(int i=1;i<b.length;i++){
            for(int j=i;j>0;j--){
                if(b[j]<b[j-1]){
                    temp = b[j];    
                    b[j] = b[j-1];
                    b[j-1] = temp;   
                }
            }
        }
        return b;
    }
    
    public int[] sortcommu(int[] c){
        int[] x = new int[c.length];
        boolean [] visit = new boolean[c.length];
        int j=0,k=0;
        for(int i=0;i<c.length;i++){
            if(visit[i]==true){
                continue;
            }
            int count = 1;
            for(j=i+1;j<c.length;j++){
                if(c[i]==c[j]){
                    visit[j] = true;
                    count++;
                }
            }
            x[k] = count;
            k++;
        }
        return x;
    }
    
}
