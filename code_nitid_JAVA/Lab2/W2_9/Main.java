import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n=1;
        Primenum a = new Primenum();
        while(n!=0){
            n = input.nextInt();
            a.setX(n);
            a.checkP();
            a.Pmax();
        }
        System.out.println(a.ansP());
    }
}