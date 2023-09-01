import java.util.Scanner;
public class W1_9{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int i,count=0,n=0,max;
        int[] keep = new int[100];
        do{
            keep[n] = input.nextInt();
            n++;
        }while(keep[n-1]!=0);
        max = keep[0];
        for(i=0;i<=n;i++){
            if(max<keep[i]){
                max = keep[i];
            }
        }
        for(i=0;i<=n;i++){
            if(max==keep[i]){
                count++;
            }
        }
        System.out.print(max+" "+count);
    }
}
