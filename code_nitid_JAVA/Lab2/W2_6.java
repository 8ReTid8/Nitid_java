// package W2_6;
import java.util.Scanner;
public class W2_6{
    public static void main(String[] args){
        Account non = new Account(1122,20000);
        non.withdraw(2500);
        System.out.println(non.getbal());
        non.desposit(3000);
        System.out.println(non.getbal()); 
        System.out.println(non.gmi()); 
    }
}
class Account {
    private int id;
    private double balance,air=0.045;
    Account(){
        this.id = 0;
        this.balance = 0;
        this.air = 0;
    }
    Account(int id,double balance){
        this.id = id;
        this.balance = balance;
    }
    public double getbal(){
        return balance;
    }
    public double gmir(){
        return air/12;
    }
    public double gmi(){
        return balance*gmir();
    }
    public void withdraw(double i){
        this.balance-=i;
    }
    public void desposit(double i){
        this.balance+=i;
    }
}

