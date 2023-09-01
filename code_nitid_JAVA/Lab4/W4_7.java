import java.util.Scanner;
public class W4_7{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] w = new int[n];
        for(int i=0;i<n;i++){
            w[i] = input.nextInt();
        }
        System.out.println(findMin(w,n));
    }
    public static int findMinRec(int arr[],int i,int sumCalculated,int sumTotal){
        if (i == 0)
            return Math.abs(sumTotal - sumCalculated*2);
        return Math.min(findMinRec(arr,i-1,sumCalculated + arr[i-1],sumTotal),findMinRec(arr,i-1,sumCalculated,sumTotal));
    }
    public static int findMin(int arr[],int n){
        int sumTotal = 0;
        for (int i = 0; i < n; i++)
            sumTotal += arr[i];
        return findMinRec(arr,n,0,sumTotal); 
    }
 
}