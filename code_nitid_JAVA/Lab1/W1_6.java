import java.util.Scanner;
public class W1_6{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int i,j;
        System.out.print("Please input number of columns and rows: ");
        int col = input.nextInt();
        int row = input.nextInt();
        for(i=1;i<=row;i++){
            for(j=1;j<=col;j++){
                System.out.print(i*j+"\t");
            }
            System.out.println("");
        }
    }
}