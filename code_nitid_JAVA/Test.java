import java.util.Scanner;
import java.lang.Math;
public class Test{
    public static void main(String[] args){
        int a[] = {1,2,3,4,5};
        int n = a.length;
        System.out.println(met(a,n));
    }
    public static int met(int a[],int n){
        if(n==0){
            return a[0];
        }
        else{
            if(a[0]<a[n-1]){
                a[0] = a[n-1];
            }
            return met(a,n-1);
        }
    }
}