import java.util.Scanner;
import java.util.ArrayList;
public class W5_5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<employee> alist = new ArrayList<>();
        for(int i=0;i<2;i++){
           System.out.println("Input:");
           String fname = input.next();
           String lname = input.next();
           String id = input.next();
           double salary = input.nextDouble();
           double year = input.nextDouble();
           employee n = new employee(fname,lname,id,salary,year);
           alist.add(n);
        }
        for(int i=0;i<alist.size();i++){
            alist.get(i).printans();
        }
    }
}

class employee{
    private String fname,lname,id;
    private double salary,year;
    public employee(String fname,String lname,String id,double salary,double year){
        this.fname = fname;
        this.lname = lname;
        this.id = id;
        this.salary = salary;
        this.year = year;
    }
    public double earn(){
        return salary*0.95;
    }
    public double bonus(){
        if(year>5){
            return salary*12;
        }
        else{
            return salary*6;
        }
    }
    public void printans(){
        System.out.println(fname+" "+lname+" "+earn()+" "+bonus());
        printf("%.2f")
    }
}