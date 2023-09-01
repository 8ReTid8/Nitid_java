import java.util.Scanner;
public class main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        method x = new method(n);
        a = x.ascendsort(a);
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");
        a = x.sortcommu(a);
        n = a.length;
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
        
    }
}
