
import java.util.ArrayList;

public class W8_4 {
    public static void main(String[] args) {
        ArrayList<Employee> a = new ArrayList();
        a.add(new SalariedEmployee("non","pop","1111",20000));
        a.add(new SalariedEmployee("nitid","pop","1111",10000));
        a.add(new ComEmployee("io","pop","1111",20000,0.5));
        a.add(new ComEmployee("uko","pop","1111",10000,0.5));
        printEmp(a);
    }
    public static void printEmp(ArrayList<Employee> a){
        double[][] arremp = new double[a.size()][a.size()];
        for(int i=0;i<a.size();i++){
            arremp[i][0] = a.get(i).earning();
            arremp[i][1] = a.get(i).bonus(5);
        }
        System.out.println("Firstname\tLastname\tearning \tbonus");
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i).getfname()+"\t\t"+a.get(i).getlname()+"\t\t"+arremp[i][0]+"\t\t"+arremp[i][1]);
        }
    }
}

abstract class Employee{
    private String firstname;
    private String lastname;
    private String id;
    public Employee(String firstname,String lastname,String id){
        this.firstname=firstname;
        this.lastname=lastname;
        this.id=id;
    }
    public String getfname(){
        return firstname;
    }
    public String getlname(){
        return lastname;
    }
    public abstract double earning();
    public abstract double bonus(int year);
}

class SalariedEmployee extends Employee{
    double salary;
    public SalariedEmployee(String firstname,String lastname,String id, double salary){
        super(firstname,lastname,id);
        this.salary = salary;
    }
    
    @Override
    public double bonus(int year){
        if(year>5){
            return salary*12;
        }
        else{
            return salary*6;
        }
    }
    @Override
    public double earning(){
        return salary*0.95;
    }
}

class ComEmployee extends Employee{
    double grossSale,comRate;
    public ComEmployee(String firstname,String lastname,String id,double sale,double percent){
        super(firstname,lastname,id);
        this.grossSale = sale;
        this.comRate = percent;
    }
    
    @Override
    public double bonus(int year){
        if(year>5){
            return grossSale*6;
        }
        else{
            return grossSale*3;
        }
    }
    @Override
    public double earning(){
        return grossSale*comRate;
    }
}