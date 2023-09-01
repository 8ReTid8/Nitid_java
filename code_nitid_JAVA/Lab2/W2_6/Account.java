// package W2_6;

import java.util.Date;

public class Account {
    private int id;
    private double balance,air=0.045;
    private Date datecreate;

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

