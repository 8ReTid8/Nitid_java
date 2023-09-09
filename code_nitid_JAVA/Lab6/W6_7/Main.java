// package W2_6;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Account non = new Account(1123,20000,new date(14,"9",2023));
        Account nitid = new Account(1110,20000,new date(1,"1",2023));
        fixAccount nid = new fixAccount(1110,20000,new date(1,"1",2023));
        savingAccount nitod = new savingAccount(1110,20000,new date(1,"1",2023));
        nitod.tranferMoney(non,10000);
        nid.withdraw(500);
        System.out.println(nitod.getBalance()); 
        // non.setAir(0.045);
        // non.withdraw(2500);
        // System.out.println(non.getBalance());
        // non.desposit(3000);
        // System.out.println(non.getBalance());
        // non.tranferMoney(nitid,10000);
        // System.out.println(non.getBalance());
        // System.out.println(non.gmi()); 
        // nitid.setAir(0.045);
        // nitid.withdraw(2500);
        // System.out.println(nitid.getBalance());
        // nitid.desposit(3000);
        // System.out.println(nitid.getBalance());
        // nitid.tranferMoney(non,10000);
        // System.out.println(nitid.getBalance());
        // System.out.println(nitid.gmi()); 
        // nitid.setAir(0.045);
        // // non.withdraw(2500);
        // // System.out.println(non.getBalance());
        
        // non.tranferMoney(nitid,10000);
        // System.out.println(non.getBalance());
        // System.out.println(nitid.getBalance()); 
        // // System.out.println(non.gmi()); 
    }
}
