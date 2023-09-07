// package W2_6;

import java.util.Date;

public class Account {
    private int id;
    private double balance, air;
    private date datecreate;
    // Account acc = new Account(1, 100, new date(10, "july", 2000));

    Account() {
        this.id = 0;
        this.balance = 0;
        this.air = 0;
    }

    Account(int id, double balance, date datecreate) {
        this.id = id;
        this.balance = balance;
        this.datecreate = datecreate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAir(double air) {
        this.air = air;
    }

    public void setDatecreate(date datecreate) {
        this.datecreate = datecreate;
    }
    public date getDatecreate(){
        return datecreate;
    }
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAir() {
        return air;
    }

    public double gmir() {
        return air / 12;
    }

    public double gmi() {
        return balance * gmir();
    }

    public void withdraw(double i) {
        this.balance -= i;
    }

    public void desposit(double i) {
        this.balance += i;
    }

    public void tranferMoney(Account acc, double amount) {
        this.balance -= amount;
        acc.setBalance(acc.balance + amount);
    }
}

class date {
    private int day;
    private String month;
    private int year;
    date() {
    }
    date(int day, String month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public int getYear(){
        return year;
    }
}

class Person {
    private String name;
    private String surname;
    private int age;
    private date bdate;
    Person() {
    }
    Person(String name, String surname, int age, date bdate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bdate = bdate;
    }
}

class savingAccount extends Account {
    savingAccount() {
        super();
    }

    savingAccount(int id, double balance,date datecreate) {
        super(id, balance,datecreate);
    }

    public void tranferMoney(Account acc, double balance) {
        super.tranferMoney(acc, balance);
        this.setBalance(this.getBalance() - 20);
    }
}

class fixAccount extends Account{
    fixAccount(int id, double balance,date datecreate) {
        super(id,balance,datecreate);
    }
    public void withdraw(double amount) {
        date current = new date(5, "9", 2023);
        int time = super.getDatecreate().getYear() - current.getYear();
        if (time > 1) {
            super.withdraw(amount);
        } else {
            System.out.println("cannot withdraw");
        }
    }

    public void tranferMoney(Account acc, double balance) {
        System.out.println("cannot tranfer from fix account");
    }
}