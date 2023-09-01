// package W2_6;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Account non = new Account(1122,20000);
        non.withdraw(2500);
        System.out.println(non.getbal());
        non.desposit(3000);
        System.out.println(non.getbal()); 
        System.out.println(non.gmi()); 
    }
}
